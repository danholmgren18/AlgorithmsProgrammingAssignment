import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class that holds functionality for writing to a file
 */
public class FileMaker {
    private static final int MAX = 10000;

    /**
     * Generates all the files, passes them to
     * writeFile() to be filled
     * @throws IOException If file cannot be found
     */
    public static ArrayList<File> generateFiles(int size, int fileNum, int fileFlag) throws IOException {
        ArrayList<File> files = new ArrayList<>();
        File file;
        for(int i  = 0; i < fileNum; i++) {

            ArrayList<Integer> contents = new ArrayList<>();
            for (int num = 0; num < size; num++) {
                contents.add((int) (Math.random() * MAX));
            }

            switch (fileFlag) {
                case 1:
                    file = new File("Unsorted Files/Unsorted " + size + "/Unsorted " + size + " " + (i + 1));
                    writeFile(contents, file.getPath());
                    files.add(file);
                    break;
                case 2:
                    file = new File("Sorted Files/Sorted " + size + "/Sorted " + size + " " + (i + 1));
                    contents.sort(Comparator.naturalOrder());
                    writeFile(contents, file.getPath());
                    files.add(file);
                    break;
                case 3:
                    file = new File("Reverse Sorted Files/Reverse Sorted " + size + "/Reverse Sorted " + size + " " + (i + 1));
                    contents.sort(Collections.reverseOrder());
                    writeFile(contents, file.getPath());
                    files.add(file);
                    break;
                default:
                    break;
            }
        }
        return files;
    }

    /***
     * Writes the contents of the list to the specified file
     * @param content the list of numbers to write
     * @param filePath the file path being written to
     */
    public static void writeFile(ArrayList<? extends Number> content, String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);

        //Writes each number in the list to the file
        content.forEach(x -> {
            try {
                writer.write(x + "\n");
            } catch (IOException e) {
                System.out.println("File not found!");
                e.printStackTrace();
            }
        });

        writer.close();
    }
}
