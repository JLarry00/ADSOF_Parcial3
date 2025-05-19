package E2;

public interface ITicket {
    public Zona zona(); // Devuelve la zona
    public String correo(); // Devuelve el correo al que está asociada
    public boolean haValidado(); // Devuelve booleano indicando si ha sido validado
    public boolean validarCon(String correo); // Valida si correo coincide con el del usuario
    //Nuevos métodos
    public ITicket en(Zona zona);
    public ITicket para(String correo);
    public TicketNormal getTicketNormal();
}