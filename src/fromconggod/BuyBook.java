package fromconggod;

/**
 * 小明去街上买书，共带了n元
 * 假设每本书有价格m和重量g
 * 如何买到最重的书
 */
public class BuyBook {

    public static void main(String[] args) {
        Book b1 = new Book(2,5);
        Book b2 = new Book(3,3);
        Book b3 = new Book(10,1);
        Book b4 = new Book(6,6);
        Book b5 = new Book(1,2);

    }

}

class Book{

    public Book(int price,int weight){
        this.price = price;
        this.weight = weight;
    }

    private int price;
    private int weight;
}
