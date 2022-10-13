
package com.example.moto.Repositories;

import com.example.moto.entities.Product;
import com.example.moto.repository.crudRepository.ProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    
    @Autowired
    private ProductCrudRepository  extensionesCrud;
    
    public List<Product> getAll(){
        return (List<Product>)  extensionesCrud.findAll();
    }
    
    public Optional<Product> getProduct(int id){
       return  extensionesCrud.findById(id);
    }
 
    public Product save(Product p){
        return  extensionesCrud.save(p);
    }
    
    public void delete(Product p) {
         extensionesCrud.delete(p);
    }
}
