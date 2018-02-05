package com.stackfing.admin.controller.restController;

import com.stackfing.common.utils.HandgoResult;
import com.stackfing.common.utils.Result;
import com.stackfing.common.vo.LayuiVo;
import com.stackfing.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: fing
 * @Description:
 * @Date: 下午12:37 18-1-26
 */
@RestController
@RequestMapping("/v1/category")
public class CategoryRestController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public Result getCategoryList(@RequestParam(required = false) Integer page
		, @RequestParam(required = false)  Integer limit) {
		if (null == page || limit == null) {
//			return (LayuiVo) LayuiVo.success(categoryService.findAll());
			return Result.success(categoryService.findAll());
		}
		return Result.success(categoryService.findAll(page, limit));
//		return LayuiVo.success(categoryService.findAll(page, limit), 100);
	}

	@GetMapping("/{id}")
	public Result getCategoryById(@PathVariable Long id) {
		return Result.success(categoryService.findById(id));
	}

}
