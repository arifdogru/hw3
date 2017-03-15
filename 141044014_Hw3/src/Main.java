import java.io.*;
import java.util.*;

/**
 * Created by Arif on 12.03.2017.
 */
public class Main {

    public static void main(String []args) throws IOException {
        File outputFile = new File("result1.txt");
        File outputFile2 = new File("result2.txt");
        File outputFile3 = new File("result3.txt");
        //File inputFile = new File("numbers.txt");
        FileWriter writer;
        writer = new FileWriter(outputFile, false);
        FileWriter writer2;
        writer2 = new FileWriter(outputFile2, false);
        FileWriter writer3;
        writer3 = new FileWriter(outputFile3, false);

        PrintWriter printWriter = new PrintWriter(writer);
        PrintWriter printWriter2 = new PrintWriter(writer2);
        PrintWriter printWriter3 = new PrintWriter(writer3);
        myStringBuilder mystr = new myStringBuilder();

        Scanner scanner = new Scanner(new File("numbers.txt"));

        /*for (int i=1; i < 11000; ++i){
            printWriter.println(i);
        }*/

        while(scanner.hasNextInt()){
            mystr.append(scanner.nextInt());
        }

        long startTime = System.currentTimeMillis();
        long end = System.currentTimeMillis();


        /***
         * bu bolumde 3 farkli tostring methodlarının calisma surelri olculmustur
         */
        System.out.println("--------------> PART1 <------------");
        startTime = System.currentTimeMillis();
        printWriter.println(mystr.toString());
        end = System.currentTimeMillis();
        System.out.print("toString index and get Execution Time --> ");
        System.out.println(end-startTime + " ms");

        startTime = System.currentTimeMillis();
        printWriter2.println(mystr.toStringIterator());
        end = System.currentTimeMillis();
        System.out.print("toString iterator Execution Time -->     ");
        System.out.println(end-startTime + " ms");

        startTime = System.currentTimeMillis();
        printWriter3.println(mystr.toStringOfLinkedList());
        end = System.currentTimeMillis();
        System.out.print("toString of linkedlist Execution Time --> ");
        System.out.println(end-startTime + " ms");

        System.out.println("-------------> PART2 <----------");
        myStringBuilder temp= new myStringBuilder();
        temp.append("a");
        temp.append("r");
        temp.append("i");
        temp.append("f");
        temp.append(1);
        temp.append(7);
        temp.append(0);
        temp.append(5);
        System.out.println("Appended String: "+ temp.toStringIterator());
        System.out.print("Reverse String: ");
        temp.reverseToStringRecursive();
        System.out.println();

        System.out.println("-----------------> PART4 <--------------");
        SingleLLWithDeletedNode<Integer> dltList = new SingleLLWithDeletedNode<Integer>();

        for (int i=1; i<=100; ++i){
            dltList.add(i);
        }
        System.out.println("100 sayı eklendi:");
        for (int i=0; i < dltList.getSize(); ++i)
            System.out.print(dltList.get(i).toString()+",");
        System.out.println();
        for (int i=1; i<=50; ++i){
            dltList.removeFirst();
        }
        System.out.println("50 sayı silindi:");
        for (int i=0; i < dltList.getSize(); ++i)
            System.out.print(dltList.get(i).toString()+",");
        System.out.println();
        for (int i=100; i<=200; ++i){
            dltList.add(i);
        }
        System.out.println("100 sayı daha eklendi:");
        for (int i=0; i < dltList.getSize(); ++i)
            System.out.print(dltList.get(i).toString()+",");
    }



}
