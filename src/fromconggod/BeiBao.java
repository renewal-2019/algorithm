package fromconggod;

public class BeiBao {

    public static void main(String[] args) {
        Bag[] bags = new Bag[] { new Bag(8, 16), new Bag(4, 20), new Bag(3, 15), new Bag(4, 12), new Bag(5, 10) };
        int money = 10;
        int[] moneys = new int[money + 1];

        // 0  1  2  3  4  5  6  7  8  9  10
        // 0  0  0  0  0  0  0  0  16 16 16
        // 0  0  0  0  20 20 20 20 20 20 20
        // 0  0  0  15 20 20 20 35 35 35 35
        for (int i = 0; i < bags.length; i++) {
            Bag bag = bags[i];

            for (int j = money; j >= 0; j--) {
                if (j + bag.money <= money) {  //当前包的索引钱 + 包内的钱 小于等于 总钱数
                    moneys[j + bag.money] = Math.max(moneys[j + bag.money], moneys[j] + bag.value);
                }

                // j = 8 moneys[8] = 20
                // j = 5 moneys[8] = 35
                if (j >= bag.money) {
                    moneys[j] = Math.max(bag.value, moneys[j]);
                }
            }

            StringBuffer sb = new StringBuffer();
            for (int j = 0; j < moneys.length; j++) {
                sb.append(moneys[j]).append(",");
            }
            System.out.println(sb);
        }
    }

}

class Bag {
    int money;

    int value;

    public Bag(int money, int value) {
        this.money = money;
        this.value = value;
    }
}

