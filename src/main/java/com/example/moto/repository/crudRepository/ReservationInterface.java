/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.moto.repository.crudRepository;

import com.example.moto.entities.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author USUARIO
 */
public interface ReservationInterface extends CrudRepository<Reservation, Integer> {
 
public List<Reservation> findAllByStatus(String status);

public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date datoUno, Date datoDos);

@Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationByClient();


}