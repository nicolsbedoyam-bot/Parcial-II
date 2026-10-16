package co.edu.uniquindio;

public class Camara extends EquipoAudioVisual{


    private int resolucionMaxima;
    private boolean estabilizador;
    private static final double costoAlquilerCamara= 12000;
    private static final double costoEstabilizador= 15000;

    public Camara(int codigoEquipo, String marca, String modelo, int resolucionMaxima, boolean estabilizador){
        super(codigoEquipo, marca, modelo);
        this.resolucionMaxima = resolucionMaxima;
        this.estabilizador = estabilizador;


    }

   @Override
    public double calcularCosto(int horas){
        double total= costoEstabilizador * horas;
        if(estabilizador){
            total= total + costoAlquilerCamara;
        }
        return total;

    }

    public int getResolucionMaxima() {
        return resolucionMaxima;
    }
    public void setResolucionMaxima(double resolucionMaxima) {
        this.resolucionMaxima=resolucionMaxima;
    }
    public boolean isEstabilizador() {
        return estabilizador;
    }
    public void setEstabilizador(boolean estabilizador) {
        this.estabilizador = estabilizador;
    }

}
