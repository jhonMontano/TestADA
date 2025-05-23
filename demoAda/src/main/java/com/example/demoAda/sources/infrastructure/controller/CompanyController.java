package com.example.demoAda.sources.infrastructure.controller;


import com.example.demoAda.sources.application.services.CompanyService;
import com.example.demoAda.sources.domain.model.Company;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService service;

    @PersistenceContext
    private EntityManager em;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Company> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getById(@PathVariable Integer id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        return service.save(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable Integer id, @RequestBody Company updated) {
        updated.setIdCompany(id);
        return ResponseEntity.ok(service.save(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/code/{codigo}")
    public ResponseEntity<Map<String, Object>> getCompanyAppVersion(@PathVariable String codigo) {
        String sql = """
            SELECT c.codigo_company, c.name_company, a.app_name, v.version
            FROM company c
            JOIN version_company vc ON vc.company_id = c.id_company
            JOIN application a ON vc.app_id = a.app_id
            JOIN version v ON vc.version_id = v.version_id
            WHERE c.codigo_company = :codigo
        """;

        Query query = em.createNativeQuery(sql);
        query.setParameter("codigo", codigo);
        List<Object[]> result = query.getResultList();

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Object[] row = result.get(0);
        Map<String, Object> response = new HashMap<>();
        response.put("codigo_company", row[0]);
        response.put("name_company", row[1]);
        response.put("app_name", row[2]);
        response.put("version", row[3]);

        return ResponseEntity.ok(response);
    }
}
