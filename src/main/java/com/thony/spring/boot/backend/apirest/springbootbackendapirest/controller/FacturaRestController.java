package com.thony.spring.boot.backend.apirest.springbootbackendapirest.controller;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Factura;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura get(@PathVariable Long id) {
        return clienteService.findFacturadById(id);
    }

    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.deleteFactura(id);
    }
}
