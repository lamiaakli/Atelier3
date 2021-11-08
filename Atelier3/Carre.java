package Atelier3;

public class Carre extends Geometrie2D {
	    private double c;

	    public Carre(String name, double c) {
	        super(name);
	        this.c = c;
	    }

	    @Override
	    public double Surface() {
	        double surface = c * c;
	        return surface;
	    }

	    @Override
	    public double Perimetre() {
	        double perimetre = c * 4;
	        return perimetre;
	    }

	    public String toString() {
	        String message = "Vous venez de construire un carr�"
	                        + "\nSon P�rim�tre est de " + Perimetre() + "m"
	                        + "\nSa surface est de " + Surface() + "m�";
	        return message;
	    }

	}

