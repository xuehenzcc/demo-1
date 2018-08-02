///**
// * 版权：zcc
// * 作者：c0z00k8
// * @data 2018年7月17日
// */
//package com.example.demo.controller;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * @author c0z00k8
// *
// */
//@Controller
//@RequestMapping(value = "error")
//public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
//
//	private static final Logger logger = LoggerFactory.getLogger(ErrorController.class);
//
//	@Override
//	public String getErrorPath() {
//		logger.info("出错啦！进入自定义错误控制器");
//		return "comm/error";
//	}
//
//	@RequestMapping
//	public String error() {
//		return getErrorPath();
//	}
//
//	
//}
