package com.pylun.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mybatis.replication.datasource.ReplicationRoutingDataSource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ObjectUtils;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableTransactionManagement
@Slf4j
public class DataSourceConfig
{

    @Autowired
    private MybatisProperties properties;

    @Primary
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.master.datasource")
    public DataSource masterDataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "spring.slave.datasource")
    public DataSource slaveDataSource()
    {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "routingDataSource")
    public DataSource routingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource, @Qualifier("slaveDataSource") DataSource slaveDataSource)
    {
        List<DataSource> dataSourceList = new ArrayList<DataSource>();
        dataSourceList.add(slaveDataSource);
        ReplicationRoutingDataSource routingDataSource = new ReplicationRoutingDataSource(masterDataSource, dataSourceList);
        return routingDataSource;
    }

    /*
     * TODO: Datasource 파라메터 정의 필요
     * 체크타임, 컨넥션 수, 재연결 등등
     * */
    @Bean(name = "dataSource")
    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource)
    {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource)
    {
        return new DataSourceTransactionManager(dataSource);
    }

    /*
     * TODO: MyBatis 설정을 XML로 사용되는지
     * Java Bean으로 구현 되는지 체크 필요
     * */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource, ApplicationContext applicationContext) throws Exception
    {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource(this.properties.getConfigLocation()));
        sqlSessionFactoryBean.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        sqlSessionFactoryBean.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        sqlSessionFactoryBean.setMapperLocations(this.properties.resolveMapperLocations());


        return sqlSessionFactoryBean.getObject();
    }
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception
    {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
