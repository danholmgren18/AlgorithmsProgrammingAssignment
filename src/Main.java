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
        //The number of files of each type to be generated
        int fileNum = 30;

        //Commented out to save time
//        FileMaker.generateFiles(small, fileNum, 1);
//        FileMaker.generateFiles(medium, fileNum, 1);
//        FileMaker.generateFiles(large, fileNum, 1);
//
//        FileMaker.generateFiles(small, fileNum, 2);
//        FileMaker.generateFiles(medium, fileNum, 2);
//        FileMaker.generateFiles(large, fileNum, 2);
//
//        FileMaker.generateFiles(small, fileNum, 3);
//        FileMaker.generateFiles(medium, fileNum, 3);
//        FileMaker.generateFiles(large, fileNum, 3);

        getRunTimes("Unsorted", small);
        getRunTimes("Unsorted", medium);
        getRunTimes("Unsorted", large);

        getRunTimes("Sorted", small);
        getRunTimes("Sorted", medium);
        getRunTimes("Sorted", large);

        getRunTimes("Reverse Sorted", small);
        getRunTimes("Reverse Sorted", medium);
        getRunTimes("Reverse Sorted", large);

    }

    private static void getRunTimes(String filePath, int size) throws IOException {
        ArrayList<Long> mergeTimes = new ArrayList<>();
        ArrayList<Long> quickTimes = new ArrayList<>();
        ArrayList<Long> heapTimes = new ArrayList<>();

        for(int i = 0; i < 30; i++){
            File file = new File(filePath + " Files/" + filePath + " " + size +"/" + filePath + " " +  size + " " + (i + 1));
            ArrayList<Integer> mergeSortList = Reader.readFile(file);
            ArrayList<Integer> quickSortList = Reader.readFile(file);
            ArrayList<Integer> heapSortList = Reader.readFile(file);

            //Gets the run time for merge sort
            long startTime = System.currentTimeMillis();
            Sorter.mergeSort(mergeSortList);
            long endTime  = System.currentTimeMillis();
            mergeTimes.add(endTime - startTime);
            System.out.println("Finished Mergesort For: " + filePath + " " + size);

            //Gets the run time quick sort
            startTime = System.currentTimeMillis();
            Sorter.quickSort(quickSortList);
            endTime  = System.currentTimeMillis();
            quickTimes.add(endTime - startTime);
            System.out.println("Finished Quicksort For: " + filePath + " " + size);

            //Gets the run time heap sort
            startTime = System.currentTimeMillis();
            Sorter.heapSort(heapSortList);
            endTime  = System.currentTimeMillis();
            heapTimes.add(endTime - startTime);
            System.out.println("Finished Heapsort For: " + filePath + " " + size);
        }
        FileMaker.writeFile(mergeTimes, filePath + " Files/" + "Merge " + filePath + " " + size + " Times");
        FileMaker.writeFile(quickTimes, filePath + " Files/" + "Quick " + filePath + " " + size + " Times");
        FileMaker.writeFile(heapTimes, filePath + " Files/" + "Heap " + filePath + " " + size + " Times");
    }
}
