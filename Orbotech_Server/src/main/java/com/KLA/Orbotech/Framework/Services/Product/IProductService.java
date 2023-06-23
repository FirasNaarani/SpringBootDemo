package com.KLA.Orbotech.Framework.Services.Product;

import com.KLA.Orbotech.Framework.Entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> Get();

    Product Get(Integer id);

    void Create(Product newProduct);

    void Delete(Integer id);
}
