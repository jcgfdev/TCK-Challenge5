package co.com.jcgfdev.challenge5.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class Producto {
    private String id;

    @NotBlank
    private String nombre;

    @NotNull
    private Integer cantidad;

    public Producto() {
    }

    public Producto(String id, String nombre, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String id() {
        return id;
    }

    public Producto setId(String id) {
        this.id = id;
        return this;
    }

    public String nombre() {
        return nombre;
    }

    public Producto setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Integer cantidad() {
        return cantidad;
    }

    public Producto setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }
}
