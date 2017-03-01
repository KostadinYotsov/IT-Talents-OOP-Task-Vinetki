package vinetki;

import java.util.Random;

public abstract class Vinetka {
	
	public enum VinetkaSrok {
		DNEVNA(1), MESECHNA(10), GODISHNA(60);
		
		int mnojitel;

		private VinetkaSrok(int mnojitel) {
			this.mnojitel = mnojitel;
		}	
	}
	
	private VinetkaSrok srok;
	private double price;
	private String color;
	private String type;
	
	public Vinetka(String type,double price, String color) {
		this.srok=VinetkaSrok.values()[new Random().nextInt(VinetkaSrok.values().length)];
		this.price = price*this.srok.mnojitel;
		this.color = color;
		this.type = type;
	}

	public VinetkaSrok getSrok() {
		return srok;
	}

	public String getType() {
		return type;
	}

	
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Vinetka [srok=" + srok + ", price=" + price + ", color=" + color + ", type=" + type + "]";
	}
	
	public abstract void lepeneNaStuklo ();
	
}
