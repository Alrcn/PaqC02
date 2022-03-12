package PaqC02;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // write your code here


        try {
            FileInputStream fis = null;
            ObjectInputStream entrada = null;
            Hotel hotel;

            fis = new FileInputStream("hotel.dat");
            entrada = new ObjectInputStream(fis);
            hotel = (Hotel) entrada.readObject();
            fis.close(); //Cerrar el file
            entrada.close(); //Cerrar el object
            System.out.println(hotel.toString());


            //Realizar una reserva
            Scanner st = new Scanner(System.in);
            String respuesta;
            System.out.println("¿Desea realizar una reserva?");
            respuesta = st.nextLine();
            respuesta = respuesta.toLowerCase();


            FileOutputStream fos = null;
            ObjectOutputStream salida = null;
            fos = new FileOutputStream("hotel.dat");
            salida = new ObjectOutputStream(fos);


            if (respuesta.equals("si")) {

                //Pedimos y guardamos los datos del cliente
                String tipo;
                System.out.println("Introduzca el tipo de habitación que desea");
                tipo = st.nextLine();


                int[] aux = new int[2];
                aux = hotel.HabitacionLibre(tipo.toLowerCase());


                if (aux[0] != -1) {
                    System.out.println("La habitación: " + aux[0] + "-" + aux[1] + " esta libre");

                    String nombre;
                    System.out.println("\nIntroduzca su nombre");
                    nombre = st.nextLine();

                    String apellidos;
                    System.out.println("Introduzca sus apellidos");
                    apellidos = st.nextLine();


                    String dni;
                    System.out.println("Introduzca su DNI sin letra");
                    dni = st.nextLine();


                    String tlf;
                    System.out.println("Introduzca su teléfono");
                    tlf = st.nextLine();


                    String fentrada;
                    System.out.println("Introduzca su fecha de entrada");
                    fentrada = st.nextLine();

                    String fsalida;
                    System.out.println("Introduzca su fecha de salida");
                    fsalida = st.nextLine();

                    String regimen;
                    System.out.println("Introduzca el tipo de régimen que quiere");
                    regimen = st.nextLine();

                    Reserva r1 = new Reserva(nombre, apellidos, dni, tlf, fentrada, fsalida, regimen);

                    hotel.realizarReserva(aux, r1);
                    System.out.println(r1.toString());
                    System.out.println(hotel.toString());


                } else {
                    System.out.println("No hay habitaciones libres del tipo: " + tipo);
                }

            }
//----------------------------------------------------------------------------------------------------------------------

            //Eliminar una reserva
            String respuesta1;
            System.out.println("Desea eliminar una reserva?");
            respuesta1 = st.nextLine();
            respuesta1 = respuesta1.toLowerCase();

            if (respuesta1.equals("si")) {
                int[] aux = new int[2];
                System.out.println("De que planta es la reserva que desea eliminar?");
                aux[0] = st.nextInt();
                System.out.println("Cual es el numero de habitación que quiere cancelar?");
                aux[1] = st.nextInt();


                if (hotel.h1[aux[0] - 1][aux[1] - 1].getReserva() != null) {
                    hotel.eliminarReserva(aux);
                } else {
                    System.out.println("Esta habitación actualmente no tiene ninguna reserva");
                }

            }
            try {
                salida.writeObject(hotel);
                fos.close();
                salida.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
