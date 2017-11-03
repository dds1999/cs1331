// public interface Iterable<E> {
//     public Iterable<E> iterator();
// }
import java.util.Scanner;

public class WordCount {
    public WordCount(String fileName) {
        Scanner in = new Scanner(new File(fileName));
        while (in.hasNext()) {

        }
    }
    // principle of least commitment. Doesnt't have to array list or array, just
    // something that implements Iterable of String. People can set this to
    // reutrn value to anything they want. Better client saide code
    public Iterable<String> getWords() {
        return null;
    }

    public int getCount() {
        return 0;
    }

    public static void main(String[] args) {
        String fileName = args[0];
        WordCount wc = new WordCount(fileName);
        for (String word : wc.getWords()) {
            System.out.printf("%s: %d%n", word, wc.getCount());
        }
        /*
        Iterator<String> it = new wc.getWords().iterator();
        while (it.hasNext()) {
            //do somthing
        }
        // wc is the target of the for-each loop.
        // needs to object of class that implements ITERABLE
        */
        // examples of white space = tabs, lines, spaces
    }
}