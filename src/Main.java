import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Runnable class for project
 */
public class Main {

    public static void main(String[] args) throws IOException {
        //The size of the files
        int small = 10000;
        int medium = 100000;
        int large = 1000000;
        //The number of files of each type to
        //be generated
        int fileNum = 1;

        ArrayList<File> unsortedSmallFiles;
        ArrayList<File> unsortedMediumFiles;
        ArrayList<File> unsortedLargeFiles;

        ArrayList<File> sortedSmallFiles;
        ArrayList<File> sortedMediumFiles;
        ArrayList<File> sortedLargeFiles;

        ArrayList<File> reverseSortedSmallFiles;
        ArrayList<File> reverseSortedMediumFiles;
        ArrayList<File> reverseSortedLargeFiles;

        unsortedSmallFiles = FileMaker.generateFiles(small, fileNum, 1);
        unsortedMediumFiles = FileMaker.generateFiles(medium, fileNum, 1);
        unsortedLargeFiles = FileMaker.generateFiles(large, fileNum, 1);

        sortedSmallFiles = FileMaker.generateFiles(small, fileNum, 2);
        sortedMediumFiles = FileMaker.generateFiles(medium, fileNum, 2);
        sortedLargeFiles = FileMaker.generateFiles(large, fileNum, 2);

        reverseSortedSmallFiles = FileMaker.generateFiles(small, fileNum, 3);
        reverseSortedMediumFiles = FileMaker.generateFiles(medium, fileNum, 3);
        reverseSortedLargeFiles = FileMaker.generateFiles(large, fileNum, 3);

        //ArrayList<Long> smallUnsortQuickTimes = new ArrayList<>();
        unsortedSmallFiles.forEach(x -> {
            try {
                ArrayList<Integer> temp = Reader.readFile(x);
                Instant start = Instant.now();
                Sorter.quickSort(temp);
                Instant end = Instant.now();
                //smallUnsortQuickTimes.add(end.toEpochMilli() - start.toEpochMilli());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //FileMaker.writeFile(quickTimes, quickOutput);

//        //Runs heapSort on each file, storing the time taken to sort
//        ArrayList<Number> heapTimes = new ArrayList<>();
//        files.forEach(x -> {
//            try{
//                ArrayList<Integer> temp = Reader.readFile(x);
//                Instant start = Instant.now();
//                Sorter.heapSort(temp);
//                Instant end = Instant.now();
//                heapTimes.add(end.toEpochMilli() - start.toEpochMilli());
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        });
//        FileMaker.writeFile(heapTimes, heapOutput);

        //Runs mergeSort on each file, storing the time taken to sort
        //ArrayList<Long> mergeTimes = new ArrayList<>();
        unsortedSmallFiles.forEach(x -> {
            try {
                Instant start = Instant.now();
                Sorter.mergeSort(Reader.readFile(x));
                Instant end = Instant.now();
                //mergeTimes.add(end.toEpochMilli() - start.toEpochMilli());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        //FileMaker.writeFile(mergeTimes, mergeOutput);
    }
}
