package Location;

public class Point {
	
	private int x,y;

	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean equals(Point p) {
		if(this.x==p.x&& this.y==p.y)
			return true;
		return false;
	}
	/*
	 * public String toString() { return String.format("Point {x=%d, y=%d}",this.x,
	 * this.y ); }
	 */

}
