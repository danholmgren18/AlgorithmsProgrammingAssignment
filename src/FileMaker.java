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
    private static final ArrayList<File> files = new ArrayList<>();

    /**
     * Generates all the files, passes them to
     * writeFile() to be filled
     * @throws IOException If file cannot be found
     */
    public static ArrayList<File> generateFiles(int size, int fileNum) throws IOException {
        File file;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < fileNum; j++){

                //Holds all the random numbers to be sorted
                ArrayList<Integer> contents = new ArrayList<>();
                for(int num = 0; num < size; num++){
                    contents.add((int) (Math.random() * MAX));
                }

                //Creates the proper file based on the current outer loop iteration
                if(i == 0){
                    file = new File("Unsorted " + size + " " + (j + 1));
                    writeFile(contents, file);
                } else if(i == 1){
                    file = new File("Sorted " + size + " " + (j + 1));
                    contents.sort(Comparator.naturalOrder());
                    writeFile(contents, file);
                } else {
                    file = new File("Reverse Sorted " + size + " " + (j + 1));
                    contents.sort(Collections.reverseOrder());
                    writeFile(contents, file);
                }
                files.add(file);
            }
        }
        return files;
    }

    /***
     * Writes the contents of the list to the specified file
     * @param content the list of numbers to write
     * @param file the file being written to
     */
    public static void writeFile(ArrayList<? extends Number> content, File file) throws IOException {
        FileWriter writer = new FileWriter(file);

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
