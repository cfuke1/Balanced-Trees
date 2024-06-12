
class Node {
    String key;
    int height;
    String foreignSaying;
    String englishSaying;
    String foreignExplanation;
    String englishExplanation;
    Node left, right;

    Node(String key, String foreignSaying, String englishSaying, String foreignExplanation, String englishExplanation) {
        this.foreignSaying = foreignSaying;
        this.englishSaying = englishSaying;
        this.foreignExplanation = foreignExplanation;
        this.englishExplanation = englishExplanation;
        this.key = key;
        this.height = 1;
    }
}
//public class Node {

//
//    public Node(String foreignSaying, String englishSaying, String foreignExplanation, String englishExplanation) {
//        this.foreignSaying = foreignSaying;
//        this.englishSaying = englishSaying;
//        this.foreignExplanation = foreignExplanation;
//        this.englishExplanation = englishExplanation;
//
//
//    }
//
//}