package com.example.demoApp.Service;

import com.example.demoApp.Model.Product;
import com.example.demoApp.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;



    //while post since array is immutable change to arraylist
   // private List<Product>products=new ArrayList<>( Arrays.asList(new Product(101,"Iphone",60000),new Product(102,"mac",100000)));
    public List<Product> getProducts() {
       // return products;
        return repo.findAll();
    }
    public Product getProductById(int id) {
       // return products.stream().filter(product -> product.getProdId() == id).findFirst().get();
       return repo.findById(id).get();
    }
    public void addProduct(Product product) {
       // products.add(product);
        repo.save(product);
    }
    public void updateProduct(Product product) {
//        int index=0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProdId() == product.getProdId()) {
//                index = i;
//            }
//        }
//       products.set(index, product);
        repo.save(product);
    }
    public void deleteProduct(int id) {
//        int index=0;
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getProdId() ==id) {
//                index = i;
//            }
//        }
//        products.remove(index);
        repo.deleteById(id);
    }
}
