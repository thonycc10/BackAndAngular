package com.thony.spring.boot.backend.apirest.springbootbackendapirest.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String observacion;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    @JsonIgnoreProperties({"facturas","hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY) // ojo la sociacion es asi muchas facturas estan asociadas a un cliente
    //@JoinColumn(name = "cliente_id") // nombre de la llave forania
    private Cliente cliente;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private List<ItemFactura> itemFacturaList;

    public Factura() {
        itemFacturaList = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItemFacturaList() {
        return itemFacturaList;
    }

    public void setItemFacturaList(List<ItemFactura> itemFacturaList) {
        this.itemFacturaList = itemFacturaList;
    }

    public Double getTotal() {
        Double total = 0.00;
        for(ItemFactura itemFactura: itemFacturaList) {
            total += itemFactura.getImporte();
        }
        return total;
    }

    private static final long serialVersionUID = 1L;
}
