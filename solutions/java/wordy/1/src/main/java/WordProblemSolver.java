class WordProblemSolver {
    int solve(final String question) {
 if (question == null || !question.startsWith("What is ") || !question.endsWith("?")) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

        String content = question.substring(8, question.length() - 1).trim();

        content = content.replaceAll("multiplied by", "multiplied_by")
                         .replaceAll("divided by", "divided_by");

        String[] tokens = content.split(" ");
        if (tokens.length < 1) {
            throw new IllegalArgumentException("No content to parse.");
        }

        int index = 0;
        int result;

        try {
            result = Integer.parseInt(tokens[index++]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }

        while (index < tokens.length) {
            if (index + 1 >= tokens.length) {
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            }

            String operator = tokens[index++];
            String nextToken = tokens[index++];

            int nextNumber;
            try {
                nextNumber = Integer.parseInt(nextToken);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            }

            switch (operator) {
                case "plus":
                    result += nextNumber;
                    break;
                case "minus":
                    result -= nextNumber;
                    break;
                case "multiplied_by":
                    result *= nextNumber;
                    break;
                case "divided_by":
                    if (nextNumber == 0) throw new ArithmeticException("Division by zero.");
                    result /= nextNumber;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown operation: " + operator);
            }
        }

        return result;    }
}
