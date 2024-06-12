
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Construct a tree to begin with */
        tree.root = tree.insert(tree.root,"Komo mai kāu māpuna hoe", "Put in your dip of the paddle", "Hoʻokomo i loko","Pitch in");
        tree.root = tree.insert(tree.root, "Kūlia i ka nuʻu", "Strive to reach the highest", "E hooikaika e hana i kou maikai", "Strive to do your best");
        tree.root = tree.insert(tree.root, "Ma ka hana ka ʻike", "In working one learns", "Hiki ke loaʻa ka ʻike ma ka hana ʻana", "Knowledge can be acquired by doing");
        tree.root = tree.insert(tree.root, "E kaupē aku nō i ka hoe a kō mai", "Put forward the paddle and draw it back", "E hoʻomau i ka hana i hoʻomaka a hoʻopau", "Go on with the task that is started and finish it");
        tree.root = tree.insert(tree.root, "Hoʻokahi nō lā o ka malihini", "A stranger only for a day", "Ma hope o ka lā mua ma ke ʻano he malihini, pono ke kōkua i ka hana", "After the first day as a guest, one must help with the work");


        /* All functions tested with this code */
        System.out.println("In order traversal of constructed AVL tree is:");
        tree.inOrder();

        tree.member(tree.root, "E kuʻikahi kākou");

        System.out.println("\nThis is the first alphabetical saying:");
        tree.first();

        System.out.println("\nThis is the last alphabetical saying:");
        tree.last();

        System.out.println("\nThis is the predecessor");
        tree.predecessor("Hoʻokahi nō lā o ka malihini");

        System.out.println("\nThis is the successor");
        tree.successor("Hoʻokahi nō lā o ka malihini");

        System.out.println("\nThis is the Hawaiian sayings with E");
        tree.meHua("E");

        System.out.println("\nThis is English translations with day");
        tree.withWord("day");
    }
}
