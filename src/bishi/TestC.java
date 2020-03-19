package bishi;

public class TestC {

    public TestC(int i , String g){
        System.out.println("1");
    }
    public TestC(String g,int i){
        System.out.println("2");
    }

}

class TestM{
    public static void main(String[] args) {
        TestC t1 = new TestC(1,"");
        TestC t2 = new TestC("",1);
    }
}
