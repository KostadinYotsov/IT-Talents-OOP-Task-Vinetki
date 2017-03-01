import java.util.ArrayList;
import java.util.Random;

import shofiori.Avtomobil;
import shofiori.Shofior;
import vinetki.GasStation;
import vinetki.VinetkaZaAvtobus;
import vinetki.VinetkaZaKamion;
import vinetki.VitnetkaZaKola;


public class Demo {

	public static void main(String[] args) {
		
		GasStation shell=new GasStation("Shell",1000);
	
		for (int i = 0; i < 1000; i++) {
			switch (new Random().nextInt(3)+1) {
			case 1:
				shell.addVinetka(new VitnetkaZaKola());
				break;
			case 2:
				shell.addVinetka(new VinetkaZaKamion());
				break;
			case 3:
				shell.addVinetka(new VinetkaZaAvtobus());
				break;
			default:
				break;
			}
		}
	
		shell.sortedVinetki();
		
		String [] firstName = {"Ivan", "Georgi", "Anton", "Marin", "Petyr" };
		String [] secondtName = {"Ivanov", "Georgiev", "Antonov", "Marinov", "Petrov" };
		
		ArrayList<Shofior> shofiori=new ArrayList<>();
		
		for (int i = 0; i <20; i++) {
			String name1=firstName[new Random().nextInt(firstName.length)];
			String name2=secondtName[new Random().nextInt(secondtName.length)];
			double money=Math.random()*25_000;
			Shofior shofior=new Shofior(name1, name2, money);
			shofior.addStation(shell);
			shofiori.add(shofior);
			//System.out.println(shofior);
		}
		
		String [] model = {"Opel", "Renault", "Lada", "Citroen", "BMW" };
		ArrayList<Avtomobil> avtomobili=new ArrayList<>();
		for (int i = 0; i < 200; i++) {
			String m=model[new Random().nextInt(model.length)];
			Avtomobil avtomobil=new Avtomobil(m);
			avtomobili.add(avtomobil);
		}
		
		
		for (int i=0; i<shofiori.size(); i++) {
			int count1=0;
			int count2=19;
			shofiori.get(i).addAvtomobili(avtomobili.subList(count1, count2));
			count1+=20;
			count2+=20;
		}
		//for (Shofior shofior : shofiori) {
			//System.out.println(shofior);
		//}
		
		Shofior sh=shofiori.get(shofiori.size()-1);
		sh.buyVinetkiZaVsichkiAvtomobili();
		System.out.println(sh);
		
	
	}

}
