package beans;

import java.util.Arrays;
import java.util.List;

import pojos.Product;

public class ProductBean {
	
	private List<Product>products;
	
	public ProductBean()
	{
		System.out.println("in bean ctor");
		products = Arrays.asList(new Product(101,"Book1",500),new Product(102,"Book2",100),new Product(103,"Book3",5000));
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
