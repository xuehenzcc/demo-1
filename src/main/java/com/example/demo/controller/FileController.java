/**
 * 版权：zcc
 * 作者：c0z00k8
 * @data 2018年7月17日
 */
package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author c0z00k8
 *
 */
@Controller
@RequestMapping("/file")
public class FileController {

	private static final Logger logger=LoggerFactory.getLogger(FileController.class);
	
	@RequestMapping("/upload")
	@ResponseBody
	public String upload(@RequestParam("roncooFile") MultipartFile file){
		if(file.isEmpty()){
			return "文件为空";
		}
		//获取文件名
		String fileName=file.getOriginalFilename();
		logger.info("上传的文件名为："+fileName);
		
		//获取文件的后缀名
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
		logger.info("文件后缀名为："+suffixName);
		
		fileName = UUID.randomUUID() + suffixName;
		// 文件上传路径
		String filePath = "d:/roncoo/tmp/";
		File upFile=new File(filePath+fileName);
		
		//检查是否存在目录
		if(!upFile.getParentFile().exists()){
			upFile.getParentFile().mkdirs();
		}
		try {
			file.transferTo(upFile);
			return "上传成功";
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败";
	}
	
}
