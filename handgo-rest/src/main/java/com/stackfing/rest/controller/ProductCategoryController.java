package com.stackfing.rest.controller;

import com.stackfing.common.utils.HandgoResult;
import com.stackfing.common.utils.ObjectUtil;
import com.stackfing.pojo.ProductCategory;
import com.stackfing.rest.service.ProductCategoryService;
import com.stackfing.rest.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.PortableInterceptor.RequestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午2:39 18-1-19
 */

@RequestMapping("/category")
@RestController
public class ProductCategoryController {

	@Autowired
	private ProductCategoryService productCategoryService;

	@ApiOperation("获得所有分类")
	@GetMapping("")
	public HandgoResult getCategory(@RequestParam(required = false) Integer page
			, @RequestParam(required = false) Integer limit) {
		if (ObjectUtil.validate(page) || ObjectUtil.validate(limit)) {
			return productCategoryService.getCategory(page, limit);
		}
		return HandgoResult.error("参数错误，请重试");
	}

	@ApiOperation("添加分类")
	@PostMapping("")
	public HandgoResult addCategory(@RequestBody(required = false) ProductCategory productCategory) {
		if (ObjectUtil.validate(productCategory)) {
			return productCategoryService.addCategory(productCategory);
		}
		return HandgoResult.error("参数错误，请重试");
	}

	@ApiOperation("更新分类")
	@PutMapping("/{id}")
	public HandgoResult updateCategory(@PathVariable Long id
			, @RequestBody(required = false) ProductCategory productCategory) {
		if (ObjectUtil.validate(productCategory)) {
			return productCategoryService.updateCategory(id, productCategory);
		}
		return HandgoResult.error("参数错误，请重试");
	}
}
