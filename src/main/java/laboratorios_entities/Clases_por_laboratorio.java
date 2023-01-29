/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_entities;

/**
 *
 * @author cchav
 */
public class Clases_por_laboratorio {
    private Long id = null;
    private Long id_clase;
    private Long id_laboratorio;

    public Clases_por_laboratorio() {
    }

    public Clases_por_laboratorio(Long id_clase, Long id_laboratorio) {
        this.id_clase = id_clase;
        this.id_laboratorio = id_laboratorio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_clase() {
        return id_clase;
    }

    public void setId_clase(Long id_clase) {
        this.id_clase = id_clase;
    }

    public Long getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(Long id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }

    @Override
    public String toString() {
        return "Clases_por_laboratorio{" + "id=" + id + ", id_clase=" + id_clase + ", id_laboratorio=" + id_laboratorio + '}';
    }

    
    
}
