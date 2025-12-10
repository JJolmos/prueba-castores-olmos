package com.castores.prueba.model;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name = "historico")
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMovimiento", updatable = false, nullable = false)
    private int id;

    @Column(name = "tipoMovimiento", nullable = false)
    private int tipoMovimiento;

    @Column(name = "cantidad", nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "idProducto")
    private Productos idProducto;

    @Column(name = "usuarioMovimiento", nullable = false)
    private String usuarioMovimiento;

    @CreationTimestamp
    private Instant createdAt;

    public Historico() {
    }

    public Historico( int tipoMovimiento, int cantidad, String usuarioMovimiento, Productos idProducto) {
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.usuarioMovimiento = usuarioMovimiento;
        this.idProducto = idProducto;
    }

    public Productos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Productos idProducto) {
        this.idProducto = idProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUsuarioMovimiento() {
        return usuarioMovimiento;
    }

    public void setUsuarioMovimiento(String usuarioMovimiento) {
        this.usuarioMovimiento = usuarioMovimiento;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

}
