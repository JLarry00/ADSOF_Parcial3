package Conjuntos;

public class RecorreConjunto<T> {
    private ConjuntoInfinito<T> conjunto;
    private T currentElem;
    private int index;

    public RecorreConjunto(ConjuntoInfinito<T> conjunto) {
        this.conjunto = conjunto;
        this.currentElem = conjunto.getInitial();
        this.index = 0;
    }

    public ConjuntoInfinito<T> getConjunto() {
        return conjunto;
    }

    public int getIndex() {
        return index;
    }

    public T elementoActual() {
        return currentElem;
    }

    public void avanza() {
        try {
            currentElem = conjunto.nextElem(currentElem);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}