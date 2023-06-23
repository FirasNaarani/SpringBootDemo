package com.KLA.Orbotech.Framework.Repositorys.Product;

import com.KLA.Orbotech.Framework.Entity.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> Get();

    Product Get(Integer id);

    void Create(Product newProduct);

    void Delete(Integer id);

}
