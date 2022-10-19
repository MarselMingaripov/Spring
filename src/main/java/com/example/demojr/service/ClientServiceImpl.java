package com.example.demojr.service;

import com.example.demojr.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ClientServiceImpl implements ClientService{

    //private final JdbcTemplate jdbcTemplate = new JdbcTemplate();
    //@Autowired
    //public ClientServiceImpl(JdbcTemplate jdbcTemplate){
     //   this.jdbcTemplate=jdbcTemplate;
   // }

    private static final Map<Integer, Client> CLIENT_MAP = new HashMap<>();
    private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();
    @Override
    public void create(Client client) {
        /*jdbcTemplate.update("INSERT INTO jr_db.public.cliens VALUES(?, ?, ?, ?)",
                client.getId(), client.getName(), client.getEmail(), client.getPhone());*/
        final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
        client.setId(clientId);
        CLIENT_MAP.put(clientId, client);

    }

    @Override
    public List<Client> readAll() {
        /*return jdbcTemplate.query("SELECT * FROM jr_db.public.cliens",
                new BeanPropertyRowMapper<>(Client.class));*/
        return new ArrayList<>(CLIENT_MAP.values());
    }

    @Override
    public Client read(int id) {
        /*return jdbcTemplate.query("SELECT * FROM jr_db.public.cliens WHERE id_user=?",new Object[]{id},
                new BeanPropertyRowMapper<>(Client.class)).stream().findAny().orElse(null);*/
        return CLIENT_MAP.get(id);
    }

    @Override
    public boolean update(Client client, int id) {
        /*jdbcTemplate.update("UPDATE jr_db.public.cliens SET name=?, email=?, phone=?, id_user=?",
                client.getName(), client.getEmail(), client.getPhone(),
                id);*/
        if (CLIENT_MAP.containsKey(id)){
            client.setId(id);
            CLIENT_MAP.put(id,client);
            return true;
        }
        return false;
        }

    @Override
    public boolean delete(int id) {
        /*jdbcTemplate.update("DELETE FROM jr_db.public.cliens WHERE id_user=? ", id);*/
        return CLIENT_MAP.remove(id) != null;
    }
}
