package app;

import java.util.Scanner;

public class Menu {

    private int choix ;
    Scanner scanner = new Scanner(System.in);

    Eleve eleve  = new Eleve();
    Animateur animateur = new Animateur();
    Classe classe = new Classe();
    Cours cours = new Cours();

    
    // outil pour  afficher plusieur menu sans repitition de code 
    public void afficherMenu(String variable1){
    	
    	System.out.println("\n \n************** Menu "+variable1+"**************\n");

        System.out.println("\t 1- Ajouter "+variable1);
        System.out.println("\t 2- Modifier "+variable1);
        System.out.println("\t 3- Supprimer "+variable1);
        System.out.println("\t 4- Lister "+variable1);
        System.out.println("\t 0- retour Menu Principale \n");
        System.out.println("****************************************\n");
    }
    
    
    // Menu principale 
    public   void MainMenu(){
    	
    	
        System.out.println("\n \n************ Menu Principale ************* \n");
        System.out.println("\t 1-Gestion Eleves");
        System.out.println("\t 2-Gestion Animateurs");
        System.out.println("\t 3-Gestion Classes");
        System.out.println("\t 4-Gestion Cours/Activité");
        System.out.println("\t 5-Statistiques de l'ecole");
        System.out.println("\t 0-Exit \n");
        System.out.println("*****************************************");



        while  (true){
            try {
                System.out.println("entrez votre choix");
                choix = Integer.parseInt(scanner.nextLine());

                break;
            }
            catch (Exception e){
                System.out.println("choix invalide");
                choix =-1; // juste pour aller a la default case dans le block swtich(choix)
                break;
            }
        }

        switch (choix){
            case 0:
                System.out.println("Au revoir");
                System.exit(0);
            case 1:
                gestionEleve();   // redirection vers le menu des Eleves
                break;
            case 2:
                gestionAnimateur();  // redirection vers le menu des animateurs
                break;
            case 3:
                gestionClasses();  // redirection vers le menu des classes
                break;
            case  4:
                gestionCours();  // redirection vers le menu des cours
                break;
            case  5:
                Statistique.showStatistiques(); //Affichage des statistiques De L'ecole
                break;    

            default:		//dans le cas contraire un message d'erreur doit etre afficher au client 
                System.out.println("choix invalid");
                break;
        }
    }

    public void gestionEleve(){
        afficherMenu("Eleves");



        while (true){
            try{
                System.out.println("donner votre choix");
                choix = Integer.parseInt(scanner.nextLine()) ;
                
                break;
            }
            catch (Exception e){
                System.out.println("choix invalide");
                choix = 10;//juste pour allez a la default case dans le block switch (choix) 
                break;
            }
        }

        switch (choix){
            case 0:
                MainMenu();//afficher le menu principale
                break;
            case 1:
            	eleve.add(); //l'ajout d'eleve 
            	
            	
                break;
            case 2:
                System.out.println("Methode modifier eleve");
                eleve.update(); //modification eleve
                break;
            case 3:
                eleve.delete(); //supprimer eleve
                break;
            case  4:
                
                eleve.listAll(); //lister les eleves
                break;

            default:
                System.out.println("choix invalid");
                break;
        }
    }

    public void gestionAnimateur(){
        afficherMenu("Animateur"); //afficher le menu d'animateurs



        while (true){
            try{
                System.out.println("donner votre choix");
                choix = Integer.parseInt(scanner.nextLine()); 
                break;
            }
            catch (Exception e){
                System.out.println("choix invalide");
                choix=10;
               
            }
        }

        switch (choix){
            case 0:
                MainMenu();
                break;
            case 1:
                System.out.println(" Methode ajouter animateur");
                animateur.add();
                break;
            case 2:
                System.out.println("Methode modifier animateur");
                animateur.update();
                break;
            case 3:
                System.out.println("methode supprimer animateur");
                animateur.delete();
                break;
            case  4:
                System.out.println("methode lister animateur");
                animateur.listAll();
                break;

            default:
                System.out.println("choix animateur");
                break;
        }
    }

    public void gestionClasses(){
        afficherMenu("Classes"); //afficher le menu d'classes



        while (true){
            try{
                System.out.println("donner votre choix");
                choix = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("choix invalide");
                
            }
        }

        switch (choix){
            case 0:
                MainMenu();
                break;
            case 1:
                System.out.println(" Methode ajouter classe");
                classe.add();
                break;
            case 2:
                System.out.println("Methode modifier classe");
                break;
            case 3:
                System.out.println("methode supprimer classe");
                break;
            case  4:
                System.out.println("methode lister classe");
                classe.listAll();
            case 5 :
            	System.out.println("Ajouter des eleves Au classe");
            	int id;
            	String nomClasse;
            	while(true) {
            		try {
            			System.out.println("Donner l'id de  l'eleve a Ajouter");
						 id = Integer.parseInt(scanner.nextLine());
						break;
					} catch (Exception e) {
						System.out.println(e);
					}
            	}
            	
            	while(true) {
            		try {
            			System.out.println("Donner le nom  de  classe  a Remplir avec l'eleve : ");
            			nomClasse = scanner.nextLine();
						break;
					} catch (Exception e) {
						System.out.println(e);
					}
            	}
            	Eleve eleveeEleve = new Eleve() ;
            	for (Eleve elevee : eleve.eleves) {
            		if(elevee.id==id) {
            			eleveeEleve = elevee ;
            		}
            		
            	}
            	
            	for(Classe classee:classe.classes) {
            		if(classee.getNom()==nomClasse) {
            			classee.eleves.add(eleveeEleve);
            			eleveeEleve.toString();
            		}
            	}
            	
            	
                
            case 6 : 
            	System.out.println("Retirer des eleves Du classe");
            case 7 :
            	System.out.println("Ajouter des Animateurs Au classe");
                break;
            case 8 : 
            	System.out.println("Retirer des Animateurs Du classe");
            case 9 :
            	System.out.println("Ajouter des Cours Au classe");
                break;
            case 10 : 
            	System.out.println("Retirer des Cours Du classe");	

            default:
                System.out.println("choix invalide");
                break;
        }
    }

    public void gestionCours(){
        afficherMenu("Cours/Activités"); //afficher le menu d'cours



        while (true){
            try{
                System.out.println("donner votre choix");
                choix = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (Exception e){
                System.out.println("choix invalide");
                choix=-1;
                break;
            }
        }

        switch (choix){
            case 0:
                MainMenu();
                break;
            case 1:
                System.out.println(" Methode ajouter cours");
                cours.add();
                break;
            case 2:
                System.out.println("Methode modifier cours");
                cours.update();
                break;
            case 3:
                System.out.println("methode supprimer cours");
                cours.delete();
                break;
            case  4:
                System.out.println("methode lister cours");
                cours.listAll();
                break;

            default:
                System.out.println("choix invalide");
                break;
        }
    }


    

}
