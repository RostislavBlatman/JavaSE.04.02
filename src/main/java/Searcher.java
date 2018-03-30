package main.java;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Searcher {

    public static boolean checkForWord(String word) {
        String line = "\"abstract\",\"assert\",\"boolean\",\"break\",\"byte\",\"case\",\"catch\"," +
                "  \"char\",\"class\",\"const\",\"continue\",\"default\",\"do\",\"double\",\"else\"," +
                "\"extends\",\"false\", \"final\"," +
                "  \"finally\", \"float\", \"for\", \"goto\", \"if\", \"implements\", \"import\", " +
                "\"instanceof\", \"int\", \"interface\"," +
                "  \"long\", \"native\", \"new\", \"null\", \"package\", \"private\", \"protected\", " +
                "\"public\", \"return\", \"short\", \"static\"" +
                " , \"strictfp\", \"super\", \"switch\", \"synchronized\", \"this\", \"throw\", " +
                "\"throws\", \"transient\", \"true\", \"try\"," +
                "   \"void\", \"volatile\", \"while\"";
        return word != null && !word.equals("") && line.contains(word);
    }


    public static void searchKeywords(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
             BufferedWriter bufferedOutputStream = new BufferedWriter(new FileWriter("src\\main\\java\\resources\\" +
                     "file.txt"))) {
            Map<String, Integer> counter = new HashMap<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("([.[,\\s({)}\"]]+)");

                for (String word : words) {
                    if (checkForWord(word) && word.length() > 0) {
                        if (counter.get(word) == null) {
                            counter.put(word, 1);
                        } else {
                            counter.put(word, counter.get(word) + 1);
                        }
                    }
                }
            }

            bufferedOutputStream.write(counter.toString());

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
