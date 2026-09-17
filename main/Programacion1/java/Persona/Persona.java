package Persona;

    public class Persona {
        //Atributos
        private String cedula; //Identificador unico
        private String nombre;
        private int edad;
        private double altura;

        //Metodo Constructor
        public Persona (String cedula, String nombre, int edad, double altura){
            //this es para las clases se usa para diferenciar de los atributos
            this.cedula = cedula;
            this.nombre = nombre;
            this.edad = edad;
            this.altura = altura;
        }

        //Metodos
        public void repirar (String datoEntrada){
            //Codigo
        }

        public int caminar(){
            //Codigo
            return 0;
        }
        //Metodos Get (Obtener) - Para ver lo que hay dentro
        public String getCedula(){
            return cedula;
        }
        public String getNombre(){
            return nombre;
        }
        public int getEdad(){
            return edad;
        }
        public double getAltura(){
            return altura;
        }

        //Metodos Set (Asignar) - Para modificar en Persona.Main
        public void setCedula (String cedula){
            this.cedula = cedula;
        }
        public void setNombre (String nombre){
            this.nombre= nombre;
        }
        public void setEdad (int edad){
            this.edad= edad;
        }
        public void setAltura (double altura){
            this.altura= altura;
        }
    }

