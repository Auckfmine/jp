package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;





public class Eleve extends Personne implements CRUD {
	
	private static final AtomicInteger count = new AtomicInteger(-1);
	
    protected  int id;
    
    Classe classe ;
    
    
    
    public static List<Eleve> eleves = new ArrayList<Eleve>();
    
    public Eleve() {
    	
    	
    }

    public Eleve(String nom , String prenom ,Personne pere,Personne mere,Adresse adresse ,String niveauScolaire, Date dateNaissance ){
        super(nom, prenom, pere, mere, adresse, niveauScolaire,dateNaissance);
        
        this.id=count.incrementAndGet();
    }

    
    @Override
    public String toString() {
    	System.out.println("************** Eleve : "+this.getPrenom()+" "+this.getNom()+" *************** \n");
    	System.out.println("\t id : "+this.id);
    	System.out.println("\t Nom : "+this.getNom());
    	System.out.println("\t Prenom : "+this.getPrenom());
    	System.out.println("\t Date de naissance :  "+this.getDateNaissance());
    	System.out.println("\t prenom pere :"+this.getPere().getPrenom());
    	System.out.println("\t nom pere :  "+this.getPere().getNom());
    	System.out.println("\t CIN : "+this.getPere().getCin());
    	System.out.println("\t Numero tel :  "+this.getPere().getNumeroTelephone());
    	System.out.println("\t Nom grand pere : "+this.getPere().getNom());
    	System.out.println("\t Nom mere :" +this.getMere().getNom());
    	System.out.println("\t prenom mere : "+this.getMere().getPrenom());
    	System.out.println("\t Niveau scolaire : "+this.getNiveauScolaire());
    	System.out.println(this.getAdresse().toString()+"\n");
    	System.out.println("******************************************************** \n\n");
    	
    	return "" ;
    }

    
    

    
    
    @SuppressWarnings("deprecation")
	public Eleve getUserInput() {
    	
    	/*
    	 * saisir les donner de l'eleve depuis le console 
    	 * condition de saisie
    	 * 
    	 * 
    	 * */
    	
    	
    	String nom ;
    	String prenom; 
    	Date dateNaissance;
    	String nomMere ; 
    	String prenomMere;
    	String nomPere ; 
    	String prenomPere ;
    	String prenomGrandPere;
    	int cin;
    	int numeroTelephone ;
    	Adresse adresse ; 
    	int numeroRue; String designation; String ville; int codePostale; String gouvernorat;
    	String niveauScolaire ; 
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("nom eleve : ");
    	nom = scanner.next();
    	System.out.println("prenom eleve : ");
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
    	
    	
    	System.out.println("nomMere");
    	nomMere = scanner.next();
    	System.out.println("prenomMere");
    	prenomMere = scanner.next();
    	System.out.println("nomPere");
    	nomPere = scanner.next();
    	System.out.println("prenom pere");	
    	prenomPere = scanner.next();
    	System.out.println("prenomGrandPere");
    	prenomGrandPere = scanner.next();
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
    	
    	System.out.println("niveau scolaire (classe) : ");
    	niveauScolaire = scanner.next();
    	
    	// retourner un object eleve
    	
    	return new Eleve(nom,prenom,new Personne(nomPere, prenomPere, new Personne(prenomGrandPere), cin, numeroTelephone),new Personne(nomMere, prenomMere),new Adresse(numeroRue, designation, ville, codePostale, gouvernorat),niveauScolaire,dateNaissance);
        
    }
    
    
    
    //methode aidante pour avoir un eleve specifique 
    
    public Eleve getEleveById(int id) {
    	
    	for(Eleve eleve : eleves) {
    		if(eleve.id==id) {
    			return eleve;
    		}
    	}
    	
    	return null ;
    }
    
    
    // Implemetation des methodes de l'interface CRUD ici 
    
    @Override
    public void add(){
    	
    	
    	//creation d'object eleve remplit de
    	
    	Eleve eleve = getUserInput();
    	
    	//l'ajout d'object eleve dans la liste
    	
    	
    	try {
    		
    		eleves.add(eleve); 
        	
        	System.out.println("\n \n eleve ajoute avec succes\n");
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
    			
    			
    			System.out.println("Entrez l'id de l'eleve ");
    			
    			//verifier si l'utilisateur a donner l'id ou non 
    			if(scanner.hasNext()) {
    				 id = Integer.parseInt(scanner.next());
    				 //optenir l'eleve spécifique a l'id donner depuis le client 
    				Eleve  eleve = new Eleve();
    				if(eleves.size()!=0) {
    					
    					for(Eleve eleveLocale:eleves) {
        					
        					if(eleveLocale.id==id) {
        						eleve=eleveLocale;
        						
        						
        						//crée un nouveau eleve avec des nouveau attributs 
        	    				Eleve nouveauEleve = getUserInput();
        	    				
        	    				
        	    	    	    	//remplir l'encien eleve avec le nouveau eleve :) 
        	    	    	    	
        	    				eleve.setNom(nouveauEleve.getNom());
        	    		    	eleve.setPrenom(nouveauEleve.getPrenom());
        	    		    	eleve.setPere(nouveauEleve.getPere());
        	    		    	eleve.setMere(nouveauEleve.getMere());
        	    		    	eleve.setAdresse(nouveauEleve.getAdresse());
        	    		    	eleve.setNiveauScolaire(nouveauEleve.getNiveauScolaire());
        	    		    	eleve.setDateNaissance(nouveauEleve.getDateNaissance());
        	    	    	    	
        	    	    	    	//afficher un message de succés
        	    	    	    	System.out.println("succés");
        	    	    			
        	    				break; // sortir le la boocle a la fin pour revenir vers le menu principale 
        					}
        					
        					else {
        						throw new Exception(); //forcer l'application a generer une exception si on ne trouve pas un eleve
        					}
        					
        				}
    				}
    				else {
    					System.out.println("Liste d'eleves est Vide . ");
    					break;
    				}
    				
    	    			
    				
    				
    			}
    	    	
    		}
    		catch(Exception e) {
    			//si l'utilisateur entre un id ui n"existe pas dans la liste une exception va se generé on doit la catché 
    			System.out.println("eleve introuvable");
    			
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
				System.out.println("entrez l'Id de l'eleve a supprimer : ");
				int id =Integer.parseInt(scanner.next()) ;
				if(eleves.size()!=0) {
					for(Eleve eleve :eleves) {
						if(eleve.id==id) {
							eleves.remove(eleve);
							System.out.println("Eleve "+id+" a ete bien supprime ...");
							break;
						}
						else {
							throw new Exception(); // forcer l'application a generer une exception si il ya pas d'object eleve 
						}
					}
					
					
				}
				else {
					System.out.println("liste d'eleves vide .");
					return;
				}
				
				
				
				
			} catch (Exception e) {
				System.out.println("eleve n'existe pas");
			}
		
    	

    }

    @Override
    public void listAll() {
    	
    	try {
    		
    		//verifier si la liste d'eleves est vide tout dabord
    		if(eleves.size()==0) {
    			System.out.println("Liste d'Eleves Vide");
    			return;
    		}
    		
    		//si la liste d'eleves nest pas vide  donc on peut  parcourir
    		for(Eleve eleve : eleves ) {
    			
					
					eleve.toString(); // toString() ici permet l'affichage de l'eleve  
    			
        		
        	}

		} catch (Exception e) {
			System.out.println("Erreur Survenu Veuillez ressayer");
		}
    	
    	
    }

}
