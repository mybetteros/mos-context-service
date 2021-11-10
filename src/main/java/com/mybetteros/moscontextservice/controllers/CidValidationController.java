package com.mybetteros.moscontextservice.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mybetteros.moscontextservice.models.SecurityBitModel;
import com.mybetteros.moscontextservice.models.UserContextModel;

@RestController
public class CidValidationController {

	@GetMapping("/cid/{cid-token}")
	public UserContextModel cid(@PathVariable("cid-token")String cidToken)
	{
		UserContextModel user = new UserContextModel();
		user.setEmail("sample@email.com");
		user.setRole("mos_admin");
		List<SecurityBitModel> securityBits = new ArrayList<SecurityBitModel>();
		user.setSecurityBits(securityBits);
		return user;
	}
	
}
