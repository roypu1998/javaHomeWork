package IO;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Random;
import java.util.Scanner; // Import the Scanner class to read text files
import Country.*;
import Location.*;
import Population.*;
public class SimulationFile {

	private Map sett;


	public void ReadFile() {
		Random ran= new Random();
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
	        	Point p=new Point(Integer.parseInt(s[2]),Integer.parseInt(s[3]));
	        	Size size=new Size(Integer.parseInt(s[4]),Integer.parseInt(s[5]));
	        	Location l=new Location(p,size);
	        	type=s[0];
	        	strName=s[1];
	        	int age;
	        	Person ppl;
	        	Point randPoint;
	        	int numberOfPeople=Integer.parseInt(s[6]);
	        	Settlement set;
	        	if(type.equals("City")) {
	        		city=new City(strName,l,RamzorColor.Green);
	        		this.getSett().updateSettelments(city, index);
	        		for (int i=0; i<numberOfPeople;i++) {
	        			age=(int) (6*ran.nextGaussian()+ 9);
	        			randPoint= new Point(city.randomLocation().getX(),city.randomLocation().getY());
	        			set=this.getSett().getSettlements()[index];
	        			ppl=new Healthy(age, randPoint,set);
		        		this.getSett().getSettlements()[index].addPerson(ppl);
	        		}
	    	        index++;
	        		
	        	}
	        	
	        	else if( type.equals("Moshav")) {
	        		moshav=new Moshav(strName,l,RamzorColor.Green);
	        		this.sett.updateSettelments(moshav, index);
	        		for (int i=0; i<numberOfPeople;i++) {
	        			age=(int) (6*ran.nextGaussian()+ 9);
	        			randPoint= new Point(moshav.randomLocation().getX(),moshav.randomLocation().getY());
	        			set=this.getSett().getSettlements()[index];
	        			ppl=new Healthy(age, randPoint,set);
		        		this.getSett().getSettlements()[index].addPerson(ppl);
	        		}
	        		index++;
	        	}
	        			
	        	else if (type.equals("Kibbutz")) {
	        		kibbutz=new Kibbutz(strName,l,RamzorColor.Green);
	        		this.sett.updateSettelments(kibbutz, index);
	        		for (int i=0; i<numberOfPeople;i++) {
	        			age=(int) (6*ran.nextGaussian()+ 9);
	        			randPoint= new Point(kibbutz.randomLocation().getX(),kibbutz.randomLocation().getY());
	        			set=this.getSett().getSettlements()[index];
	        			ppl=new Healthy(age, randPoint,set);
		        		this.getSett().getSettlements()[index].addPerson(ppl);
	        		}
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
