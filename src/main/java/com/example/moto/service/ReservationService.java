package com.example.moto.service;

import com.example.moto.entities.Reservation;
import com.example.moto.Repositories.ReservationRepository;
import java.util.List;
import java.util.Optional;
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
            Optional <Reservation> q =reservationRepository.getReservation((int) p.getIdReservation());
            if(q.isPresent()){
                if (p.getStartDate()!=null){
                    q.get().setStartDate(p.getStartDate());
                }
                if (p.getStatus()!=null){
                    q.get().setStatus(p.getStatus());
                }
                if (p.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(p.getDevolutionDate());
                }
                if (p.getScore()!=null){
                    q.get().setScore(p.getScore());
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

    
}
