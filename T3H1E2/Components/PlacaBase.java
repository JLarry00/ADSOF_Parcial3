package Components;


public abstract class PlacaBase {
    private String tipoMicro;
    private String tipoGrafica;
    private int nUSBs;
    private int nExp;

    public PlacaBase(String tipoMicro, String tipoGrafica, int nUSBs, int nExp) {
        this.tipoMicro = tipoMicro;
        this.tipoGrafica = tipoGrafica;
        this.nUSBs = nUSBs;
        this.nExp = nExp;
    }

    public String getTipoMicro() {
        return tipoMicro;
    }

    public String getTipoGrafica() {
        return tipoGrafica;
    }

    public int getNUSBs() {
        return nUSBs;
    }

    public int getNExp() {
        return nExp;
    }
} 