package IO;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner; // Import the Scanner class to read text files

import Country.*;
import Location.*;

public class SimulationFile {

	private Map sett;
	
	public void ReadFile() {
		
		try {
	        BufferedReader inFile = new BufferedReader(new FileReader("src/homework_IO.txt"));
	       
	        this.sett=new Map();
	        
	        String str;
	        City c=new City();
	        Kibbutz k=new Kibbutz();
	        Moshav m=new Moshav();
	  
	        int index=0,lines=0;
	        
	        while (inFile.readLine() != null) { 
	        	lines++;  	
	        }
	        
	       
	        BufferedReader inFile2 = new BufferedReader(new FileReader("src/homework_IO.txt"));
	        
	        this.sett.setSize(lines);
	        
	        while ((str = inFile2.readLine())!=null ){
	        	
	        	String [] s=str.split(";");
	        	
	        	String type,strName;
	        	Point p=new Point();
	        	Size size=new Size();
	        	Location l=new Location();
	        	
	        	type=s[0];
	        	
	        	strName=s[1];
	        	
	        	p.setX(Integer.parseInt(s[2]));
	        	p.setY(Integer.parseInt(s[3]));
	        	l.setPosition(p);
	        	
	        	size.setWidth(Integer.parseInt(s[4]));
	        	size.setHeight(Integer.parseInt(s[5]));
	        	l.setSize(size);
	        	
	        	
	        	if(type == "City") {
	        		c.setName(strName);
	        		c.setLocation(l);
	        		c.setRamzorColor(RamzorColor.Green);
	        		this.sett.updateSettelments(c, index);
	        		System.out.println("Successed !");
	        		index++;
	        		
	        	}
	        	
	        	else if( type == "Moshav") {
	        		m.setName(strName);
	        		m.setLocation(l);
	        		m.setRamzorColor(RamzorColor.Green);
	        		this.sett.updateSettelments(m, index);
	        		System.out.println("Successed !");
	        		index++;
	        	}
	        			
	        	else if (type == "Kibbutz") {
	        		k.setName(strName);
	        		k.setLocation(l);
	        		k.setRamzorColor(RamzorColor.Green);
	        		this.sett.updateSettelments(k, index);
	        		System.out.println("Successed !");
	        		index++;

	        		}
	        		
	        	
	        	}

	        inFile.close();
	        inFile2.close();

	    
	    } catch (IOException e) {
	    	System.out.println("Error: "+ e);
	    }
	}
	
	public Map getSett() {
		return this.sett;
	}


}
