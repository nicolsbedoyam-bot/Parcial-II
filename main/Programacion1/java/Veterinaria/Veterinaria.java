package Veterinaria;

public class Veterinaria {
    private String nit;
    private String nombre;

    private Mascota[] listMascotas;
    private Duenio[] listDuenios;

    public Veterinaria(String nit, String nombre) {
        this.nit = nit;
        this.nombre = nombre;
        listMascotas = new Mascota[10];
        listDuenios = new Duenio[10];
    }


    //Metodos logicos CRUD Duenio
    // C- Crear/ Registrar/ Guardar un duenio
    public boolean registrarDuenio(String cedula, String nombre, String numeroContacto, String direccion) {

        Duenio nuevoDuenio = new Duenio("D-" + cedula, nombre, numeroContacto, direccion);

        if (encontrarIndexDuenio(nuevoDuenio.getCedula()) == -1) {
            for (int i = 0; i < listDuenios.length; i++) {
                if (listDuenios[i] == null) {
                    listDuenios[i] = nuevoDuenio;
                    return true;
                }
            }
        }
        return false;

    }
    //R - Leer/Mostrar/ Imprimir un duenio
    public String mostrarDuenio(String cedulaDuenioMostrar) {
        String mensaje = "";
        int index = encontrarIndexMascota(cedulaDuenioMostrar);

            if (index != -1) {
                Duenio duenioEncontrado = listDuenios[index];

                mensaje = "Duenio encontrado:\n" +
                        "\nCedula: " + duenioEncontrado.getCedula() + "\nNombre: " + duenioEncontrado.getNombre() +
                        "\nNumeroContacto: " + duenioEncontrado.getNumeroContacto() + "\nDireccion: " + duenioEncontrado.getDireccion();
            } else {
                mensaje = "El duenio no se encuentra en la lista.";
            }
            return mensaje;

    }
    //R - Mostrar todos los duenios
    public String mostrarListaDuenios() {
        String mensaje = "Lista de duenios:\n";

        for (int i = 0; i < listDuenios.length; i++) {
            if (listDuenios[i] != null) {
                mensaje += "\nCedula: " + listDuenios[i].getCedula() + "\nNombre: " + listDuenios[i].getNombre() +
                        "\nNumeroContacto: " + listDuenios[i].getNumeroContacto() + "\nDireccion: " + listDuenios[i].getDireccion();
            }
        }
        return mensaje;
    }
    //U - Actulizar/Modificar/Cambiar un duenio
    public boolean actualizarDuenio(String cedulaDuenioActualizar, String nombre, String numeroContacto, String direccion) {
        boolean respuesta = false;
        int index = encontrarIndexDuenio(cedulaDuenioActualizar);

        if (index != -1) {
            listDuenios[index].setCedula(cedulaDuenioActualizar);
            listDuenios[index].setNombre(nombre);
            listDuenios[index].setNumeroContacto(numeroContacto);
            listDuenios[index].setDireccion(direccion);

            respuesta = true;
        }

        return respuesta;
    }
    //D- Elimimar/ Quitar/ Borrar un duenio
     boolean eliminarDuenio(String cedulaDuenioEliminar) {
        boolean respuesta = false;
        int index = encontrarIndexDuenio(cedulaDuenioEliminar);

        if(index != -1){
            listDuenios[index] = null;
            respuesta = true;
        }

        return respuesta;
    }
    public int encontrarIndexDuenio(String cedulaDuenioBuscar) {

        for (int i = 0; i < listDuenios.length; i++) {
            if (listDuenios[i] != null && listDuenios[i].getCedula().equals(cedulaDuenioBuscar)) {
                return i;
            }
        }

        return -1;
    }


    //Metodos logicos CRUD Mascota
    // C- Crear/Registrar/Guardar una mascota
    public boolean registrarMascota(String nombre, String raza, String especie, int edad) {

        Mascota nuevaMascota = new Mascota("M-" + nombre + "-" + edad, nombre, raza, especie, edad);

        if (encontrarIndexMascota(nuevaMascota.getId()) == -1) {
            for (int i = 0; i < listMascotas.length; i++) {
                if (listMascotas[i] == null) {
                    listMascotas[i] = nuevaMascota;
                    return true;
                }
            }
        }

        return false;
    }
    //R - Leer/Mostrar/Imprimir una mascota
    public String mostrarMascota(String idMascotaMostrar) {
        String mensaje = "";
        int index = encontrarIndexMascota(idMascotaMostrar);

        if (index != -1) {
            Mascota mascotaEncontrada = listMascotas[index];

            mensaje = "Mascota encontrada:\n" +
                    "\nNombre: " + mascotaEncontrada.getNombre() +
                    "\nRaza: " + mascotaEncontrada.getRaza() +
                    "\nEspecie: " + mascotaEncontrada.getEspecie() +
                    "\nEdad: " + mascotaEncontrada.getEdad();
        } else {
            mensaje = "La mascota no se encuentra en la lista.";
        }

        return mensaje;
    }
    //R - Mostrar todas las mascotas
    public String mostrarListaMascotas() {
        String mensaje = "Lista de mascotas:\n";

        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] != null) {
                mensaje += "\nNombre: " + listMascotas[i].getNombre() + "\nRaza: " + listMascotas[i].getRaza() +
                        "\nEspecie: " + listMascotas[i].getEspecie() + "\nEdad: " + listMascotas[i].getEdad();

            }

        }

        return mensaje;
    }
    //U - Actualizar/Modificar/Cambiar una mascota
    public boolean actualizarMascota(String idMascotaActualizar, String nombre, String raza, String especie, int edad) {
        boolean respuesta = false;
        int index = encontrarIndexMascota(idMascotaActualizar);

        if (index != -1) {
            listMascotas[index].setNombre(nombre);
            listMascotas[index].setRaza(raza);
            listMascotas[index].setEspecie(especie);
            listMascotas[index].setEdad(edad);

            respuesta = true;
        }

        return respuesta;
    }
    //D - Eliminar/Quitar/Borrar una mascota.
    public boolean eliminarMascota(String idMascotaEliminar) {
        boolean respuesta = false;
        int index = encontrarIndexMascota(idMascotaEliminar);

        if(index != -1){
            listMascotas[index] = null;
            respuesta = true;
        }

        return respuesta;
    }
    public int encontrarIndexMascota(String idMascotaBuscar) {

        for (int i = 0; i < listMascotas.length; i++) {
            if (listMascotas[i] != null && listMascotas[i].getId().equals(idMascotaBuscar)) {
                return i;
            }
        }

        return -1;
    }


    //Gets and Sets
    public String getNit(){
        return nit;
    }

    public void setNit(String nit){
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Mascota[] getListMascotas() {
        return listMascotas;
    }

    public void setListMascotas(Mascota[] listMascotas) {
        this.listMascotas = listMascotas;
    }

    public Duenio[] getListDuenios() {
        return listDuenios;
    }

    public void setListDuenios(Duenio[] listDuenios) {
        this.listDuenios = listDuenios;
    }


}

