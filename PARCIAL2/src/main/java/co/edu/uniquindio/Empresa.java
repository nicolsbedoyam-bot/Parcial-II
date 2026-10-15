package co.edu.uniquindio;

public class Empresa {
 private static final int MAX=100;
    private String nombre;
    private String nit;


    private String nombre;
    private String nit;
    private ArrayList<Sede> sedes;
    private ArrayList<EquipoAudioVisual> equipos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Operador> operadores;
    private ArrayList<Reserva> reservas;;


    public empresa(String nombre, String nit){
            this.nombre = nombre;
            this.nit = nit;
            this.sedes = new ArrayList<>();
            this.equipos = new ArrayList<>();
            this.clientes = new ArrayList<>();
            this.operadores = new ArrayList<>();
            this.reservas = new ArrayList<>();
    }

}
public boolean registrarSede(Sede sede) {
    if (consultarSede(sede.getCodigo()) != null) {
        return false;
    }
    sedes.add(sede);
    return true;
}

public boolean registrarEquipo(EquipoAudioVisual equipo) {
    if (consultarEquipo(equipo.getCodigo()) != null) {
        return false;
    }
    equipos.add(equipo);
    return true;
}

public boolean registrarCliente(Cliente cliente) {
    if (consultarCliente(cliente.identificacion()) != null) {
        return false;
    }
    clientes.add(cliente);
    return true;
}

public boolean registrarOperador(Operador operador) {
    if (consultarOperador(operador.getIdentificacion()) != null) {
        return false;
    }
    operadores.add(operador);
    return true;
}

public boolean registrarReserva(Reserva reserva) {
    if (consultarReserva(reserva.getCodigo()) != null) {
        return false;
    }
    if (consultarCliente(reserva.getCliente().identificacion()) == null) {
        return false;
    }
    reservas.add(reserva);
    return true;
}
public boolean agregarEquipoAReserva(String codigoReserva, String codigoEquipo, int horas) {
    Reserva reserva = consultarReserva(codigoReserva);
    EquipoAudioVisual equipo = consultarEquipo(codigoEquipo);
    if (reserva == null || equipo == null) {
        return false;
    }
    return reserva.agregarEquipo(equipo, horas);
}

public boolean asignarOperadorAReserva(String codigoReserva, String identificacionOperador) {
    Reserva reserva = consultarReserva(codigoReserva);
    Operador operador = consultarOperador(identificacionOperador);
    if (reserva == null || operador == null) {
        return false;
    }
    return reserva.asignarOperador(operador);
}



private boolean equipoLibre(EquipoAudioVisual equipo, LocalDate fecha, Turno_Reserva turno) {
    if (!equipo.estaDisponible()) {
        return false;
    }
    for (Reserva r : reservas) {
        if (r.getSituacion() == Situacion_Reserva.CONFIRMADA) {
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


public boolean cambiarSituacionReserva(String codigoReserva, Situacion_Reserva nueva) {
    Reserva reserva = consultarReserva(codigoReserva);
    if (reserva == null) {
        return false;
    }
    if (nueva == Situacion_Reserva.CONFIRMADA && !todosLosEquiposLibres(reserva)) {
        return false;
    }
    return reserva.cambiarSituacion(nueva);
}
public ArrayList<EquipoAudioVisual> consultarEquiposDisponibles(LocalDate fecha, Turno_Reserva turno) {
    ArrayList<EquipoAudioVisual> resultado = new ArrayList<>(); // caja vacía
    for (EquipoAudioVisual e : equipos) {
        if (equipoLibre(e, fecha, turno)) {
            resultado.add(e);
        }
    }
    return resultado;
}

public ArrayList<Reserva> consultarReservasConfirmadasPorCliente(String identificacionCliente) {
    ArrayList<Reserva> resultado = new ArrayList<>();
    for (Reserva r : reservas) {
        if (r.getSituacion() == Situacion_Reserva.CONFIRMADA) {
            if (r.getCliente().identificacion().equals(identificacionCliente)) {
                resultado.add(r);
            }
        }
    }
    return resultado;
}


public double obtenerValorReserva(String codigoReserva) {
    Reserva reserva = consultarReserva(codigoReserva);
    if (reserva == null) {
        return -1;
    }
    return reserva.calcularValor();
}
public string getNombre(){
    return nombre;
}
public String getNit() {
    return nit;
}
}




