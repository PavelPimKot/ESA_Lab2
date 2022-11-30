package com.example.esa_lab2.beans.repository;

import com.example.esa_lab2.entities.Client;

import java.util.List;

public interface ClientRepository extends Repository {
    Client getClient(Integer id);

    List<Client> findClientByLoginAndPassword(String login, String password);
}
