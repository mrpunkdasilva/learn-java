public class ValidationSystem {
    private final List<Validator> validators = new ArrayList<>();
    private final ValidationResultBuilder resultBuilder = new ValidationResultBuilder();

    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    public ValidationResult validate(Object data) {
        resultBuilder.reset();
        
        for (Validator validator : validators) {
            try {
                ValidationResult result = validator.validate(data);
                if (!result.isValid()) {
                    resultBuilder.addErrors(result.getErrors());
                }
            } catch (Exception e) {
                resultBuilder.addError("Erro interno: " + e.getMessage());
            }
        }
        
        return resultBuilder.build();
    }
}