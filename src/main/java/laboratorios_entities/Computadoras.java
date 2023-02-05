/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorios_entities;



/**
 *
 * @author cchav
 */
public class Computadoras {
    private Long id = null;
    private String procesador_computadora;
    private String ram_computadora;
    private String almacenamiento_computadora;
    private Long id_laboratorio = null;
    private String nombre_laboratorio = null;
    
            

    public Computadoras() {
    }

    public Computadoras(String procesador_computadora, String ram_computadora, String almacenamiento_computadora, Long id_laboratorio) {
        this.procesador_computadora = procesador_computadora;
        this.ram_computadora = ram_computadora;
        this.almacenamiento_computadora = almacenamiento_computadora;
        
    }

    public Computadoras(String procesador_computadora, String ram_computadora, String almacenamiento_computadora, Long id_laboratorio, String nombre_laboratorio) {
        this.procesador_computadora = procesador_computadora;
        this.ram_computadora = ram_computadora;
        this.almacenamiento_computadora = almacenamiento_computadora;
        this.id_laboratorio = id_laboratorio;
        this.nombre_laboratorio = nombre_laboratorio;
    }

    public Computadoras(String procesador_computadora, String ram_computadora, String almacenamiento_computadora, String nombre_laboratorio) {
        this.procesador_computadora = procesador_computadora;
        this.ram_computadora = ram_computadora;
        this.almacenamiento_computadora = almacenamiento_computadora;
        this.nombre_laboratorio = nombre_laboratorio;
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
    
    

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcesador_computadora() {
        return procesador_computadora;
    }

    public void setProcesador_computadora(String procesador_computadora) {
        this.procesador_computadora = procesador_computadora;
    }

    public String getRam_computadora() {
        return ram_computadora;
    }

    public void setRam_computadora(String ram_computadora) {
        this.ram_computadora = ram_computadora;
    }

    public String getAlmacenamiento_computadora() {
        return almacenamiento_computadora;
    }

    public void setAlmacenamiento_computadora(String almacenamiento_computadora) {
        this.almacenamiento_computadora = almacenamiento_computadora;
    }

    

    @Override
    public String toString() {
        return "Computadoras{" + "id=" + id + ", procesador_computadora=" + procesador_computadora + ", ram_computadora=" + ram_computadora + ", almacenamiento_computadora=" + almacenamiento_computadora +'}';
    }

    
    
//    public static class Computadora_en_laboratorio{
//        private Long id;
//        private String nombre_laboratorio;
//
//        public Computadora_en_laboratorio() {
//        }
//
//        public Computadora_en_laboratorio(Long id, String nombre_laboratorio) {
//            this.id = id;
//            this.nombre_laboratorio = nombre_laboratorio;
//        }
//
//        public Long getId() {
//            return id;
//        }
//
//        public void setId(Long id) {
//            this.id = id;
//        }
//
//        public String getNombre_laboratorio() {
//            return nombre_laboratorio;
//        }
//
//        public void setNombre_laboratorio(String nombre_laboratorio) {
//            this.nombre_laboratorio = nombre_laboratorio;
//        }
//        
//        
//    }
    
}
