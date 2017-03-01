package shofiori;

import java.util.Random;

import vinetki.Vinetka;
import vinetki.VinetkaZaAvtobus;
import vinetki.VinetkaZaKamion;
import vinetki.VitnetkaZaKola;

public class Avtomobil {
	
	enum AvtomobilType {KOLA, KAMION, AVTOBUS}
	

	
	private AvtomobilType type;
	private String model;
	private Vinetka vinetka;
	
	
	public Avtomobil(String model) {
		this.type=AvtomobilType.values()[new Random().nextInt(AvtomobilType.values().length)];
		if (model!=null && !model.trim().isEmpty()) {
			this.model = model;
		}
		else {
			this.model="Phantom";
		}
		
	}
	
	public void addVinetka (Vinetka v) {
		if (v!=null && this.type==AvtomobilType.AVTOBUS && v instanceof VinetkaZaAvtobus) {
			this.vinetka=v;
		}
		if (v!=null && this.type==AvtomobilType.KOLA && v instanceof VitnetkaZaKola) {
			this.vinetka=v;
		}
		if (v!=null && this.type==AvtomobilType.KAMION && v instanceof VinetkaZaKamion) {
			this.vinetka=v;
		}
	}

	

	@Override
	public String toString() {
		return "Avtomobil [type=" + type + ", model=" + model + ", vinetka=" + vinetka + "]";
	}

	public AvtomobilType getType() {
		return type;
	}
	
}
