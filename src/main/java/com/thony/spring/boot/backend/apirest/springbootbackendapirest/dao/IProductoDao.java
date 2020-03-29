package com.thony.spring.boot.backend.apirest.springbootbackendapirest.dao;
import com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface IProductoDao extends CrudRepository<Producto, Long> {

    // para buscar consultas de acuerdo a la igualdad se usa %%
    @Query("select p from Producto p where p.nombre like %?1%")
    public List<Producto> findProductoByNombre(String term);
//
//    // ojo puedes añadir varias metodos en el mismo nombre orden del metodo doc Spring JPA
    public List<Producto> findByNombreContainingIgnoreCase(String term);
//
    public List<Producto> findByNombreStartingWithIgnoreCase(String term);

}
