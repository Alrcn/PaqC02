package PaqC02;

import java.io.Serializable;
import java.util.Arrays;

public class Hotel implements Serializable {
     int nPlanta= 8;
     int nHabxPlanta = 6;
     Habitacion [][] h1 = new Habitacion[nPlanta][nHabxPlanta];

    //construimos el hotel
    public Hotel()
    {
        for(int i = 0 ; i < nPlanta ; i++){
            for(int j = 0; j < nHabxPlanta; j++){
                if(i<6) {
                    h1[i][j] = new Standar(j +1, i+1);
                }else if( i<8){
                    h1[i][j] = new Balcon(j +1, i+1);

                }else {
                    h1[i][j] = new Suite(j +1, i+1);
                }
            }

        }

    }

    public int[] HabitacionLibre(String tipo)
    {
        int num [] = new int[2];

        switch (tipo)
        {
            case "estandar" :
                for (int i = 0; i < 5; i++){
                    for(int j = 0; j < nHabxPlanta; j++){
                        if(h1[i][j].getReserva() == null){
                            num[0] = i+1;
                            num[1] = j+1;
                            return  num;
                        }

                    }
                }
                break;
            case "balcon" :
                for (int i = 5; i < 7; i++){
                    for(int j = 0; j < nHabxPlanta; j++){
                        if(h1[i][j].getReserva() == null){
                            num[0] = i+1;
                            num[1] = j+1;
                            return  num;
                        }

                    }
                }
            case "suite" :
                for (int i = 7; i <= 7; i++){
                    for(int j = 0; j < nHabxPlanta; j++){
                        if(h1[i][j].getReserva() == null){
                            num[0] = i+1;
                            num[1] = j+1;
                            return  num;
                        }

                    }
                }
            //El default es para que en el caso de que no se especificasen bien ninguna de las 3 opciones
                //Se pueda informar al cliente y que no siga ejecutándose el programa.
            default:
                num[0] = -1;
                num[1] = -1;
                return num  ;


        }
        return num;
    }

    public void realizarReserva(int [] aux, Reserva reserva){
        h1[aux[0]-1][aux[1]-1].setReserva(reserva);


    }

    public void eliminarReserva(int [] aux){


            h1[aux[0]-1][aux[1]-1].setReserva(null);

    }

    //mostramos el hotel sobreescribiendo el método toString
    @Override
    public String toString() {
        String mostrar="";
        for(int i = nPlanta -1 ; i >= 0 ; i--){

            for(int j = 0 ; j<  nHabxPlanta; j++){
                if(h1[i][j].getReserva() == null)
                {
                    mostrar = mostrar +"[L] ["+h1[i][j].getNumPl() +"-"+h1[i][j].getNumHab()+"]    ";

                }else
                {
                    mostrar = mostrar +"[R] ["+h1[i][j].getNumPl() +"-"+h1[i][j].getNumHab()+"]    ";
                }
            }
            mostrar = mostrar + "\n";
        }
        return mostrar;
    }
}
