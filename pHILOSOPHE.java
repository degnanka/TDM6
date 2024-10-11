package fr.esisar.exo2;

import java.util.ArrayList;
import java.util.List;

public class Philosophe extends Thread {
	Boolean discuter;
	int numero;
	Arbitre arbitre;

	public Philosophe(Boolean discuter, int numero,Arbitre arbitre) {
		this.discuter=discuter;
		this.numero=numero;
		this.arbitre=arbitre;
	}

	public void run() {
		Boolean manger = false;
		try {
			while(true) {
				int temps= (int) (Math.random()*10000);
				if(!discuter) {
					System.out.println("Philosophe n° "+numero+": Je discute");
					sleep(temps);
				}
				else {
					while(!manger) {
						if(arbitre.autorisation(numero)){
							System.out.println("Philosophe n° "+numero+": Je mange");
							sleep(temps);
							manger=true;
						}
						else {
							sleep(1000);
						}
					}
					manger = false;
					arbitre.liberation(numero);
				}
				discuter=!discuter;
			}
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[]args) {
		int nb_philo = 5;
			Boolean[]baguette_libre;
			baguette_libre =new Boolean[nb_philo];
			for (int i=0;i<baguette_libre.length;i++) {
				baguette_libre[i]= true;
			}
			List<Philosophe >philo= new ArrayList<>();
			Arbitre arbitre = new Arbitre(nb_philo,baguette_libre);
			for(int i =0;i<nb_philo;i++) {
				Philosophe philosophe = new Philosophe(true,i+1,arbitre);
				philo.add(philosophe);
			}
			for(int i =0;i<nb_philo;i++) {
				philo.get(i).start();
			}
		
		
	}
}
