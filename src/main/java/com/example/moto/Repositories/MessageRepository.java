
package com.example.moto.Repositories;

import com.example.moto.entities.Message;
import com.example.moto.repository.crudRepository.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository extensionesCrud;
    
    public List<Message> getAll(){
        return (List<Message>) extensionesCrud.findAll();
    }
    
    public Optional<Message> getMessage(int id){
       return extensionesCrud.findById(id);
    }

   
    public Message save(Message p){
        return extensionesCrud.save(p);
    }
    
    public void delete(Message p) {
        extensionesCrud.delete(p);
    }
    
}
