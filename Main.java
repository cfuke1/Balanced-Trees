
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, "Let us be united", "E kuʻikahi kākou", "Let us be united", "E kuʻikahi kākou - Explanation in ʻōlelo Hawaiʻi", "Let us be united - Explanation in English");
        tree.root = tree.insert(tree.root, "Unite to move forward", "Pupukahi i holomua", "Unite to move forward", "Pupukahi i holomua - Explanation in ʻōlelo Hawaiʻi", "Unite to move forward - Explanation in English");
        tree.root = tree.insert(tree.root, "One does not see the back", "ʻAʻole ʻike i ke a kā", "One does not see the back", "ʻAʻole ʻike i ke a kā - Explanation in ʻōlelo Hawaiʻi", "One does not see the back - Explanation in English");

        /* The constructed AVL Tree would be
               30
              /  \
            20   40
           /  \     \
         10   25    50
        */
        System.out.println("Preorder traversal of constructed AVL tree is :");
        tree.preOrder(tree.root);

        System.out.println("\nFinding key :");
        tree.find(tree.root, "One does not see the back");
    }
}
