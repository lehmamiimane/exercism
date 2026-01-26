
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        int[] last = {0,2,5,3,7,8,4};
        return last;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length -1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length -1]++;
    }

    public boolean hasDayWithoutBirds() {
        for(int a : this.birdsPerDay){
            if(a == 0) return true;
        }
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int sum =0;
        int n = numberOfDays > birdsPerDay.length ? birdsPerDay.length : numberOfDays;
        for(int i =0; i< n; i++){
            sum += birdsPerDay[i];
        }
        return sum;
    }

    public int getBusyDays() {
        int sum =0;
        for(int a : this.birdsPerDay){
            if(a > 4) sum++;
        }
        return sum;
    }
}
