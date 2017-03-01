package shofiori;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import shofiori.Avtomobil.AvtomobilType;
import vinetki.GasStation;
import vinetki.Vinetka;
import vinetki.Vinetka.VinetkaSrok;
import vinetki.VinetkaZaAvtobus;
import vinetki.VinetkaZaKamion;

public class Shofior {
	
	private String firstName;
	private String secondName;
	private double money;
	private GasStation station;
	private ArrayList<Avtomobil> avtomobili;
	
	public Shofior(String firstName, String secondName, double money) {
		if (firstName!=null && !firstName.trim().isEmpty()) {
			this.firstName = firstName;
		}
		if (secondName!=null && !secondName.trim().isEmpty()) {
			this.secondName = secondName;
		}
		if (money>0) {
			this.money = money;
		}
		else {
			this.money=2000;
		}
		
		this.avtomobili=new ArrayList<>();
		
	}
	
	public void addAvtomobil (Avtomobil a) {
		if (a!=null) {
			avtomobili.add(a);
		}
	}
	
	public void addAvtomobili(List<Avtomobil> subList) {
		this.avtomobili.addAll(subList);
	}
	
	public void addStation (GasStation g) {
		if (g!=null) {
			this.station=g;
		}
	}

	@Override
	public String toString() {
		return "Shofior [firstName=" + firstName + ", secondName=" + secondName + ", money=" + money + ", station="
				+ station + ", avtomobili=" + avtomobili + "]";
	}
	
	public void buyVinetkiZaVsichkiAvtomobili () {
		for (Avtomobil a : this.avtomobili) {
			AvtomobilType type=a.getType();
			VinetkaSrok srok=VinetkaSrok.values()[new Random().nextInt(VinetkaSrok.values().length)];
			if (type==AvtomobilType.AVTOBUS) {
				Vinetka v=this.station.sellVinetka("AVTOBUS",srok);
				this.money-=v.getPrice();
				a.addVinetka(v);
			}
			if (type==AvtomobilType.KOLA) {
				Vinetka v=this.station.sellVinetka("KOLA",srok);
				this.money-=v.getPrice();
				a.addVinetka(v);
			}
			if (type==AvtomobilType.KAMION) {
				Vinetka v=this.station.sellVinetka("KAMION",srok);
				this.money-=v.getPrice();
				a.addVinetka(v);
			}
		}
	}

}
