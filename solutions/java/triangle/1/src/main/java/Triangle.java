class Triangle {
   private final int res;

    public Triangle(double a, double b, double c) throws TriangleException {
        if (a <= 0 || b <= 0 || c <= 0 || !(a + b > c && b + c > a && a + c > b)) {
            throw new TriangleException();
        }

        int count = 0;
        if (a == b) count++;
        if (b == c) count++;
        if (a == c) count++;
        this.res = count;
    }

    public boolean isEquilateral() {
        return res == 3;
    }

    public boolean isIsosceles() {
        return res >= 1;
    }

    public boolean isScalene() {
        return res == 0;
    }

}
