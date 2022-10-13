
package com.example.moto.Repositories;

import com.example.moto.entities.Category;
import com.example.moto.repository.crudRepository.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {
    
    @Autowired
    private CategoryCrudRepository extensionesCrud;
    
    public List<Category> getAll(){
        return (List<Category>) extensionesCrud.findAll();
    }
    
    public Optional<Category> getCategory(int id){
        return extensionesCrud.findById(id);
    }
    
    public Category save(Category c){
        return extensionesCrud.save(c);
    }
    
    public void delete(Category c){
        extensionesCrud.delete(c);
    }
}
