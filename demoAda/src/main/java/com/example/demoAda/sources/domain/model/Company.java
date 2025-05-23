package com.example.demoAda.sources.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Company {
    private Integer idCompany;
    private String codigoCompany;
    private String nameCompany;
    private String descriptionCompany;
}
