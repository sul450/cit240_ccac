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
public class Client {
        // A test method for bubbleSort
    public static void main(String[] args){
        
        Random random = new Random();
        
        int[] list = {random.nextInt()};
                bubbleSort(list);
                for (int i = 0; i < list.length; i++)
                    System.out.print(list[i] + " ");
    }
}
