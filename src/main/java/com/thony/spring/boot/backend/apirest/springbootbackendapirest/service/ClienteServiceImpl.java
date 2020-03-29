package com.thony.spring.boot.backend.apirest.springbootbackendapirest.service;

import com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao.ClienteDao;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao.IFacturaDao;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao.IProductoDao;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Cliente;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Factura;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Producto;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Autowired
    private IFacturaDao facturaDao;

    @Autowired
    private IProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pegeable) {
        return clienteDao.findAll(pegeable);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones() {
        return clienteDao.findAllRegiones();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(Long id) {
        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura findFacturadById(Long id) {
        return facturaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Factura saveFactura(Factura factura) {
        return facturaDao.save(factura);
    }

    @Override
    @Transactional
    public void deleteFactura(Long id) {
        facturaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Producto> findProductoByNombre(String term) {
        return productoDao.findByNombreContainingIgnoreCase(term);
    }
}
