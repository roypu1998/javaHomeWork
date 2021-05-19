 /*
  * Names : Roi Putterman && Erelle Boubli ;
  * ID's : 314919010 && 324460443 ;
  */

package Simulation;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenuBar;

import Country.*;
import IO.SimulationFile;
import Population.*;
import UI.MainWindow;
import Virus.*;
import Location.*;
public class Main{
	public static Main m;
	public Main() {
		m=this;
	}
	public static int num=0;
	
	public static void OpenFrame(Map mapSett) {
		MainWindow mw= new MainWindow(mapSett,m);
		JFrame frame=new JFrame();
		frame= mw.getRoot();
		List<Settlement> settlement= new ArrayList<>();
		for(int i=0; i<mapSett.Size();i++) {
			settlement.add(mapSett.getSettlements()[i]);
		}
		mw.setPaintMap(settlement);
		mw.BuildFrame();
		JMenuBar menuBar = new JMenuBar();
		menuBar=mw.getMenuBar();
		menuBar.setPreferredSize(new Dimension(120,40));
		frame.setJMenuBar(menuBar);
		frame.add(mw.getRootPanel());
		frame.getContentPane().add(mw.getSliderPanel(),"South");
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(700,550);
		frame.setVisible(true);
		
	}
	
	public static void OpenFrame1(Map mapSett) {
		MainWindow mw= new MainWindow(mapSett,m);
		JFrame frame=new JFrame();
		frame= mw.getRoot();
		mw.BuildFrame();
		num++;
		JMenuBar menuBar = new JMenuBar();
		menuBar=mw.getMenuBar();
		menuBar.setPreferredSize(new Dimension(120,40));
		frame.setJMenuBar(menuBar);
		frame.add(mw.getRootPanel());
		frame.getContentPane().add(mw.getSliderPanel(),"South");
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(700,550);
		frame.setVisible(true);
		
	}
	public static Map makePplSickMain(Map mapSett, double percentage) {
		
		int numOfPpl, sickPpl;
		
		Sick sc;
		
		Random rand= new Random();
		
		for (int i=0; i<mapSett.Size();i++) {
			
			numOfPpl=mapSett.getSettlements()[i].getPeople().size();
			
			sickPpl=(int) Math.ceil((double)(numOfPpl*percentage));
						
			for (int j=0; j<sickPpl;j++) {
				
					Person p=mapSett.getSettlements()[i].getNotSickPpl().get(j);
				
					sc= new Sick(p.getAge(),p.getLocation(),p.getSettlement(),Clock.now(),
						mapSett.getSettlements()[i].getRandVirus());
				
					mapSett.getSettlements()[i].getNotSickPpl().remove(p);
					mapSett.getSettlements()[i].getPeople().remove(p);
					mapSett.getSettlements()[i].getPeople().add(sc);
					mapSett.getSettlements()[i].getSickPpl().add(sc);
				}
					
				
		}
		return mapSett;
		
	}
	
	
	public static Map newMapLoad(SimulationFile sf) {
		
		sf.ReadFile();
		
		Map mapSett= sf.getSett();	
		
		mapSett=makePplSickMain(mapSett,0.01);
		
		return mapSett;
		
	}
	
	
	public static void main(String args[]) {
		
		/*
		 * Map mapSett = new Map();
		 * 
		 * SimulationFile simulationfile=new
		 * SimulationFile("src/homework_IO.txt",mapSett);
		 * 
		 * mapSett= newMapLoad(simulationfile);
		 * 
		 * Random rand= new Random();
		 * 
		 * OpenFrame(mapSett);
		 */
	
		OpenFrame1(null);
	}


}
