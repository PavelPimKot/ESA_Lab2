package com.example.esa_lab2.beans.service.impl;

import com.example.esa_lab2.beans.repository.impl.ClientRepositoryImpl;
import com.example.esa_lab2.beans.service.ClientService;
import com.example.esa_lab2.entities.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "clientService")
public class ClientServiceImpl implements ClientService {
    public ClientServiceImpl(ClientRepositoryImpl clientRepository) {
        this.clientRepository = clientRepository;
    }

    private ClientRepositoryImpl clientRepository;

    @Override
    public Client getClient(Integer id) {
        return clientRepository.getClient(id);
    }

    @Override
    public List<Client> findClientByLoginAndPassword(String login, String password) {
        return clientRepository.findClientByLoginAndPassword(login, password);
    }

    @Override
    public void save(Client client) {
        clientRepository.save(client);
    }
}
