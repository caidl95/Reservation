package com.example.demo.adder.controller;

import java.util.List;


import com.example.demo.adder.entity.District;
import com.example.demo.adder.service.IDistrictService;
import com.example.demo.common.controller.BaseController;
import com.example.demo.common.serverResponse.ServerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/districts")
public class DistrictController extends BaseController {

	@Autowired
	private IDistrictService districtService;
	
	@GetMapping("/")
	public ServerResponse<List<District>> getByParent(@RequestParam("parent") String parent) {
		return districtService.getByParent(parent);
	}
	
}









