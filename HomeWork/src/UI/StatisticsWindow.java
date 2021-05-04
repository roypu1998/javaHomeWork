package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import Country.*;
import IO.StatisticFile;
import Location.Point;
import Population.Person;
import Population.Sick;
import Simulation.Clock;
import Simulation.Main;

public class StatisticsWindow {

	public static int change=0;
	
	private JFrame statisticWindow;
	
	private DefaultTableModel tableModel;
	
	private JPanel high, middle, low;
	
	private JButton save, addSick ,Vaccinate, ok;
	
	private Map mapSett;
	
	private JLabel label;
	
	private JFileChooser fileChoose;
	
	private String [] names =new String[] {"Settlement Name", "Type", "Color", "Sick Precentage",
			"Number Of Vaccinated","Number Of Death", "Residents"};
	
	private JTextField filterText;

	private String name;
	
	private JComboBox col;
	 
	private CreateModel model;
	
	private JTable table, tempTable;
	
	private Point p;
	
	private MainWindow mw;

	private Main m;
	
	public StatisticsWindow(Point p,Map map,MainWindow mw,Main m)	{
		this.m=m;
		
		this.mw= mw;
		
		this.addSick= new JButton("Add Sick");
		
		this.save= new JButton("Save");
		
		this.Vaccinate= new JButton("Vaccinate");
		
		this.label= new JLabel("filter: ");
		
		this.filterText= new JTextField();
				
		this.high= new JPanel();
		
		this.low= new JPanel();
		
		this.middle= new JPanel();
		
		this.ok= new JButton("Ok");
		
		this.mapSett=map;
						
		this.col= new JComboBox(this.names);
		
		this.statisticWindow= new JFrame("Statistics Window");
		
		this.p=p;
		
		this.ok.setBorder(new EmptyBorder(10,30,10,30));
		
		this.name=this.getName();
		
		createTable();
						
		this.col.setPreferredSize(new Dimension(200,30));
		
		this.label.setFont(new Font(label.getFont().getName(),Font.PLAIN,20));
		
		this.label.setBorder(new EmptyBorder(0,60,0,10));
		
		this.high.setLayout(new BoxLayout(this.high,BoxLayout.X_AXIS));
		
		this.high.setBorder(new EmptyBorder(0,20,0,10));
		
		this.high.add(this.col);
		
		this.high.add(this.label);
		
		this.high.add(this.filterText);
		
		this.high.add(this.ok);
		
		this.middle.setLayout(new BoxLayout(this.middle,BoxLayout.Y_AXIS));
		
		this.middle.setBorder(new EmptyBorder(100,0,20,0));
		
		this.addSick.setBorder(new EmptyBorder(20,50,20,50));
		
		this.save.setBorder(new EmptyBorder(20,50,20,50));
		
		this.Vaccinate.setBorder(new EmptyBorder(20,50,20,50));
		
		this.low.setLayout(new GridLayout(0,3));
		
		this.low.add(this.save);
		
		this.low.add(this.addSick);
		
		this.low.add(this.Vaccinate);
		
		String word=this.filterText.getText();
		
		this.getAction(word);
		
		CreateModel cm= new CreateModel(this.mapSett);

	}
	
	public void makePplSick(Settlement sett, int numOfSick) {

		int randNum,numOfPpl= sett.getNotSickPpl().size();
		Sick sc;
		int x=numOfPpl;
		for (int i=0; i<numOfSick;i++) {
			Random rand= new Random();
			randNum=rand.nextInt(x);
			Person p= sett.getNotSickPpl().get(randNum);
			sc= new Sick(p.getAge(),p.getLocation(),p.getSettlement(),Clock.now(),
					sett.getRandVirus());
			sett.getNotSickPpl().remove(p);
			sett.getPeople().remove(p);
			sett.addPerson(sc);
			x--;
		}
		
	}
	
	public void recreateTable() {
		this.setMapSett(mapSett);
		this.getStatisticWindow().getContentPane().add(this.getHigh(),"North");
		
		this.getStatisticWindow().getContentPane().add(this.getMiddle(),"Center");
		
		this.getStatisticWindow().getContentPane().add(this.getLow(),"South");

		this.getStatisticWindow().setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.getStatisticWindow().setSize(700,550);
		this.getStatisticWindow().setVisible(true);
	}
	
	public void createTable() {
		
		int row=0;

		model = new CreateModel(mapSett);
		  
		this.table = new JTable(model);
		  
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		table.getSelectionModel().setSelectionInterval(1, 0);
		
		for(int i=0; i<this.table.getRowCount();i++) {
			if(table.getValueAt(i, 0).equals(this.name)) {
				row=i;
			}
		}
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		table.getSelectionModel().setSelectionInterval(0, row);
		
		table.setFillsViewportHeight(true);
		  
		this.middle.add(new JScrollPane(table));

	}
	
	
	
	public void getAction(String word) {
		
		this.save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fileChoose= new JFileChooser();
					fileChoose.showSaveDialog(new JFrame("save"));
					fileChoose.setCurrentDirectory(new java.io.File("."));
					fileChoose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					StatisticFile sf= new StatisticFile();
					sf.exportToCSV(tempTable, fileChoose.getSelectedFile().getAbsolutePath());
			
		}
		});
		
		this.ok.addActionListener(new ActionListener()
		{
			   
			public void actionPerformed(ActionEvent e) {
				int chooseIndex=col.getSelectedIndex();
				filtervalue(word,chooseIndex);
			
			}
		});
		
		this.addSick.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				int sizePpl;
				RamzorColor rc;
				double percent;
				String nameSett=(String) table.getValueAt(table.getSelectedRow(), 0);
				for(Settlement s:mapSett.getSettlements()) {
					if(s.getName().equals(nameSett)) {
						sizePpl=(int) (s.getNotSickPpl().size()*0.1);
						makePplSick(s, sizePpl);
						percent= (double)(s.getSickPpl().size())/s.getPeople().size();
						rc=s.getRamzorColor();
						s.setRamzorColor(s.getRamzorColor().getName(percent));
						if(!rc.equals(s.getRamzorColor())) {
							change++;
						}
						

					}
				}
				recreateTable();
				colorChange();
			}
		});
		
		
		this.Vaccinate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				JButton vac= new JButton("ok");
				JTextField input= new JTextField();
				JLabel lb= new JLabel("  enter number of vaccine to add: ");
				JDialog dialog= new JDialog(new JFrame("vaccine"), "vaccinated amount");
				dialog.setLayout(new GridLayout(3,1));
				dialog.add(lb);
				dialog.add(input);
				
				dialog.add(vac);
				vac.addActionListener(new ActionListener()
				{public void actionPerformed(ActionEvent e)
			     {
					String count= input.getText();
					int numCount= Integer.parseInt(count);
					String nameSett=(String) table.getValueAt(table.getSelectedRow(), 0);
					for(Settlement s:mapSett.getSettlements()) {
						if(s.getName().equals(nameSett)) {
							s.setVacineNum(numCount);
							dialog.dispose();
							recreateTable();

						}
						}
			     }
			
				});
				dialog.setSize(300, 200);
		        dialog.setVisible(true);
				
			}
		});
		
	}
	
	public void colorChange() {
		if(change>0) {
			statisticWindow.dispose();
			mw.getRoot().dispose();
			m.OpenFrame(mapSett);
			change=0;
		}
	}
	
	public void filtervalue(String filterString,int chooseIndex ) {
				
		tableModel = new DefaultTableModel(names, 0);

		this.tempTable = new JTable(tableModel);
		
		TableRowSorter<CreateModel> sorter = null;
		String s;
		this.table.setRowSorter(sorter = new TableRowSorter<CreateModel>(this.model));
		
		try {
			sorter.setRowFilter(RowFilter.regexFilter(this.filterText.getText(),chooseIndex));
			
		} catch (java.util.regex.PatternSyntaxException e) {		
		}
		  for(int row = 0;row < table.getRowCount();row++) {
              Object[] o={this.table.getModel().getValueAt(table.convertRowIndexToModel(row), 0)
            		  ,this.table.getModel().getValueAt(table.convertRowIndexToModel(row), 1)
             		 ,this.table.getModel().getValueAt(table.convertRowIndexToModel(row), 2),
             		 this.table.getModel().getValueAt(table.convertRowIndexToModel(row),3),
             		 this.table.getModel().getValueAt(table.convertRowIndexToModel(row), 4)
             		 ,this.table.getModel().getValueAt(table.convertRowIndexToModel(row), 5),
             		this.table.getModel().getValueAt(table.convertRowIndexToModel(row), 6)};
              tableModel.addRow(o);
          }
		  this.tempTable.setModel(tableModel);
	}
	
	public void setMapSett(Map mapSett) {
		this.mapSett=mapSett;
	}
	public void setfilterText(String n) {
		this.filterText.setText(n);
	}
	
	public JPanel getHigh() {
		return high;
	}


	public void setHigh(JPanel high) {
		this.high = high;
	}


	public JPanel getMiddle() {
		return middle;
	}


	public void setMiddle(JPanel middle) {
		this.middle = middle;
	}


	public JPanel getLow() {
		return low;
	}


	public void setLow(JPanel low) {
		this.low = low;
	}


	public JComboBox getCol() 
	{
		return this.col;
	}
	
	public String getName()
	{
		String name=null;
		int x=p.getX(), y=p.getY();
		for (Settlement loc:this.mapSett.getSettlements()) {
			int lx=loc.getLocation().getPosition().getX();
			int ly=loc.getLocation().getPosition().getY();
			int lw=loc.getLocation().getSize().getWidth();
			int lh=loc.getLocation().getSize().getHeight();
			if (x>=lx && x<=lx+lw && y>=ly &&y<=ly+lh ) 
				name=loc.getName();
		}
		return name;

	}
	public JFrame getStatisticWindow() {
		return statisticWindow;
	}

	public void setStatisticWindow(JFrame statisticWindow) {
		this.statisticWindow = statisticWindow;
	}


	public JTextField getFilterText() {
		return filterText;
	}


	public void setFilterText(JTextField filterText) {
		this.filterText = filterText;
	}
	
	

}
