package app;
public class Adresse {

    private int numeroRue;
    private String designation;
    private String ville;
    private int codePostale;
    private String gouvernorat;


    public Adresse(int numeroRue, String designation, String ville, int codePostale, String gouvernorat) {
        this.numeroRue = numeroRue;
        this.designation = designation;
        this.ville = ville;
        this.codePostale = codePostale;
        this.gouvernorat = gouvernorat;
    }
    
    
    
    @Override 
    
    public String toString() {
    	System.out.print("\t Adresse  : "+this.numeroRue +"," +this.designation +","+this.ville+","+this.codePostale+","+this.gouvernorat);
    	return "" ;
    }

    public int getNumeroRue() {
        return numeroRue;
    }

    public void setNumeroRue(int numeroRue) {
        this.numeroRue = numeroRue;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }
}
