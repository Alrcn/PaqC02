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
            Scanner sr = new Scanner(System.in);
            String respuesta;
            System.out.println("¿Desea realizar una reserva?");
            respuesta = sr.nextLine();
            respuesta = respuesta.toLowerCase();


            FileOutputStream fos = null;
            ObjectOutputStream salida = null;
            fos = new FileOutputStream("hotel.dat");
            salida = new ObjectOutputStream(fos);

            Reserva r1 = new Reserva();
            if (respuesta.equals("si")) {

                //Pedimos y guardamos los datos del cliente
                String tipo;
                System.out.println("Introduzca el tipo de habitación que desea");
                tipo = sr.nextLine();

                int cant;
                System.out.println("Introduzca la cantidad de habitaciones que desea reservar ");
                cant = sr.nextInt();


                 String aux = hotel.HabitacionLibre(tipo.toLowerCase(),r1,cant);

                System.out.println(aux);


                if (aux != null) {
                    //System.out.println("La habitación: " + aux[0] + "-" + aux[1] + " esta libre");

                    Scanner st = new Scanner(System.in);
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

                     r1 = new Reserva(nombre, apellidos, dni, tlf, fentrada, fsalida, regimen);

                    //hotel.realizarReserva(aux, r1);

                    //System.out.println(r1.toString());
                    System.out.println(hotel.toString());


                } else {
                    System.out.println("No hay habitaciones libres del tipo: " + tipo);
                }

            }
//----------------------------------------------------------------------------------------------------------------------

            //Eliminar una reserva
            Scanner se = new Scanner(System.in);
            String respuesta1;
            System.out.println("Desea eliminar una reserva?");
            respuesta1 = se.nextLine();
            respuesta1 = respuesta1.toLowerCase();

            if (respuesta1.equals("si")) {

                String tipoElim;
                System.out.println("Introduzca el tipo de habitación que desea eliminar");
                tipoElim = se.nextLine();

                int cantElim;
                System.out.println("Introduzca la cantidad de las que desea eliminar la reserva");
                cantElim = se.nextInt();
                int[] aux2 = new int[2];


                    hotel.eliminarHabReservada(tipoElim.toLowerCase(),cantElim,r1);

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
