public class TernarySearchTreeNode {
    public TernarySearchTreeNode left;
    public TernarySearchTreeNode mid;
    public TernarySearchTreeNode right;
    public char data;
    public boolean isTerm;

    public TernarySearchTreeNode(TernarySearchTreeNode left, TernarySearchTreeNode mid, TernarySearchTreeNode right, char data, boolean isTerm) {
        this.left = left;
        this.mid = mid;
        this.right = right;
        this.data = data;
        this.isTerm = isTerm;
    }

    public TernarySearchTreeNode(char data) {
        this(null, null, null, data, false);
    }
}