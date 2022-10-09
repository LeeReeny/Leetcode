public class IsNumber_offer20 {
    public boolean isNumber(String s){
        if(s.length() == 0) return false;
        char[] charAry = s.trim().toCharArray(); // 去除前后的空格
        boolean isNum = false, isDot = false, isE = false; // 标记是否遇到数字、小数点或e

        for(int i = 0; i < charAry.length; ++i){
            if(charAry[i] >= '0' && charAry[i] <= '9') isNum = true;
            else if(charAry[i] == '.'){
                if(isDot || isE) return false; // 小数点前面不可以出现小数点或e
                isDot = true;
            }
            else if(charAry[i] == 'e' || charAry[i] == 'E'){
                if(isE || !isNum) return false; // e前面不能重复出现e，前面也必须有整数
                isE = true;
                isNum = false; // 重置num，因为e后面必须要有整数
            }
            else if(charAry[i] == '+' || charAry[i] == '-' ){
                // 符号只能出现在第一个位置或者e之后的第一个位置
                if(i != 0 && charAry[i-1] != 'e' && charAry[i-1] != 'E') return false;
            }
            else return false;
        }
        return isNum;
    }
}
