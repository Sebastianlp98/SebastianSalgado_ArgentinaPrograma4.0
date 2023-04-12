package com.resultados;

import com.resultados.clases.Equipo;
import com.resultados.clases.Partido;
import com.resultados.clases.Resultado;
import com.resultados.clases.Ronda;
import com.resultados.utils.Utils;


public class Main {
    public static void main(String[] args) {
        String repositorio = Utils.csvToString("src/main/resources/Hoja de cálculo sin título - Hoja 1.csv");

        String[] formated = repositorio.split(",");

        Equipo equipo1 = new Equipo();
        equipo1.setNombre(formated[6]);

        Equipo equipo2 = new Equipo();
        equipo2.setNombre(formated[9]);

        Equipo equipo3 = new Equipo();
        equipo3.setNombre(formated[11]);

        Equipo equipo4 = new Equipo();
        equipo4.setNombre(formated[14]);

        Partido partido1 = new Partido();
        Equipo[] equiposPartido1 = new Equipo[2];
        equiposPartido1[0] = equipo1;
        equiposPartido1[1] = equipo2;
        partido1.setEquipos(equiposPartido1);
        partido1.setGolesEquipo1(Integer.valueOf(formated[7]));
        partido1.setGolesEquipo2(Integer.valueOf(formated[8]));
        partido1.setResultado(partido1.getGolesEquipo1(), partido1.getGolesEquipo2());
       // System.out.println(partido1);

        //System.out.println(" ");

        Partido partido2 = new Partido();
        Equipo[] equiposPartido2 = new Equipo[2];
        equiposPartido2[0] = equipo3;
        equiposPartido2[1] = equipo4;
        partido2.setEquipos(equiposPartido2);
        partido2.setGolesEquipo1(Integer.valueOf(formated[12]));
        partido2.setGolesEquipo2(Integer.valueOf(formated[13]));
        partido2.setResultado(partido2.getGolesEquipo1(), partido2.getGolesEquipo2());
        //System.out.println(partido2);

        Ronda ronda1 = new Ronda();
        Partido[] partidosRonda1 = new Partido[2];
        partidosRonda1[0] = partido1;
        partidosRonda1[1] = partido2;
        ronda1.setRondaEntera(partidosRonda1);

        Resultado[] resultadosRonda1 = new Resultado[2];
        resultadosRonda1[0] = partido1.getResultado();
        resultadosRonda1[1] = partido2.getResultado();
        ronda1.setResultadoRonda(resultadosRonda1);
        System.out.println(ronda1);














    }
}