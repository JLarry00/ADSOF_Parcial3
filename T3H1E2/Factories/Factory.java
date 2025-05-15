package Factories;

import Components.*;
import Ordenadores.*;

public interface Factory {
    static PlacaBase createPB(String tipoMicro, String tipoGrafica, int nUSBs, int nExp) {
        return null;
    }
    
    static HD createHD(int cap, String tipo) {
        return null;
    }
    
    static RAM createRAM(int cap, int frec) {
        return null;
    }
    
    static Ordenador createOrdenador(String marca, HD hd, RAM ram, PlacaBase placaBase) {
        return null;
    }
}