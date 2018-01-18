package com.stackfing.admin.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: fing
 * @Description:
 * @Date: 上午10:37 18-1-13
 */
@Controller
@RequestMapping("/product")
public class ProductController {

	@GetMapping("")
	public String toProduct() {
		return "product";
	}


}
