package Ordenadores;

import Components.*;

public abstract class Ordenador {
    private String marca;
    private HD disco;
    private RAM ram;
    private PlacaBase placa;

    public Ordenador(String marca, HD hd, RAM ram, PlacaBase placaBase) {
        this.marca = marca;
        this.disco = hd;
        this.ram = ram;
        this.placa = placaBase;
    }
    
    public String getMarca() {
        return marca;
    }

    public HD getDisco() {
        return disco;
    }

    public RAM getRam() {
        return ram;
    }

    public PlacaBase getPlaca() {
        return placa;
    }
}