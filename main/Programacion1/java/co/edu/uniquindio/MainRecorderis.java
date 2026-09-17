package co.edu.uniquindio;

import javax.swing.*;

public class MainRecorderis {
        static void main() {
            //encontrarMayorDiez(20);
            //String respuestaMetodo = sumaNumeros(5);
            //IO.println(respuestaMetodo);

            //mostrarImpares(10);

            testArreglo();
        }

        //Tipos de datos - int double boolean String
        //Arreglos - un conjunto de datos. Indexado(0 (cantidad-1)). NO es redimensionable

        public static void testArreglo(){
            int[] numeros = {10, 20, 30, 40};
            String[] nombres = new String[5];
            int sumaNumeros = 0;

            for (int i = 0; i < numeros.length; i++) {
                sumaNumeros += numeros[i];
            }
            IO.println(sumaNumeros);

            for (int i = 0; i < nombres.length; i++) {
                nombres[i] = JOptionPane.showInputDialog("Ingrese su nombre: ");
            }

            for (int i = 0; i < nombres.length; i++) {
                JOptionPane.showMessageDialog(null, nombres[i]);
            }
        }

        // Escribe un programa que reciba un número entero y
        // luego imprima todos los números impares entre 1 y
        // ese número. Utiliza un ciclo for con una condición
        // if dentro para filtrar los impares.
        public static void mostrarImpares(int numero){
            for (int i = 1; i < numero; i++) {
                if(i % 2 != 0){
                    IO.println(i);
                }
            }
        }


        // Escribe un programa que reciba un número entero y
        // determine si es mayor que 10. Si lo es, muestra
        // el mensaje "El número es mayor que 10".
        // Si no lo es, muestra el mensaje
        // "El número no es mayor que 10".
        public static void encontrarMayorDiez(int numero){
            if(numero > 10){
                IO.println("El numero es mayor que 10");
            }else{
                IO.println("El numero NO es mayor que 10");
            }
        }

        // Escribe un programa que reciba un número y calcule
        // la suma de todos los números desde 1 hasta ese número. Utiliza un ciclo for.
        public static String sumaNumeros(int numero){
            int sumaAcumulada = 0;
            String cadenaSuma = "";

            for(int i = 1; i <= numero; i++){
                cadenaSuma += i + " ";
                sumaAcumulada += i;
            }
            cadenaSuma += " = "+ sumaAcumulada;
            return cadenaSuma;
        }
    }

