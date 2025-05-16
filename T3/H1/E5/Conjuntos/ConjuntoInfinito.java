package Conjuntos;

import java.util.function.*;
import java.util.stream.Stream;
import java.util.*;

public class ConjuntoInfinito<T> {
    private Predicate<T> pertenece;
    private T inicial;
    private Function<T,T> next;

    public ConjuntoInfinito(Predicate<T> pertenece, T inicial, Function<T,T> next) {
        this.pertenece = pertenece;
        this.inicial = inicial;
        this.next = next;
    }

    public T getInitial() {
        return inicial;
    }

    public boolean pertenece(T elem) {
        return this.pertenece.test(elem);
    }

    public T nextElem(T elem) throws Exception{
        T nextElem = elem;
        for (int i = 0; i<1000000000; i++) {
            nextElem = next.apply(nextElem);
            if (pertenece(nextElem)) return nextElem;
        }
        throw new Exception("Recorridos 10^9 elementos sin siguiente");
    }

    public RecorreConjunto<T> getRecorreConjunto() {
        return new RecorreConjunto<T>(this);
    }

    public SortedSet<T> toSet(int n) {
        SortedSet<T> set = new TreeSet<>();
        T current = inicial;
        try {
            for (int i = 0; i < n; i++, current = nextElem(current))
                set.add(current);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return set;
    }

    public Stream<T> toStream(int n) {
        List<T> set = new ArrayList<T>();
        T current = inicial;
        try {
            for (int i = 0; i < n; i++, current = nextElem(current))
                set.add(current);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return set.stream();
    }
}