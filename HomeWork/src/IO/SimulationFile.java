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
	        City city;
	        Kibbutz kibbutz;
	        Moshav moshav;
	  
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
	        	
	        	
	        	if(type.equals("City")) {
	        		city=new City();
	        		city.setName(strName);
	        		city.setLocation(l);
	        		city.setRamzorColor(RamzorColor.Green);
	        		this.sett.updateSettelments(city, index);
	        		System.out.println("Successed !");
	        		index++;
	        		
	        	}
	        	
	        	else if( type.equals("Moshav")) {
	        		moshav=new Moshav();
	        		moshav.setName(strName);
	        		moshav.setLocation(l);
	        		moshav.setRamzorColor(RamzorColor.Green);
	        		this.sett.updateSettelments(moshav, index);
	        		System.out.println("Successed !");
	        		index++;
	        	}
	        			
	        	else if (type.equals("Kibbutz")) {
	        		kibbutz=new Kibbutz();
	        		kibbutz.setName(strName);
	        		kibbutz.setLocation(l);
	        		kibbutz.setRamzorColor(RamzorColor.Green);
	        		this.sett.updateSettelments(kibbutz, index);
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
