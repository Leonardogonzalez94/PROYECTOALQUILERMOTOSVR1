
package com.example.moto.Repositories;

import com.example.moto.entities.Client;
import com.example.moto.entities.Reservation;
import com.example.moto.repository.crudRepository.ReservationInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    
    @Autowired
    private ReservationInterface  extensionesCrud;
    
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
    public List <Reservation> getReservationByStatus (String status){
        return extensionesCrud.findAllByStatus(status);
    }
    
    public List <Reservation> informePeriodoTiempoReservas(Date a, Date b){
        return extensionesCrud.findAllByStartDateAfterAndStartDateBefore(a,b);
    }
    
    public List<CountClient> getTopClient(){
        List<CountClient> res= new ArrayList<>();
        List<Object[]> report = extensionesCrud.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }
   
}