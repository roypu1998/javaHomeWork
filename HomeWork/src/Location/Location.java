package Location;

public class Location {

	private Point position;
	
	private Size size;

	public Location(Point p, Size s) {
		this.position=p;
		this.size=s;
	}
	
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String toString() {
		return "Location {point= "+ this.position.toString()+" size= "+this.size.toString()+"}";
	}

	
}
