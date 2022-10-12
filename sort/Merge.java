package sort;

import java.util.Arrays;

/**
 * Write a description of class Merge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Merge
{

    /**
     * Returns the sorted array
     */
    public static int[] sort(int[] arr) {
        int N = arr.length;
        int [] left = {};
        int [] right = {};
        if (N<2){
            return arr;
        }
        int middle = N/2;
        int[] leftLength = new int[middle];
        int[] rightLength = new int[N - middle];

        for(int i = 0; i < middle; i++){
            leftLength[i] = arr[i];
        }

        for(int i = middle; i < N; i++){
            rightLength[i -middle] = arr[i];
        }
        
        sort(leftLength);
        sort(rightLength);
        merge(arr, leftLength, rightLength);
        
        return arr;
    }
    
    private static void merge(int [] arr, int[] leftLength, int[] rightLength){
        int leftSize = leftLength.length;
        int rightSize = rightLength.length;
        int x = 0;
        int y = 0;
        int z  =0; 
        
        while (x < leftSize && y < rightSize){
            if(leftLength[x] <= rightLength[y]){
                arr[z] = leftLength[x];
                x++;
            }else{
                arr[z] = rightLength[y];
                y++;
            }
            z++;
        }
        while(x <leftSize){
            arr[z] = leftLength[x];
            x++;
            z++;
        }
        while(y <rightSize){
            arr[z] = rightLength[y];
            y++;
            z++;
        }
    } 

    public static void main(String[] args) {
        int[] arr = {53,85,93,25,39,27,42,5,24,45,33,51,5,80,4,7,91,
                31,66,71,32,19,79,58,61,82,89,63,7,4,50,10,48,24,75,19,22,
                73,54,51,25,33,20,52,79,97,70,54,63,49};    

        // Test the sort
        testSort(sort(arr));
    }

    public static void testSort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i] > arr[i+1]) {
                System.out.println("FAIL at index "+i);
                System.out.println(Arrays.toString(arr));
                return;
            }
        }
        System.out.println("SUCCESS!");
    }

}
