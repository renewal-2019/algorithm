package bishi;

public class Test22 {
    public void move(){
        speak();
    };

    public void speak(){
        System.out.println("hhahahh ");
    }
}

class Test33 extends Test22 {
    public void speak(){
        System.out.println("666666 ");
    }
}

class Test44{
    public static void main(String[] args) {
        new Test33().move();
    }
}
