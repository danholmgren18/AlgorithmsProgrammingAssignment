import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.swap;

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
        }
    }

    //Using the pseudocode from the book
    //Merlin helped :)
    public static void heapSort(List<Integer> fileContents){
        buildHeap(fileContents);
        int notSorted = fileContents.size() - 1;
        while(notSorted > 0){
            swap(fileContents, 0, notSorted);
            notSorted--;
            heapify(fileContents.subList(0, notSorted + 1), 0);
        }
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
    private static int partition(List<Integer> A) {
        int i = 0;
        int j = 0;
        int k = A.size()-1;
        int pivot = A.get(A.size() / 2);
        if(A.size() > 100) {
            int first = A.get(0);
            int middle = A.get(A.size() / 2);
            int last = A.get(A.size()-1);
            if(((last > middle) && (first < middle)) || ((first > middle) && (last < middle))) {
                pivot = middle;
            }else if(((last > first) && (middle < first)) || ((middle > first) && (last < first))) {
                pivot = first;
            } else {
                pivot = last;
            }
        } else {
            pivot = A.get(A.size() / 2);
        }

        while (j <= k) {
            if (A.get(j) < pivot) {
                swap(A, i, j);
                i++;
                j++;
            } else if (A.get(j) > pivot) {
                swap(A, j, k);
                k--;
            }else {
                j++;
            }
        }
        return k;
    }

    //Using pseudocode from the book
    private static void heapify (List<Integer> fileContents, int position) {
        int childOne = ((2 * position) + 1);
        int childTwo = ((2 * position) + 2);
        if(childTwo < fileContents.size()){
            if(fileContents.get(childOne) > fileContents.get(childTwo)){
                if(fileContents.get(position) < fileContents.get(childOne)){
                    swap(fileContents, childOne, position);
                    heapify(fileContents, childOne);
                }
            } else{
                if(fileContents.get(position) < fileContents.get(childTwo)){
                    swap(fileContents, childTwo, position);
                    heapify(fileContents, childTwo);
                }
            }
        } else if(childOne < fileContents.size()){
            if(fileContents.get(position) < fileContents.get(childOne)){
                swap(fileContents, childOne, position);
                heapify(fileContents, childOne);
            }
        }
    }

    private static void buildHeap(List<Integer> fileContents){
        for(int i = fileContents.size() / 2; i >=0; i--){
            heapify(fileContents, i);
        }
    }

    private static void isSorted(List<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > list.get(i + 1)){
                System.out.println("SOMETHING FAILED!!!");
                return;
            }
        }
        System.out.println("SORTED!!!");
    }
}
