package com.example.esa_lab2.beans.service;

import com.example.esa_lab2.entities.Client;

import java.util.List;

public interface ClientService {
    Client getClient(Integer id);

    List<Client> findClientByLoginAndPassword(String login, String password);

    void save(Client client);
}
