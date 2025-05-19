package E2;

public class TicketNormal implements ITicket {
    private boolean valido = false;
    private Zona zona = null;
    private String correo = null;

    public TicketNormal(String correo, Zona zona) { this.zona = zona; this.correo = correo; }
    public TicketNormal(String correo) { this.correo = correo; }
    public TicketNormal() {}

    public Zona zona() { return this.zona; }
    public String correo(){ return this.correo; }
    public boolean haValidado() { return this.valido; }

    public boolean validarCon(String str) {
        if (this.correo.equals(str)) valido = true;
        return valido;
    }
    
    public TicketNormal en(Zona zona) {
        this.zona = zona;
        return this;
    }

    public TicketNormal para(String correo) {
        this.correo = correo;
        return this;
    }

    public TicketNormal getTicketNormal() { return this; }

    @Override
    public String toString() { return "ticket para " + correo + " en " + zona.toString() + " [validado= " + valido + "]"; }
}