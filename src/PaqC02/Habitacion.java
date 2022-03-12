package PaqC02;
import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class Habitacion implements Serializable{

    private Reserva reserva ;
    private int numHab;
    private int numPl;


    public Habitacion(){}
    public  Habitacion(int numHab, int numPl){
        this.numHab = numHab;
        this.numPl = numPl;

    }

   public void setReserva(Reserva res)
   {
       this.reserva = res;
   }
   public Reserva getReserva(){
        return this.reserva;
   }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public void setNumPl(int numPl) {
        this.numPl = numPl;
    }



    public int getNumHab() {
        return numHab;
    }

    public int getNumPl() {
        return numPl;
    }
}
