package com.filePro;
import java.io.File;
import java.io.IOException;

public class FileCre {
	public static void main(String[] args) {
		String zz="hhh";
		System.out.println("Start");	
		File f=new File("rou.txt");
		try {
			f.createNewFile();
			System.out.println("File Created");
		//	return "hi";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End");
	}
}
