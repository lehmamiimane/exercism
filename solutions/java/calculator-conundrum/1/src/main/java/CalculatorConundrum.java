class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) throws IllegalArgumentException, IllegalOperationException {
         if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null");
        }

        if (operation.equals("")) {
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        int result;
        try {
            result = switch (operation) {
                case "+" -> operand1 + operand2;
                case "*" -> operand1 * operand2;
                case "/" -> {
                    if (operand2 == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    yield operand1 / operand2;
                }
                default -> throw new IllegalOperationException("Operation '" + operation + "' does not exist");
            };
        } catch (ArithmeticException e) {
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }

        return operand1 + " " + operation + " " + operand2 + " = " + result;
    }
}
