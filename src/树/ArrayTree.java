package 树;

public class ArrayTree {
    private int[] tree;

    public void addLeft(int targetIndex, int leftValue) {
        tree[targetIndex * 2] = leftValue;
    }

    public void addRight(int targetIndex, int rightValue) {
        tree[targetIndex * 2 + 1] = rightValue;
    }

    public ArrayTree(int[] tree) {
        this.tree = tree;
    }
}
