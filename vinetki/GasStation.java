package vinetki;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import vinetki.Vinetka.VinetkaSrok;

public class GasStation {
	
	HashMap<String,HashMap<VinetkaSrok,ArrayList<Vinetka>>> kartoteka;
	private double moneyInBank;
	private String name;
	
	public GasStation(String name, double moneyInBank) {
		this.name=name;
		this.moneyInBank = moneyInBank;
		this.kartoteka=new HashMap<>();
	}
	
	public void addVinetka (Vinetka v) {
		String type=v.getType();
		VinetkaSrok srok=v.getSrok();
		if (!kartoteka.containsKey(type)) {
			kartoteka.put(type, new HashMap<>());
		}
		if (!kartoteka.get(type).containsKey(srok)) {
			kartoteka.get(type).put(srok, new ArrayList<>());
		}
		kartoteka.get(type).get(srok).add(v);
		System.out.println(v);
	}
	
	public Vinetka sellVinetka (String type, VinetkaSrok srok) {
		ArrayList<Vinetka > vinetki=kartoteka.get(type).get(srok);
		this.moneyInBank+=vinetki.get(vinetki.size()-1).getPrice();
		return vinetki.remove(vinetki.size()-1);
	}

	@Override
	public String toString() {
		return "GasStation [moneyInBank=" + moneyInBank + ", name=" + name + "]";
	}
	
	public void sortedVinetki () {
		ArrayList<Vinetka> sortedVinetki = new ArrayList<>();
		for (HashMap<VinetkaSrok,ArrayList<Vinetka>> map : kartoteka.values()) {
			for (ArrayList<Vinetka> list : map.values()) {
				sortedVinetki.addAll(list);
			}
		}
		Collections.sort(sortedVinetki, new Comparator<Vinetka>() {

			@Override
			public int compare(Vinetka o1, Vinetka o2) {
				double razlika=o1.getPrice()-o2.getPrice();
				if (razlika<0) {
					return 1;
				}
				if (razlika>0) {
					return -1;
				}
				return 0;
			}
			
		});
		
		for (Vinetka v : sortedVinetki) {
			System.out.println(v);
		}
	}
	
}
