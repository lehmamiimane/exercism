public class SquareRoot {
    public int squareRoot(int radicand) {
         int left = 1;
        int right = radicand;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int square = mid * mid;

            if (square == radicand) {
                return mid; // trouvé !
            } else if (square < radicand) {
                left = mid + 1; // essayer plus grand
            } else {
                right = mid - 1; // essayer plus petit
            }
        }

        // Si aucun carré parfait trouvé (ne devrait pas arriver selon l'énoncé)
        throw new IllegalArgumentException("The number is not a perfect square.");
    }
}
