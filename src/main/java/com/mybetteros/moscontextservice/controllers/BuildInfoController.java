package com.mybetteros.moscontextservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BuildInfoController {

	@GetMapping("/buildinfo")
	public String buildInfo()
	{
		return "version 1.0";
	}
}
