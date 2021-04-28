package UI;

import javax.swing.table.AbstractTableModel;

import Country.Map;
import Country.Settlement;
import Location.Location;
import Population.Person;

class CourseModel extends AbstractTableModel {
	

	private Map data;
	
	private String [] names =new String[] {"Settlement Name", "Type", "Color", "Sick Precentage",
			"Number Of Vaccinated","Number Of Death", "Residents"};
	public CourseModel (Map data) {
		this.data=data;
	}
	
	@Override
	public int getColumnCount() {
		 return data.Size();
	}

	@Override
	public int getRowCount() {
		return 7;
	}
	@Override
	public String getColumnName(int column) { return names[column]; 
	}

	public Class getColumnClass(int column) { return getValueAt(0, column).getClass(); }


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Settlement p= this.data.at(rowIndex);
		switch (columnIndex) {
		
		case 0: return p.getName();
		case 1: return p.getClass().getSimpleName();
		case 2: return p.getRamzorColor();
		case 3: return p.contagiousPercent();
		case 4: return p.VaccinatedAmount();
		case 5: return p.getCountDeath();
		case 6: return p.getPeople().size();
		
		}
		return null;

	}
	
	
	

}
