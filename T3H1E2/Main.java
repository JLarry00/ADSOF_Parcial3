import Factories.*;
import Ordenadores.*;
import Components.*;

public class Main {
    public static void main(String[] args) {
        // Create DELL components
        DELLHD dellHD = DELLFactory.createHD(512, "SSD");
        DELLRAM dellRAM = DELLFactory.createRAM(16, 3200);
        DELLPlacaBase dellPlacaBase = DELLFactory.createPB("Intel", "NVIDIA", 4, 2);

        // Create HP components
        HPHD hpHD = HPFactory.createHD(1024, "HDD");
        HPRAM hpRAM = HPFactory.createRAM(8, 2400);
        HPPlacaBase hpPlacaBase = HPFactory.createPB("AMD", "Radeon", 6, 3);

        // Create a DELL computer with DELL components
        DELLOrdenador dellOrdenador = DELLFactory.createOrdenador("DELL", dellHD, dellRAM, dellPlacaBase);
        System.out.println("Created a DELL computer with DELL components: " + dellOrdenador);

        // Create an HP computer with HP components
        HPOrdenador hpOrdenador = HPFactory.createOrdenador("HP", hpHD, hpRAM, hpPlacaBase);
        System.out.println("Created an HP computer with HP components: " + hpOrdenador);
    }
}