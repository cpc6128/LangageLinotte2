/***********************************************************************
 * Linotte                                                             *
 * Version release date : October 26, 2005                             *
 * Author : Mounes Ronan ronan.mounes@amstrad.eu                        *
 *                                                                     *
 *     http://langagelinotte.free.fr                                   *
 *                                                                     *
 * This code is released under the GNU GPL license, version 2 or       *
 * later, for educational and non-commercial purposes only.            *
 * If any part of the code is to be included in a commercial           *
 * software, please contact us first for a clearance at                *
 *   ronan.mounes@amstrad.eu                                            *
 *                                                                     *
 *   This notice must remain intact in all copies of this code.        *
 *   This code is distributed WITHOUT ANY WARRANTY OF ANY KIND.        *
 *   The GNU GPL license can be found at :                             *
 *           http://www.gnu.org/copyleft/gpl.html                      *
 *                                                                     *
 ***********************************************************************/

package org.linotte.moteur.exception;

import java.util.HashMap;
import java.util.Map;

public class Messages {

	private static Map<String, String> erreurs = new HashMap<String, String>();

	public static String retourneErreur(String key) {
		String s = erreurs.get(key);
		return s == null ? "<" + key + ">" : s;
	}

	public static void creerErreur(String key, String valeur) {
		erreurs.put(key, valeur);
	}
}
