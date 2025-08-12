class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
         int sum = 0, num = numberToCheck;
         int numberOfDigits = String.valueOf(numberToCheck).length();
         while(num !=0){
             int digit = num % 10;
             sum += Math.pow(digit, numberOfDigits);
             num /= 10;
         }
        return sum == numberToCheck;

    }

}
