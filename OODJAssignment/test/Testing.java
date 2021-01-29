/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kianjun
 */
public class Testing {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < num.length; i++) {
            if(num[i] == 11) {
                System.out.println("i is found.");
                break;
            } else {
                System.out.println("i is currently at: " + num[i]);
            }
        }
    }
}
