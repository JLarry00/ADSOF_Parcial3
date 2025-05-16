import Proxy.*;

public class Main {
    public static void main(String[] args) {
        // Create a CuentaProxy object with an initial balance and a password
        CuentaProxy cuentaProxy = new CuentaProxy(1000, "securePassword");

        // Attempt to access the balance without the correct password
        System.out.println("Balance: " + cuentaProxy.obtenerDisponible()); // Should prompt for password and return -1 if incorrect

        System.out.println("Mostrando balance de nuevo: " + cuentaProxy.obtenerDisponible()); // Should not ask for password again

        cuentaProxy.logout();

        System.out.println("Balance: " + cuentaProxy.obtenerDisponible()); // Should prompt for password and return -1 if incorrect
    }
}