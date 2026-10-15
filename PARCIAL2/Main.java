package co.edu.uniquindio.Programacion1.PixelRentParcial2;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {

    static Empresa empresa = new Empresa("98765", "PixelRent");
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<EquipoAudiovisual> equipos = new ArrayList<>();

    public static void main(String[] args) {

        int option = 0;
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "MENU PIXELRENT\n"
                            + "1. Registrar sede\n"
                            + "2. Registrar equipo\n"
                            + "3. Registrar cliente\n"
                            + "4. Registrar operador\n"
                            + "5. Registrar reserva\n"
                            + "6. Agregar equipo a reserva\n"
                            + "7. Asignar operador a reserva\n"
                            + "8. Cambiar situacion reserva\n"
                            + "9. Consultar equipos disponibles\n"
                            + "10. Consultar reservas confirmadas por cliente\n"
                            + "11. Obtener valor reserva\n"
                            + "12. Equipo libre\n"
                            + "0. Salir del sistema"));

            switch (option) {
                case 1:
                    registrarSede();
                    break;
                case 2:
                    registrarEquipoAudiovisual();
                    break;
                case 3:
                    registrarCliente();
                    break;
                case 4:
                    registrarOperador();
                    break;
                case 5:
                    registrarReserva();
                    break;
                case 6:
                    agregarEquipoAReserva();
                    break;
                case 7:
                    asignarOperador();
                    break;
                case 8:
                    cambiarSituacionReserva();
                    break;
                case 9:
                    consultarEquiposDisponibles();
                    break;
                case 10:
                    consultarReservasConfirmadasPorCliente();
                    break;
                case 11:
                    obtenerValorReserva();
                    break;
                case 12:
                    equipoLibre();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Hasta pronto");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
                    break;
            }

        } while (option != 0);
    }

    //Registros

    static void registrarSede() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la sede:"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la sede:");
        String direccion = JOptionPane.showInputDialog("Ingrese la direccion de la sede:");

        Sede sede = new Sede(codigo, nombre, direccion);

        if (empresa.registrarSede(sede)) {
            JOptionPane.showMessageDialog(null, "Sede registrada");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la sede");
        }
    }

    static void registrarEquipoAudiovisual() {
        int tipo = Integer.parseInt(JOptionPane.showInputDialog(
                "Tipo de equipo:\n1. Camara\n2. Dron\n3. Kit de iluminacion"));
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del equipo:"));
        String marca = JOptionPane.showInputDialog("Ingrese la marca:");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");

        int s = Integer.parseInt(JOptionPane.showInputDialog(
                "Situacion equipo:\n1. Disponible\n2. En mantenimiento\n3. Fuera de servicio"));

        SituacionEquipo estado;
        if (s == 2) {
            estado = SituacionEquipo.EN_MANTENIMIENTO;
        } else if (s == 3) {
            estado = SituacionEquipo.FUERA_DE_SERVICIO;
        } else {
            estado = SituacionEquipo.DISPONIBLE;
        }

        EquipoAudiovisual equipo = null;

        switch (tipo) {
            case 1:
                int resolucionMaxima = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la resolucion maxima:"));
                boolean estabilizador = Boolean.parseBoolean(JOptionPane.showInputDialog("Tiene estabilizador? (true/false):"));
                equipo = new Camara(resolucionMaxima, estabilizador, codigo, marca, modelo, estado.toString());
                break;
            case 2:
                int autonomiaVuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la autonomia de vuelo (minutos):"));
                boolean bateriaAdicional = Boolean.parseBoolean(JOptionPane.showInputDialog("Tiene bateria adicional? (true/false):"));
                equipo = new Dron(autonomiaVuelo, bateriaAdicional, codigo, marca, modelo, estado.toString());
                break;
            case 3:
                int cantidadLuces = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de luces:"));
                boolean controlInalambrico = Boolean.parseBoolean(JOptionPane.showInputDialog("Tiene control inalambrico? (true/false):"));
                equipo = new KitIluminacion(cantidadLuces, controlInalambrico, codigo, marca, modelo, estado.toString());
                break;
            default:
                JOptionPane.showMessageDialog(null, "Tipo no valido");
                return;
        }

        if (empresa.registrarEquipo(equipo)) {
            equipos.add(equipo);
            JOptionPane.showMessageDialog(null, "Equipo audiovisual registrado");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el equipo");
        }
    }

    static void registrarCliente() {
        String nombre = JOptionPane.showInputDialog("Ingrese nombre completo:");
        String cedula = JOptionPane.showInputDialog("Ingrese numero de identificacion:");
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese telefono:"));
        String correo = JOptionPane.showInputDialog("Ingrese el correo electronico:");

        Cliente cliente = new Cliente(nombre, cedula, telefono, correo);

        if (empresa.registrarCliente(cliente)) {
            clientes.add(cliente);
            JOptionPane.showMessageDialog(null, "Cliente registrado");
        } else {
            JOptionPane.showMessageDialog(null, "El cliente ya se encuentra registrado");
        }
    }

    static void registrarOperador() {
        String cedula = JOptionPane.showInputDialog("Ingrese el numero de identificacion del operador:");
        String nombre = JOptionPane.showInputDialog("Ingrese nombre completo del operador:");
        String certificacion = JOptionPane.showInputDialog("Ingrese la certificacion:");
        int aniosExperiencia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los anios de experiencia:"));

        Operador operador = new Operador(cedula, nombre, certificacion, aniosExperiencia);

        if (empresa.registrarOperador(operador)) {
            JOptionPane.showMessageDialog(null, "Operador registrado");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar el operador");
        }
    }

    static void registrarReserva() {
        int codigoReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la reserva:"));
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula del cliente:");

        Cliente cliente = buscarCliente(cedula);
        if (cliente == null) {
            JOptionPane.showMessageDialog(null, "Cliente no registrado");
            return;
        }

        LocalDate fecha = pedirFecha();
        Turno_Reserva turno = pedirTurno();
        if (turno == null) {
            JOptionPane.showMessageDialog(null, "Turno no valido");
            return;
        }

        Reserva reserva = new Reserva(codigoReserva, cliente, fecha, turno);

        if (empresa.registrarReserva(reserva)) {
            JOptionPane.showMessageDialog(null, "Reserva registrada");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la reserva");
        }
    }

    //Operaciones

    static void agregarEquipoAReserva() {
        int codigoReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la reserva:"));
        int codigoEquipo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del equipo:"));
        int horas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese las horas de uso:"));

        if (empresa.agregarEquipoAReserva(codigoReserva, codigoEquipo, horas)) {
            JOptionPane.showMessageDialog(null, "Equipo agregado a la reserva");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el equipo");
        }
    }

    static void asignarOperador() {
        int codigoReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la reserva:"));
        String cedulaOperador = JOptionPane.showInputDialog("Ingrese el numero de identificacion del operador:");

        if (empresa.asignarOperadorAReserva(codigoReserva, cedulaOperador)) {
            JOptionPane.showMessageDialog(null, "Operador asignado");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo asignar el operador");
        }
    }

    static void cambiarSituacionReserva() {
        int codigoReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la reserva:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog(
                "Situacion reserva:\n1. Solicitada\n2. Confirmada\n3. Cancelada\n4. Finalizada"));

        Situacion_Reserva nueva = null;
        if (s == 1) {
            nueva = Situacion_Reserva.Solicitada;
        } else if (s == 2) {
            nueva = Situacion_Reserva.Confirmada;
        } else if (s == 3) {
            nueva = Situacion_Reserva.Cancelada;
        } else if (s == 4) {
            nueva = Situacion_Reserva.Finalizada;
        }

        if (nueva == null) {
            JOptionPane.showMessageDialog(null, "Situacion no valida");
            return;
        }

        if (empresa.cambiarSituacionReserva(codigoReserva, nueva)) {
            JOptionPane.showMessageDialog(null, "Situacion de la reserva cambiada");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo cambiar la situacion");
        }
    }

    //Consultas

    static void consultarEquiposDisponibles() {
        LocalDate fecha = pedirFecha();
        Turno_Reserva turno = pedirTurno();
        if (turno == null) {
            JOptionPane.showMessageDialog(null, "Turno no valido");
            return;
        }

        ArrayList<EquipoAudiovisual> lista = empresa.consultarEquiposDisponibles(fecha, turno);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos disponibles para esa fecha y turno");
            return;
        }

        String texto = "Equipos disponibles:\n";
        for (EquipoAudiovisual e : lista) {
            texto = texto + e.getCodigo() + " | " + e.getMarca() + " " + e.getModelo() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    static void consultarReservasConfirmadasPorCliente() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cedula del cliente:");

        ArrayList<Reserva> lista = empresa.consultarReservasConfirmadasPorCliente(cedula);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El cliente no tiene reservas confirmadas");
            return;
        }

        String texto = "Reservas confirmadas:\n";
        for (Reserva r : lista) {
            texto = texto + "Reserva " + r.getCodigoReserva() + " | " + r.getFecha() + " | " + r.getTurno() + "\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    static void obtenerValorReserva() {
        int codigoReserva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo de la reserva:"));
        double valor = empresa.obtenerValorReserva(codigoReserva);

        if (valor < 0) {
            JOptionPane.showMessageDialog(null, "Reserva no encontrada");
        } else {
            JOptionPane.showMessageDialog(null, "Valor total de la reserva: $" + valor);
        }
    }

    static void equipoLibre() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del equipo:"));
        EquipoAudiovisual equipo = buscarEquipo(codigo);
        if (equipo == null) {
            JOptionPane.showMessageDialog(null, "Ese equipo no esta registrado");
            return;
        }

        LocalDate fecha = pedirFecha();
        Turno_Reserva turno = pedirTurno();
        if (turno == null) {
            JOptionPane.showMessageDialog(null, "Turno no valido");
            return;
        }

        if (empresa.equipoLibre(equipo, fecha, turno)) {
            JOptionPane.showMessageDialog(null, "El equipo esta libre en esa fecha y turno");
        } else {
            JOptionPane.showMessageDialog(null, "El equipo NO esta libre en esa fecha y turno");
        }
    }

    static Cliente buscarCliente(String cedula) {
        for (Cliente c : clientes) {
            if (c.cedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    static EquipoAudiovisual buscarEquipo(int codigo) {
        for (EquipoAudiovisual e : equipos) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }

    static LocalDate pedirFecha() {
        int anio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año:"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes (1-12):"));
        int dia = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dia:"));
        return LocalDate.of(anio, mes, dia);
    }

    static Turno_Reserva pedirTurno() {
        int t = Integer.parseInt(JOptionPane.showInputDialog("Turno reserva:\n1. Manana\n2. Tarde\n3. Noche"));

        if (t == 1) {
            return Turno_Reserva.Manana;
        } else if (t == 2) {
            return Turno_Reserva.Tarde;
        } else if (t == 3) {
            return Turno_Reserva.Noche;
        } else {
            return null;
        }
    }
}


