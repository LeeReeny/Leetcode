public class HappyNumber {
    public boolean isHappy(int n){
        int slow = n, fast = n;
        do{
            slow = sumOfBits(slow);
            fast = sumOfBits(fast);
            fast = sumOfBits(fast);
            if(fast == 1) return true;
        }while(slow != fast);
        return slow == 1;
    }

    public int sumOfBits(int num){
        int sum = 0;
        while(num > 0){
            sum += (num % 10) * (num % 10);
            num /= 10;
        }
        return sum;
    }
}
