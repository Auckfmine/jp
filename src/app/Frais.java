package app;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



public class Frais {

	Eleve eleve ;
	private Cours cours;
	private Classe classe;
	private Boolean isPayed=false;
	private int montant;
	private String mois ;
	private static final AtomicInteger count = new AtomicInteger(-1);
	public static List<Frais>listFrais = new ArrayList<Frais>();
	public int id;
	
	public Frais() {
		
	}
	
	public Frais(Cours cours,Classe classe,Boolean isPayed,int mantant,String mois) {
		
		this.setClasse(classe);
		this.setCours(cours);
		this.setIsPayed(isPayed);
		this.setMontant(mantant);
		this.setMois(mois);
		this.id=count.incrementAndGet();
		
		
		
		
	}
	
	
	
	
	public void afficherFacture() {
		System.out.println("\n \n *****************facture N° "+this.id +"***************\n");
		System.out.println("\t \t \t facture Pour le Mois de : "+this.getMois());
		System.out.println("\t classe : " +this.getClasse().getNom());
		System.out.println("\t cours : " +this.getCours().getNom());
		System.out.println("\t mantant : "+this.getMontant());
		System.out.println("\t etat de payement: "+this.isPayed);
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

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public String getMois() {
		return mois;
	}

	public void setMois(String mois) {
		this.mois = mois;
	}
	
	
	
}
