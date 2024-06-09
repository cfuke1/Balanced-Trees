public class Node {
    String foreignSaying;
    String englishSaying;
    String foreignExplanation;
    String englishExplanation;
    Node left;
    Node right;
    Node parent;

    boolean color; //Red is FALSE, Black is TRUE

    public Node(String foreignSaying, String englishSaying, String foreignExplanation, String englishExplanation) {
        this.foreignSaying = foreignSaying;
        this.englishSaying = englishSaying;
        this.foreignExplanation = foreignExplanation;
        this.englishExplanation = englishExplanation;


    }

}