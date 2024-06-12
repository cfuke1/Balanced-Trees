
class Node {
    int height;
    String englishSaying;
    String foreignExplanation;
    String englishExplanation;
    String key;
    Node left, right;

    Node(String key, String englishSaying, String foreignExplanation, String englishExplanation) {
        this.key = key;
        this.englishSaying = englishSaying;
        this.foreignExplanation = foreignExplanation;
        this.englishExplanation = englishExplanation;
        this.height = 1;
    }
}
