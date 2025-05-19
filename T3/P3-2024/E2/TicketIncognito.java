package E2;

public class TicketIncognito implements ITicket {
    public String correoAlt = null;
    public TicketNormal ticket;

    public TicketIncognito(TicketNormal ticket) {
        this.ticket = ticket;
    }
    public TicketIncognito(TicketNormal ticket, String correo) {
        this.ticket = ticket;
        this.correoAlt = correo;
    }
    
    public Zona zona() { return ticket.zona(); }
    public String correo() { return correoAlt; }
    public boolean haValidado() { return ticket.haValidado(); }
    public TicketNormal getTicketNormal() { return this.ticket; }
    public boolean validarCon(String correo) {
        if (this.correoAlt.equals(correo))
            return ticket.validarCon(ticket.correo());
        return false;
    }
    public TicketIncognito en(Zona zona) { return this; }
    public TicketIncognito para(String correo) {
        if (correoAlt == null) correoAlt = correo;
        return this;
    }

    @Override
    public String toString() { return "incognito de " + correoAlt + " sobre ticket para " + ticket.correo() + " [validado= " + ticket.haValidado() + "]"; }
}
