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
    Node insert(Node node, String key, String foreignSaying, String englishSaying, String foreignExplanation, String englishExplanation) {
        if (node == null)
            return new Node(key, foreignSaying, englishSaying, foreignExplanation, englishExplanation);

        if (key.compareTo(node.key) < 0)
            node.left = insert(node.left, key, foreignSaying, englishSaying, foreignExplanation, englishExplanation);
        else if (key.compareTo(node.key) > 0)
            node.right = insert(node.right, key, foreignSaying, englishSaying, foreignExplanation, englishExplanation);
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

    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    Node find(Node node, String key) {
        // Base Cases: node is null or key is present at node
        if (node == null || node.key.equals(key)) {
            if (node != null) {
                System.out.println("Found: " + node.englishSaying);
            } else {
                System.out.println("Not Found");
            }
            return node;
        }
        // Key is greater than node's key
        if (node.key.compareTo(key) < 0) {
            return find(node.right, key);
        }
        // Key is smaller than node's key
        return find(node.left, key);
    }

    // Wrapper function for search
    Node find(String key) {
        return find(root, key);
    }
}
