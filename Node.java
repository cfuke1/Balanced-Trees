
class Node {
    int height;
    String foreignSaying;
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

    public static String hawaiianToEnglish(String hawaiianWord) {
        StringBuilder englishWord = new StringBuilder();

        for (char c : hawaiianWord.toCharArray()) {
            char englishEquivalent = getEnglishEquivalent(c);
            englishWord.append(englishEquivalent);
        }
        return englishWord.toString();
    }

    // Function to get the English equivalent of a Hawaiian letter
    private static char getEnglishEquivalent(char hawaiianLetter) {
        switch (hawaiianLetter) {
            case 'Ā':
            case 'ā':
                return 'a';
            case 'Ē':
            case 'ē':
                return 'e';
            case 'Ī':
            case 'ī':
                return 'i';
            case 'Ō':
            case 'ō':
                return 'o';
            case 'Ū':
            case 'ū':
                return 'u';
            default:
                return hawaiianLetter;
        }
    }

}
