package com.resultados.clases;

public class Apuesta {

    private String equipoApostado;

    private Persona apostador;

    public Apuesta(String equipoApostado, Persona apostador) {
        this.equipoApostado = equipoApostado;
        this.apostador = apostador;
    }

    public Apuesta() {
    }

    public String getEquipoApostado() {
        return equipoApostado;
    }

    public void setEquipoApostado(String equipoApostado) {
        this.equipoApostado = equipoApostado;
    }

    public Persona getApostador() {
        return apostador;
    }

    public void setApostador(Persona apostador) {
        this.apostador = apostador;
    }

    @Override
    public String toString() {
        return "Apuesta{" +
                "equipoApostado='" + equipoApostado + '\'' +
                ", apostador=" + apostador +
                '}';
    }
}
