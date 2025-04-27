public class ValidationResult {
    private final boolean valid;
    private final List<String> errors;

    public ValidationResult(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = Collections.unmodifiableList(errors);
    }

    public boolean isValid() {
        return valid;
    }

    public List<String> getErrors() {
        return errors;
    }
}