package com.example.demoAda.sources.infrastructure.repository;

import com.example.demoAda.sources.domain.model.Company;
import com.example.demoAda.sources.domain.model.entity.CompanyEntity;
import com.example.demoAda.sources.domain.ports.CompanyRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaCompanyRepository implements CompanyRepositoryPort {

    private final SpringDataCompanyRepository jpa;

    public JpaCompanyRepository(SpringDataCompanyRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Company save(Company company) {
        return mapToDomain(jpa.save(mapToEntity(company)));
    }

    @Override
    public void delete(Integer id) {
        jpa.deleteById(id);
    }

    @Override
    public Optional<Company> findById(Integer id) {
        return jpa.findById(id).map(this::mapToDomain);
    }

    @Override
    public Optional<Company> findByCodigo(String codigo) {
        return jpa.findByCodigoCompany(codigo).map(this::mapToDomain);
    }

    @Override
    public List<Company> findAll() {
        return jpa.findAll().stream().map(this::mapToDomain).toList();
    }

    // Mapping
    private Company mapToDomain(CompanyEntity e) {
        return new Company(e.getIdCompany(), e.getCodigoCompany(), e.getNameCompany(), e.getDescriptionCompany());
    }

    private CompanyEntity mapToEntity(Company c) {
        return new CompanyEntity(c.getIdCompany(), c.getCodigoCompany(), c.getNameCompany(), c.getDescriptionCompany());
    }
}
