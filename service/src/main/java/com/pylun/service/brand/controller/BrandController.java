package com.pylun.service.brand.controller;

import com.pylun.brand.model.Brand;
import com.pylun.brand.model.BrandParam;
import com.pylun.brand.service.BrandService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class BrandController
{
    static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    BrandService brandService;

    @GetMapping("/")
    public String home()
    {
        logger.info("BrandController /");
        return "Hello World!/t" + new Date();
    }

    @GetMapping(value = "/api/brands/{brandIdx}")
    public Brand getBrands(@PathVariable long brandIdx)
    {
        //logger.info("BrandController /detail");
        BrandParam brandParam = new BrandParam();
        brandParam.setBrandIdx(brandIdx);
        Brand brand = brandService.getBrand(brandParam);

        return brand;
    }

    @GetMapping(value = "/api/brands")
    public List<Brand> listBrand(@ModelAttribute BrandParam brandParam)
    {
        //logger.info("BrandController /api/brands");

        List<Brand> listBrand = brandService.listBrand(brandParam);
        return listBrand;
    }

    @PostMapping(value = "/api/brands")
    public Brand insertBrand(@ModelAttribute Brand brand) throws Exception
    {
        //logger.info("BrandController /productadd");
        int resultCnt = brandService.insertBrand(brand);
        return brand;
    }

    @PutMapping(value = "/api/brands")
    public Brand updateBrand(@ModelAttribute Brand brand) throws Exception
    {
        //logger.info("BrandController /productadd");

        int resultCnt = brandService.updateBrand(brand);
        return brand;
    }

/*
    @RequestMapping(value = "/api/product")
    public SourcingProduct sourcingProduct(long sourcingProductIdx)
    {
        logger.info("BrandController /company");

        SourcingProduct sourcingProduct = null;//sourcingCompanyService.getSourcingProduct(sourcingCompanyIdx);
        return sourcingProduct;
    }
*/

}
