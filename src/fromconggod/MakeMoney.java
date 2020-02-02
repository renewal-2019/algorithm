package fromconggod;

/**
 * 理财功能,按日结算
 * A产品: 日赚17元
 * B产品: 日赚60元, 消耗10积分
 * C产品: 日赚4积分
 * 假设有x积分,求y天的最大收益组合
 */
public class MakeMoney {
    //初始没有积分,7天一周期,5C 2B方案收益最佳

    //思路:先消耗积分到<= 3,再消耗天数到<=6,完成过滤后,将剩下的情况求出最大收益

    /**
     *
     * @param originPoints 初始积分
     * @param days days
     * @return
     */
    public int calculateMaxIncome(int originPoints, int days) {

        /**
         * 最大收益
         */
        int maxIncome = 0;
        /**
         * 购买A产品的总天数
         */
        int totalADays = 0;
        /**
         * 购买B产品的总天数
         */
        int totalBDays = 0;
        /**
         * 购买C产品的总天数
         */
        int totalCDays = 0;

        //判断积分和天数是否为正
        if (originPoints < 0 || days <= 0) {
            System.out.println("参数错误");
            return 0;
        }

        //先判断手里的积分有没有10的倍数,有几倍就买几天的B产品
        /**
         * 初始积分能买到B产品的天数
         */
        totalBDays = originPoints / 10;

        /**
         * 剩余天数
         */
        int remainDays = days - totalBDays;

        /**
         * 剩余积分
         */
        int remainPoints = originPoints - totalBDays * 10;

        //如果剩下天数小于等于0,也就说原始积分足够全部购买B产品,那么就只买B产品
        if (remainDays <= 0) {
            System.out.println("购买" + days + "天B产品");
            return maxIncome = days * 60;
        }

        maxIncome = totalBDays * 60;

        //如果剩余积分大于等于6(此时天数必定大于0)
        if (remainPoints >= 6) {
            if (remainDays >= 2) {//且还有至少2天,那么可以变现
                //买1天C,1天B
                totalBDays = totalBDays + 1;
                totalCDays = totalCDays + 1;
                maxIncome = maxIncome + 60;
                remainPoints = remainPoints + 4 - 10;//剩余积分最多为3
                remainDays = remainDays - 2;
                if (remainDays == 0) {
                    System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
                    return maxIncome;
                }
            } else {//只剩一天
                //买一天A
                totalADays = 1;
                maxIncome = maxIncome + 17;
                System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
                return maxIncome;
            }
        }

        //已经将原有积分消耗到小于等于5
        if (remainPoints >= 4) {
            // 4<=积分<=5
            if (remainDays >= 6) {
                //4天C, 2天B
                totalBDays = totalBDays + 2;
                totalCDays = totalCDays + 4;
                maxIncome = maxIncome + 2 * 60;
                remainDays = remainDays - 6;
                remainPoints = remainPoints + 16 - 20;//积分已经 <=1
                if (remainDays == 0) {
                    System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
                    return maxIncome;
                }
            } else if (remainDays <= 2) {
                //全买A
                maxIncome = maxIncome + remainDays * 17;
                totalADays = totalADays + remainDays;
                System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
                return maxIncome;
            }else{//剩下3到5天
                //买2C 1B 剩下全A
                totalCDays = totalCDays + 2;
                totalBDays = totalBDays + 1;
                totalADays = days - totalBDays - totalCDays;
                maxIncome = totalBDays * 60 + totalADays * 17;
                System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
                return maxIncome;
            }
        }

        //已经将原有积分消耗到小于等于3了,先不管这个积分,假设我没有积分,以7天一周期计算最大收益
        if (remainDays >= 7) {

            int sevenDaysNumber = remainDays / 7;
            //5天C,2天B
            totalBDays = totalBDays + 2 * sevenDaysNumber;
            totalCDays = totalCDays + 5 * sevenDaysNumber;
            remainDays = remainDays - 7 * sevenDaysNumber;
            maxIncome = totalBDays * 60 + totalADays * 17;
            if (remainDays == 0) {
                System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
                return maxIncome;
            }

        }

        //此时已经将积分过滤到<=3 , 天数过滤到<=6

        if (remainDays <= 2) {//因为剩下最多3积分,如果只剩2天,就只能买A产品
            //剩下天数全部买A
            totalADays = totalADays + remainDays;
            maxIncome = maxIncome + 17 * remainDays;
            System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
            return maxIncome;
        } else {// 3<=剩余天数<=6
            if (remainPoints >= 2) {// 2<=积分<=3
                //买2天C, 1天B,剩下全买A
                totalBDays = totalBDays + 1;
                totalCDays = totalCDays + 2;
                totalADays = days - totalBDays - totalCDays;
                maxIncome = totalBDays * 60 + totalADays * 17;
                System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
                return maxIncome;
            } else {//最多剩余1积分,
                //全部买A产品
                totalADays = days - totalBDays - totalCDays;
                maxIncome = totalBDays * 60 + totalADays * 17;
                System.out.println("购买A产品" + totalADays + "天,购买B产品" + totalBDays + "天,购买C产品" + totalCDays + "天");
                return maxIncome;
            }
        }

    }
}
