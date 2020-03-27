package com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Factura;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {
}
