package wordcount;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class wordcount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "G:\\Rohan\\java_wordcounter\\wordcount\\src\\Data.txt";
		
		//String filePath = args[0];
        Map<String, Integer> wordCounts = new TreeMap<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\W+"); // Split on non-word characters
                for (String word : words) {
                    if (word.isEmpty()) {
                        continue;
                    }
                    word = word.toLowerCase(); // Convert to lowercase to handle case sensitivity
                    wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
	}

}
