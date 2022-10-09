public class A_Nums2Chinese {
    private static final char[] data = new char[]{'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
    private static final char[] units = new char[]{'个','十','百','千'};

    public String convert(int num){
        StringBuilder res = new StringBuilder();
        int i = 0;
        int pre = -1; //为了应对1300、1000这种后面多个0都不需要处理的情况
        while(num > 0){
            if(i/4 == 1 && i%4 == 0) res.append('万');
            if(i/4 == 2 && i%4 == 0) res.append('亿');
            int cur = num % 10;
            if( cur == 0){ //当前数字是0
                if(i % 4 == 0 || pre == 0){  //0在个位,或者后面都是0
                    i++;
                    num /= 10;
                    pre = cur;
                    continue;
                }
                else res.append(data[cur]);
            }
            else{
                if(i%4 != 0)res.append(units[i%4]);
                res.append(data[cur]);
            }
            num /= 10;
            pre = cur;
            i++;
        }
        return res.reverse().toString();
    }
}
