package Persona;

public class MainPersona {

        static void main() {
            // new invoca al metodo constructor
            Persona personaUno = new Persona("1234", "Jhancarlos", 25, 1.81);

            IO.println(personaUno.getCedula());
            personaUno.setCedula("4321");
            IO.println(personaUno.getCedula());


        }
    }

