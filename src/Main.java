import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

/**
 * Runnable class for project
 */
public class Main {
    private static final File mergeOutput = new File("MergeOutput");
    private static final File heapOutput = new File("HeapOutput");
    private static final File quickOutput = new File("QuickOutput");

    public static void main(String[] args) throws IOException {
        //TODO remove this stuff after testing
        //The size of the files
        int size = 10;
        //The number of files of each type to
        //be generated
        int fileNum = 1;

        //TODO Make 9 lists for files, one for each size and sorted combo
        ArrayList<File> files;
        files = FileMaker.generateFiles(size, fileNum);

        //TODO Finish testing and use this instead
//        ArrayList<Integer> sizes = new ArrayList<>(){
//            {
//                add(10000);
//                add(100000);
//                add(1000000);
//            };
//        };
//
//        sizes.forEach(x -> {
//            try {
//                files = FileMaker.generateFiles(x, fileNum);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });


//        //Runs quicksort on each file, storing the time taken to sort
//        ArrayList<Number> quickTimes = new ArrayList<>();
//        files.forEach(x -> {
//            try{
//                Instant start = Instant.now();
//                Sorter.quickSort(Reader.readFile(x));
//                Instant end = Instant.now();
//                quickTimes.add(end.toEpochMilli() - start.toEpochMilli());
//            } catch (IOException e){
//                e.printStackTrace();
//            }
//        });
//        FileMaker.writeFile(quickTimes, quickOutput);

        //Runs heapSort on each file, storing the time taken to sort
        ArrayList<Number> heapTimes = new ArrayList<>();
        files.forEach(x -> {
            try{
                Instant start = Instant.now();
                Sorter.heapSort(Reader.readFile(x));
                Instant end = Instant.now();
                heapTimes.add(end.toEpochMilli() - start.toEpochMilli());
            } catch (IOException e){
                e.printStackTrace();
            }
        });
        FileMaker.writeFile(heapTimes, heapOutput);

//        //Runs mergeSort on each file, storing the time taken to sort
//        ArrayList<Long> mergeTimes = new ArrayList<>();
//        files.forEach(x -> {
//            try {
//                Instant start = Instant.now();
//                Sorter.mergeSort(Reader.readFile(x));
//                Instant end = Instant.now();
//                mergeTimes.add(end.toEpochMilli() - start.toEpochMilli());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });
//        FileMaker.writeFile(mergeTimes, mergeOutput);
    }
}
