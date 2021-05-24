package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Classe implements CRUD{

    private String nom;
    public List<Eleve>eleves = new ArrayList<Eleve>();
    public List<Cours>cours = new ArrayList<Cours>();
    public List<Animateur>animateurs = new ArrayList<Animateur>();
    public static List<Classe> classes = new ArrayList<Classe>();
    Eleve eleve = new Eleve();
    Animateur animateur = new Animateur();
    
public Classe(String nom) {
	this.setNom(nom);
}
    public Classe(String nom,List<Eleve> eleves) {
    	this.setNom(nom);
    	this.eleves = eleves;
    }
    public Classe() {
    	
    }
   
    
    public Classe(String nom,List<Eleve> eleves,List<Animateur> animateurs){
        this.animateurs=animateurs;
        this.eleves = eleves;
        this.setNom(nom);
    }
    
    
    
    
    public Boolean verifClass(String nom) {
    	Boolean result=false;
    	if(classes.contains(this.nom)) {
    		result = true;
    	}
    	
    	return result;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

   
    
	@Override
	public void add() {
		
		//pour ajouter une classe on doit donner le nom du classe  la liste des eleves de cette classe , liste des animateurs dans cette classe et la liste des actitivtées 
		String nom;
		int idEleve;
		int idAnimateur;
		
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("entrez le nom du classe : ");
			nom = scanner.next();
			while(true) {
				
				try {
					System.out.println("entrer l'id de l'eleve a ajouter dans cette classe ");
					if(scanner.hasNext()) {
						idEleve = Integer.parseInt(scanner.next());
						
						if(eleve.getEleveById(idEleve)==null) {
							System.out.println("acun eleve corrrespond a cette id ");
							
						}
						
						else {
							Eleve eleveeEleve = eleve.getEleveById(idEleve);
							eleveeEleve.toString();
							eleves.add(eleveeEleve);
							break;
						}
						
						
					}
					
					
				} catch (Exception e) {
					System.out.println("l'id doit etre un entier");
				}
			}
			
			while(true) {
				
				try {
					System.out.println("entrer l'id de l'animateur a ajouter dans  cette classe ");
					if(scanner.hasNext()) {
						idAnimateur = Integer.parseInt(scanner.next());
						if(animateur.getAnimateurById(idAnimateur)==null) {
							System.out.println("acun animateur corrrespond a cette id ");
							
						}
						
						else {
							Animateur anim = animateur.getAnimateurById(idAnimateur);
							anim.toString();
							animateurs.add(anim);
							break;
						}
						
						
					}
					
					
				} catch (Exception e) {
					System.out.println("l'id doit etre un entier");
				}
			}
			
			//check if student with given id exists 
			
			
			
			
			
			Classe classe = new Classe(nom,eleves);
			classes.add(classe);
			
			System.out.println("\n \n classe ajoutee avec succes\n");
		}
		catch(Exception e) {
			System.out.println("Erreur");
		}
		
		
	}
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void listAll() {
		
try {
    		
    		//verifier si la liste d'eleves est vide tout dabord
    		if(classes.size()==0) {
    			System.out.println("Liste des classes est Vide");
    			return;
    		}
    		
    		//si la liste d'eleves nest pas vide  donc on peut  parcourir
    		for(Classe classe : classes ) {
    			
					
					System.out.println(classe.getNom()); // toString() ici permet l'affichage de l'eleve  
    			
        		
        	}

		} catch (Exception e) {
			System.out.println("Erreur Survenu Veuillez ressayer");
		}
    	
		
	}
    
    
    
    
    
    
}
