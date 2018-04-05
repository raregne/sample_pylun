package com.pylun.brand.dao;

import com.pylun.brand.model.Brand;
import com.pylun.brand.model.BrandParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BrandDAO
{
    Brand getBrand(BrandParam brandParam);

    int insertBrand(Brand brand);

    List<Brand> listBrand(BrandParam brandParam);

    int updateBrand(Brand brand);

//    List<Brand> getBrandList(BrandParam brandParam);

}
