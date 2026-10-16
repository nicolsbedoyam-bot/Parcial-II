package co.edu.uniquindio;

public class Kit_Iluminacion extends EquipoAudioVisual{

    private int cantidadLuces;
    private boolean controlInalambrico;
    private static final double costoAlquilerKit=10000;
    private static final double costoAlquilerControlInalambrico= 12000;


    public Kit_Iluminacion(int codigoEquipo, String marca, String modelo, int cantidadLuces, boolean controlInalambrico) {
        super(codigoEquipo, marca, modelo);
        this.cantidadLuces=cantidadLuces;
        this.controlInalambrico=controlInalambrico;

    }

    @Override
    public double calcularCosto(int horas) {
        double total = costoAlquilerKit * horas;
        if (controlInalambrico) {
            total = total + costoAlquilerControlInalambrico;
        }
        return total;

    }
    public void setCantidadLuces(int cantidadLuces){
        this.cantidadLuces=cantidadLuces;
    }
    public int getCantidadLuces(){
        return cantidadLuces
    }
    public void setControlInalambrico(boolean controlInalmbrico){
        this.controlInalambrico=controlInalmbrico;
    }

    public boolean isControlInalambrico() {
        return controlInalambrico;
    }
}
