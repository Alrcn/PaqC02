package PaqC02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class InicializacionHotel {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Inicializamos el hotel con todas las habitaciones libres y lo guardamos en un .dat
        FileOutputStream fos = null;
        ObjectOutputStream salida = null;

        Hotel hotel = new Hotel();
        try {
            fos = new FileOutputStream("hotel.dat");
            salida = new ObjectOutputStream(fos);

            salida.writeObject(hotel);
            fos.close();

            salida.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
