package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Animateur extends Personne implements CRUD{

    private Personne pere ;
    
    public static List<Animateur> animateurs = new ArrayList<Animateur>();
    
private static final AtomicInteger count = new AtomicInteger(-1);
	
    protected  int id;

    public Animateur(String nom , String prenom ,Date dateNaissance,Adresse adresse ,int cin ,int numeroTelephone ,Personne pere){
        super(  nom ,  prenom ,dateNaissance, adresse , cin , numeroTelephone, pere);
        this.id=count.incrementAndGet();
    }

    
    
    
    
    public Animateur() {
		// TODO Auto-generated constructor stub
	}
    
    public Animateur(int cin) {
    	this.setCin(cin) ;
    }


    
    @Override
    public String toString() {
    	System.out.println("************** Animateur : "+this.getPrenom()+" "+this.getNom()+" *************** \n");
    	System.out.println("\t id : "+this.id);
    	System.out.println("\t Nom : "+this.getNom());
    	System.out.println("\t Prenom : "+this.getPrenom());
    	System.out.println("\t Date de naissance :  "+this.getDateNaissance());
    	System.out.println("\t prenom pere :"+this.getPere().getPrenom());
    	System.out.println("\t CIN : "+this.getCin());
    	System.out.println("\t Numero tel :  "+this.getNumeroTelephone());
    	System.out.println(this.getAdresse().toString()+"\n");
    	System.out.println("******************************************************** \n\n");
    	
    	return "" ;
    }



	@SuppressWarnings("deprecation")
	public Animateur getUserInput() {
    	
    	/*
    	 * saisir les donner de l'eleve depuis le console 
    	 * condition de saisie
    	 * 
    	 * 
    	 * */
    	
    	
    	String nom ;
    	String prenom; 
    	Date dateNaissance;
    	
    	
    	String prenomPere ;
    	
    	int cin;
    	int numeroTelephone ;
    	Adresse adresse ; 
    	int numeroRue; String designation; String ville; int codePostale; String gouvernorat;
    	
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("nom Animateur : ");
    	nom = scanner.next();
    	System.out.println("prenom Animateur : ");
    	prenom = scanner.next();
    	
    	
    	while(true) {
    		try {
    			System.out.println("date de naissance (jj/mm/aaaa): ");
    			if(scanner.hasNext()) {
    				String naissanceString = scanner.next();
        			dateNaissance = new Date(naissanceString);
        			
        			break;
    			}
    			
			} catch (Exception e) {
				System.out.println("date invalide");
			}
    	};
    	
    	
    	
    	System.out.println("prenom pere");	
    	prenomPere = scanner.next();
    	
    	while(true) {
    		try {
    			System.out.println("cin : ");	
    			if(scanner.hasNext()) {
    				cin = Integer.parseInt(scanner.next());//scanner.nextInt(); 
        	    	break;
    			}
    	    	
			} catch (Exception e) {
				
				System.out.println("cin doit etre un entier");
			
				
			}
    	}
    	while(true) {
    		try {
    			System.out.println("numeroTlf : ");
    			if(scanner.hasNext()) {
    				numeroTelephone = Integer.parseInt(scanner.next());
        	    	break;
    			}
    	    	
			} catch (Exception e) {
				System.out.println("numero tlf invalide");
			}
    	}
    	while(true) {
    		try {
    			System.out.println("numero Rue");
    			if(scanner.hasNext()) {
    				numeroRue = Integer.parseInt(scanner.next());
        	    	break;
    			}
    	    	
			} catch (Exception e) {
				System.out.println("numero rue invalide");
			}
    	}
    	
    	System.out.println("designation rue : ");
    	designation = scanner.next();
    	System.out.println("ville :");
    	ville = scanner.next();
    	
    	while(true) {
    		try {
    			System.out.println("code postale : ");
    			if(scanner.hasNext()) {
    				codePostale = Integer.parseInt(scanner.next());
        	    	break;
    			}
    	    	
			} catch (Exception e) {
				System.out.println("code postale  invalide");
			}
    	}
    	
    	System.out.println("gouvernorat : ");
    	gouvernorat = scanner.next();
    	
    	
    	return new Animateur(nom ,  prenom ,dateNaissance, new Adresse( numeroRue,  designation,ville,codePostale,gouvernorat) , cin , numeroTelephone, new Personne(prenomPere));
		
    	
    }
    
    
    

public Animateur getAnimateurById(int id) {
    	
    	for(Animateur animateur : animateurs) {
    		if(animateur.id==id) {
    			return animateur;
    		}
    	}
    	
    	return null ;
    }
    
    
	@Override
	public void add() {
		//creation d'object eleve remplit de
    	
    	Animateur animateur = getUserInput();
    	
    	//l'ajout d'object eleve dans la liste
    	
    	
    	try {
    		
    		animateurs.add(animateur); 
        	
    		System.out.println("\n \n animateur ajoute avec succes\n");
    	}
    	
    	catch (Exception e) {
			System.out.println("erreur survenu . . . ");
		}
		
	}

	@Override
	public void update() {
		/*
    	 * TODO
    	 * 	demandeer l'id d'eleve de la part de client (console) 
    	 * 
    	 * 	acc�der ala liste des eleves et troouvez l'eleve qui a l'id entr� 
    	 * 
    	 *	 remplacer l'object Eleve ancien avec le nouveau  en conservant l'id
    	 *
    	 * 	
    	 * 
    	 * */
    	
    	Scanner scanner  = new Scanner(System.in);
    	int id = 0 ;
    	
    	while(true) {
    		
    		try {
    			
    			
    			System.out.println("Entrez l'id de l'Animateur ");
    			
    			//verifier si l'utilisateur a donner l'id ou non 
    			if(scanner.hasNext()) {
    				 id = Integer.parseInt(scanner.next());
    				 //optenir l'eleve spécifique a l'id donner depuis le client 
    				Animateur  animateur = animateurs.get(id);
    	    			
    				//crée un nouveau eleve avec des nouveau attributs 
    				Animateur nouveauAnimateur = getUserInput();
    				
    				
    	    	    	//remplir l'encien eleve avec le nouveau eleve :) 
    	    	    	
    				animateur.setNom(nouveauAnimateur.getNom());
    				animateur.setPrenom(nouveauAnimateur.getPrenom());
    				animateur.setDateNaissance(nouveauAnimateur.getDateNaissance());
    				animateur.setAdresse(nouveauAnimateur.getAdresse());
    				animateur.setCin(nouveauAnimateur.getCin());
    				animateur.setNumeroTelephone(nouveauAnimateur.getNumeroTelephone());
    				animateur.setPere(nouveauAnimateur.getPere());
    				
    				
    				
    	    	    	
    	    	    	//afficher un message de succés
    	    	    	System.out.println("succés");
    	    			
    				break; // sortir le la boocle a la fin pour revenir vers le menu principale 
    				
    			}
    	    	
    		}
    		catch(Exception e) {
    			//si l'utilisateur entre un id ui n"existe pas dans la liste une exception va se generé on doit la catché 
    			System.out.println("Animateur introuvable");
    			
    		}
    	}
		
	}

	@Override
	public void delete() {
		/*
    	 * TODO : 
    	 * 
    	 * 	entrez l'id de l'eleve depuis le console 
    	 * 
    	 * acc�dez ala liste des eleves et supprimer l'eleve qui a le meme id que celle entr�e
    	 * */
    	
			
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("entrez l'Id de l'animateur a supprimer : ");
				int id =Integer.parseInt(scanner.nextLine()) ;
				for(Animateur animateur:animateurs) {
					if (animateur.id==id) {
						animateurs.remove(animateur);
						System.out.println("Animateur"+id+" a ete bien supprime ...");
						break;
						
					}
				}
				
				
			} catch (Exception e) {
				System.out.println("Animateur n'existe pas");
			}
		
	}

	@Override
	public void listAll() {
		try {
    		
    		//verifier si la liste d'eleves est vide tout dabord
    		if(animateurs.size()==0) {
    			System.out.println("Liste d'animateurs Vide");
    			return;
    		}
    		
    		//si la liste d'eleves nest pas vide  donc on peut  parcourir
    		for(Animateur animateur : animateurs ) {
    			
					
					animateur.toString(); // toString() ici permet l'affichage de l'eleve  
    			
        		
        	}

		} catch (Exception e) {
			System.out.println("Erreur Survenu Veuillez ressayer");
		}
		
	}
    
    
    
    
}
