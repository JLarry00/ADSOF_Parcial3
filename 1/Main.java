import java.util.*;

class PrinterUtil {
    public static IPrinter makeExclusive(Printer p) {
        try {
            ProxyPrinter printer = new ProxyPrinter(p); // Placeholder return statement
            return printer;
        }
        catch (Exception e) {
            System.out.println("    Error: " + e.getMessage());
        }
        return null;
    }
}

interface IPrinter { //Completar
    public void startJob(String header, String user);
    public void printPage(String page, String user);
    public void endJob(String footer, String user);
}

class ProxyPrinter implements IPrinter{
    private String user;
    private Printer printer;
    private static List<Printer> printers = new ArrayList<Printer>();

    public ProxyPrinter(Printer printer) throws Exception {
        if (canCreate(printer)) {
            this.printer = printer;
            ProxyPrinter.printers.add(printer);
        }
        else throw new Exception("  Impresora ya creada");
    }

    public static boolean canCreate(Printer p) {
        for (Printer prt: printers) {
            if (prt.equals(p)) return false;
        }
        return true;
    }

    public void startJob(String header, String user) {
        if(this.user == null) {
            this.user = user;
            this.printer.startJob(header, user);
        }
        else {
            System.out.println("    Impresora ocupada");
        }
    }

    public void printPage(String header, String user) {
        if (this.user != null && this.user.equals(user)) {
            this.printer.printPage(header, user);
        }
        else {
            System.out.println("    Impresora no inicializada");
        }
    }

    public void endJob(String header, String user) {
        if (this.user != null && this.user.equals(user)) {
            this.printer.endJob(header, user);
            this.user = null;
        }
        else {
            System.out.println("    Impresora no inicializada");
        }
    }
}

class Printer implements IPrinter{
    public void startJob(String header, String user) {
        System.out.println("User " + user + " Printing Header:: " + header);
    }

    public void printPage(String page, String user) {
        System.out.println("User " + user + " Printing Page:: " + page);
    }

    public void endJob(String footer, String user) {
        System.out.println("User " + user + " Printing Footer:: " + footer);
    }
}

public class Main {
    public static void main(String[] args) {
        Printer p = new Printer();
        IPrinter ap = PrinterUtil.makeExclusive(p);
        PrinterUtil.makeExclusive(p);
        ap.startJob("inicio", "juan");
        ap.startJob("otro inicio", "eduardo"); // no imprime, la tiene juan
        ap.printPage("página 1", "juan");
        ap.printPage("otra pagina 1", "eduardo"); // no imprime, la tiene juan
        ap.endJob("final", "juan"); // juan libera la impresora
        ap.startJob("a ver si esta vez...", "eduardo"); // ahora sí
        ap.endJob("fin", "eduardo");
    }
}