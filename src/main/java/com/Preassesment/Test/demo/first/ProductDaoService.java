package com.Preassesment.Test.demo.first;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProductDaoService {
	public List<Product> getSortedProduct(List<Product> product) {

		product.sort(Comparator.comparing(Product::getProductId).thenComparing(Product::getLaunchDate).reversed());
		return product;
	}

}