package dev.xtremeshooter.handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
	public static int highScore, currentScore;
	String st,n,p;
	public int readFile(){
		File file = new File("res/textures/score.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader(new java.io.FileReader(file));
        } catch (FileNotFoundException ex) {

        }
        try {
           
            while ((st = br.readLine()) != null) {
                String[] t = st.split(" ");
                n = t[0];
                p = t[1];
               
            }
        } catch (IOException ex) {
            
        }
		int x=Integer.parseInt(p);
		return x;
	}
	
	public  void write(int current) {
		String ss="null "+current;
        BufferedWriter output = null;
        try {
            File file = new File("res/textures/score.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(ss);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
          if ( output != null ) {
            try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
          }
       }
	}
	
}
