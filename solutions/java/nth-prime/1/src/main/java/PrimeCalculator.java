class PrimeCalculator {

    int nth(int nth) {
        if(nth <=0){
           throw new IllegalArgumentException("nth must be a positive integer.");
        }

        int count = 0, number = 1;

        while(count < nth){
            number++;
            if(isPrime(number)){
                count++;
            }
        }
        return number;
    }

    private boolean isPrime(int num){
        if(num < 2) return false;
        if(num == 2) return true;
        if(num%2 == 0) return false;

        for(int i = 3; i<=Math.sqrt(num); i+=2){
            if(num%i == 0) return false;
        }

        return true;
    }

}
