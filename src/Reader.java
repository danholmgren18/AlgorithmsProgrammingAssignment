import java.io.*;
import java.util.ArrayList;

/**
 * Class that handles the functionality for
 * reading the contents of a file
 */
public class Reader {

    /**
     * reads in the lines from a file
     * @return A list of the file contents
     * @throws IOException If file cannot be found
     */
    public static ArrayList<Integer> readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));

        ArrayList<Integer> content = new ArrayList<>();
        String line = reader.readLine();
        while(line != null && !line.isEmpty()){
            content.add(Integer.parseInt(line));
            line = reader.readLine();
        }

        reader.close();
        return content;
    }
}
