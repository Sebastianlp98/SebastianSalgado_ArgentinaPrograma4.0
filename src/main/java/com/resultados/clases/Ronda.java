package com.resultados.clases;

import java.util.Arrays;

public class Ronda {

    private Partido[] rondaEntera ;

    private Resultado[] resultadoRonda;

    private Apuesta[] apuestas;

    private Persona apostadorGanador = new Persona();

    public Ronda() {
        this.rondaEntera = new Partido[2];
        this.apuestas = new Apuesta[2];
        this.resultadoRonda = new Resultado[2];
    }


    public Partido[] getRondaEntera() {
        return rondaEntera;
    }

    public void setRondaEntera(Partido[] rondaEntera) {
        if(rondaEntera.length > 2 ){
            System.out.println("amiguerow solo 2 partidos por ronda");
        }else{
            this.rondaEntera = rondaEntera;

        }
    }

    public Apuesta[] getApuestas() {
        return apuestas;
    }

    public void setApuestas(Apuesta[] apuestas) {
        this.apuestas = apuestas;
    }

    public Resultado[] getResultadoRonda() {
        return resultadoRonda;
    }

    public void setResultadoRonda(Resultado[] resultadoRonda) {
        this.resultadoRonda = resultadoRonda;
    }

    public Persona getApostadorGanador() {
        return apostadorGanador;
    }

    public void setApostadorGanador(Persona apostadorGanador) {
        this.apostadorGanador = apostadorGanador;
    }

    @Override
    public String toString() {
        return "Ronda{" +
                "rondaEntera=" + Arrays.toString(rondaEntera) +
                ", resultadoRonda=" + Arrays.toString(resultadoRonda) +
                ", apuestas=" + Arrays.toString(apuestas) +
                ", apostadorGanador=" + apostadorGanador +
                '}';
    }
}
