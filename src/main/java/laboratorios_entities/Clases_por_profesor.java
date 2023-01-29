/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_entities;

/**
 *
 * @author cchav
 */
public class Clases_por_profesor {
    private Long id = null;
    private Long id_profesor;
    private Long id_clase;

    public Clases_por_profesor() {
    }

    public Clases_por_profesor(Long id_profesor, Long id_clase) {
        this.id_profesor = id_profesor;
        this.id_clase = id_clase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(Long id_profesor) {
        this.id_profesor = id_profesor;
    }

    public Long getId_clase() {
        return id_clase;
    }

    public void setId_clase(Long id_clase) {
        this.id_clase = id_clase;
    }

    @Override
    public String toString() {
        return "Clases_por_profesor{" + "id=" + id + ", id_profesor=" + id_profesor + ", id_clase=" + id_clase + '}';
    }

    
    
    
}
