/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_entities;

import java.util.Objects;

/**
 *
 * @author cchav
 */
public class Laboratorios {
    private Long id = null;
    private String nombre_laboratorio;

    public Laboratorios() {
    }

    public Laboratorios(Long id) {
        this.id = id;
    }
    
    
    

    public Laboratorios(Long id, String nombre_laboratorio) {
        this.id = id;
        this.nombre_laboratorio = nombre_laboratorio;
    }

    
    
    public Laboratorios(String nombre_laboratorio) {
        this.nombre_laboratorio = nombre_laboratorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_laboratorio() {
        return nombre_laboratorio;
    }

    public void setNombre_laboratorio(String nombre_laboratorio) {
        this.nombre_laboratorio = nombre_laboratorio;
    }

   @Override
    public String toString() {
        return this.nombre_laboratorio;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Laboratorios other = (Laboratorios) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
    
}
