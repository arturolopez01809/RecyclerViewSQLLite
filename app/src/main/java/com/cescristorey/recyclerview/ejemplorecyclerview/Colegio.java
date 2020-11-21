package com.cescristorey.recyclerview.ejemplorecyclerview;

/**
 * Created by Luis on 23/10/2017.
 */

public class Colegio {

    private int cod_colegio;
    private String nombre;
    private String direccion;

    public Colegio(int cod_colegio, String nombre, String direccion) {
        this.cod_colegio = cod_colegio;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getCod_colegio() {
        return this.cod_colegio;
    }

    public void setCod_colegio(int cod_colegio) {
        this.cod_colegio = cod_colegio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


}
