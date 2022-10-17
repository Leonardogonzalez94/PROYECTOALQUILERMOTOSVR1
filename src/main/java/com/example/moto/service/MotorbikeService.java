
package com.example.moto.service;

import com.example.moto.entities.Motorbike;
import com.example.moto.Repositories.MotorbikeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotorbikeService {
    
    @Autowired
    private MotorbikeRepository motorbikeRepository;
    
    public List<Motorbike> getAll(){
        return motorbikeRepository.getAll();
    }
    
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);                      
    }
    
    public Motorbike save(Motorbike p){
        if (p.getId()==null){
            return motorbikeRepository.save(p);
        }else{
            Optional<Motorbike> e = motorbikeRepository.getMotorbike(p.getId());
            if (e.isPresent()){
                return motorbikeRepository.save(p);
            }else{
                return p;
            }
         }
        
    }
    
  
      public Motorbike update(Motorbike motorbike){
        if(motorbike.getId()!=null){
            Optional<Motorbike> e= motorbikeRepository.getMotorbike(motorbike.getId());
            if(!e.isPresent()){
                if(motorbike.getName()!=null){
                    e.get().setName(motorbike.getName());
                }
                if(motorbike.getYear()!=null){
                    e.get().setYear(motorbike.getYear());
                }
                if(motorbike.getBrand()!=null){
                    e.get().setBrand(motorbike.getBrand());
                }
                if(motorbike.getDescription()!=null){
                    e.get().setDescription(motorbike.getDescription());
                }
                if(motorbike.getCategory()!=null){
                    e.get().setCategory(motorbike.getCategory());
                }
                motorbikeRepository.save(e.get());
                return e.get();
            }else{
                return motorbike;
            }
        }else{
            return motorbike;
        }
    }
    //public boolean delete (int id){
      //  boolean flag=false;
       // Optional<Motorbike> p = motorbikeRepository.getMotorbike(id);
       // if(p.isPresent()){
         //   motorbikeRepository.delete(p.get());
          //  flag = true;
        //}
                
        //return flag;       
    //}
     public boolean deleteMotorbike(int id){
        Boolean d = getMotorbike(id).map(motorbike -> {
            motorbikeRepository.delete(motorbike);
            return true;
        }).orElse(false);
        return d;
    }
    
    
}


