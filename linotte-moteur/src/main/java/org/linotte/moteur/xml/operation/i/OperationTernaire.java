/***********************************************************************
 * Linotte                                                             *
 * Version release date : April 1, 2011                                *
 * Author : Mounes Ronan ronan.mounes@amstrad.eu                       *
 *                                                                     *
 *     http://langagelinotte.free.fr                                   *
 *                                                                     *
 * This code is released under the GNU GPL license, version 2 or       *
 * later, for educational and non-commercial purposes only.            *
 * If any part of the code is to be included in a commercial           *
 * software, please contact us first for a clearance at                *
 *   ronan.mounes@amstrad.eu                                           *
 *                                                                     *
 *   This notice must remain intact in all copies of this code.        *
 *   This code is distributed WITHOUT ANY WARRANTY OF ANY KIND.        *
 *   The GNU GPL license can be found at :                             *
 *           http://www.gnu.org/copyleft/gpl.html                      *
 *                                                                     *
 ***********************************************************************/

package org.linotte.moteur.xml.operation.i;

import org.linotte.moteur.xml.alize.kernel.Job;
import org.linotte.moteur.xml.analyse.Mathematiques.Temoin;

public abstract class OperationTernaire implements Operation {

	public Object valeurBrute1;
	public Object valeurBrute2;
	public Object valeurBrute3;

	public Object calculer(Job moteur, Temoin temoin, Object token_courant) throws Exception {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		return getClass().getSimpleName().toLowerCase();
	}

}