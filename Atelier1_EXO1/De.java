package Atelier1_EXO1;

import java.util.*;

	public class De {

	    /*Constantes de classe
	      static : "de classe"
	      final : " constant"
	      static final : constante de classe
	    */
	    public static final int NB_MIN_FACES = 3;
	    public static final int NB_MAX_FACES = 120;
	    public static final int NB_DEFAUT_FACES = 6;
	    public static final String NOM_DEFAUT = "D�";

	    //Variables de classe, elles sont rattach�es � la classe, un seul espace m�moire pour la classe
	    //En premier les variables public, ensuite les protected, package (pas de modificateur) enfin les private
	    public static Random rand = new Random(); // On souhaite utiliser le m�me g�n�rateur al�atoire
	    //  pour tous les d�s
	    private static int nbDe = 0; //On souhaite conserver le nombre de d�s qui ont �t� cr��s

	    /*
	     * Variables (attribut, champs, etc.) d'instances, elles caract�risent une
	     * instance de D� en particulier. Chaque instance a sa propre zone m�moire
	     * d�di�e
	     * En premier les variables public, ensuite les protected, package (pas de modificateur) enfin les private
	     *
	     * Concept de l'encapsulation, on va utiliser un modificateur d'acc�s parmi
	     * les quatres possibles
	     * - public : on peut acc�der � l'item depuis toutes les classes
	     * - protected : on peut acc�der � l'item depuis les classes d�riv�es et les classes du m�me package
	     * - private : l'item est seulement accessible depuis l'int�rieur de la classe o� il est d�fini.
	     * -(par d�faut/rien) sans modificateur d'acc�s, seules les classes du m�me package peuvent acc�der � l'item.
	     */

	    private int nbFaces; // On le d�clare priv� pour le prot�ger, car sa modification demande
	                        // de respecter certaines r�gles (>= NB_MIN_FACES = 3 et <= NB_MAX_FACES = 120)
	    private String nom;  // On le d�clare priv� pour le prot�ger, il ne doit pas pouvoir �tre modifi� une fois
	    // affect� depuis le constructeur
	    //On aurait aussi pu d�clarer l'attribut nom
	    //public final nom;  auquel cas on a pas besoin de m�thode getNom()


	    //Constructeurs
	    //On �crit le constructeur le plus complet c'est � dire avec tous les param�tres n�cessaires
	    public De(int nFaces, String pnom) throws IllegalArgumentException  {
	    	if(pnom == "") {
	    		throw new IllegalArgumentException("Le nom ne doit pas etre vide");
	    		
	    		}
	    	else if(pnom== null) {
	    		throw new NullPointerException("Le nom ne doit pas etre null");
	    	}
	    	
	    	
	        this.setNbFaces(nFaces);
	        if ((pnom != null) && (pnom != "")) {
	            nom = pnom;
	        }else {
	            nom = NOM_DEFAUT;
	            System.err.println("Attention le nom doit �tre non null et non vide il a �t�" +
	                    "positionn� � la cha�ne \"D�\"");
	        }
	    }
	    //On appel le constructeur le plus complet pour d�finir les constructeurs ayant moins de param�tres
	    public De()  {
	    	
	        this(NB_DEFAUT_FACES,NOM_DEFAUT);
	    }


	    //Acesseurs et modificateurs : getter et setter
	    //Accesseurs
	    public int getNbFaces() {
	        return nbFaces;		//Equivalent � this.nbFaces, this repr�sente l'instance courante, celle sur
	        //laquelle on invoque la m�thode
	    }

	    public String getNom() {
	        return nom;			//Equivalent � this.nom, this repr�sente l'instance courante, celle sur
	        //laquelle on invoque la m�thode
	    }

	    //Modificateurs
	    public void setNbFaces(int nvNbFaces) {
	        if ((nvNbFaces >= NB_MIN_FACES) && (nvNbFaces <= NB_MAX_FACES)) {
	            nbFaces = nvNbFaces;
	        }else {
	        	 throw new IllegalArgumentException("Attention le nombre de faces doit �tre compris entre "+
	        	            NB_MIN_FACES+" et " + NB_MAX_FACES);
	        }
	    }

	    public static int getNbDesCrees(){
	        return nbDe;
	    }

	    //M�thodes d'instances
	    //Question 5 : lanc� de d�
	    public int lancer() {
	        return 1+rand.nextInt(nbFaces);
	    }

	    public int lancer(int nbLances){
	        int result=lancer();
	        int temp;
	        for (int i=0;i<nbLances-1;i++) {
	            temp = lancer();
	            if (result>temp){
	                result = temp;
	            }
	        }
	        return result;
	    }


	    /* Methodes h�rit�es de la classe Object
	       Redefinition de la methode toString. Cette m�thode par d�faut renvoie l'adresse de l'objet
	       en m�moire. Il faut s'astreindre � syst�matiquement la red�finir pour renvoyer une description
	       de l'objet sous forme de chaine de caract�re.
	       Elle est implicitement invoqu�e lorsqu'on passe une r�f�rence � un objet en param�tre de la
	       m�thode print. Ainsi System.out.printl(monInstance.toString()) est �quivalent �
	       System.out.printl(monInstance)
	     */
	    public String toString() {
	        return "un D� nomm� " + nom + " � " + nbFaces + " faces";
	    }
	}



