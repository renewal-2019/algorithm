package leecode;

public class Al12 {

    public ListNodeX deleteDuplicates(ListNodeX head) {

        ListNodeX current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;//这一步使current指向了另一个对象
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Al12 al12 = new Al12();

        ListNodeX x1 = new ListNodeX(1);
        ListNodeX x2 = new ListNodeX(1);
        ListNodeX x3 = new ListNodeX(2);
        ListNodeX x4 = new ListNodeX(3);
        ListNodeX x5 = new ListNodeX(4);
        ListNodeX x6 = new ListNodeX(4);
        x1.next = x2;
        x2.next = x3;
        x3.next = x4;
        x4.next = x5;
        x5.next = x6;
        al12.deleteDuplicates(x1);
    }


}

class ListNodeX {
    int val;
    ListNodeX next;

    ListNodeX(int x) {
        val = x;
    }
}
