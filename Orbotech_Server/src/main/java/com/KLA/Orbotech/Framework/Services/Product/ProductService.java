package com.KLA.Orbotech.Framework.Services.Product;

import com.KLA.Orbotech.Framework.Entity.Product;
import com.KLA.Orbotech.Framework.Repositorys.Product.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;

    @Transactional
    @Override
    public List<Product> Get() {
        return productRepo.Get();
    }

    @Transactional
    @Override
    public Product Get(Integer id) {
        return productRepo.Get(id);
    }

    @Transactional
    @Override
    public void Create(Product newProduct) {
        productRepo.Create(newProduct);
    }

    @Transactional
    @Override
    public void Delete(Integer id) {
        productRepo.Delete(id);
    }
}
