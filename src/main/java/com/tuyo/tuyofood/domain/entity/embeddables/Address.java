package com.tuyo.tuyofood.domain.entity.embeddables;

import javax.persistence.*;

import com.tuyo.tuyofood.domain.entity.City;
import lombok.Data;

/* 1. @Data: gera Getters, Setters, ToString, Equals and HashCode e etc...
*  2. @Embeddable: É uma classe incormporável. Tem a capacidade de ser incorporada em uma entidade.
* Ou seja, ela parte de uma entidade e não de uma outra entidade em si. E todas as propriedades dessa
* classes são refletidas na entidade que a incorpora.
*  3. Não Esquecer: Adicionar dados para teste no import.sql  */

@Data
@Embeddable
public class Address {

    @Column(name = "address_cep")
    private String cep;

    @Column(name = "address_logradouro")
    private String logradouro;

    @Column(name = "address_numero")
    private String numero;

    @Column(name = "address_complemento")
    private String complemento;

    @Column(name = "address_bairro")
    private String bairro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_city_id")
    private City city;

}

