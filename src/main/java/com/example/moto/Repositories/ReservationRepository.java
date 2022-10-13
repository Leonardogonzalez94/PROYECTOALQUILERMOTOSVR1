
package com.example.moto.Repositories;

import com.example.moto.entities.Reservation;
import com.example.moto.repository.crudRepository.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationCrudRepository  extensionesCrud;
    
    public List<Reservation> getAll(){
        return (List<Reservation>)  extensionesCrud.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
       return  extensionesCrud.findById(id);
    }
    
  
    public Reservation save(Reservation p){
        return  extensionesCrud.save(p);
    }
    
    public void delete(Reservation p) {
         extensionesCrud.delete(p);
    }
   
}