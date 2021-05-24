package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Classe implements CRUD {

	private String nom;
	public List<Eleve> eleves = Eleve.eleves;
	//public List<Cours> cours = Cours.cours;
	public List<Animateur> animateurs = new ArrayList<Animateur>();
	public static List<Classe> classes = new ArrayList<Classe>();
	
	private static final AtomicInteger count = new AtomicInteger(-1);
	public int id;static
	Eleve eleve = new Eleve();
	Animateur animateur = new Animateur();

	public Classe() {

	}

	public Classe(String nom) {

		this.setNom(nom);
		// ajouter les eleves qui ont un niveau scolaire egale au nom de cette classe
		// dés l'initialisation du classe
		List<Eleve> eleves2 = new ArrayList<Eleve>();
		for (Eleve eleve : eleves) {
			if (eleve.getNiveauScolaire().equals(nom)) {
				eleves2.add(eleve);
			}
		}

		this.eleves = eleves2;
		

		this.id = count.incrementAndGet();

	}
	
	public Classe getClasseById(int id) {

		for (Classe classe : classes) {
			if (classe.id == id) {
				return classe;
			}
		}

		return null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		for (Eleve eleve : this.eleves) {
			System.out.println(eleve.getNom());
		
		}
		
		
		return "";
	}

	@Override
	public void add() {

		try {
			String nom;
			String coursNom;
			Scanner scanner = new Scanner(System.in);
			System.out.println("donner le nom de la  classe");
			nom = scanner.next();
			

			Classe classe = new Classe(nom);
			
			

			classe.toString();

			classes.add(classe);
			System.out.println("Classe ajoutee");
		} catch (Exception e) {
			System.out.println("Erreur");
		}

	}

	@Override
	public void update() {
		
	}

	@Override
	public void delete() {
		/*
		 * TODO :
		 * 
		 * entrez l'id de la classe depuis le console
		 * 
		 * acc�dez ala liste des classes et supprimer la classe qui a le meme id que
		 * celle entr�e
		 */

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("entrez l'Id de la classe  a supprimer : ");
			int id = Integer.parseInt(scanner.next());
			if (classes.size() != 0) {
				for (Classe classe : classes) {
					if (classe.id == id) {
						classes.remove(eleve);
						System.out.println("Classe " + id + " a ete bien supprime ...");
						break;
					} else {
						throw new Exception(); // forcer l'application a generer une exception si il ya pas d'object
												// eleve
					}
				}

			} else {
				System.out.println("liste des classe vide .");
				return;
			}

		} catch (Exception e) {
			System.out.println("classe n'existe pas");
		}

	}

	@Override
	public void listAll() {

		try {

			// verifier si la liste d'eleves est vide tout dabord
			if (classes.size() == 0) {
				System.out.println("Liste des classes est Vide");
				return;
			}

			// si la liste d'eleves nest pas vide donc on peut parcourir
			for (Classe classe : classes) {

				System.out.println("Nom de la classe : "+classe.getNom()); // toString() ici permet l'affichage de l'eleve
				System.out.println("Les Eleves Dans cette classe : \n");
				for (Eleve eleve : classe.eleves) {
					System.out.println(eleve.toString());
				}

			}

		} catch (Exception e) {
			System.out.println("Erreur Survenu Veuillez ressayer");
		}

	}

}
