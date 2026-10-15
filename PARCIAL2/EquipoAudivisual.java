package co.edu.uniquindio.Programacion1.PixelRentParcial2;

//Clase Padre
public abstract class EquipoAudivisual {
    protected int codigo;
    protected String marca;
    protected String modelo;
    protected String estado;

    public EquipoAudivisual(int codigo, String marca, String modelo, String estado){
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
    }
    public boolean identificarDisponibilidad(){
        return estado.equalsIgnoreCase("Disponible");
    }
    //Por defecto un equipo no requiere operador, el dron lo sobrescribe
    public boolean requiereOperador() {
        return false;
    }
    //Cada clase hija debe implementarlo
    public abstract double calcularCosto(int horas);

    @Override
    public String toString() {
        return "EquipoAudiovisual:" + codigo + "-" + marca + "-" + modelo + "-" + estado;
    }
    //Getters and setters
    public int getCodigo(){

        return this.codigo;
    }

    public void setCodigo(int codigo){

        this.codigo = codigo;
    }

    public String getMarca() {

        return marca;
    }

    public void setMarca(String marca) {

        this.marca = marca;
    }

    public String getModelo() {

        return modelo;
    }

    public void setModelo(String modelo) {

        this.modelo = modelo;
    }
    public String getEstado() {

        return estado;
    }

    public void setEstado(String estado) {

        this.estado = estado;
    }
}


