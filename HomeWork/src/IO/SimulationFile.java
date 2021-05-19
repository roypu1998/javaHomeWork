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
	
	Random rand=new Random();
	
	private String nameFile;
	
	public SimulationFile(String nameFile,Map sett) {
		
		this.nameFile=nameFile;
		this.sett= sett;
	}

	public void ReadFile() {
		Random ran= new Random();
		
		try {
	        BufferedReader inFile = new BufferedReader(new FileReader(this.nameFile));
	        
	        String str;
	        City city;
	        Kibbutz kibbutz;
	        Moshav moshav;
	  
	        int index=0,lines=0;
	        
	        while (inFile.readLine() != null &&(str = inFile.readLine())!="#" ) { 
	        	lines++;  	
	        }
	        
	        
	        BufferedReader inFile2 = new BufferedReader(new FileReader(this.nameFile));
	        
	        BufferedReader inFile3 = new BufferedReader(new FileReader(this.nameFile));
	        
	        sett=new Map();
	        
	        this.sett.setSize(lines-1);
	        
	        int size1=0, size2=0;
	        
	        while (inFile3.readLine() != null)
	        	size1++;
	        
	        size2=size1-lines;
	        
	        while ((str = inFile2.readLine())!=null ){
	        	Point p;
	        	Size size;
	        	int age;
	        	Location l;
	        	String [] s=str.split(";");
	        	String type,strName,set1,set2;
	        	type=s[0];
	        	if (!(type.equals("#"))) {
	        		p=new Point(Integer.parseInt(s[2]),Integer.parseInt(s[3]));
		        	size=new Size(Integer.parseInt(s[4]),Integer.parseInt(s[5]));
		        	l=new Location(p,size);
		        	strName=s[1];
		        	Person ppl;
		        	Point randPoint;
		        	int numberOfPeople=Integer.parseInt(s[6]);
		        	Settlement set;
		        	if(type.equals("City")) {
		        		city=new City(strName,l,RamzorColor.Green);
		        		this.getSett().updateSettelments(city, index);
		        		for (int i=0; i<numberOfPeople;i++) {
		        			age=Math.abs(5*(int)(6*ran.nextGaussian()+ 9)+rand.nextInt(5));
		        			randPoint= new Point(city.randomLocation().getX(),city.randomLocation().getY());
		        			set=this.getSett().getSettlements()[index];
		        			ppl=new Healthy(age, randPoint,set);
			        		set.addPerson(ppl);
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
			        		set.addPerson(ppl);
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
			        		set.addPerson(ppl);
		        		}
		        		index++;
	
		        		}
	        	}
	        	
		        else {
		        		
		        		set1=s[1];
		        		set2=s[2];
		        		for (Settlement x: sett.getSettlements()) {
		        			if (x.getName().equals(set1)) {
		        				for (Settlement y: sett.getSettlements()) {
		        					if (y.getName().equals(set2)) {
		        						x.addConnectedAreas(y);
		        						y.addConnectedAreas(x);
		        					}
		        				}
		        			}
		        		}

		        		
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
