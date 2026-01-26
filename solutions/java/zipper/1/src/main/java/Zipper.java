class Zipper {
    private int val;
    Zipper up;
    Zipper left;
    Zipper right;

    Zipper(int val) {
        this.val = val;
    }

    BinaryTree toTree() {
        Zipper root = this;
        while(root.up != null){
            root = root.up;
        }
        return new BinaryTree(root);
    }

    int getValue() {
        return val;
    }

    Zipper setLeft(Zipper leftChild) {
        this.left = leftChild;
         if (leftChild != null) leftChild.up = this;
        return this;
    }

    Zipper setRight(Zipper rightChild) {
        this.right = rightChild;
        if (rightChild != null) rightChild.up = this;
        return this;
    }

    void setValue(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Zipper)) return false;
        Zipper other = (Zipper) obj;
        return this == other;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
}

class BinaryTree {

    private final Zipper root;
    
    BinaryTree(int value) {
        this.root = new Zipper(value);
    }

    BinaryTree(Zipper root) {
        this.root = root;
    }

    Zipper getRoot() {
        return root;
    }

    String printTree() {
        return printZipper(root);
    }

        private String printZipper(Zipper node) {
       if(node == null) return "null";
            return "value: " + node.getValue() + ", " +
                "left: " + formatChild(node.left) + ", " + 
                "right: "  + formatChild(node.right);
    }

    private String formatChild(Zipper node) {
        if (node == null) return "null";
        return "{ " + printZipper(node) + " }";}
        

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BinaryTree)) return false;
        return printTree().equals(((BinaryTree) obj).printTree());
    }

    @Override
    public int hashCode() {
        return printTree().hashCode();
    }
}
