package Factories;

import Components.*;
import Ordenadores.*;

public class FactoryDELL implements Factory {
    public static PlacaBaseDELL createPB(String tipoMicro, String tipoGrafica, int nUSBs, int nExp) {
        return new PlacaBaseDELL(tipoMicro, tipoGrafica, nUSBs, nExp);
    }
    public static HDDELL createHD(int cap, String tipo) {
        return new HDDELL(cap, tipo);
    }
    public static RAMDELL createRAM(int cap, int frec) {
        return new RAMDELL(cap, frec);
    }
    public static OrdenadorDELL createOrdenador(String marca, HDDELL hd, RAMDELL ram, PlacaBaseDELL placaBase) {
        return new OrdenadorDELL(marca, hd, ram, placaBase);
    }
} 