package org.collections;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> wishlist = new ArrayList<>();

        boolean exit = false;

        while(!exit){
            System.out.println("vuoi inserire un regalo? :premi y se si altrimenti premi qualsiasi altro tasto");
            String choice=scanner.nextLine();
            if(choice.equals("y")){
                System.out.println("Inserici il regalo: ");
                String gift=scanner.nextLine();
                wishlist.add(gift);

                System.out.println("Attualmente hai inserito: "+wishlist.size()+" regali");
            }else{
                exit = true;
            }
        }

        Collections.sort(wishlist);

        /*mostro a vido gli elementi del arraylist */
        System.out.println("Ecco la tua lista desideri; ");
        for (String element : wishlist) {
            System.out.println(element);
        }

        scanner.close();
    }
}
