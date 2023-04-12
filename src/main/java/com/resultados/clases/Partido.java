package com.resultados.clases;


import java.util.Arrays;

public class Partido {

    private Equipo[] equipos;

    private Resultado resultado;

    private Integer golesEquipo1;

    private Integer golesEquipo2;

    public Partido( Resultado resultado, Integer golesEquipo1, Integer golesEquipo2) {
        this.equipos = new Equipo[2];
        this.resultado = resultado;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    public Partido(){}

    public Equipo[] getEquipos() {
        return equipos;
    }

    public void setEquipos(Equipo[] equipos) {
        if(equipos.length > 2){
            System.out.println("amigo no se puede mas de 2 equipos por partido :v");
        }else{
            this.equipos = equipos;

        }
    }

    public Integer getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(Integer golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public Integer getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(Integer golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public Resultado getResultado(){
        return this.resultado;
    }

    public void setResultado(Integer golesEquipo1, Integer golesEquipo2){
        Resultado resultado = new Resultado();
        if(this.golesEquipo1 > this.golesEquipo2){
            resultado.setEquipoGanador(this.equipos[0].getNombre());
            resultado.setEquipoPerdedor(this.equipos[1].getNombre());
        }else{
            resultado.setEquipoGanador(this.equipos[1].getNombre());
            resultado.setEquipoPerdedor(this.equipos[0].getNombre());
        }

        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "equipos=" + Arrays.toString(equipos) +
                ", resultado=" + resultado +
                ", golesEquipo1=" + golesEquipo1 +
                ", golesEquipo2=" + golesEquipo2 +
                '}';
    }
}
