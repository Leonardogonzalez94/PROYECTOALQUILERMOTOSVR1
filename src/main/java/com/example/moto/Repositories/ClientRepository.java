
package com.example.moto.Repositories;

import com.example.moto.entities.Client;
import com.example.moto.repository.crudRepository.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ClientRepository {
    
    @Autowired
    private ClientCrudRepository extensionesCrud;
    
    public List<Client> getAll(){
        return (List<Client>) extensionesCrud.findAll();
        
    }
    
    public Optional<Client> getClient(int id){
       return extensionesCrud.findById(id);
    }
    /**
     *
     * @param p
     * @return
     */
   
    public Client save(Client p){
        return extensionesCrud.save(p);
    }
    
    public void delete(Client p) {
        extensionesCrud.delete(p);
    }
    
      

    
}