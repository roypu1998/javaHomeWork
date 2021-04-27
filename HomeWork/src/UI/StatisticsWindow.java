package UI;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import Country.*;
import Location.Point;

public class StatisticsWindow {

	private JFrame statisticWindow;
	
	private JPanel high, middle, low;
	
	private JButton save, addSick ,Vaccinate;
	
	private Settlement[] sett;
	
	private JLabel label;
	
	private JTextField filerText;

	private String name;
	
	private String [] names =new String[] {"Settlement Name", "Type", "Color", "Sick Precentage",
		"Number Of Vaccinated","Number Of Death", "Residents"};
	
	private JComboBox col;
	
	private JTable table;
	
	private Point p;
	
	Object [][] data;
			
	public StatisticsWindow(Point p,Settlement[] sett)	{
		this.addSick= new JButton("Add Sick");
		this.save= new JButton("Save");
		this.Vaccinate= new JButton("Vaccinate");
		this.label= new JLabel("filter: ");
		this.filerText= new JTextField();
		this.high= new JPanel();
		this.low= new JPanel();
		this.middle= new JPanel();
		this.sett=sett;
		this.data=new Object[this.names.length][this.sett.length];
		this.fillData();
		this.col= new JComboBox(this.names);
		this.table= new JTable(this.data,this.names);
		JScrollPane scrollPane = new JScrollPane(this.table);
		scrollPane.setViewportView(this.table);
		
		this.statisticWindow= new JFrame();
		
		this.table.setSize(this.middle.getWidth(), this.middle.getHeight());
		
		this.middle.add(scrollPane);

		this.p=p;
		this.name=this.getName();
		this.col.setPreferredSize(new Dimension(200,30));
		this.label.setFont(new Font(label.getFont().getName(),Font.PLAIN,20));
		this.label.setBorder(new EmptyBorder(0,60,0,10));
		this.high.setLayout(new BoxLayout(this.high,BoxLayout.X_AXIS));
		this.high.setBorder(new EmptyBorder(0,20,0,20));
		this.high.add(this.col);
		this.high.add(this.label);
		this.high.add(this.filerText);
		
		this.middle.setLayout(new BoxLayout(this.middle,BoxLayout.Y_AXIS));

		this.middle.setBorder(new EmptyBorder(100,0,20,0));

		this.addSick.setBorder(new EmptyBorder(20,50,20,50));
		this.save.setBorder(new EmptyBorder(20,50,20,50));
		this.Vaccinate.setBorder(new EmptyBorder(20,50,20,50));
		this.low.setLayout(new GridLayout(0,3));
		

		this.low.add(this.save);
		this.low.add(this.addSick);
		this.low.add(this.Vaccinate);
		
		
	}
	
	public void fillData(){
		String type;
		int len= this.sett.length;

		for (int i=0; i<len; i++) {
			if (sett[i] instanceof City)
				type="City";
			else if (sett[i] instanceof Kibbutz)
				type="Kibbutz";
			else 
				type="Moshav";
			Object []temp= {sett[i].getName(), type, sett[i].getRamzorColor(),
					sett[i].contagiousPercent(),sett[i].VaccinatedAmount(),
					sett[i].getCountDeath(),sett[i].getPeople().size()};
			this.data[i]=temp;
		}
		
		
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
		for (Settlement loc:this.sett) {
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
