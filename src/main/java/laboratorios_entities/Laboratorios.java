/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_entities;

/**
 *
 * @author cchav
 */
public class Laboratorios {
    private Long id = null;
    private String nombre_laboratorio;

    public Laboratorios() {
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
        return "Laboratorios{" + "id=" + id + ", nombre_laboratorio=" + nombre_laboratorio + '}';
    }

    
    
    
    
}
