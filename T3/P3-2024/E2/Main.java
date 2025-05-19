package E2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ITicket ticketCoyote = Expendedor.dispensaTicketNormal("coyote@acme.co", Zona.FONDO);
        ITicket ticketLucas = Expendedor.dispensaTicketNormal()
                                        .para("lucas@acme.co").en(Zona.CENTRO);

        ITicket ticketBunny = Expendedor.dispensaTicketNormal("bugsbunny@acme.co", Zona.VIP);
        ITicket ticketMarvin = Expendedor.hazIncognito(ticketBunny, "marvin@acme.co");
        ITicket ticketGallo = Expendedor.dispensaTicketNormal().para("gallo@acme.co").en(Zona.VIP);
        ITicket ticketPiolin = Expendedor.hazIncognito(ticketGallo).para("piolin@acme.co");
        // El siguiente no puede hacerse de incognito, y por tanto ticketSilvestre == ticketLucas
        ITicket ticketSilvestre=Expendedor.hazIncognito(ticketLucas).para("silvestre@acme.co");
       
        ticketCoyote.validarCon("coyote@acme.co");
        ticketLucas.validarCon("pato@acme.co"); // no valida con este correo
        ticketBunny.validarCon("elmer@acme.co"); // no valida con este correo
        ticketMarvin.validarCon("marvin@acme.co");
        // ticketGallo.validarCon("gallo@acme.co"); // este ticket no lo validamos
        ticketPiolin.validarCon("piolin@acme.co");
       
        List.of(ticketCoyote, ticketLucas, ticketBunny,
                ticketMarvin, ticketGallo, ticketPiolin, ticketSilvestre)
            .forEach( t -> System.out.println(t));
        }       
}