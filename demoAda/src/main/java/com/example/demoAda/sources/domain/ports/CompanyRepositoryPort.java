package com.example.demoAda.sources.domain.ports;


import com.example.demoAda.sources.domain.model.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepositoryPort {
    Company save(Company company);
    void delete(Integer id);
    Optional<Company> findById(Integer id);
    Optional<Company> findByCodigo(String codigo);
    List<Company> findAll();
}
