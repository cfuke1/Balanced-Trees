
class Node {
    int key, height;
    String foreignSaying;
    String englishSaying;
    String foreignExplanation;
    String englishExplanation;
    Node left, right;

    Node(int d) {
        /*
        this.foreignSaying = foreignSaying;
        this.englishSaying = englishSaying;
        this.foreignExplanation = foreignExplanation;
        this.englishExplanation = englishExplanation;
         */
        key = d;
        height = 1;
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