package co.edu.uniquindio;

public class Dron extends EquipoAudioVisual{

    private int autonomiaVuelo;
    private boolean bateriaAdicional;
    private static final double costoAlquilerDron=18000;
    private static final double costoBateriaAdicionalDron=20000;

    public Dron(int codigoEquipo, String marca, String modelo,int autonomiaVuelo, boolean bateriaAdicional) {
        super(codigoEquipo, marca, modelo);
        this.autonomiaVuelo = autonomiaVuelo;
        this.bateriaAdicional = bateriaAdicional;
    }
  @Override
    public double calcularCosto(int horas){
        double total = costoAlquilerDron * horas;
        if (bateriaAdicional){
            total = total + costoBateriaAdicionalDron;
        }
        return  total;
  }

  public void setAutonomiaVuelo(int autonomiaVuelo) {
        this.autonomiaVuelo = autonomiaVuelo;
  }
  public int getAutonomiaVuelo() {
        return autonomiaVuelo;
  }
  public void setBateriaAdicional(boolean bateriaAdicional) {
        this.bateriaAdicional = bateriaAdicional;
  }
  public boolean isBateriaAdicional() {
        return bateriaAdicional;
  }


}
