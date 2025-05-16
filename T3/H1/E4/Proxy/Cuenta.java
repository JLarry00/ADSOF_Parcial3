package Proxy;

public class Cuenta implements ICuenta {
    private int disponible;

    public Cuenta(int disponible) {
        this.disponible = disponible;
    }

    @Override
    public int obtenerDisponible() {
        return disponible;
    }
}