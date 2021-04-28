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
public class Main {
	
	public static void main(String args[]) {
	
		SimulationFile simulationfile=new SimulationFile();
		
		simulationfile.ReadFile();
		
		IVirus africanVirus=new SouthAfricanVariant();
		
		Map mapSett= simulationfile.getSett();
		
		int numOfPpl, sickPpl;
		
		Sick sc;
		
		for (int i=0; i<mapSett.Size();i++) {
			
			numOfPpl=mapSett.getSettlements()[i].getPeople().size();
			
			sickPpl=(int) (numOfPpl*0.01);
			
			for (int j=0; j<mapSett.getSettlements()[i].getPeople().size();j+=9) {
				
				Person p=mapSett.getSettlements()[i].getPeople().get(j);
				
				sc= new Sick(p.getAge(),p.getLocation(),p.getSettlement(),Clock.now(),
						africanVirus);
				
				mapSett.getSettlements()[i].getNotSickPpl().remove(p);
				
				mapSett.getSettlements()[i].getSickPpl().add(sc);
			}
		}
		Random rand= new Random();
		
		
		
		
		//int numOfIterations =0;
		
		/*
		 * while (numOfIterations<5) {
		 * 
		 * boolean succes;
		 * 
		 * Person p1, p2;
		 * 
		 * for (int i=0; i<sett.length;i++) {
		 * 
		 * for (int j=0; j<sett[i].getPeople().size();j++) {
		 * 
		 * if(sett[i].getPeople().get(j) instanceof Sick) {
		 * 
		 * p1=sett[i].getPeople().get(j);
		 * 
		 * for (int h=0; h<6;h++) {
		 * 
		 * p2=sett[i].getPeople().get(rand.nextInt(sett[i].getPeople().size()));
		 * succes=africanVirus.tryToContagion(p1, p2); if (succes ==true) { sc=new
		 * Sick(p2.getAge(),p2.getLocation(),p2.getSettlement(),Clock.now(),
		 * africanVirus); sett[i].getPeople().remove(p2); sett[i].addPerson(sc); }
		 * 
		 * } } } } }
		 * 
		 * numOfIterations++;
		 */
	

	MainWindow mw= new MainWindow(mapSett);
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
	
	
	
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(700,550);
	frame.setVisible(true);
	
	
	
	
	
	
	
	
	
	}

}
