package Veterinaria;

public class Duenio {
    private String cedula;
    private String nombre;
    private String numeroContacto;
    private String direccion;

    private Mascota[] listMascotas;

    public Duenio(String cedula, String nombre, String numeroContacto, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.numeroContacto = numeroContacto;
        this.direccion = direccion;
        listMascotas = new Mascota[10];
    }

    //Getters and setters
    public String getCedula(){

        return cedula;
    }
    public void setCedula(String cedula){

        this.cedula = cedula;
    }
    public String getNombre(){

        return nombre;
    }
    public void setNombre(String nombre){

        this.nombre = nombre;
    }

    public String getNumeroContacto(){

        return numeroContacto;
    }

    public void setNumeroContacto (String numeroContacto){

        this.numeroContacto = numeroContacto;
    }

    public String getDireccion() {

        return direccion;
    }

    public void setDireccion(String direccion){

        this.direccion = direccion;
    }

    public Mascota[] getListMascotas(){

        return listMascotas;
    }

    public void setListMascotas(Mascota[] listMascotas){

        this.listMascotas = listMascotas;
    }


}

