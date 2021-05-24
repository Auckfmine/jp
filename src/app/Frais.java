package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;



public class Frais implements CRUD{

	private Eleve eleve;
	private Cours cours;
	private Classe classe;
	private Boolean isPayed=false;
	private float montant = 500f;
	private String mois ;
	private static final AtomicInteger count = new AtomicInteger(-1);
	public static List<Frais>listFrais = new ArrayList<Frais>();
	public int id;
	
	public Frais() {
		
	}
	
	public Frais(Eleve eleve ,Cours cours,Classe classe,Boolean isPayed,float mantant,String mois) {
		
		this.setClasse(classe);
		this.setCours(cours);
		this.setIsPayed(isPayed);
		this.setMontant(mantant);
		this.setMois(mois);
		this.setEleve(eleve);
		this.id=count.incrementAndGet();
		
		
		
		
	}
	
	
	
	
	public void afficherFacture() {
		System.out.println("\n \n *****************facture N� "+this.id +"***************\n");
		System.out.println("\t facture Pour le Mois de : "+this.getMois());
		System.out.println("\t Pour L'eleve : "+this.getEleve().getNom()+" "+this.getEleve().getPrenom());
		System.out.println("\t classe : " +this.getClasse().getNom());
		System.out.println("\t cours : " +this.getCours().getNom());
		System.out.println("\t mantant : "+this.getMontant());
		System.out.println("\t etat de payement: "+this.isPayed);
	}

	public Eleve getEleve() {
		return eleve;
	}

	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public Boolean getIsPayed() {
		return isPayed;
	}

	public void setIsPayed(Boolean isPayed) {
		this.isPayed = isPayed;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float mantant) {
		this.montant = mantant;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}

	
public Frais getUserInput() {
    	
    	String nomCours ;
    	int idEleve;
    	int codeCours;
    	int idClasse;
    	int montant;
    	String mois ;
    	
    	Cours cours = new Cours();
    	Eleve eleve = new Eleve();
    	Classe classe = new Classe();
    	Scanner scanner = new Scanner(System.in);
    	
    	
    	
 
    	while(true) {
    		try {
    			System.out.println("id Eleve : ");	
    			if(scanner.hasNext()) {
    				idEleve = Integer.parseInt(scanner.next());//scanner.nextInt(); 
    				if(eleve.getEleveById(idEleve)==null) {
    					System.out.println("il y'a pas d'eleve avec cet id");
    				}
    				
    				else {
						eleve = eleve.getEleveById(idEleve);
						break;
					}
        	    	
    			}
    	    	
			} catch (Exception e) {
				
				System.out.println("l'id doit etre un entier");
			
				
			}
    	}
    	
    	while(true) {
    		try {
    			System.out.println("id Cours : ");	
    			if(scanner.hasNext()) {
    				codeCours = Integer.parseInt(scanner.next());//scanner.nextInt(); 
    				if(cours.getCoursByCode(codeCours)==null) {
    					System.out.println("il y'a pas de cours  avec ce code");
    				}
    				
    				else {
						cours = cours.getCoursByCode(codeCours);
						break;
					}
        	    	
    			}
    	    	
			} catch (Exception e) {
				
				System.out.println("le code doit etre un entier");
			
				
			}
    	}
    	
    	
    	while(true) {
    		try {
    			System.out.println("id classe : ");	
    			if(scanner.hasNext()) {
    				idClasse = Integer.parseInt(scanner.next());//scanner.nextInt(); 
    				if(classe.getClasseById(idEleve)==null) {
    					System.out.println("il y'a pas de classe avec cet id");
    				}
    				
    				else {
						classe = classe.getClasseById(idClasse);
						break;
					}
        	    	
    			}
    	    	
			} catch (Exception e) {
				
				System.out.println("l'id doit etre un entier");
			
				
			}
    	}
    	
    	
    	while (true) {
			try {
				System.out.println("montant : ");
				if (scanner.hasNext()) {
					montant = Integer.parseInt(scanner.next());
					break;
				}

			} catch (Exception e) {
				System.out.println("montant  invalide");
			}
		}
    	
    	System.out.println("mois");
		mois = scanner.next();
    	
    	
    	
    	
    	
    	return new Frais( eleve , cours, classe, isPayed, getMontant(), mois);
    }
	@Override
	public void add() {
		
		// creation d'object facture remplit de console

				Frais frais = getUserInput();

				// l'ajout d'object d'une facture dans la liste des factures

				try {

					listFrais.add(frais);

					System.out.println("\n \n Facture  ajoute avec succes pour l'eleve : "+frais.getEleve().getNom()+" "+frais.getEleve().getPrenom()+"\n");
				}

				catch (Exception e) {
					System.out.println("erreur survenu . . . ");
				}

		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete() {
		/*
		 * TODO :
		 * 
		 * entrez l'id de l'eleve depuis le console
		 * 
		 * acc�dez ala liste des eleves et supprimer l'eleve qui a le meme id que celle
		 * entr�e
		 */

		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("entrez l'Id de la facture a supprimer : ");
			int id = Integer.parseInt(scanner.nextLine());
			Boolean error = false;

			if (listFrais.size() != 0) {
				for (Frais frais : listFrais) {
					if (frais.id == id) {
						listFrais.remove(frais);
						System.out.println("facture Numero : " + id + " a ete bien supprime ...");
						break;

					}

					else {
						throw new Exception(); // forcer l'application a generer unne erreur si l'animateur n'existe pas
					}

				}

			} else {
				System.out.println("Pas de facttures  dans la liste des factures");
				return;
			}

		} catch (Exception e) {
			System.out.println("facture  n'existe pas");

		}
		
	}

	@Override
	public void listAll() {
		try {

			// verifier si la liste des factures est vide tout dabord
			if (listFrais.size() == 0) {
				System.out.println("Liste de factures est  Vide");
				return;
			}

			// si la liste des facture nest pas vide donc on peut parcourir
			for (Frais frais : listFrais) {

				frais.afficherFacture(); //  permet l'affichage des  factures

			}

		} catch (Exception e) {
			System.out.println("Erreur Survenu Veuillez ressayer");
		}

	}
		
	
	
	
	
}
