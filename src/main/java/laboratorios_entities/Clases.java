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
public class Clases {
    
    private Long id = null;
    private String codigo_clase;
    private String nombre_clase;
    private int cantidad_estudiantes_clase;
    private int cantidad_creditos;
    private Long id_profesor;
    private Long id_laboratorio;
    private String nombre_laboratorio = null;
    private String nombre_profesor = null;
    
    public Clases() {
        
    }

    public Clases(Long id) {
        this.id = id;
    }
    
    

    public Clases(Long id, String codigo_clase, String nombre_clase) {
        this.id = id;
        this.codigo_clase = codigo_clase;
        this.nombre_clase = nombre_clase;
    }

    
    
    
    public Clases(String codigo_clase, String nombre_clase, int cantidad_estudiantes_clase, int cantidad_creditos) {
        this.codigo_clase = codigo_clase;
        this.nombre_clase = nombre_clase;
        this.cantidad_estudiantes_clase = cantidad_estudiantes_clase;
        this.cantidad_creditos = cantidad_creditos;
        
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo_clase() {
        return codigo_clase;
    }

    public void setCodigo_clase(String codigo_clase) {
        this.codigo_clase = codigo_clase;
    }

    public String getNombre_clase() {
        return nombre_clase;
    }

    public void setNombre_clase(String nombre_clase) {
        this.nombre_clase = nombre_clase;
    }

    public int getCantidad_estudiantes_clase() {
        return cantidad_estudiantes_clase;
    }

    public void setCantidad_estudiantes_clase(int cantidad_estudiantes_clase) {
        this.cantidad_estudiantes_clase = cantidad_estudiantes_clase;
    }

    public int getCantidad_creditos() {
        return cantidad_creditos;
    }

    public void setCantidad_creditos(int cantidad_creditos) {
        this.cantidad_creditos = cantidad_creditos;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public Long getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(Long id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    public String getNombre_laboratorio() {
        return nombre_laboratorio;
    }

    public void setNombre_laboratorio(String nombre_laboratorio) {
        this.nombre_laboratorio = nombre_laboratorio;
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Clases other = (Clases) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
    
    @Override
    public String toString() {
        return this.nombre_clase + " -- " + this.codigo_clase;
    }

    
   
    
    
}
