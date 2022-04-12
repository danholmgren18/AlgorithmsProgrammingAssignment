import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class that holds all the sorting algorithms
 */
public class Sorter {

    //Using the pseudocode from the book
    public static void quickSort(List<Integer> fileContents){
        int left = 0;
        int right = fileContents.size();
        if(left < right){
            int s = partition(fileContents);
            quickSort(fileContents.subList(left, s));
            quickSort(fileContents.subList(s + 1, right));
        }
        System.out.println(fileContents);
    }

    //Using the pseudocode from the book
    public static void mergeSort(ArrayList<Integer> fileContents){
        if(fileContents.size() > 1){
            int middle = fileContents.size() / 2;
            //Copy A[0 ... (n/2) - 1] to B[]
            ArrayList<Integer> tempB = new ArrayList<>();
            for(int i = 0; i < middle; i++){
                tempB.add(fileContents.get(i));
            }
            //Copy A[(n/2) ... (n - 1)] to C[]
            ArrayList<Integer> tempC = new ArrayList<>();
            for(int j = middle; j < fileContents.size(); j++){
                tempC.add(fileContents.get(j));
            }
            mergeSort(tempB);
            mergeSort(tempC);
            merge(tempB, tempC, fileContents);
            System.out.println(fileContents);
        }
    }

    //Using the pseudocode from the book
    public static void heapSort(ArrayList<Integer> fileContents){
        int k;
        int v;
        int j;
        boolean heap;
        for(int i = (fileContents.size() / 2); i > 0; i--){
            k = i;
            v = fileContents.get(k);
            heap = false;
            while(!heap && (2 * k) <= fileContents.size() - 1){
                j = 2 * k;
                if(j < fileContents.size() - 1){
                    if(fileContents.get(j) < fileContents.get(j + 1)){
                        j++;
                    }
                }
                if(v >= fileContents.get(j)){
                    heap = true;
                } else {
                    fileContents.set(k, fileContents.get(j));
                    k = j;
                }
            }
            fileContents.set(k, v);
        }
        System.out.println(fileContents);
    }

    //Using the pseudocode from the book
    private static void merge(ArrayList<Integer> B, ArrayList<Integer> C, ArrayList<Integer> A){
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < B.size() && j < C.size()){
            if(B.get(i) <= C.get(j)){
                A.set(k, B.get(i));
                i++;
            } else {
                A.set(k, C.get(j));
                j++;
            }
            k++;
        }

        if(i == B.size()) {
            while (j < C.size()) {
                A.set(k, C.get(j));
                j++;
                k++;
            }
        } else {
            while(i < B.size()) {
                A.set(k, B.get(i));
                i++;
                k++;
            }
        }
    }

    //Using the pseudocode from the book
    //Also referenced: https://en.wikipedia.org/wiki/Dutch_national_flag_problem
    private static int partition(List<Integer> A){
        int i = 0;
        int j = 0;
        int k = A.size() - 1;
        int mid = A.size() / 2;

        while (j <= k) {
            if (A.get(j) < A.get(mid)) {
                int temp = A.get(i);
                A.set(i, A.get(j));
                A.set(j, temp);
                i++;
                j++;
            }
            else if (A.get(j) > A.get(mid)) {
                int temp = A.get(j);
                A.set(j, A.get(k));
                A.set(k, temp);
                k--;
            }
            else {
                j++;
            }
        }
        return k;
    }
}
