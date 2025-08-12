class NaturalNumber {
    private final int number;
    
    NaturalNumber(int number) {
        if(number <= 0){
 throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    int getSumDivide(int number){
        int count = 0, num = 1;
        while(num < number){
            if(number % num == 0){
                count += num;
            }
            num ++;
        }
        return count;
    }

    Classification getClassification() {
        int sum = getSumDivide(number);
        if(sum == number){
            return Classification.PERFECT;
        } else if( sum > number){
            return Classification.ABUNDANT;
        }

        return Classification.DEFICIENT;
    }
}
