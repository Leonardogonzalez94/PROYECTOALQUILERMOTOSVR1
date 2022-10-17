package com.example.moto.service;

import com.example.moto.entities.Client;
import com.example.moto.Repositories.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);                      
    }
    
    public Client save(Client p){
        if (p.getIdClient()==null){
            return clientRepository.save(p);
        }else{
            Optional<Client> e = clientRepository.getClient((int) p.getIdClient());
            if (e.isPresent()){
                return clientRepository.save(p);
            }else{
                return p;
            }
         }
        
    }
    
    public Client update(Client client){
        if(client.getIdClient()!=null){
            Optional<Client> e= clientRepository.getClient(client.getIdClient());
            if(!e.isPresent()){
                if(client.getName()!=null){
                    e.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    e.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    e.get().setPassword(client.getPassword());
                }
                clientRepository.save(e.get());
                return e.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }

    
//    public boolean delete (int id){
   //   boolean flag=false;
     //   Optional<Client> p = clientRepository.getClient(id);
       // if(p.isPresent()){
         //   clientRepository.delete(p.get());
           // flag = true;
       // }
                
       // return flag;       
   // }
     public boolean deleteClient(int id){
        Boolean d = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return d;
    }
    
    
}
