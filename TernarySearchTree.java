import java.util.Set;

public class TernarySearchTree {
    private TernarySearchTreeNode overallRoot;

    public TernarySearchTree(Set<String> dict) {
        overallRoot = null;
        add(dict);
    }

    private TernarySearchTreeNode add(String word, TernarySearchTreeNode root) {
        if (root == null) {
            root = new TernarySearchTreeNode(word.charAt(0));
        }
        if (word.length() == 1 && root.data == word.charAt(0)) {
            root.isTerm = true;
            return root;
        }
        if (word.charAt(0) < root.data) {
            root.left = add(word, root.left);
        } else if (word.charAt(0) == root.data) {
            root.mid = add(word.substring(1), root.mid);
        } else {
            root.right = add(word, root.right);
        }
        return root;
    }

    public TernarySearchTreeNode add(String word) {
        return overallRoot = add(word, overallRoot);
    }

    public void add(Set<String> dict) {
        for (String word : dict) {
            add(word);
        }
    }

    private void inOrderTraversal(TernarySearchTreeNode root, String s) {
        if (root != null) {
            inOrderTraversal(root.left, s);
            if (root.isTerm) {
                System.out.print(s + root.data + ", ");
            }
            inOrderTraversal(root.mid, s + root.data);
            inOrderTraversal(root.right, s);
        } 
    }

    public void inOrderTraversal() {
        inOrderTraversal(overallRoot, "");
    }

    public boolean search(String word) {
        return search(word, overallRoot);
    }

    private boolean search(String word, TernarySearchTreeNode root) {
        if (root == null || word.isEmpty()) { 
            return false;
        }
        if (word.charAt(0) == root.data) {
            if (word.length() == 1 && root.isTerm) {
                return true;
            }
            return search(word.substring(1), root.mid);
        } 
        if (word.charAt(0) < root.data) {
            return search(word, root.left);
        } else if (word.charAt(0) > root.data) {
            return search(word, root.right);
        }
        return false;
    }
}