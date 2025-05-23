package com.example.demoAda.sources.infrastructure.repository;

import com.example.demoAda.sources.domain.model.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataCompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    Optional<CompanyEntity> findByCodigoCompany(String codigoCompany);
}
