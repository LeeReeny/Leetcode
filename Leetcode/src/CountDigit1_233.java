public class CountDigit1_233 {
    public int countDigitOne(int n){
        long cnt = 0, i = 0, num = n;
        while(num > 0){
            if(num % 10 == 0) cnt += (num/10) * i;
            if(num % 10 == 1) cnt += (num/10) * i + (n%i) + 1;
            if(num % 10 > 1) cnt += Math.ceil(num/10.0)*i;
            num /= 10;
            i *= 10;
        }
        return (int)cnt;
    }
}
