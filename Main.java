
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        /* The constructed AVL Tree would be
               30
              /  \
            20   40
           /  \     \
         10   25    50
        */
        System.out.println("Preorder traversal of constructed AVL tree is :");
        tree.preOrder(tree.root);

        System.out.println("Finding key :");
        tree.find(tree.root, 10);
    }
}
