package Mascota;

import Veterinaria.Veterinaria;

import javax.swing.*;

public class Main {

        static Mascota[] listaMascostas = new Mascota[1];

        static void mai() {

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
                        mostrarListaMascotas();
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
            String nombrePropietario = JOptionPane.showInputDialog("Ingrese el nombre del propietario de la mascota");
            String numeroContatcto = JOptionPane.showInputDialog("Ingrese el numero de contacto del propietario");

            Mascota nuevaMascota = new Mascota("M-" + nombre + "-" + edad, nombre, raza, especie, edad, nombrePropietario, numeroContatcto);

            boolean resultado = registrarMascota(nuevaMascota.getId(), nuevaMascota);

            if (resultado) {
                JOptionPane.showMessageDialog(null, "Registro exitoso");
            } else {
                JOptionPane.showMessageDialog(null, "No se hizo el registrp");
            }
        }

        public static boolean registrarMascota(String idNuevaMascota, Mascota nuevaMascota) {

            if (encontrarIndexMascota(idNuevaMascota) == -1) {
                for (int i = 0; i < listaMascostas.length; i++) {
                    if (listaMascostas[i] == null) {
                        listaMascostas[i] = nuevaMascota;
                        return true;
                    }
                }
            }
            return false;
        }

        public static int encontrarIndexMascota(String idMascotaBuscar) {

            for (int i = 0; i < listaMascostas.length; i++) {
                if (listaMascostas[i] != null && listaMascostas[i].getId().equals(idMascotaBuscar)) {
                    return i;

                }
            }
            return -1;
        }

        //Mostrar la informcion de las mascotas
        private static void solicitarIdMascota() {
            String idMascotaMostrar = JOptionPane.showInputDialog("Ingrese el ID de la mascota que quiere ver");

            String resultado = mostrarMascota(idMascotaMostrar);

            JOptionPane.showMessageDialog(null, resultado);


        }

        private static String mostrarMascota(String idMascotaMostrar) {
            String mensaje = "";
            int index = encontrarIndexMascota(idMascotaMostrar);

            if (index != -1) {
                Mascota mascotaEncontrada = listaMascostas[index];
                mensaje = "Mascota encontrada:\n" + "\nNombre: " + mascotaEncontrada.getNombre() + "\nRaza: " + mascotaEncontrada.getRaza() + "\nEspecie:" + mascotaEncontrada.getEspecie() + "\nEdad: " + mascotaEncontrada.getEdad() + "\nPropietario: " + mascotaEncontrada.getNombrePropietario() + "\nNumeroContacto:" + mascotaEncontrada.getNumeroContacto();
            } else {
                mensaje = "La mascota no se encuentra en la lista";
            }
            return mensaje;

        }

        //Mostrar todas las mascotas
        private static void mostrarListaMascotas() {
            String mensaje = "Lista de mascotas:\n";

            for (int i = 0; i < listaMascostas.length; i++) {
                if (listaMascostas[i] != null) {
                    mensaje += "\nNombre: " + listaMascostas[i].getNombre() + "\nRaza: " + listaMascostas[i].getRaza() + "\nEspecie: " + listaMascostas[i].getEspecie() + "\nEdad: " + listaMascostas[i].getEdad() + "\nNombrePropietario: " + listaMascostas[i].getNombrePropietario() + "\nNumeroContacto: " + listaMascostas[i].getNumeroContacto();
                }
                JOptionPane.showMessageDialog(null, mensaje);


            }
            //Actualizar la informacion de las mascotas
            private static void solicitarInformacionActualizarMascota() {
                String idMascotaActualizar = JOptionPane.showInputDialog("Ingrese el id de la mascota que quiere actualizar");
                int index = encontrarIndexMascota(idMascotaActualizar);

                if (index != -1) {
                    actualizarMascota(index);

                } else {
                    JOptionPane.showInputDialog("El id no fue encontrado");

                }

            }
            private static void actualizarMascota(int indexMascota) {

                String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
                listaMascostas[indexMascota].setNombre(nombre);

                String raza = JOptionPane.showInputDialog("Ingrese la raza de la mascota:");
                listaMascostas[indexMascota].setRaza(raza);

                String especie = JOptionPane.showInputDialog("Ingrese la especie de la mascota:");
                listaMascostas[indexMascota].setEspecie(especie);

                int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota:"));
                listaMascostas[indexMascota].setEdad(edad);

                String nombrePropietario = JOptionPane.showInputDialog("Ingrese el nombre del propietario de la mascota:");
                listaMascostas[indexMascota].setNombrePropietario(nombrePropietario);

                String numeroContacto = JOptionPane.showInputDialog("Ingrese el numero de contacto del propietario:");
                listaMascostas[indexMascota].setNumeroContacto(numeroContacto);

            }
            //Eliminar la informacion de las mascotas
            private static void solicitarInformacionEliminarMascota() {
                String idMascotaActualizar = JOptionPane.showInputDialog("Ingrese el id de la mascota que quiere eliminar: ");
                int index = encontrarIndexMascota(idMascotaActualizar);

                if (index != -1) {
                    listaMascostas[index] = null;
                } else {
                    JOptionPane.showInputDialog("El id no fue encontrado.");
                }

            }
        }
    }

