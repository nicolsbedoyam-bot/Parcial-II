package co.edu.uniquindio.Programacion1.PixelRentParcial2;

import enumrecord.Vehiculo;

import java.time.LocalDate;

public record Cliente (String nombre, String cedula, int telefono, String correo){
    @Override
    public String toString() {
        return "Cliente:" + nombre + "-" + cedula + "-" + telefono + "-" + correo;
    }
}


