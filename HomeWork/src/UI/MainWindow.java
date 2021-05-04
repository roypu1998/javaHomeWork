package UI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Location.*;
import Location.Point;
import Population.*;
import Simulation.Clock;
import Simulation.Main;
import Virus.IVirus;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Country.Map;
import Country.RamzorColor;
import Country.Settlement;
import IO.SimulationFile;
import Location.*;

public class MainWindow {

	private JFrame root;
	
	private JPanel  SliderPanel, RootPanel;
	
	private JPanel middlePanel;
	
	private MutationWindow mw;
	
	private JScrollBar sp;
	
	private PaintMap map;
	
	private JOptionPane option;
	
	private JSplitPane split;
	
	private JSlider slider;
	
	private JMenuBar MenuBar; 
	
	private JMenu File, Simulation, Help;
	
	private JMenuItem load, statistics, editM, exit, play, pause, stop, help, stpd, about;
	
	private List<Location> location;
		
	private String s;
	
	private JFileChooser chooser;
	
	private Map mapSett;
		
	private JDialog dialog;
	
	private MainWindow mainWindow;
	
	private Main m;
	
	private StatisticsWindow sw;
	
	public MainWindow (Map mapSett,Main m) {
		mainWindow=this;
		this.m=m;
		this.chooser= new JFileChooser("C:\\Users\\reina\\OneDrive\\Desktop\\HomeWork2021\\javaFiles");
		this.mapSett=mapSett;
		mw= new MutationWindow(mapSett);
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
		if (Main.num>0)
			this.RootPanel.add(this.map);
		else
			this.RootPanel.add(new JLabel ("load a new map to get started! "), "Center");
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
		action();
	}


	public void setPaintMap(List <Settlement> settlement){
		this.map= new PaintMap(settlement);
		
		this.map.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int x=e.getX();
				int y=e.getY();
				for (int i=0; i<settlement.size(); i++) {
					int lx=settlement.get(i).getLocation().getPosition().getX();
					int ly=settlement.get(i).getLocation().getPosition().getY();
					int lw=settlement.get(i).getLocation().getSize().getWidth();
					int lh=settlement.get(i).getLocation().getSize().getHeight();
					if (x>=lx && x<=lx+lw && y>=ly &&y<=ly+lh ) {
						
						sw= new StatisticsWindow(settlement.get(i).getLocation().getPosition(),mapSett,mainWindow,m);
						
						sw.getStatisticWindow().getContentPane().add(sw.getHigh(),"North");
						
						sw.getStatisticWindow().getContentPane().add(sw.getMiddle(),"Center");
						
						sw.getStatisticWindow().getContentPane().add(sw.getLow(),"South");

						sw.setfilterText(sw.getName());
						
						sw.getStatisticWindow().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
						sw.getStatisticWindow().setSize(700,550);
						sw.getStatisticWindow().setVisible(true);
					}
				}
			}
		});
	}
	
	public void action() {
		this.editM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mw.setVisible(true);

			}
		});

		this.stpd.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent e) {
			dialog= new JDialog(new JFrame("ticks per day"), "tick amount");
			dialog.setLayout(new GridLayout(2,1));
			JSpinner spinner= new JSpinner();
			JButton tickB= new JButton("ok");
			dialog.add(spinner);
			dialog.add(tickB);
			Clock clock= new Clock();
			tickB.addActionListener(new ActionListener()
			{public void actionPerformed(ActionEvent e)
		     {
				clock.setTicksPerDay((int)spinner.getValue());
				dialog.dispose();
		     }
			});
			dialog.setSize(150, 150);
	        dialog.setVisible(true);
		}
		});
		

		this.stop.addActionListener(new ActionListener()
		{public void actionPerformed(ActionEvent e) {
			Main.num=0;
			root.dispose();
			Main.OpenFrame(mapSett);

		}
		});
		
		this.load.addActionListener(new ActionListener()
				{public void actionPerformed(ActionEvent e) {
				chooser.showOpenDialog(new JFrame("Choose Map"));
				File file= chooser.getSelectedFile();
				String nameFile= file.getPath();
				root.dispose();
				Main main = new Main();
				SimulationFile sf= new SimulationFile(nameFile,mapSett);
				mapSett=main.newMapLoad(sf);
				main.OpenFrame(mapSett);
				}
				});
		
		
		this.exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		this.help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon = new ImageIcon("helpCenterPic.jpeg");
				option.showMessageDialog(root,
					    "To load a new map click on 'file-load' and choose your file\n"
					    +"To get a table with the information about your locations click on 'file-statistics'"
					    +"\nTo edit mutation click on 'file-editMutation"
					    +"\nTo exit click on 'file-exit"+
					    "\nTo get information about the programmers click on 'Help-About\n"
					    + "To pause the simulation click on 'simulation-pause\n"
					    + "To restart the simulation click on'simulation-play'\n"
					    + "To Stop the simulation click on'simulation-stop'\n"
					    + "To set ticks of click click on 'simulation-set ticks per day'\n"
					    + "To add a sick person to a specific settlement click on the settlement- add sick\n"
					    + "To save the current state of the settlements click on 'file-statistics-save'\n"
					    + "To add a number of vacines to a settlement click on 'file-statistics-choose a settlement-vaccinate",
					    "Help center",
					    JOptionPane.INFORMATION_MESSAGE,icon);
				
       
				
			}
		});
		
		this.about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option.showMessageDialog(root,
					    "Names: Erelle Boubli and Roi Putterman\nID: 324460443 and 314919010"
					    + "\nDate: 29/04/2021",
					    "About",
					    JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		
		this.play.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				newSimulation();
			}

		});
		
		this.pause.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
			}

		});
		
		this.statistics.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				StatisticsWindow sw= new StatisticsWindow(new Point(0,0),mapSett,mainWindow,m);
				
				sw.getStatisticWindow().getContentPane().add(sw.getHigh(),"North");
				
				sw.getStatisticWindow().getContentPane().add(sw.getMiddle(),"Center");
				
				sw.getStatisticWindow().getContentPane().add(sw.getLow(),"South");

				sw.setfilterText(sw.getName());

				
				sw.getStatisticWindow().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				sw.getStatisticWindow().setSize(700,550);
				sw.getStatisticWindow().setVisible(true);
			}
		});
		
	}
	
	public void newSimulation() {
		int numSick,randNum, randVirus,sizeSick,numMove, numPpl;
		Random rand= new Random();
		Person p1,p2;
		Clock c=new Clock();
		boolean flag;
		List <IVirus> viruses= new ArrayList<>();

		for (Settlement s: mapSett.getSettlements()) {
			numSick=(int) Math.ceil(s.getSickPpl().size()*0.2);
			if(s.getSickPpl().size()!=0) {
				randNum= rand.nextInt(s.getSickPpl().size());
				for (int i=0; i<numSick;i++) {
					for (int j=0; j<3; j++) {
						p1=s.getSickPpl().get(randNum);
						p2=s.getNotSickPpl().get(j);
						flag=s.getSickPpl().get(randNum).getVirus().tryToContagion(p1, p2);
						if(flag) {
							viruses=mw.mutationVirus(s.getSickPpl().get(randNum).getVirus());
							randVirus=rand.nextInt(viruses.size());
							p2.contagion(viruses.get(randVirus));
						}
					}
				}
			}
		}
		for (Settlement s: mapSett.getSettlements()) {
			sizeSick=s.getPeople().size();
			for(int i=0; i<sizeSick; i++) {
				if(s.getPeople().get(i) instanceof Sick) {
					if(c.calcTime(((Sick) s.getPeople().get(i)).getContagiousTime())>=2) {
						((Sick) s.getPeople().get(i)).recover();
					}
				}
			}
		}

		for (Settlement s: mapSett.getSettlements()) {
			numMove=(int) Math.ceil(s.getPeople().size()*0.03);
			numPpl=s.getPeople().size();
			for (int i=0; i<numMove; i++) {
				flag=s.transferPerson(s.getPeople().get(rand.nextInt(numPpl)), s.RandConnectedArea());
				if (flag) {
					numPpl--;
				}

			}
			
		}

		for (Settlement s: mapSett.getSettlements()) {
			for(int i=0; i<s.getNotSickPpl().size();i++) {
				if(s.getNotSickPpl().get(i) instanceof Healthy && s.getVacineNum()>0) {
					Person p=(((Healthy) s.getNotSickPpl().get(i)).vaccinate());
					s.setVacineNum(-1);
			}
			}
			
		}
		sw=new StatisticsWindow(new Point(0,0), mapSett, mainWindow,m);
		sw.colorChange();
		Clock.nextTick();
		try {
			Thread.sleep(this.slider.getValue());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
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