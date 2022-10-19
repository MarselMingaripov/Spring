package com.example.demojr.service;

import com.example.demojr.models.Client;
import com.example.demojr.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientsRepository clientsRepository;
    @Override
    public void create(Client client) {
    clientsRepository.save(client);
    }

    @Override
    public List<Client> readAll() {
        return clientsRepository.findAll();
    }

    @Override
    public Client read(int id) {
        return clientsRepository.getOne(id);
    }

    @Override
    public boolean update(Client client, int id) {
        if (clientsRepository.existsById(id)){
            client.setId(id);
            clientsRepository.save(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        if (clientsRepository.existsById(id)){
            clientsRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
