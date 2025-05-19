package E2;

public class Expendedor {
    public static ITicket dispensaTicketNormal(String correo, Zona zona) { return new TicketNormal(correo, zona); }
    public static ITicket dispensaTicketNormal(String correo) { return new TicketNormal(correo); }
    public static ITicket dispensaTicketNormal() { return new TicketNormal(); }

    public static ITicket hazIncognito(ITicket ticket, String correo) {
        if (ticket.zona().equals(Zona.VIP)) return new TicketIncognito(ticket.getTicketNormal(), correo);
        else return ticket;
    }
    public static ITicket hazIncognito(ITicket ticket) {
        if (ticket.zona().equals(Zona.VIP)) return new TicketIncognito(ticket.getTicketNormal());
        else return ticket;
    }
}