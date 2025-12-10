
package com.castores.prueba.model;


public class HistoricoDTO {

    private int tipoMovimiento;
    private int cantidad;
    private int idProducto;
    private String usuarioMovimiento;

    public HistoricoDTO() {
    }

    public HistoricoDTO( int tipoMovimiento, int cantidad, String usuarioMovimiento, int idProducto) {
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
        this.usuarioMovimiento = usuarioMovimiento;
        this.idProducto = idProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
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

}
