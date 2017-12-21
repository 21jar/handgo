package com.stackfing.handgo.controller.admin;

import com.stackfing.handgo.entity.User;
import com.stackfing.handgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class UserManagerController {

	@Autowired
	private UserService userService;

	@GetMapping("")
	public String getAllUsers() {

		return "redirect:/admin";
	}

	@GetMapping("{uid}")
	public String editUser(@PathVariable Long uid, ModelMap modelMap) {
		User user = userService.selectUserById(uid);
		modelMap.put("userDetail", user);
		return "/admin/user-edit";
	}

	@RequestMapping("userList")
	@ResponseBody
	public List<User> getUserList() {
		List<User> list = userService.findAllUser();
		for (User u : list) {
			System.out.println(u.toString());
		}
		return list;
	}

	@PostMapping("submit")
	public String postUser(User user) {
		userService.saveUser(user);
		return "redirect:/admin";
	}

	@GetMapping("add")
	public String addUser() {
		return "/admin/user-edit";
	}

	@ResponseBody
	@GetMapping("del/{uid}")
	public String delUser(@PathVariable Long uid) {
		userService.deleteUserById(uid);
		return "删除成功";
	}
}
