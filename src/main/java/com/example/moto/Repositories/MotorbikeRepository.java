
package com.example.moto.Repositories;

import com.example.moto.entities.Motorbike;
import com.example.moto.repository.crudRepository.MotorbikeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MotorbikeRepository {
    
    @Autowired
    private MotorbikeCrudRepository  extensionesCrud;
    
    public List<Motorbike> getAll(){
        return (List<Motorbike>)  extensionesCrud.findAll();
        
    }
    
    public Optional<Motorbike> getMotorbike(int id){
       return  extensionesCrud.findById(id);
    }
  
   
    public Motorbike save(Motorbike p){
        return  extensionesCrud.save(p);
    }
    
    public void delete(Motorbike p) {
        extensionesCrud.delete(p);
    }
    
}
