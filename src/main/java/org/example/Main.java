package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       System.out.print("Enter the number of items in the list: ");
       int n = in.nextInt();
       MyList<Integer> list = new MyList<>();
       System.out.println("Enter the values you want to add to the list: ");
       for (int i = 0; i < n; i++) {
           int temp = in.nextInt();
           list.add(temp);
       }
       System.out.println("Your list: ");
       list.print();
       System.out.println("Enter the index you want to remove from the list: ");
       int k = in.nextInt();
       System.out.println("This is an element with a value of " + list.get(k));
       list.remove(k);
       System.out.println("Your list after removing an element with an index " + k + ": ");
       list.print();
       System.out.println("The size of your list after removing an element with an index " + k + " is " + list.getSize());
    }
}