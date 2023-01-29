/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_entities;

/**
 *
 * @author cchav
 */
public class Profesores {
    private Long id = null;
    private String nombre_profesor;
    private String apellido_profesor;
    private String codigo_profesor;

    public Profesores() {
    }

    public Profesores(String nombre_profesor, String apellido_profesor, String codigo_profesor) {
        this.nombre_profesor = nombre_profesor;
        this.apellido_profesor = apellido_profesor;
        this.codigo_profesor = codigo_profesor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getApellido_profesor() {
        return apellido_profesor;
    }

    public void setApellido_profesor(String apellido_profesor) {
        this.apellido_profesor = apellido_profesor;
    }

    public String getCodigo_profesor() {
        return codigo_profesor;
    }

    public void setCodigo_profesor(String codigo_profesor) {
        this.codigo_profesor = codigo_profesor;
    }

    @Override
    public String toString() {
        return "Profesores{" + "id=" + id + ", nombre_profesor=" + nombre_profesor + ", apellido_profesor=" + apellido_profesor + ", codigo_profesor=" + codigo_profesor + '}';
    }

    
    
    
    
}
