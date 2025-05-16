package Proxy;

import java.io.*;

public class CuentaProxy implements ICuenta {
    private Cuenta cuenta;
    private String pwd;
    private boolean correcta;

    public CuentaProxy(int disponible, String pwd) {
        this.cuenta = new Cuenta(disponible);
        this.pwd = pwd;
        this.correcta = false;
    }

    @Override
    public int obtenerDisponible() {
        if (correcta == false) {
            System.out.print("Ingrese la contraseña: ");
            BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
            try {
                String inputPwd = scanner.readLine();
                if (inputPwd.equals(this.pwd)) correcta = true;
                else System.out.println("Contraseña incorrecta.");
            } catch (IOException e) { return -1; }
        }
        if (correcta == true) return cuenta.obtenerDisponible();
        return -1;
    }

    public void logout() { correcta = false; }
}