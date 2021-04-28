package UI;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Country.Map;

public class MutationWindow extends JFrame {
			
	private Map map;
	
	private String [] names1 =new String[] {"British Variant","South Africa Variant", "Chinese Variant"};
	
	private JTable table;
	private DefaultTableModel model;
	Random rnd = new Random();

	private boolean [][] checks;  
	
	public MutationWindow(Map map) {
		super("Mutation Window");
		this.map=map;
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(550,400);
		this.setVisible(true);
		this.checks=new boolean[3][3];
		
	    model = new DefaultTableModel(names1, 0) {
	         @Override
	         public Class getColumnClass(int columnIndex) {
	          return Boolean.class;
	         }
	      };
	      this.setChecks();
	    table = new JTable(model);
		this.getContentPane().add(new RowedTableScroll(table, this.names1));
		
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 70));
		
		table.setFillsViewportHeight(true);
		

	}
	
	public void setChecks() {
		boolean t=true,f=false;
		model.addRow(new Object[]{f, f, t});
		model.addRow(new Object[]{t, f, t});
		model.addRow(new Object[]{f, t, f});

	}
	
	public boolean[][] getChecks(){
		return this.checks;
	}
}
