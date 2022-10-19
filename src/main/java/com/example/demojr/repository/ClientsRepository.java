package com.example.demojr.repository;

import com.example.demojr.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface ClientsRepository extends JpaRepository<Client, Integer> {
}
