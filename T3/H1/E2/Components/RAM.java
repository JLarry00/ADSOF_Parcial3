package Components;


public abstract class RAM {
    private int cap;
    private int frec;

    public RAM(int cap, int frec) {
        this.cap = cap;
        this.frec = frec;
    }

    public int getCap() {
        return cap;
    }

    public int getFrec() {
        return frec;
    }
}