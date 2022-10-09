public class FindComplement_476 {
    public int findComplement(int num) {
        int tmp = num;
        int flag = 0;
        while(tmp > 0){
            tmp >>= 1;
            flag = (flag << 1) + 1;
        }
        return num ^ flag;
    }
}
