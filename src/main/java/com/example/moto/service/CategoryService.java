package com.example.moto.service;

import com.example.moto.entities.Category;
import com.example.moto.Repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);                      
    }
    
    public Category save(Category p){
        if (p.getId()==null){
            return categoryRepository.save(p);
        }else{
            Optional<Category> e = categoryRepository.getCategory(p.getId());
            if (e.isPresent()){
                return categoryRepository.save(p);
            }else{
                return p;
            }
         }

    }

    public Category update(Category p) {
        if (p.getId() != null) {
            Optional<Category> q = categoryRepository.getCategory(p.getId());
            if (!q.isPresent()) {
                if (p.getName() != null) {
                    q.get().setName(p.getName());
                }
                if (p.getDescription() != null) {
                    q.get().setDescription(p.getDescription());
                }
                return categoryRepository.save(q.get());
            }
        }
        return p;
    }
    
    //public boolean delete (int id){
      //  boolean flag=false;
        //Optional<Category> p = categoryRepository.getCategory(id);
        //if(p.isPresent()){
          //  categoryRepository.delete(p.get());
           // flag = true;
       // }
                
        //return flag;       
    //}
     public boolean deleteCategory(int id){
        Boolean d = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
    
}
