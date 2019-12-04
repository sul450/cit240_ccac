
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sliu11
 */
public class Sorter {
    //Bubble sort method
    public static void bubbleSort(int[] list){
        boolean needNextPass = true;
        for (int k = 1; k < list.length && needNextPass; k++){
            //Array may be sorted and next pass not needed
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++){
                if (list[i] > list[i + 1]){
                    //Swap list[i] with list[i + 1]
                    int temp = list[i];
                    list[i] = list[i+1];
                    list[i +1] = temp;
                    
                    needNextPass = true; //Next pass still needed
                }
            }
        }
    }
}



public static void mergeSort(int[] list){
        
    }


