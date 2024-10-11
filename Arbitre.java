package fr.esisar.exo2;

public class Arbitre {
	Boolean[] baguette_libre;
	int nb_philo;


	public Arbitre(int nb_philo,Boolean []baguette_libre) {
		this.nb_philo = nb_philo;
		this.baguette_libre= new Boolean[nb_philo];
		this.baguette_libre= baguette_libre;
	}

	boolean autorisation(int numPhilo) {
		if(baguette_libre[(numPhilo-1)%nb_philo]&&baguette_libre[(numPhilo+1)%nb_philo]) {
			baguette_libre[(numPhilo-1)%nb_philo]=false;
			baguette_libre[(numPhilo+1)%nb_philo]=false;
			return true;
		}
		else {
			return true;
		}
	}

	public void liberation(int numPhilo) {
		baguette_libre[(numPhilo-1)%nb_philo]=true;
		baguette_libre[(numPhilo+1)%nb_philo]=true;

	}
}
