package com.example.demoAda.sources.domain.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompany;

    @Column(unique = true)
    private String codigoCompany;

    private String nameCompany;
    private String descriptionCompany;

}
