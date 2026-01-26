public class EliudsEggs {
    public int eggCount(int number) {
        if(number == 0){
            return 0;
        }
        int count = 0;
        while(number > 0){
            if(number%2 == 1){
                count++;
            }
            number/=2;
        }
        return count;
    }
}
