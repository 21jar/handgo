package com.stackfing.admin.aop;


import com.stackfing.common.utils.SystemLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class SystemLogAspect {

	@Autowired(required = false)
	private HttpServletRequest request;

//	@Pointcut("execution(* com.stackfing.admin.controller.admin..*(..))")
//	public void controllerMethodPointcut(){}

	@Pointcut("execution(* com.stackfing.admin.controller.*..*(..))")
	public void controllerLogPointcut(){}

	@After("controllerLogPointcut()")
	public void writeLogger() {
		/*
		用于后置通知，用于controller操作
		日志标题
		类型
		url
		请求方式
		请求参数
		用户
		ip
		开始时间
		耗时
		 */
		Map<String, String[]> logParams = request.getParameterMap();

		log.info(new SystemLog()
				.setId(10000L)
				.setName("name")
				.setType(1)
				.setUrl(request.getRequestURI())
				.setRequestType(request.getMethod())
				.setrequestParam(logParams.toString())
				.setUser(null)
				.setIp(null)
				.setIpInfo("null")
				.setTime(null)
				.setCreateDate(null)
				.commit());
	}
}
