import java.util.*;

public class ValidationException extends RuntimeException {
    private Map<String, List<String>> errors = new HashMap<>();

    public ValidationException() {
        super("Validation errors:\n");
    }

    public ValidationException addError(String TString, String errorName) {
        if (errors.get(TString) == null) {
            errors.put(TString, new ArrayList<>());
        }
        errors.get(TString).add(errorName);
        return this;
    }

    public boolean hasErrors() {
        return errors.size() > 0;
    }

    @Override
    public String toString() {
        return super.getMessage() + errors.toString();
    }
}