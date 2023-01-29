/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_entities;

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

    public Clases() {
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

    @Override
    public String toString() {
        return "Clases{" + "id=" + id + ", codigo_clase=" + codigo_clase + ", nombre_clase=" + nombre_clase + ", cantidad_estudiantes_clase=" + cantidad_estudiantes_clase + ", cantidad_creditos=" + cantidad_creditos + '}';
    }

   
    
    
}
