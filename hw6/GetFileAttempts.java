import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetFileAttempts {
    public static void main(String[] args) {
        List<String> results = new ArrayList<String>();
        File[] files = new File(System.getProperty("user.dir")).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().contains(".pgn")) {
                results.add((file.getName()));
                ArrayList<String> moves = getMoves(fileContent(file.toPath()));
                System.out.println(moves);
            }
        }
        System.out.println(results);
    }
    public static ArrayList<String> getMoves(String game) {
        int turn = 1;
        String turnAsString = turn + ".";
        ArrayList<String> result = new ArrayList<>();
        while (game.contains(turnAsString)) {
            int start = game.indexOf(turnAsString);
            start += turnAsString.length();
            turnAsString = ++turn + ".";
            int end = game.indexOf(turnAsString);
            if (end != -1) {
                result.add(game.substring(start, end).trim());
            } else {
                result.add(game.substring(start).trim());
            }
        }
        return result;
    }
    public static String fileContent(Path file) {
        //Path file = Paths.get(path);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                // Add the \n that's removed by readline()
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            System.exit(1);
        }
        return sb.toString();
    }
}