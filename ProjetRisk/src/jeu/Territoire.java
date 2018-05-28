package jeu;

public class Territoire {
    private int territoireId;
    private int soldatSurT;
	private String nomT;
	private int cavalierSurT;
	private int canonSurT;
    private String couleurT;
//    private Zone zone; Comment les zones sont définis ?
    //Constructeur 
    
    public Territoire (int territoireId, String couleurT,String nomT) {
    	this.territoireId= territoireId;
    	this.couleurT=couleurT;
    	this.nomT=nomT;
    }

    
    
    //Get & set 
    public int getSoldatSurT() {
		return soldatSurT;
	}

	public void setSoldatSurT(int soldatSurT) {
		this.soldatSurT = soldatSurT;
	}


    public int getCavalierSurT() {
		return cavalierSurT;
	}

	public void setCavalierSurT(int cavalierSurT) {
		this.cavalierSurT = cavalierSurT;
	}


    public int getCanonSurT() {
		return canonSurT;
	}

	public void setCanonSurT(int canonSurT) {
		this.canonSurT = canonSurT;
	}


	public String getNomT() {
		return nomT;
	}

	public void setNomT(String nomT) {
		this.nomT = nomT;
	}

	public String getCouleurT() {
		return couleurT;
	}

	public void setCouleurT(String couleurT) {
		this.couleurT = couleurT;
	}

	public int getTerritoireId() {
		return territoireId;
	}

	public void setTerritoireId(int territoireId) {
		this.territoireId = territoireId;
	}
    
}
