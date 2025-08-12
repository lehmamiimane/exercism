class CryptoSquare {
    private final String ciphertext;

    public CryptoSquare(String plaintext) {
        // Step 1: Normalize the input
        String normalized = plaintext.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int length = normalized.length();

        // Step 2: Determine number of rows and columns
        int c = (int) Math.ceil(Math.sqrt(length));
        int r = (int) Math.floor(Math.sqrt(length));
        if (r * c < length) r++;

        // Step 3: Build the rectangle row by row
        String[] grid = new String[r];
        for (int i = 0; i < r; i++) {
            int start = i * c;
            int end = Math.min(start + c, length);
            grid[i] = normalized.substring(start, end);
        }

        // Step 4: Read the grid column by column to encode the message
        StringBuilder encoded = new StringBuilder();
        for (int col = 0; col < c; col++) {
            if (col > 0) encoded.append(" ");
            for (int row = 0; row < r; row++) {
                if (col < grid[row].length()) {
                    encoded.append(grid[row].charAt(col));
                } else {
                    encoded.append(" "); // Pad with space if column index exceeds the row length
                }
            }
        }

        this.ciphertext = encoded.toString();
    }

    public String getCiphertext() {
        return this.ciphertext;
    }

}
