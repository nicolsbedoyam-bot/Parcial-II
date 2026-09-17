package Veterinaria;

public class Mascota {
    //Atributos
    private String id;
    private String nombre;
    private String raza;
    private String  especie;
    private int edad;
    private Duenio theDuenio;

    //Constructor
    public Mascota(String id, String nombre, String raza, String especie, int edad){
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.raza = raza;

    }
    //Getters and setters
    public String getId() {

        return id;
    }
    public void stetId(String Id) {

        this.id = id;
    }
        public String getNombre(){

            return nombre;
        }
        public void setNombre(String nombre){

            this.nombre = nombre;
        }
        public String getRaza(){

            return raza;
        }
        public void setRaza(String raza){

            this.raza = raza;
        }

        public String getEspecie() {

            return especie;
        }

        public void setEspecie(String especie){

            this.especie = especie;
        }

        public int getEdad(){

            return edad;
        }

        public void setEdad(int edad){

            this.edad = edad;
        }
        public Duenio getTheDuenio(){
            return theDuenio;
        }
        public void setTheDuenio(Duenio theDuenio){
            this.theDuenio = theDuenio;
        }



    }

