package E1;
import java.util.*;
import java.util.function.*;

public class Validator<T> {
    private Function<? super T, String> toString;
    private Map<String, Predicate<? super T>> constraints = new HashMap<>();
    private Map<String, Consumer<? super T>> fixers = new HashMap<>();

    public Validator(Function<? super T, String> fcn) {
        this.toString = fcn;
    }

    public Validator() {
        this(p -> p.toString());
    }

    public Validator<T> withConstraint(String error, Predicate<? super T> cnst, Consumer<? super T> fix) {
        if (error == null || cnst == null || fix == null) throw new IllegalArgumentException("No arguments can be null");

        this.constraints.put(error, cnst);
        this.fixers.put(error, fix);
        
        return this;
    }

    public Validator<T> withConstraint(String error, Predicate<? super T> cnst) {
        this.withConstraint(error, cnst, p -> {});
        return this;
    }

    public void validateAll(List<? extends T> lst) throws ValidationException {
        ValidationException e = new ValidationException();
        runAll(lst, (str, elem) -> {e.addError(this.toString.apply(elem), str);});
        if (e.hasErrors()) throw e;
    }

    public void fixAll(List<? extends T> lst) {
        runAll(lst, (str, elem) -> {fixers.get(str).accept(elem);});
    }

    public void runAll(List<? extends T> lst, BiConsumer<String, ? super T> oper) {
        for (T elem: lst)
            for (String str: constraints.keySet())
                if (constraints.get(str).test(elem) == true)
                    oper.accept(str, elem);
    }
}