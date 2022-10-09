import java.util.*;

public class Number2Chinese {
    /*
    以10000为小节
    1. 小节结尾是0，也不使用“零”
    2. 小节内两个非0数字中间使用“零”
    3. 小节的“千”位是0时，若本小节的前一小节无其他数字，则不用“零”，否则用“零”
     */
    public static final char[] chnNum = new char[]{'零', '一', '二', '三', '四', '五', '六', '七', '八', '九'};
    public static final char[] unitSection = new char[]{'0','万','亿'}; //节
    public static final char[] unitChar = new char[]{'0','十','百','千'}; //节权位

    public static void main(String[] args) {
        System.out.println(num2Chn(10));
        System.out.println(num2Chn(10003));
        System.out.println(num2Chn(100000));;
        System.out.println(num2Chn(10301030));
    }

    public static String num2Chn (int num) {
        StringBuilder sb =  new StringBuilder();
        int unitPos = 0; // 对应节的位置，0是空字符串，1是万，2是亿，3是万亿
        // num对10000取模得到一个节，将这个节转成中文数字，然后根据节的位置unitPos补上节权位，重复这个过程，直到num为0
        boolean needZero = false;
        while (num > 0) {
            int section = num % 10000;
            // 根据规则3, 一节内数字的千位是0，根据前面的数字决定是否加”零
            if(needZero) {
                sb.insert(0, chnNum[0]);
            }
            // 节内数字转中文
            String secStr = sec2Chn(section);
            // 是否需要节权位
            if (section != 0 && unitPos != 0) {
                secStr += unitSection[unitPos];
            }
            sb.insert(0, secStr);
            // 千位是0需要在下一个section补“零”
            needZero = (section < 1000) && (section > 0);
            num = num / 10000;
            unitPos++;
        }
        return sb.toString();
    }

    // 将一节内的数字转为中文
    public static String sec2Chn (int section) {
        StringBuilder sb1 =  new StringBuilder();
        /*1. 小节结尾是0，也不使用“零”
          2. 小节内两个非0数字中间使用“零”
         */
        int unitPos = 0;
        boolean zero = true; // 控制零的转换，避免多个零连在一起
        while (section > 0) {
            StringBuilder tmp =  new StringBuilder();
            int number = section % 10;
            if (number == 0) {
                if (section == 0 || zero == false) {
                    zero = true; // 这里要有零，并且确保对连续多个0，只有一个中文“零”
                    sb1.insert(0,chnNum[number]);
                }
            } else {
                zero = false; // 当前数字不为0
                tmp.append(chnNum[number]); // 该位置对应的数字
                if (unitPos != 0 ) {
                    tmp.append(unitChar[unitPos]); // 该节内位置数字对应的中文权位
                    // 单独处理”一十“的情况，也可以不处理
                    if (unitChar[unitPos] == '十' && chnNum[number] == '一') {
                        tmp.delete(0,1);
                    }
                }
                sb1.insert(0, tmp);
            }
            section = section / 10;
            unitPos++;
        }
        return sb1.toString();
    }
}
