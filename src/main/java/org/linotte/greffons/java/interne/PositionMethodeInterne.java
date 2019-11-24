package org.linotte.greffons.java.interne;

import java.math.BigDecimal;

import org.linotte.greffons.externe.Greffon;
import org.linotte.greffons.externe.Greffon.ObjetLinotte;
import org.linotte.greffons.java.interne.a.MethodeInterne;
import org.linotte.greffons.outils.ObjetLinotteHelper;
import org.linotte.moteur.entites.Acteur;
import org.linotte.moteur.exception.Constantes;
import org.linotte.moteur.exception.ErreurException;
import org.linotte.moteur.outils.ChaineOutils;

public class PositionMethodeInterne extends MethodeInterne {

	public PositionMethodeInterne(Acteur acteur) {
		super(acteur);
	}

	@Override
	public ObjetLinotte appeler(Greffon greffon, ObjetLinotte... parametres) throws Exception {
		try {

			// Transformation des paramètres si le developpeur utilise des types Java :
			if (parametres.length != 2) {
				throw new ErreurException(Constantes.PROTOTYPE_METHODE_FONCTIONNELLE_PARAMETRE, nom());
			}

			int p1 = ((BigDecimal) transformerObjet(BigDecimal.class, parametres[0])).intValue();
			String p2 = (String) transformerObjet(String.class, parametres[1]);

			String s = (String) acteur.getValeur();
			int pos = ChaineOutils.indexOfIgnoreCase(s, p2, p1);

			return ObjetLinotteHelper.copy(pos);

		} catch (java.lang.IndexOutOfBoundsException e) {
			throw new ErreurException(Constantes.PROTOTYPE_METHODE_FONCTIONNELLE_PARAMETRE, nom());
		} catch (java.lang.IllegalArgumentException e) {
			throw new ErreurException(Constantes.PROTOTYPE_METHODE_FONCTIONNELLE_PARAMETRE, nom());
		} catch (ClassCastException e) {
			throw new ErreurException(Constantes.PROTOTYPE_METHODE_FONCTIONNELLE_PARAMETRE, nom());

		}
	}

	@Override
	public String parametres() {
		return "( à partir de , quoi )";
	}

	public String nom() {
		return "position";
	}

}
