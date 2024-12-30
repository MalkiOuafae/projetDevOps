package org.tva.mytva;

public class CalculateurTva {
	public double calculerTva(double montant, String pays) {
		switch (pays) {
		case "Maroc":
			return montant * 0.20;
		case "France":
			return montant * 0.30;
		case "Espagne":
			if (montant < 1000) {
				return 0;
			} else {
				return montant * 0.15;
			}
		default:
			throw new IllegalArgumentException("Pays non pris en charge");
		}
	}
}
