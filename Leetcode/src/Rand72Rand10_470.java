import java.util.Random;

class Rand72Rand10_470 {
    // Random().nextInt(7)生成的是[0,7)范围内的随机数，即{0,1,2,3,4,5,6}
    // 因此要生成[1,7]范围内的随机数，需要+1，这仅仅是为了符合题目要求
    public int rand7(){
        return new Random().nextInt(7) + 1;
    }

    public int rand10(){
        int num = (rand7() - 1) * 7 + rand7();
        while(num > 10){
            num = (rand7() - 1) * 7 + rand7();
        }
        return num;
    }

    public int rand10_2(){
        while(true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) return num % 10 + 1;
            num = (num - 40 - 1) * 7 + rand7(); // 利用刚刚生成的41-49之间的随机数再操作一遍
            if (num <= 60) return num % 10 + 1;
            num = (num - 60 - 1) * 7 + rand7(); // 利用刚刚生成的61-63之间的操作数再操作一遍
            if (num <= 20) return num % 10 + 1;
        }
    }
}


