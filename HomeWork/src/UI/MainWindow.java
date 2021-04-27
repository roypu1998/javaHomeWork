package UI;

import java.util.ArrayList;
import java.util.List;

import Location.*;
import Population.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import Location.*;

public class MainWindow {

	private JFrame root;
	
	private JPanel  SliderPanel, RootPanel;
	
	private JPanel middlePanel;
	
	private JScrollBar sp;
	
	private PaintMap map;
	
	private JSplitPane split;
	
	private JSlider slider;
	
	private JMenuBar MenuBar; 
	
	private JMenu File, Simulation, Help;
	
	private JMenuItem load, statistics, editM, exit, play, pause, stop, help, stpd, about;
	
	private List<Location> location;
	
	private String s;
	
	public MainWindow () {
		
		this.root= new JFrame("Main Window");
		this.RootPanel=new JPanel();
		this.MenuBar= new JMenuBar();
		this.slider= new JSlider();
		this.middlePanel= new JPanel();
		this.SliderPanel= new JPanel();
		this.about= new JMenuItem("About");
		this.editM= new JMenuItem("Edit Mutation");
		this.exit= new JMenuItem("Exit");
		this.File= new JMenu("File");
		this.Help= new JMenu("Help");
		this.help= new JMenuItem("Help");
		this.load= new JMenuItem("Load");
		this.sp= new JScrollBar();
		this.Simulation= new JMenu("Simulation");
		this.statistics= new JMenuItem("Statistics");
		this.stop= new JMenuItem("Stop");
		this.stpd= new JMenuItem("Set Ticks Per Day");
		this.pause= new JMenuItem("Pause");
		this.play= new JMenuItem("Play");
		
	}
	
	
	public void BuildFrame() {
		this.RootPanel.setLayout(new BoxLayout(this.RootPanel,BoxLayout.Y_AXIS));
		this.File.add(this.load);
		this.File.add(this.statistics);
		this.File.add(this.editM);
		this.File.add(this.exit);
		this.Simulation.add(this.play);
		this.Simulation.add(this.pause);
		this.Simulation.add(this.stop);
		this.Simulation.add(this.stpd);
		this.Help.add(this.help);
		this.Help.add(this.about);
		this.MenuBar.add(this.File);
		this.MenuBar.add(this.Simulation);
		this.MenuBar.add(this.Help);
		this.RootPanel.add(this.map);
		Dimension d = this.slider.getPreferredSize();
		this.slider.setPreferredSize(new Dimension(d.width+450,d.height+30));
		this.SliderPanel.setBackground(Color.white);
		slider.setValue(50);
        slider.setMaximum(100);
        slider.setMinorTickSpacing(5);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
		this.SliderPanel.add(this.slider, "South");		
	}

	public void setPaintMap(List <Location> l, List <String> n){
		this.map= new PaintMap(l,n);
		this.map.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				System.out.println("hi");
			}
		});

	}
	
	public PaintMap getMap() {
		return this.map;
	}

	
	public JFrame getRoot() {
		return root;
	}

	public void setRoot(JFrame root) {
		this.root = root;
	}



	public JPanel getSliderPanel() {
		return SliderPanel;
	}

	public void setSliderPanel(JPanel sliderPanel) {
		SliderPanel = sliderPanel;
	}

	public JPanel getRootPanel() {
		return RootPanel;
	}

	public void setRootPanel(JPanel rootPanel) {
		RootPanel = rootPanel;
	}

	public JSlider getSlider() {
		return slider;
	}

	public void setSlider(JSlider slider) {
		this.slider = slider;
	}

	public JMenuBar getMenuBar() {
		return MenuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		MenuBar = menuBar;
	}

	public JMenu getFile() {
		return File;
	}

	public void setFile(JMenu file) {
		File = file;
	}

	public JMenu getSimulation() {
		return Simulation;
	}

	public void setSimulation(JMenu simulation) {
		Simulation = simulation;
	}

	public JMenu getHelp() {
		return Help;
	}

	public void setHelp(JMenu help) {
		Help = help;
	}

	public JMenuItem getLoad() {
		return load;
	}

	public void setLoad(JMenuItem load) {
		this.load = load;
	}

	public JMenuItem getStatistics() {
		return statistics;
	}

	public void setStatistics(JMenuItem statistics) {
		this.statistics = statistics;
	}

	public JMenuItem getEditM() {
		return editM;
	}

	public void setEditM(JMenuItem editM) {
		this.editM = editM;
	}

	public JMenuItem getExit() {
		return exit;
	}

	public void setExit(JMenuItem exit) {
		this.exit = exit;
	}

	public JMenuItem getPlay() {
		return play;
	}

	public void setPlay(JMenuItem play) {
		this.play = play;
	}

	public JMenuItem getPause() {
		return pause;
	}

	public void setPause(JMenuItem pause) {
		this.pause = pause;
	}

	public JMenuItem getStop() {
		return stop;
	}

	public void setStop(JMenuItem stop) {
		this.stop = stop;
	}

	public JMenuItem gethelp() {
		return help;
	}

	public void sethelp(JMenuItem help) {
		this.help = help;
	}

	public JMenuItem getStpd() {
		return stpd;
	}

	public void setStpd(JMenuItem stpd) {
		this.stpd = stpd;
	}

	public JMenuItem getAbout() {
		return about;
	}

	public void setAbout(JMenuItem about) {
		this.about = about;
	}


}