package com.example.demoApp.controller;

import com.example.demoApp.Model.Product;
import com.example.demoApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ProductController {
  @Autowired
    ProductService productService;
    @RequestMapping ("/products")
    public List<Product> getProduct() {
          return productService.getProducts();
    }
    //for particular id
    @RequestMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
      return productService.getProductById(id);
    }
    //for post
  // for above use getmapping
  // here post
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
         productService.addProduct(product);
    }
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
      productService.updateProduct(product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(int id) {
      productService.deleteProduct(id);
    }
}
