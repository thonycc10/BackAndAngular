package com.thony.spring.boot.backend.apirest.springbootbackendapirest.controller;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Factura;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Producto;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class FacturaRestController {

    @Autowired
    private ClienteService clienteService;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Factura get(@PathVariable Long id) {
        return clienteService.findFacturadById(id);
    }

    @Secured({"ROLE_ADMIN"})
    @DeleteMapping("/facturas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        clienteService.deleteFactura(id);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/facturas/filtrar-productos/{term}")
    @ResponseStatus(HttpStatus.OK)
    public List<Producto> filtrarProducto(@PathVariable String term) {
        return clienteService.findProductoByNombre(term);
    }

    @Secured({"ROLE_ADMIN"})
    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    public Factura crear(@RequestBody Factura factura) {
        return clienteService.saveFactura(factura);
    }
}
