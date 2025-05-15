package Factories;

import Components.*;
import Ordenadores.*;

public class FactoryX implements Factory {
    public static PlacaBaseX createPB(String tipoMicro, String tipoGrafica, int nUSBs, int nExp) {
        return new PlacaBaseX(tipoMicro, tipoGrafica, nUSBs, nExp);
    }
    public static HDX createHD(int cap, String tipo) {
        return new HDX(cap, tipo);
    }
    public static RAMX createRAM(int cap, int frec) {
        return new RAMX(cap, frec);
    }
    public static OrdenadorX createOrdenador(String marca, HDX hd, RAMX ram, PlacaBaseX placaBase) {
        return new OrdenadorX(marca, hd, ram, placaBase);
    }
} 