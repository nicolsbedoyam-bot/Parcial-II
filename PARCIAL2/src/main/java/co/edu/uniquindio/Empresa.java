import java.time.LocalDate;
import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private String nit;
    private ArrayList<Sede> sedes;
    private ArrayList<EquipoAudiovisual> equipos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Operador> operadores;
    private ArrayList<Reserva> reservas;

    public Empresa(String nombre, String nit) {
        this.nombre = nombre;
        this.nit = nit;
        this.sedes = new ArrayList<>();
        this.equipos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.operadores = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    // ---------------- REGISTROS ----------------

    public boolean registrarSede(Sede sede) {
        if (consultarSede(sede.getCodigo()) != null) {
            return false;
        }
        sedes.add(sede);
        return true;
    }

    public boolean registrarEquipo(EquipoAudiovisual equipo) {
        if (consultarEquipo(equipo.getCodigo()) != null) {
            return false;
        }
        equipos.add(equipo);
        return true;
    }

    public boolean registrarCliente(Cliente cliente) {
        if (consultarCliente(cliente.cedula()) != null) {
            return false;
        }
        clientes.add(cliente);
        return true;
    }

    public boolean registrarOperador(Operador operador) {
        if (consultarOperador(operador.getCedula()) != null) {
            return false;
        }
        operadores.add(operador);
        return true;
    }

    public boolean registrarReserva(Reserva reserva) {
        if (consultarReserva(reserva.getCodigoReserva()) != null) {
            return false;
        }
        if (consultarCliente(reserva.getCliente().cedula()) == null) {
            return false;
        }
        reservas.add(reserva);
        return true;
    }

    // ---------------- OPERACIONES ----------------

    public boolean agregarEquipoAReserva(int codigoReserva, int codigoEquipo, int horas) {
        Reserva reserva = consultarReserva(codigoReserva);
        EquipoAudiovisual equipo = consultarEquipo(codigoEquipo);
        if (reserva == null || equipo == null) {
            return false;
        }
        return reserva.agregarEquipo(equipo, horas);
    }

    public boolean asignarOperadorAReserva(int codigoReserva, String cedulaOperador) {
        Reserva reserva = consultarReserva(codigoReserva);
        Operador operador = consultarOperador(cedulaOperador);
        if (reserva == null || operador == null) {
            return false;
        }
        return reserva.asignarOperador(operador);
    }

    public boolean cambiarSituacionReserva(int codigoReserva, Situacion_Reserva nueva) {
        Reserva reserva = consultarReserva(codigoReserva);
        if (reserva == null) {
            return false;
        }
        if (nueva == Situacion_Reserva.Confirmada && !todosLosEquiposLibres(reserva)) {
            return false;
        }
        return reserva.cambiarSituacion(nueva);
    }

    public boolean equipoLibre(EquipoAudiovisual equipo, LocalDate fecha, Turno_Reserva turno) {
        if (!equipo.identificarDisponibilidad()) {
            return false;
        }
        for (Reserva r : reservas) {
            if (r.getSituacion() == Situacion_Reserva.Confirmada) {
                if (r.getFecha().equals(fecha)) {
                    if (r.getTurno() == turno) {
                        if (r.tieneEquipo(equipo)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private boolean todosLosEquiposLibres(Reserva reserva) {
        for (int i = 0; i < reserva.getCantidadEquipos(); i++) {
            if (!equipoLibre(reserva.getEquipo(i), reserva.getFecha(), reserva.getTurno())) {
                return false;
            }
        }
        return true;
    }

    // ---------------- CONSULTAS ----------------

    public ArrayList<EquipoAudiovisual> consultarEquiposDisponibles(LocalDate fecha, Turno_Reserva turno) {
        ArrayList<EquipoAudiovisual> resultado = new ArrayList<>();
        for (EquipoAudiovisual e : equipos) {
            if (equipoLibre(e, fecha, turno)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public ArrayList<Reserva> consultarReservasConfirmadasPorCliente(String cedulaCliente) {
        ArrayList<Reserva> resultado = new ArrayList<>();
        for (Reserva r : reservas) {
            if (r.getSituacion() == Situacion_Reserva.Confirmada) {
                if (r.getCliente().cedula().equals(cedulaCliente)) {
                    resultado.add(r);
                }
            }
        }
        return resultado;
    }

    public double obtenerValorReserva(int codigoReserva) {
        Reserva reserva = consultarReserva(codigoReserva);
        if (reserva == null) {
            return -1;
        }
        return reserva.calcularValor();
    }

    // ---------------- BUSQUEDAS ----------------

    private Sede consultarSede(int codigo) {
        for (Sede s : sedes) {
            if (s.getCodigo() == codigo) {
                return s;
            }
        }
        return null;
    }

    public EquipoAudiovisual consultarEquipo(int codigo) {
        for (EquipoAudiovisual e : equipos) {
            if (e.getCodigo() == codigo) {
                return e;
            }
        }
        return null;
    }

    public Cliente consultarCliente(String cedula) {
        for (Cliente c : clientes) {
            if (c.cedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    private Operador consultarOperador(String cedula) {
        for (Operador o : operadores) {
            if (o.getCedula().equals(cedula)) {
                return o;
            }
        }
        return null;
    }

    private Reserva consultarReserva(int codigoReserva) {
        for (Reserva r : reservas) {
            if (r.getCodigoReserva() == codigoReserva) {
                return r;
            }
        }
        return null;
    }

    // ---------------- GETTERS ----------------

    public String getNombre() {
        return nombre;
    }

    public String getNit() {
        return nit;
    }
}


