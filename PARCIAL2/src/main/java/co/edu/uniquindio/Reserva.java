import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;

public class Reserva {

    private final int codigoReserva;
    private final Cliente cliente;
    private final LocalDate fecha;
    private final Turno_Reserva turno;
    private Situacion_Reserva situacion;
    private Operador operador;
    private ArrayList<EquipoAudiovisual> equipos;
    private ArrayList<Integer> horasPorEquipo;


    public Reserva(int codigoReserva, Cliente cliente, LocalDate fecha, Turno_Reserva turno) {
        this.codigoReserva = codigoReserva;
        this.cliente = cliente;
        this.fecha = fecha;
        this.turno = turno;
        this.situacion = Situacion_Reserva.Solicitada;
        this.operador = null;
        this.equipos = new ArrayList<>();
        this.horasPorEquipo = new ArrayList<>();
    }

    public EquipoAudiovisual getEquipo(int i){
        return equipos.get(i);
    }


    public boolean tieneEquipo(EquipoAudiovisual equipo) {
        for (EquipoAudiovisual e : equipos) {
            if (e.getCodigo()==equipo.getCodigo()) {
                return true;
            }
        }
        return false;
    }


    public boolean agregarEquipo(EquipoAudiovisual equipo, int horas) {
        if (situacion != Situacion_Reserva.Solicitada) {
            return false;
        }
        if (horas <= 0) {
            return false;
        }
        if (tieneEquipo(equipo)) {
            return false;
        }
        if (!equipo.identificarDisponibilidad()) {
            return false;
        }
        equipos.add(equipo);
        horasPorEquipo.add(horas);
        return true;
    }


    public int getCantidadEquipos() {
        int contador = 0;
        for (EquipoAudiovisual e : equipos) {
            contador = contador + 1;
        }
        return contador;
    }


    private boolean requiereOperador() {
        for (EquipoAudiovisual e : equipos) {
            if (e.requiereOperador()) {
                return true;
            }
        }
        return false;
    }



    public boolean asignarOperador(Operador operador) {
        if (situacion != Situacion_Reserva.Solicitada) {
            return false;
        }
        if (operador == null) {
            return false;
        }
        if (!requiereOperador()) {
            return false;
        }
        this.operador = operador;
        return true;
    }


    private boolean puedeConfirmarse() {
        if (getCantidadEquipos() == 0) {
            return false;
        }
        if (requiereOperador()) {
            if (operador == null || !operador.estaCapacitado()) {
                return false;
            }
        }
        return true;
    }


    public boolean cambiarSituacion(Situacion_Reserva nueva) {
        if (situacion == Situacion_Reserva.Solicitada) {
            if (nueva == Situacion_Reserva.Confirmada) {
                if (!puedeConfirmarse()) {
                    return false;
                }
                situacion = nueva;
                return true;
            }
            if (nueva == Situacion_Reserva.Cancelada) {
                situacion = nueva;
                return true;
            }
        }
        if (situacion == Situacion_Reserva.Confirmada) {
            if (nueva == Situacion_Reserva.Cancelada || nueva == Situacion_Reserva.Finalizada) {
                situacion = nueva;
                return true;
            }
        }
        return false;
    }


    public double calcularValor() {
        double total = 0;
        int cantidad = getCantidadEquipos();
        for (int i = 0; i < cantidad; i++) {
            // get(i) = "dame lo que está en la posición i" de cada lista
            total = total + equipos.get(i).calcularCosto(horasPorEquipo.get(i));
        }
        return total;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Turno_Reserva getTurno() {
        return turno;
    }

    public Situacion_Reserva getSituacion() {
        return situacion;
    }

    public void setSituacion(Situacion_Reserva situacion) {
        this.situacion = situacion;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public ArrayList<EquipoAudiovisual> getEquipos() {
        return equipos;
    }

    public void setEquipos(ArrayList<EquipoAudiovisual> equipos) {
        this.equipos = equipos;
    }

    public ArrayList<Integer> getHorasPorEquipo() {
        return horasPorEquipo;
    }

    public void setHorasPorEquipo(ArrayList<Integer> horasPorEquipo) {
        this.horasPorEquipo = horasPorEquipo;
    }
}