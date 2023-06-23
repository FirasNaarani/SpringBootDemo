package com.KLA.Orbotech.Framework.Controllers;

import com.KLA.Orbotech.Framework.Entity.Product;
import com.KLA.Orbotech.Framework.Services.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> Get(){
        return productService.Get();
    }

    @GetMapping("/products/{id}")
    public Product Get(@PathVariable Integer id){
        Product productObj = productService.Get(id);
        if(productObj != null)
            return productObj;

        else
            throw new RuntimeException("PRODUCT WITH ID " + id + " IS NOT FOUND");
    }

    @PostMapping("/products")
    public Product Create(@RequestBody Product productObj){
        productService.Create(productObj);
        return productObj;
    }

    @DeleteMapping("/products/{id}")
    public String Delete(@PathVariable Integer id){
        productService.Delete(id);
        return "PRODUCT HAS BEEN DELETED WITH ID :" + id;
    }
}
