package Factories;

import Components.*;
import Ordenadores.*;

public class DELLFactory implements Factory {
    public static DELLPlacaBase createPB(String tipoMicro, String tipoGrafica, int nUSBs, int nExp) {
        return new DELLPlacaBase(tipoMicro, tipoGrafica, nUSBs, nExp);
    }
    public static DELLHD createHD(int cap, String tipo) {
        return new DELLHD(cap, tipo);
    }
    public static DELLRAM createRAM(int cap, int frec) {
        return new DELLRAM(cap, frec);
    }
    public static DELLOrdenador createOrdenador(String marca, DELLHD hd, DELLRAM ram, DELLPlacaBase placaBase) {
        return new DELLOrdenador(marca, hd, ram, placaBase);
    }
} 