package com.tuyo.tuyofood.api.controller;

import com.tuyo.tuyofood.api.model.KitchensXmlWrapper;
import com.tuyo.tuyofood.domain.entity.Kitchen;
import com.tuyo.tuyofood.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* ResponseEntity:
 1. permite a customização da resposta HTTP
 2. permite também a customização dos headers das respostas */

@RestController
@RequestMapping(value = "/kitchens")
public class KitchenController {

    @Autowired
    private KitchenRepository kitchenRepository;

    /* Listando Coleções de Kitchen */
    @GetMapping
    public List<Kitchen> listar() {
        return kitchenRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public KitchensXmlWrapper listarXml() {
        return new KitchensXmlWrapper(kitchenRepository.listar());
    }

    @GetMapping("/{kitchenId}")
    public ResponseEntity<Kitchen> buscar(@PathVariable Long kitchenId) {
        Kitchen kitchen = kitchenRepository.buscar(kitchenId);

//      Definindo o Status:
//		return ResponseEntity.status(HttpStatus.OK).body(kitchen);

//      mesmo que o de cima mas é um atalho:
//		return ResponseEntity.ok(kitchen);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "http://localhost:8080/kitchens/");

//      Customizando os
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .headers(headers)
                .build();
    }
}
