package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Cours implements CRUD{

    private String nom;
    private int code ;
    private Animateur animateur;
    public static List<Cours>cours = new ArrayList<Cours>();

    public Cours(String nom, Animateur animateur,int code) {
        this.setNom(nom); 
        this.setAnimateur(animateur);
        this.setCode(code);
    }
    
    public Cours() {
    	
    }

    public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Animateur getAnimateur() {
        return animateur;
    }

    public void setAnimateur(Animateur animateur) {
        this.animateur = animateur;
    }

    
    public Boolean checkCodeUnique(int code) {
    	
    	for(Cours cour:cours) {
    		if(cour.code==code) {
    			return false;
    		}
    	}
    	return true;
    }
    
    
    @Override
    public String toString() {
    	System.out.println("************** Cour : "+this.getNom()+" *************** \n");
    	System.out.println("\t code : "+this.getCode());
    	System.out.println("\t Nom : "+this.getNom());
    	System.out.println("\t Animateur Responsable : \n");
    	this.getAnimateur().toString();
    	
    	
    	return "" ;
    }
    
    public Cours getUserInput() {
    	
    	String nomCours ;
    	int idAnimateur;
    	int code;
    	Animateur animateur = new Animateur();
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Entrez nom Cours");
    	nomCours =scanner.next();
    	
    	
 
    	while(true) {
    		try {
    			System.out.println("id Animateur : ");	
    			if(scanner.hasNext()) {
    				idAnimateur = Integer.parseInt(scanner.next());//scanner.nextInt(); 
    				if(animateur.getAnimateurById(idAnimateur)==null) {
    					System.out.println("il y'a pas d'animateur avec cet id");
    				}
    				
    				else {
						animateur = animateur.getAnimateurById(idAnimateur);
						break;
					}
        	    	
    			}
    	    	
			} catch (Exception e) {
				
				System.out.println("l'id doit etre un entier");
			
				
			}
    	}
    	
    	while(true) {
    		try {
    			System.out.println("code Cours : ");	
    			if(scanner.hasNext()) {
    				code = Integer.parseInt(scanner.next());//scanner.nextInt(); 
    				
    				//verifier si le code existe dans d'autres cours 
    				
    				if(checkCodeUnique(code)==false) {
    					System.out.println("le code Entrer est utilise dans un autre cour");
    				}
    				else {
    					break;
					}
        	    	
    			}
    	    	
			} catch (Exception e) {
				
				System.out.println("cin doit etre un entier");
			
				
			}
    	}
    	
    	
    	
    	return new Cours(nomCours , animateur,code);
    }
    
	@Override
	public void add() {
		
		//creation d'object cours remplit depuis le console
		//ici on a utiliser la fonction getUserInput() pour nous aidez a remplir un object cours depuis le console
    	
    	Cours cour = getUserInput();
    	
    	//l'ajout d'object cours dans la liste
    	
    	
    	try {
    		
    		cours.add(cour); 
        	
    		System.out.println("\n \n cours ajoute avec succes\n");
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
    	int code;
    	
    	while(true) {
    		
    		try {
    			
    			
    			System.out.println("Entrez le code du cours a modifier ");
    			
    			//verifier si l'utilisateur a donner le code  ou non 
    			if(scanner.hasNext()) {
    				 code = Integer.parseInt(scanner.next());
    				 //optenir le cours specifique au code  donner depuis le client 
    				Cours  cour = new Cours();
    					for(Cours localCours:cours) {
    						if(cour.code==code) {
    							cour=localCours;
    							cour.toString();
    							break;
    						}
    						else {
								System.out.println("cours introuvable");
								break;
							}
    						
    					}
    						
    	    			
    				//cree un nouveau eleve avec des nouveau attributs 
    				Cours nouveauCour = getUserInput();
    				
    				
    	    	    	//remplir l'encien eleve avec le nouveau eleve :) 
    	    	    	
    				cour.setNom(nouveauCour.getNom());
    				cour.setCode(nouveauCour.getCode());
    				cour.setAnimateur(nouveauCour.getAnimateur());
    				
    	    	    	//afficher un message de succés
    	    	    	System.out.println("cours modifier avec succes");
    	    			
    				break; // sortir le la boocle a la fin pour revenir vers le menu principale 
    				
    			}
    	    	
    		}
    		catch(Exception e) {
    			//si l'utilisateur entre un code qui n"existe pas dans la liste une exception va se generé on doit la catché 
    			System.out.println("Cour introuvable");
    			
    		}
    	}
		
	}

	@Override
	public void delete() {
		/*
    	 * TODO : 
    	 * 
    	 * 	entrez le code de du cours  depuis le console 
    	 * 
    	 * accedez ala liste des cours et supprimer le cour qui a le meme code que celle entre
    	 * */
    	
			
			try {
				Scanner scanner = new Scanner(System.in);
				System.out.println("entrez le code du cours  a supprimer : ");
				int code =Integer.parseInt(scanner.nextLine()) ;
				for(Cours cour:cours) {
					if (cour.code==code) {
						cours.remove(cour);
						System.out.println("Cours : "+code+" a ete bien supprime ...");
						break;
						
					}
				}
				
				
			} catch (Exception e) {
				System.out.println("Cours  n'existe pas");
			}
		
	}

	@Override
	public void listAll() {
		try {
    		
    		//verifier si la liste des Cours/Acitivite est vide 
    		if(cours.size()==0) {
    			System.out.println("Liste des cours est  Vide");
    			return;
    		}
    		
    		//si la liste d'eleves nest pas vide  donc on peut  parcourir
    		for(Cours cour : cours ) {
					cour.toString(); 
					//note : toString ici est une fonction reimplementer pour satisfaire notre besoin
					// toString() ici permet l'affichage du cour  
    			
        		
        	}

		} catch (Exception e) {
			System.out.println("Erreur Survenu Veuillez ressayer");
		}
	}
}
