import java.lang.reflect.Array;
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
        isSorted(fileContents);
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
            isSorted(fileContents);
        }
    }

    //Using the pseudocode from the book
    public static void heapSort(List<Integer> fileContents){
        int unsorted = fileContents.size() - 1;
        while(unsorted > 0){
            heapify(fileContents.subList(0, unsorted + 1));
            int temp = fileContents.get(0);
            fileContents.set(0, fileContents.get(unsorted));
            fileContents.set(unsorted, temp);
            unsorted--;
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

    //Using pseudocode from the book
    private static void heapify (List<Integer> list) {
        int n = list.size();
        for (int i = Math.floorDiv(n, 2);i > 0; i--) {
            int k = i-1;
            int v = list.get(k);

            boolean heap = false;
            while ((!heap) && ((2*(k+1)) <= n)) {
                int j = (2*(k+1)-1);
                if (j < n-2) {
                    if (list.get(j) < list.get(j + 1)) {
                        j++;
                    }
                }
                if (v >= list.get(j)) {
                    heap = true;
                }
                else {
                    list.set(k, list.get(j));
                    k = j;
                }
            }
            list.set(k, v);
        }
    }

    private static boolean isSorted(List<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > list.get(i + 1)){
                System.out.println("SOMETHING FAILED!!!");
                return false;
            }
        }
        System.out.println("SORTED!!!");
        return true;
    }
}
