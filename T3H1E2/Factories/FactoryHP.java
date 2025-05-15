package Factories;

import Components.*;
import Ordenadores.*;

public class FactoryHP implements Factory {
    public static PlacaBaseHP createPB(String tipoMicro, String tipoGrafica, int nUSBs, int nExp) {
        return new PlacaBaseHP(tipoMicro, tipoGrafica, nUSBs, nExp);
    }
    public static HDHP createHD(int cap, String tipo) {
        return new HDHP(cap, tipo);
    }
    public static RAMHP createRAM(int cap, int frec) {
        return new RAMHP(cap, frec);
    }
    public static OrdenadorHP createOrdenador(String marca, HDHP hd, RAMHP ram, PlacaBaseHP placaBase) {
        return new OrdenadorHP(marca, hd, ram, placaBase);
    }
} 