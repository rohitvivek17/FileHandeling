package com.filePro;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/*** @author VIVEK K */
public class CompleteFileHandelingPro {
    static int size=0;
    public static void main(String[] args) {
        System.out.println("********************************");
        File f=new File("fileReaderDemo.txt"); 
//        fileCreat(f);
//        fileWrit(f);
//        readFileBuff(f);      
        switCase(f);               
    }
public static void switCase(File f){  
        Scanner s=new Scanner(System.in);
        System.out.println("\n___________________");
        System.out.println("Creat File: c\nWriteFile: w\nRead File: r\nFile Info: i\nStop Pro: s");
        System.out.println("**********************************");
        System.out.println("Select The Option:");
        char x=s.next().charAt(0);
        switch (x){
            case 'c':
                fileCreat(f);
                System.out.println("_________________________");
                break;
            case 'w':
                fileWrit(f);
                System.out.println("_________________________");                
                break;
            case 'r':
                readFileBuff(f);
                System.out.println("_________________________");                
                break;
            case 'i':
                info(f);
                System.out.println("_________________________");
                break;
            case 's':
                System.out.println("Program Stopped sucessfully....");   
                System.out.println("_________________________");                
                System.exit(0);
                break;
            case 'd':
                deleteFile(f);
                System.out.println("Program Deleted sucessfully....");   
                break;
            default:
                System.out.println("_________________________");                
                System.out.println("Select Proper Option..");                
        }  
      
}
public static void deleteFile(File f){
    f.delete();
    switCase(f);
}
public static void info(File f){
        //String re=f.exists()?"File Present":"File Unavailable";
      //  System.out.println(size);//doubt....
        System.out.println("Status: "+(f.exists()?"File Present":"File Unavailable"));
        System.out.println("File Name: " +f.getName());
        System.out.println("File Path: " +f.getAbsolutePath());
        switCase(f);
}
public static void easyPath(){  //Not Working
//      System.out.println("Easy Read");
//        List<String> line=Files.readAllLines(Path.get(first, args)"fileReaderDemo.txt");
//        System.out.println(line);
}
public static void readFileBuff(File f){ 
        System.out.println("File Size & Data:");        
        char[] in=new char[50];
        try {
            FileReader fr=new FileReader(f);
            try {
                size=fr.read(in);
                System.out.println("Size: " +size);
                for(char i:in){
                    System.out.print((i==0)?"":i);                                     
                }fr.close();
            } catch (IOException ex) {
                Logger.getLogger(CompleteFileHandelingPro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompleteFileHandelingPro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        switCase(f);
               System.out.println("\n************************");
}
public static void fileWrit(File f){
    Scanner s=new Scanner(System.in);
    System.out.println("Writing File:");
    System.out.println("Type Text To Write:");
    String t=s.nextLine();
     try {
            FileWriter fw;
            fw = new FileWriter(f);
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write(t);
//            bw.append("This is awsome");
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(CompleteFileHandelingPro.class.getName()).log(Level.SEVERE, null, ex);
        }
     System.out.println("File Written");
     switCase(f);
     System.out.println("******************************");
}
public static void fileCreat(File f){
         System.out.println("Creating File:");        
        try {
            f.createNewFile();
            
        } catch (IOException ex) {
            Logger.getLogger(CompleteFileHandelingPro.class.getName()).log(Level.SEVERE, null, ex);
        }        
        System.out.println((f.exists()?"File Created...":"File unavailable..."));
        switCase(f);
        System.out.println("********************************");
    }
}
