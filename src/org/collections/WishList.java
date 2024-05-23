package org.collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class WishList {
    public static void main(String[] args) {


        File file = new File("./src/Resources/File.txt");
        ArrayList<String> wishlist = new ArrayList<>();

        /*leggo il file e aggiungo i dati apresenti alla wish list*/
        readFile(wishlist,file);

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while(!exit){
            System.out.print("Inserici il regalo: ");
            String gift=scanner.nextLine();
            wishlist.add(gift);

            System.out.println("Attualmente hai inserito: "+wishlist.size()+" regali");

            System.out.println("vuoi inserire un altro regalo? :premi y se si altrimenti premi qualsiasi altro tasto");
            String choice=scanner.nextLine();
            if(!choice.equals("y")){
                exit = true;
            }

        }

        Collections.sort(wishlist);

        /*mostro a vido gli elementi del arraylist */
        System.out.println("Ecco la tua lista desideri; ");

        /*svuotamento del file*/
        emptyFile(file);

        for (String element : wishlist) {
            System.out.println(element);

            /*scrittura del file*/
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                fileWriter.write(element);
                fileWriter.write(System.lineSeparator());
                fileWriter.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        scanner.close();

    }

    /*metodo che legge il file*/
    public static void  readFile(ArrayList wishlist, File file){
        if (file.exists()){
            try{
                Scanner scanner = new Scanner(file);
                while(scanner.hasNextLine()){
                    String line= scanner.nextLine();
                    wishlist.add(line);

                }
                scanner.close();
            }catch(FileNotFoundException e){
            }
        }
    }

    //metodo che svuota il file prima del compilamento
    public static void emptyFile(File file){
        try  {
            FileWriter fileempty = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
