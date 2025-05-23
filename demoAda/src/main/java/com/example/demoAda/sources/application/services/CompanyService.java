package com.example.demoAda.sources.application.services;


import com.example.demoAda.sources.domain.model.Company;
import com.example.demoAda.sources.domain.ports.CompanyRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private final CompanyRepositoryPort repository;

    public CompanyService(CompanyRepositoryPort repository) {
        this.repository = repository;
    }

    public Company save(Company c) {
        return repository.save(c);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }

    public List<Company> findAll() {
        return repository.findAll();
    }

    public Optional<Company> findById(Integer id) {
        return repository.findById(id);
    }

    public Optional<Company> findByCodigo(String codigo) {
        return repository.findByCodigo(codigo);
    }
}
