package co.edu.uniquindio.Programacion1.PixelRentParcial2;
import Herencia.Persona;
import enumrecord.EstadoOperativo;
import enumrecord.ReciboPago;

import java.util.LinkedList;

public class Sede {
    private int codigo;
    private String nombre;
    private String direccion;
    private LinkedList<EquipoAudivisual>listEquiposAudiovisuales;

    public Sede(int codigo, String nombre, String direccion){
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this. listEquiposAudiovisuales= new LinkedList<>();
    }
    public void equiposAsignados(EquipoAudivisual equipoAudivisual){
        listEquiposAudiovisuales.add(equipoAudivisual);
    }

    //Getters and setters
    public int getCodigo(){

        return codigo;
    }

    public void setCodigo(int codigo){

        this.codigo = codigo;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getDireccion() {

        return direccion;
    }

    public void setDireccion(String direccion) {

        this.direccion = direccion;
    }


}
