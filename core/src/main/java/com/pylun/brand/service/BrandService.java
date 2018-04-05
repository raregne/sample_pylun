package com.pylun.brand.service;

import com.pylun.brand.dao.BrandDAO;
import com.pylun.brand.dao.LanguageDAO;
import com.pylun.brand.model.Brand;
import com.pylun.brand.model.BrandParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrandService
{
    static final Logger logger = LoggerFactory.getLogger(BrandService.class);


    @Autowired
    BrandDAO brandDAO;

    @Autowired
    LanguageDAO languageDAO;

    @Transactional(readOnly = true)
    public Brand getBrand(BrandParam brandParam)
    {
        return brandDAO.getBrand(brandParam);
    }

    @Transactional
    public int insertBrand(Brand brand)
    {
        int resultCnt = brandDAO.insertBrand(brand);
        return resultCnt;
    }

    @Transactional
    public int updateBrand(Brand brand)
    {
        int resultCnt = brandDAO.updateBrand(brand);
        return resultCnt;
    }

    @Transactional(readOnly = true)
    public List<Brand> listBrand(BrandParam brandParam)
    {
        List<Brand> list = brandDAO.listBrand(brandParam);
        return list;
    }

}
