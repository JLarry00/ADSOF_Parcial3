package Components;

public abstract class HD {
    private int cap;
    private String tipo;

    public HD(int cap, String tipo) {
        this.cap = cap;
        this.tipo = tipo;
    }

    public int getCap() {
        return cap;
    }

    public String getTipo() {
        return tipo;
    }
}