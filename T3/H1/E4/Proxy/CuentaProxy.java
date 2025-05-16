package Proxy;

import java.util.*;

public class CuentaProxy implements ICuenta {
    private Cuenta cuenta;
    private String pwd;
    private boolean acceso;

    public CuentaProxy(int disponible, String pwd) {
        this.cuenta = new Cuenta(disponible);
        this.pwd = pwd;
        this.acceso = false;
    }

    @Override
    public int obtenerDisponible() {
        if (acceso == false) {
            System.out.print("Ingrese la contraseña: ");
            @SuppressWarnings("resource")
            Scanner scanner = new Scanner(System.in);
            String inputPwd = scanner.nextLine();
            if (inputPwd.equals(this.pwd)) acceso = true;
            else System.out.println("Contraseña incorrecta.");
        }
        if (acceso == true) return cuenta.obtenerDisponible();
        return -1;
    }

    public void logout() { acceso = false; }
}