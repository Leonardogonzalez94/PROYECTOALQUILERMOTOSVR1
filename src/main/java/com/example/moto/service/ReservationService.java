package com.example.moto.service;

import com.example.moto.entities.Reservation;
import com.example.moto.Repositories.ReservationRepository;
import com.example.moto.Service.Status;
import com.example.moto.Repositories.CountClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//import javax.transaction.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);                      
    }
    
    public Reservation save(Reservation p){
        if (p.getIdReservation()==null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation((int) p.getIdReservation());
            if (e.isPresent()){
                return reservationRepository.save(p);
            }else{
                return p;
            }
         }
        
    }
    
    public Reservation update(Reservation p){
        if (p.getIdReservation()!=null){
            Optional <Reservation> q =reservationRepository.getReservation(p.getIdReservation());
            if(!q.isPresent()){
                if (p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
                }
                 if (p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                if (p.getStatus()!=null){
                    q.get().setStatus(p.getStatus());
                }
                
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return p;
            }
        }else{
            return p;
        }
    }
    
    //public boolean delete (int id){
      //  boolean flag=false;
       // Optional<Reservation> p = reservationRepository.getReservation(id);
       // if(p.isPresent()){
         //   reservationRepository.delete(p.get());
          //  flag = true;
       // }
                
       // return flag;       
    //}
    
    public boolean deleteReservation(int id){
        Boolean d = getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse(false);
        return d;
    }
    
     public Status getReservationStatusReport(){
           List<Reservation>completed=reservationRepository.getReservationByStatus("completed");
           List<Reservation>cancelled=reservationRepository.getReservationByStatus("cancelled");
           return new Status (completed.size(),cancelled.size()); 
       }

    public List<Reservation> informePeriodoTiempoReservas(String datoA, String datoB){
           SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
           Date a = new Date();
           Date b = new Date();
           
           try{
               a = parser.parse(datoA);
               b= parser.parse(datoB);
           }catch(ParseException e){
               e.printStackTrace();
           }
           
           if (a.before(b)){
               return reservationRepository.informePeriodoTiempoReservas(a, b);
           }else{
               return new ArrayList<>();
           }
           
    }

    public List<CountClient> getTopClients() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

    
