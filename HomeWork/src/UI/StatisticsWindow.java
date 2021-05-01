package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;

import Country.*;
import Location.Point;
import Population.Person;
import Population.Sick;
import Simulation.Clock;
import Simulation.Main;

public class StatisticsWindow {


	public JTextField getFilterText() {
		return filterText;
	}


	public void setFilterText(JTextField filterText) {
		this.filterText = filterText;
	}
	
	private JFrame statisticWindow;
	
	private JPanel high, middle, low;
	
	private JButton save, addSick ,Vaccinate, ok;
	
	private Map mapSett;
	
	private JLabel label;
	
	private String [] names =new String[] {"Settlement Name", "Type", "Color", "Sick Precentage",
			"Number Of Vaccinated","Number Of Death", "Residents"};
	
	private JTextField filterText;

	private String name;
	
	private JComboBox col;
	 
	private CreateModel model;
	
	private JTable table;
	
	private Point p;
				
	public StatisticsWindow(Point p,Map map)	{
		
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
		
		createTable();

		this.p=p;
		
		this.ok.setBorder(new EmptyBorder(10,30,10,30));
		
		this.name=this.getName();
		
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
	
	public void makePplSick(Settlement sett, double percentage) {
		
		int num,numOfPpl= sett.getNotSickPpl().size(), sickPpl=(int) Math.ceil (sett.getNotSickPpl().size()*percentage);
		
		Sick sc;
		int x=numOfPpl;
		for (int i=0; i<sickPpl;i++) {
			Random rand= new Random();
			num=rand.nextInt(x);
			Person p= sett.getNotSickPpl().get(num);
			sc= new Sick(p.getAge(),p.getLocation(),p.getSettlement(),Clock.now(),
					sett.getRandVirus());
			
			sett.getNotSickPpl().remove(p);
			sett.getPeople().remove(p);
			sett.getPeople().add(sc);
			x--;
			sett.getSickPpl().add(sc);
			
		}
		
	}
	
	public void createTable() {
		
		model = new CreateModel(mapSett);
		
		this.table = new JTable(model);
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		table.setFillsViewportHeight(true);
		
		this.middle.add(new JScrollPane(table));

	}
	
	public void getAction(String word) {
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
				String nameSett=(String) table.getValueAt(table.getSelectedRow(), 0);
				for(Settlement s:mapSett.getSettlements()) {
					if(s.getName().equals(nameSett)) {
						sizePpl=(int) (s.getNotSickPpl().size()*0.1);
						makePplSick(s, sizePpl);
					}
				}
				createTable();

			}
		});
		
		
		
	}

	public void filtervalue(String filterString,int chooseIndex ) {
		
		TableRowSorter<CreateModel> sorter = null;
		
		this.table.setRowSorter(sorter = new TableRowSorter<CreateModel>(this.model));
		
		try {
			sorter.setRowFilter(RowFilter.regexFilter(this.filterText.getText(),chooseIndex));
		} catch (java.util.regex.PatternSyntaxException e) {		
		}
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

	
	

}
