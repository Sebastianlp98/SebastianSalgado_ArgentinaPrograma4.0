package com.resultados.clases;

public class Resultado {

    private String equipoGanador;
    private String equipoPerdedor;

    public String getEquipoGanador() {
        return equipoGanador;
    }

    public void setEquipoGanador(String equipoGanador) {
        this.equipoGanador = equipoGanador;
    }

    public String getEquipoPerdedor() {
        return equipoPerdedor;
    }

    public void setEquipoPerdedor(String equipoPerdedor) {
        this.equipoPerdedor = equipoPerdedor;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "equipoGanador='" + equipoGanador + '\'' +
                ", equipoPerdedor='" + equipoPerdedor + '\'' +
                '}';
    }
}
