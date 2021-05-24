package app;

import java.util.Date;

public class Personne {

    private String nom;
    private String prenom;
    private Date dateNaissance;
    private Adresse adresse ;
    private String niveauScolaire;
    
    private int cin;
    private int numeroTelephone;
    private Personne pere;
    private Personne mere;
    
    
    
    
    public Personne() {
    	
    }
    
    
    //constructeur de l"object mere

    public  Personne(String nom , String prenom) //la mere
    {
        this.setNom(nom);
        this.setPrenom(prenom);
    }
    
    
    //constructeur de l'object grandPere

    public Personne(String prenom) //le grandPére
    {
        this.setPrenom(prenom);
    }

    
    
    // le pere
    
    public Personne(String nom ,String prenom ,Personne pere,int cin,int numeroTelephone ) 
    {
    this.setNom(nom);
    this.setPrenom(prenom);
    this.setCin(cin);
    this.setNumeroTelephone(numeroTelephone);
    this.pere = pere ;
    }
    
    
    
    
    //l'eleve

    public Personne (String nom , String prenom ,Personne pere,Personne mere,Adresse adresse ,String niveauScolaire ,Date dateNaissance) //eleve
    {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setNiveauScolaire(niveauScolaire);
        this.pere=pere ;
        this.mere = mere;
        this.setDateNaissance(dateNaissance);
    }

    
    
    
    //l'animateur
    public Personne (String nom , String prenom ,Date DateNaissance,Adresse adresse ,int cin ,int numeroTelephone,Personne pere)//animateur
    {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setCin(cin);
        this.setNumeroTelephone(numeroTelephone);
        this.pere=pere ;
        this.setDateNaissance(DateNaissance);
       
    }
    
    
    
    //GETTERS et SETTERS (encapsulation)

    public void setPere(Personne pere) {
	 this.pere=pere;
    }
    
    
 	public Personne getPere() {
 		
	return this.pere;
 	}
 	
 	
 	
	public Personne getMere() {
		return this.mere;
	}

	public void setMere(Personne mere) {
		this.mere = mere;
	}


	public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(String niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }


    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public int getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(int numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
}
