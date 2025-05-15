import Factories.*;
import Ordenadores.*;
import Components.*;

public class Main {
    public static void main(String[] args) {
        // Create DELL components
        HDDELL dellHD = FactoryDELL.createHD(512, "SSD");
        RAMDELL dellRAM = FactoryDELL.createRAM(16, 3200);
        PlacaBaseDELL dellPlacaBase = FactoryDELL.createPB("Intel", "NVIDIA", 4, 2);

        // Create HP components
        HDHP hpHD = FactoryHP.createHD(1024, "HDD");
        RAMHP hpRAM = FactoryHP.createRAM(8, 2400);
        PlacaBaseHP hpPlacaBase = FactoryHP.createPB("AMD", "Radeon", 6, 3);

        // Create a DELL computer with DELL components
        OrdenadorDELL dellOrdenador = FactoryDELL.createOrdenador("DELL", dellHD, dellRAM, dellPlacaBase);
        System.out.println("Created a DELL computer with DELL components: " + dellOrdenador);

        // Create an HP computer with HP components
        OrdenadorHP hpOrdenador = FactoryHP.createOrdenador("HP", hpHD, hpRAM, hpPlacaBase);
        System.out.println("Created an HP computer with HP components: " + hpOrdenador);
    }
}