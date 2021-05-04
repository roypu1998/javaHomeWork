package Location;

public class Size {

	private int width , height;

	public Size(int w, int h) {
		this.width=w;
		this.height=h;
		
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean equals(Size s) {
		if(this.height==s.height&& this.width==s.width)
			return true;
		return false;
	}
	/*
	 * public String toString() { return
	 * String.format("Size {width=%d, height=%d}",this.width, this.height ); }
	 */
}
