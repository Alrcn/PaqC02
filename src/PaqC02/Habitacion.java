package PaqC02;
import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class Habitacion implements Serializable{

    private Reserva reserva ;
    private int numHab;
    private int numPl;
    private double precio;

    public Habitacion(){}
    public  Habitacion(int numHab, int numPl, double precio){
        this.numHab = numHab;
        this.numPl = numPl;
        this.precio = precio;

    }

   public void setReserva(Reserva res)
   {
       this.reserva = res;
   }
   public Reserva getReserva(){
        return this.reserva;
   }

    public double getPrecio() {
        return precio;
    }

    public int getNumHab() {
        return numHab;
    }

    public int getNumPl() {
        return numPl;
    }
}
