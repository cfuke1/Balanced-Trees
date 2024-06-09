
import java.util.Collection;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList sayings = new LinkedList();

        Node first = new Node("E kaupē aku nō i ka hoe a kō mai.", "Put forward the paddle and draw it back.", "Go on with the task that is started and finish it", "Hawaiian Explanation");

        sayings.add(first);

        System.out.println("Sorted List: " + sayings);
    }
}