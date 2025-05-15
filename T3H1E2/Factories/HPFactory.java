package Factories;

import Components.*;
import Ordenadores.*;

public class HPFactory implements Factory {
    public static HPPlacaBase createPB(String tipoMicro, String tipoGrafica, int nUSBs, int nExp) {
        return new HPPlacaBase(tipoMicro, tipoGrafica, nUSBs, nExp);
    }
    public static HPHD createHD(int cap, String tipo) {
        return new HPHD(cap, tipo);
    }
    public static HPRAM createRAM(int cap, int frec) {
        return new HPRAM(cap, frec);
    }
    public static HPOrdenador createOrdenador(String marca, HPHD hd, HPRAM ram, HPPlacaBase placaBase) {
        return new HPOrdenador(marca, hd, ram, placaBase);
    }
} 