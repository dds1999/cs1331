import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Comparator;

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
    // private class RankComparator implements Comparator<String> {
    //     public int compare(String word1, String word2) {
    //         int diff = wordCounts.get(word1) - wordCounts.get(word2);
    //         return (diff == 0) ? word1.compareTo(word2) : diff;
    //     }
    // }
    public Iterable<String> getWords() {
        return wordCounts.keySet();
        // reutrns a Set which a Collection which is an Iterable
    }
    public Iterable<String> getRankedWords() {
        TreeSet<String> rankedWords = new TreeSet<>((String word1, String word2)
            -> {
            int diff = wordCounts.get(word1) - wordCounts.get(word2);
            return (diff == 0) ? word1.compareTo(word2) : diff;
        });

        rankedWords.addAll(wordCounts.keySet());
        return rankedWords;
    }
    public int getCount(String word) {
        return wordCounts.get(word);
    }
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = args[0];
        WordCount wc = new WordCount(fileName);
        for (String word : wc.getRankedWords()) {
            System.out.printf("%s: %d%n", word, wc.getCount(word));
        }
    }
}



// WAY 1 - Inner Class
//     private class RankComparator implements Comparator<String> {
//         public int compare(String word1, String word2) {
//             int diff = wordCounts.get(word1) - wordCounts.get(word2);
//             return (diff == 0) ? word1.compareTo(word2) : diff;
//         }
//     }
//     public Iterable<String> getWords() {
//         return wordCounts.keySet();
//         // reutrns a Set which a Collection which is an Iterable
//     }
//     public Iterable<String> getRankedWords() {
//         TreeSet<String> rankedWords = new TreeSet<>(new RankComparator());
//         rankedWords.addAll(wordCounts.keySet());
//         return rankedWords;

// WAY 2 - Anon Class
//     public Iterable<String> getRankedWords() {
//         Comparator<String> RankComparator = new Comparator<>() {
//             public int compare(String word1, String word2) {
//                 int diff = wordCounts.get(word1) - wordCounts.get(word2);
//                 return (diff == 0) ? word1.compareTo(word2) : diff;
//             }
//         };

//         TreeSet<String> rankedWords = new TreeSet<>(RankComparator);
//         rankedWords.addAll(wordCounts.keySet());
//         return rankedWords;
//     }

// WAY 3 - Intermediate Step to Lambda Expressions
//     public Iterable<String> getRankedWords() {
//         TreeSet<String> rankedWords = new TreeSet<>(new Comparator<>() {
//             public int compare(String word1, String word2) {
//                 int diff = wordCounts.get(word1) - wordCounts.get(word2);
//                 return (diff == 0) ? word1.compareTo(word2) : diff;
//             }
//         });

//         rankedWords.addAll(wordCounts.keySet());
//         return rankedWords;
//     }

// WAY 4 - Lambda (Syntax shortcut to anon inter class)

//The type of a lambda expression is a functional interface





// public interface Iterable<E> {
//     public Iterable<E> iterator();
// }
//import java.util.Scanner;

// public class WordCount {
//     public WordCount(String fileName) {
//         Scanner in = new Scanner(new File(fileName));
//         while (in.hasNext()) {

//         }
//     }
//     // principle of least commitment. Doesnt't have to array list or array, just
//     // something that implements Iterable of String. People can set this to
//     // reutrn value to anything they want. Better client saide code
//     public Iterable<String> getWords() {
//         return null;
//     }

//     public int getCount() {
//         return 0;
//     }

//     public static void main(String[] args) {
//         String fileName = args[0];
//         WordCount wc = new WordCount(fileName);
//         for (String word : wc.getWords()) {
//             System.out.printf("%s: %d%n", word, wc.getCount());
//         }
//         /*
//         Iterator<String> it = new wc.getWords().iterator();
//         while (it.hasNext()) {
//             //do somthing
//         }
//         // wc is the target of the for-each loop.
//         // needs to object of class that implements ITERABLE
//         */
//         // examples of white space = tabs, lines, spaces
//     }
// }