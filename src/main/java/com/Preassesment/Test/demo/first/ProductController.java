package com.Preassesment.Test.demo.first;
 

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class ProductController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	Map<String, List<Product>> response = new HashMap<String, List<Product>>();
	
	@Autowired
	ProductDaoService service;

	
	@PostMapping("/sortProducts")	
	public Map<String,List<Product>> getSortedProduct(@RequestBody Map<String,List<Product>> productmap){
		try {
			logger.info("sortProducts post method endpoint triggred");
			response.put("sortedProductList", service.getSortedProduct(productmap.get("productList")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ResponseStatusException(
			          HttpStatus.INTERNAL_SERVER_ERROR, "Error inside Controller",e);
		}
		return response;
	}

}