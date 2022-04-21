package PaqC02;

import java.io.Serializable;
import java.util.Date;

public class Reserva implements Serializable {
    private String dni;
    private String nombre;
    private String apellidos;
    private String tlf;
    private String fentrada;
    private String fsalida;
    private String regimen;



    public Reserva(){}

    public Reserva(String dni, String nombre, String apellidos, String tlf, String fentrada, String fsalida, String regimen){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tlf = tlf;
        this.fentrada = fentrada;
        this.fsalida = fsalida;
        this.regimen = regimen;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public void setFentrada(String fentrada) {
        this.fentrada = fentrada;
    }

    public void setFsalida(String fsalida) {
        this.fsalida = fsalida;
    }

    public void setRegimen(String regimen) {
        this.regimen = regimen;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getTlf() {
        return tlf;
    }

    public String getFentrada() {
        return fentrada;
    }

    public String getFsalida() {
        return fsalida;
    }

    public String getRegimen() {
        return regimen;
    }

    public String toString(){
        String dReserva = dni + "\n" + nombre + "\n" + apellidos +  "\n" + tlf + "\n"
                + fentrada + "\n" + fsalida + "\n" + regimen;
        return dReserva;

    }
}
