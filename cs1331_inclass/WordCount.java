import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class WordCount {
    private Map<String, Integer> wordCounts;

    public WordCount(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        this.wordCounts = new HashMap<>();
        while (sc.hasNext()) {
            String word = sc.next();
            if (wordCounts.containsKey(word)) {
                int count = wordCounts.get(word);
                wordCounts.put(word, count + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
    }
    public Iterable<String> getWords() {
        return wordCounts.keySet();
        // reutrns a Set which a Collection which is an Iterable
    }
    public int getCount(String word) {
        return wordCounts.get(word);
    }
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        WordCount wc = new WordCount(fileName);
        for (String word : wc.getWords()) {
            System.out.printf("%s: %d%n", word, wc.getCount(word));
        }
    }
}