package app;


public class Statistique {





public static void showStatistiques() {
	/*
	 * on a utiliser des liste Static  dans les classes Eleve , Animateurs , Cours , Classes  pour facilit� l'acces pour ces liste directement sans instancer 
	 * */
	
	int nbEleves = Eleve.eleves.size();
	int nbClasses = Classe.classes.size();
	int nbAnimateurs = Animateur.animateurs.size();
	int nbCours = Cours.cours.size();
	int nbFactures = Frais.listFrais.size();
	
	System.out.println("\n \n************ Statistiques ************* \n");
	System.out.println("\t Nombres D'eleves Dans l'Ecole : "+nbEleves);
	System.out.println("\t Nombres De Classes Dans l'Ecole : "+nbClasses);
	System.out.println("\t Nombres D'Animateurs Dans l'Ecole : "+nbAnimateurs);
	System.out.println("\t Nombres De Cours/Activites Dans l'Ecole : "+nbCours);
	System.out.println("\t Nombres De Factures Dans l'Ecole : "+nbCours);
	System.out.println("\n**********************************\n");
}

}
