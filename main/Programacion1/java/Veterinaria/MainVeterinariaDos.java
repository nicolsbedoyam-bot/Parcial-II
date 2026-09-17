package Veterinaria;

import javax.swing.*;

public class MainVeterinariaDos {
    private static Veterinaria nuevaVeterinaria;

    static void main() {

        nuevaVeterinaria = new Veterinaria("1234", "Veterinaria UQ");

        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("Este es el menu de la veterinaria:" +
                    "\n Seleccione una opcion:" +
                    "\n 1. Registrar mascota" +
                    "\n 2.Mostrar mascotas" +
                    "\n 3. Buscar mascota por id" +
                    "\n 4. Actualizar mascota" +
                    "\n 5. Eliminar mascota" +
                    "\n 0. Salir del sistema"));

            switch (option) {
                case 1:
                    solicitarInformacionMascota();
                    break;
                case 2:
                    String mensaje = MainVeterinariaDos.nuevaVeterinaria.mostrarListaMascotas();
                    JOptionPane.showInputDialog(null, mensaje);
                    break;
                case 3:
                    solicitarIdMascota();
                    break;
                case 4:
                    solicitarInformacionActualizarMascota();
                    break;
                case 5:
                    solicitarInformacionEliminarMascota();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "El programa finalizo");
                    break;

                default:
                    JOptionPane.showInputDialog(null, "La opcion no es valida");
                    break;
            }


        } while (option != 0);
    }

    //Registrar la informacion de las mascotas
    private static void solicitarInformacionMascota() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
        String raza = JOptionPane.showInputDialog("Ingrese la raza de la mascota");
        String especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota "));

        boolean resultado = nuevaVeterinaria.registrarMascota(nombre, raza, especie, edad);

        if (resultado) {
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } else {
            JOptionPane.showMessageDialog(null, "No se hizo el registrp");
        }
    }

    //Mostrar la informcion de las mascotas
    private static void solicitarIdMascota() {
        String idMascotaMostrar = JOptionPane.showInputDialog("Ingrese el ID de la mascota que quiere ver");

        String resultado = nuevaVeterinaria.mostrarMascota(idMascotaMostrar);

        JOptionPane.showMessageDialog(null, resultado);


    }

    //Actualizar la informacion de las mascotas
    private static void solicitarInformacionActualizarMascota() {
        String idMascotaActualizar = JOptionPane.showInputDialog("Ingrese el id de la mascota que quiere actualizar");

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
        String raza = JOptionPane.showInputDialog("Ingrese la raza de la mascota:");
        String especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota:"));

        boolean resultadoActualizacion = nuevaVeterinaria.actualizarMascota(idMascotaActualizar, nombre, raza, especie, edad);

        if (resultadoActualizacion) {
            JOptionPane.showInputDialog(null, "Se modifico la mascota");
        } else {
            JOptionPane.showInputDialog(null, "No se puede modificar la mascota");

        }

    }

    //Eliminar la informacion de las mascotas
    private static void solicitarInformacionEliminarMascota() {
        String idMascotaActualizar = JOptionPane.showInputDialog("Ingrese el id de la mascota que quiere eliminar: ");

        boolean respuestaEliminar = nuevaVeterinaria.eliminarMascota(idMascotaActualizar);

        if (respuestaEliminar) {
            JOptionPane.showInputDialog(null, "Se elimino la mascota:");
        } else {
            JOptionPane.showInputDialog(null, "No se puede eliminar la mascota.");
        }


    }
}

