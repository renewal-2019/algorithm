package fromconggod;

public class TestMakeMoney {

    public static void main(String[] args) {

        //要买B ,最起码有10积分, 如果没有积分需要买c产品3天
        //积分只能用来换B产品,10积分 == 60元
        //也即是说尽量在不浪费积分的情况下.多买b产品

        int originPoints = 19;

        int days = 2;

        int maxIncome = new MakeMoney().calculateMaxIncome(originPoints,days);

        System.out.println("最大收益为: " + maxIncome);

    }

}
