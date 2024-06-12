import java.util.List;
class AVLTree {
    Node root;

    // Get height of the node
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Get balance factor of the node
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Right rotate subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Insert a key in the tree
    Node insert(Node node, String key, String englishSaying, String foreignExplanation, String englishExplanation) {
        if (node == null)
            return new Node(key, englishSaying, foreignExplanation, englishExplanation);

        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, englishSaying, foreignExplanation, englishExplanation);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key, englishSaying, foreignExplanation, englishExplanation);
        else // Duplicate keys not allowed
            return node;

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether this node became unbalanced
        int balance = getBalance(node);

        // If the node is unbalanced, there are four possible cases

        // Left Left Case
        if (balance > 1 && key.compareTo(node.left.key) < 0)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key.compareTo(node.right.key) > 0)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // If the node is already balanced
        return node;
    }

    // Displays all sayings in alphabetical order
    void inOrder(Node node) {
        if (node == null)
            return;

        // Traverse the left subtree
        inOrder(node.left);

        // Visit the current node
        System.out.print(node.key + " -> ");

        // Traverse the right subtree
        inOrder(node.right);
    }

    void inOrder() {
        inOrder(root);
    }

    //Checks if a saying is in the database
    Node member(Node node, String key) {
        // Base Cases: node is null or key is present at node
        if (node == null || node.key.equals(key)) {
            if (node != null) {
                System.out.println("\nFinding key :");
                System.out.println("Found: " + key + "\nEnglish Saying: " + node.englishSaying + "\nHawaiian Explanation: " + node.foreignExplanation + "\nEnglish Explanation: " + node.englishExplanation);
            } else {
                System.out.println("\nFinding key :");
                System.out.println("Not Found");
            }
            return node;
        }
        // Key is greater than node's key
        if (node.key.compareTo(key) < 0) {
            return member(node.right, key);
        }
        // Key is smaller than node's key
        return member(node.left, key);
    }

    //Finds first alphabetical saying in the database
    void first(Node node) {
        if (node.left != null) {
            first(node.left);
        } else {
            System.out.println("Found: " + node.key + "\nEnglish Saying: " + node.englishSaying + "\nHawaiian Explanation: " + node.foreignExplanation + "\nEnglish Explanation: " + node.englishExplanation);
        }
    }

    void first() {
        first(root);
    }

    //Finds first alphabetical saying in the database
    void last(Node node) {
        if (node.right != null) {
            last(node.right);
        } else {
            System.out.println("Found: " + node.key + "\nEnglish Saying: " + node.englishSaying + "\nHawaiian Explanation: " + node.foreignExplanation + "\nEnglish Explanation: " + node.englishExplanation);
        }
    }

    void last() {
        last(root);
    }

    //Finds predecessor of a saying in the database
    Node predecessor(Node node, String key, Node[] predecessor) {
        if (node == null)
            return null;

        // If key is found, find predecessor in left subtree
        if (node.key.equals(key)) {
            Node current = node.left;
            while (current != null && current.right != null) {
                current = current.right;
            }
            predecessor[0] = current;
            System.out.println("Found: " + current.key + "\nEnglish Saying: " + current.englishSaying + "\nHawaiian Explanation: " + current.foreignExplanation + "\nEnglish Explanation: " + current.englishExplanation);
            return node;
        }

        // If key is smaller than node's key, go left
        if (key.compareTo(node.key) < 0)
            return predecessor(node.left, key, predecessor);

        // If key is greater than node's key, go right
        predecessor[0] = node;
        return predecessor(node.right, key, predecessor);
    }

    Node predecessor(String key) {
        Node[] predecessor = new Node[1];
        return predecessor(root, key, predecessor);
    }

    //Finds predecessor of a saying in the database
    Node successor(Node node, String key, Node[] successor) {
        if (node == null)
            return null;

        // If key is found, find successor in left subtree
        if (node.key.equals(key)) {
            Node current = node.right;
            while (current != null && current.left != null) {
                current = current.left;
            }
            successor[0] = current;
            System.out.println("Found: " + current.key + "\nEnglish Saying: " + current.englishSaying + "\nHawaiian Explanation: " + current.foreignExplanation + "\nEnglish Explanation: " + current.englishExplanation);
            return node;
        }

        // If key is smaller than node's key, go left
        if (key.compareTo(node.key) < 0)
            return successor(node.left, key, successor);

        // If key is greater than node's key, go right
        successor[0] = node;
        return successor(node.right, key, successor);
    }

    Node successor(String key) {
        Node[] successor = new Node[1];
        return successor(root, key, successor);
    }

    //Displays all Hawaiian sayings that contain a certain word
    void meHua(Node node, String key) {
        if (node == null) {
            return;
        }

        // Visit the current node
        if (node.key.contains(key)) {
            System.out.print(node.key + "\n");
        }

        // Traverse the left subtree

        meHua(node.left, key);

        // Traverse the right subtree
        meHua(node.right, key);
    }

    void meHua(String key) {
        meHua(root, key);
    }

    //Displays all English translations that contain a certain word
    void withWord(Node node, String key) {
        if (node == null) {
            return;
        }

        // Visit the current node
        if (node.englishSaying.contains(key)) {
            System.out.print(node.englishSaying + "\n");
        }

        // Traverse the left subtree

        withWord(node.left, key);

        // Traverse the right subtree
        withWord(node.right, key);
    }

    void withWord(String key) {
        withWord(root, key);
    }
}

