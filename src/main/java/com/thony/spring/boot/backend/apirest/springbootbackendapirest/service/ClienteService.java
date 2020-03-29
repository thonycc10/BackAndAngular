package com.thony.spring.boot.backend.apirest.springbootbackendapirest.service;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Cliente;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Factura;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Producto;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Region;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClienteService {

    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pegeable);

    public Cliente save(Cliente cliente);

    public List<Region> findAllRegiones();

    public void delete(Long id);

    public Cliente findById(Long id);

    public Factura findFacturadById(Long id);

    public Factura saveFactura(Factura factura);

    public void deleteFactura(Long id);

    public List<Producto> findProductoByNombre(String term);

}
