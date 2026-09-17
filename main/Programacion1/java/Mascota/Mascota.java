package Mascota;

public class Mascota {

        //Atributos
        private String id;
        private String nombre;
        private String raza;
        private String especie;
        private int edad;
        private String nombrePropietario;
        private String numeroContacto;

        //Constructor
        public Mascota (String id, String nombre, String raza, String especie, int edad, String nombrePropietario, String numeroContacto){
            this.id = id;
            this.nombre = nombre;
            this.raza = raza;
            this.especie = especie;
            this.edad = edad;
            this.nombrePropietario = nombrePropietario;
            this.numeroContacto = numeroContacto;
        }
        //Getters and setters
        public String getNombre(){

            return nombre;
        }
        public void setNombre(String nombre){

            this.nombre = nombre;
        }
        public int getEdad(){

            return edad;
        }
        public void setEdad(int edad){

            this.edad = edad;
        }

        public String getId(){

            return id;
        }

        public void setId (String id){

            this.id = id;
        }

        public String getRaza() {

            return raza;
        }

        public void setRaza(String raza){

            this.raza = raza;
        }

        public String getEspecie(){

            return especie;
        }

        public void setEspecie(String especie){

            this.especie = especie;
        }
        public String getNombrePropietario(){

            return nombrePropietario;
        }
        public void setNombrePropietario(String
                                                 nombrePropietario){
            this.nombrePropietario = nombrePropietario;
        }
        public String getNumeroContacto(){
            return
                    numeroContacto;
        }
        public void setNumeroContacto(String numeroContacto){

            this.numeroContacto = numeroContacto;
        }


    }


