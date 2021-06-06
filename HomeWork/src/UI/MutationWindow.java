package UI;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

import Country.Map;
import Virus.*;

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
	
	public List<IVirus> mutationVirus(String nameVirus){
		int row;
		List<IVirus> viruses= new ArrayList <>();
		if(nameVirus.equals("BritishVariant")) {
			row=0;	
			for (int column=0; column<this.table.getColumnCount();column++) {
					if(this.table.getValueAt(row, column).equals(true)) {
						switch(column){
						case 0: viruses.add(BritishVariant.get_instance());
						case 1: viruses.add(SouthAfricanVariant.get_instance());
						case 2: viruses.add(ChineseVariant.get_instance());
						}
					}
			}
		}
		if(nameVirus.equals("SouthAfricanVariant")) {
			row=1;	
			for (int column=0; column<this.table.getColumnCount();column++) {
					if(this.table.getValueAt(row, column).equals(true)) {
						switch(column){
						case 0: viruses.add(BritishVariant.get_instance());
						case 1: viruses.add(SouthAfricanVariant.get_instance());
						case 2: viruses.add(ChineseVariant.get_instance());
						}
					}
			}
		}
		if(nameVirus.equals("ChineseVariant")) {
			row=2;	
			for (int column=0; column<this.table.getColumnCount();column++) {
					if(this.table.getValueAt(row, column).equals(true)) {
						switch(column){
						case 0: viruses.add(BritishVariant.get_instance());
						case 1: viruses.add(SouthAfricanVariant.get_instance());
						case 2: viruses.add(ChineseVariant.get_instance());
						}
					}
			}
		}
		return viruses;
	}
	
	public boolean[][] getChecks(){
		return this.checks;
	}
}
