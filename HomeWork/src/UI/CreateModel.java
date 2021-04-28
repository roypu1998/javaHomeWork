package UI;

import javax.swing.table.AbstractTableModel;

import Country.Map;
import Country.Settlement;
import Location.Location;
import Population.Person;

class CreateModel extends AbstractTableModel {
	

	private Map data;
	
	private String [] names =new String[] {"Settlement Name", "Type", "Color", "Sick Precentage",
			"Number Of Vaccinated","Number Of Death", "Residents"};
	public CreateModel (Map data) {
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
		Settlement s= this.data.at(rowIndex);
		switch (columnIndex) {
		
		case 0: return s.getName();
		case 1: return s.getClass().getSimpleName();
		case 2: return s.getRamzorColor();
		case 3: return s.contagiousPercent();
		case 4: return s.VaccinatedAmount();
		case 5: return s.getCountDeath();
		case 6: return s.getPeople().size();
		
		}
		return null;

	}
	
	
	

}
