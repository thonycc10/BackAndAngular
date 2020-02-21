package com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Cliente;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

    @Query("from Region")
    public List<Region> findAllRegiones();

}
