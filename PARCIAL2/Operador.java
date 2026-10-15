package co.edu.uniquindio.Programacion1.PixelRentParcial2;

public class Operador {
    private String cedula;
    private String nombre;
    private String certificacion;
    private int aniosExperiencia;

    public Operador(String cedula, String nombre, String certificacion){
        this.cedula = cedula;
        this.nombre = nombre;
        this.certificacion = certificacion;
        this.aniosExperiencia = aniosExperiencia;
    }

    //Getters and setters
    public String getCedula(){

        return cedula;
    }

    public void setCedula(String cedula){

        this.cedula = cedula;
    }

    public String getNombre() {

        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getCertificacion() {

        return certificacion;
    }

    public void setCertificacion(String certificacion) {

        this.certificacion = certificacion;
    }
    public int getAniosExperiencia() {

        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {

        this.aniosExperiencia = aniosExperiencia;
    }
}
