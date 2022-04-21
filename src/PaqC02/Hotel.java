package PaqC02;

import java.io.Serializable;
import java.util.ArrayList;
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
                    h1[i][j] = new Standar(j +1, i+1,50);
                }else if( i<8){
                    h1[i][j] = new Balcon(j +1, i+1,75);

                }else {
                    h1[i][j] = new Suite(j +1, i+1,100);
                }
            }

        }

    }
    //Clasebuscarcliente

    public Reserva buscarCliente(String dni){
        Reserva aux= new Reserva();

        for (int i = 0; i < 5; i++){
            for(int j = 0; j < nHabxPlanta; j++){

                if(dni.equals(h1[i][j].getReserva().getDni())){
                    aux = h1[i][j].getReserva();
                }
            }
        }
        return aux;

    }



    //poner cuantas quieres y que te reserve el numero de habitaciones que quiere reservar,
    public String HabitacionLibre(String tipo, Reserva r1 ,int cantidad)
    {
        int num [] = new int[2];
        String hab = "";
        switch (tipo)
        {
            case "estandar" :
                for (int i = 0; i < 5; i++){
                    for(int j = 0; j < nHabxPlanta; j++){

                        if(cantidad >0){
                            if (h1[i][j].getReserva() == null) {

                                num[0] = i + 1;
                                num[1] = j + 1;
                                realizarReserva(num, r1);
                                hab = hab + String.valueOf(num[0]) +"-"+ String.valueOf(num[1])+"/ ";
                                cantidad --;

                            }
                        }
                    }
                }
                break;

            case "balcon" :


                for (int i = 5; i < 7; i++){
                    for(int j = 0; j < nHabxPlanta; j++) {

                        if(cantidad >0){
                            if (h1[i][j].getReserva() == null) {
                                num[0] = i + 1;
                                num[1] = j + 1;
                                realizarReserva(num, r1);
                                hab = hab + String.valueOf(num[0]) +"-"+ String.valueOf(num[1])+"/ ";
                                cantidad --;

                            }
                        }

                    }
                }
            case "suite" :

                for (int i = 7; i <= 7; i++){
                    for(int j = 0; j < nHabxPlanta; j++) {
                        if(cantidad >0){
                        if (h1[i][j].getReserva() == null) {
                            num[0] = i + 1;
                            num[1] = j + 1;
                            realizarReserva(num, r1);
                            hab = hab + String.valueOf(num[0]) +"-"+ String.valueOf(num[1])+"/ ";
                            cantidad --;

                        }
                        }

                    }
                }
            //El default es para que en el caso de que no se especificasen bien ninguna de las 3 opciones
                //Se pueda informar al cliente y que no siga ejecutándose el programa.
            default:
                hab = null;
                return hab ;


        }
        return hab  ;
    }


    //Cambiar a privado y usar en el anterior para reservar.
    private void realizarReserva(int [] aux, Reserva reserva){
        h1[aux[0]-1][aux[1]-1].setReserva(reserva);


    }
    //seleccionar el numero de habitaciones que quieres eliminar de que tipo y si puede las elimina, pedimmos el dni para
    //para eliminarlas en funcion del cliente.

        //comprobar con el dni si es el cliente de esa reserva
    public void eliminarHabReservada(String tipo, int cantidad, Reserva r1)
    {
        int num [] = new int[2];
        String hab = "";
        switch (tipo)
        {
            case "estandar" :
                for (int i = 0; i < 5; i++){
                    for(int j = 0; j < nHabxPlanta; j++){

                        if(cantidad >0){
                            if (h1[i][j].getReserva() != null) {
                                num[0] = i + 1;
                                num[1] = j + 1;
                                eliminarReserva(num,r1);
                                cantidad --;
                            }
                        }
                    }
                }
                break;

            case "balcon" :


                for (int i = 5; i < 7; i++){
                    for(int j = 0; j < nHabxPlanta; j++) {

                        if(cantidad >0){
                            if (h1[i][j].getReserva() != null) {
                                num[0] = i + 1;
                                num[1] = j + 1;
                                eliminarReserva(num,r1);

                                cantidad --;
                            }
                        }

                    }
                }
            case "suite" :

                for (int i = 7; i <= 7; i++){
                    for(int j = 0; j < nHabxPlanta; j++) {
                        if(cantidad >0){
                            if (h1[i][j].getReserva() != null) {
                                num[0] = i + 1;
                                num[1] = j + 1;
                                eliminarReserva(num,r1);
                                cantidad --;
                            }
                        }

                    }
                }
                //El default es para que en el caso de que no se especificasen bien ninguna de las 3 opciones
                //Se pueda informar al cliente y que no siga ejecutándose el programa.
            //default:
                //hab = null;

        }
    }
    private void eliminarReserva(int [] aux,Reserva r1){

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
