/***********************************************************************
 * Linotte                                                             *
 * Version release date : January 11, 2006                             *
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

package org.linotte.moteur.xml;

import org.linotte.greffons.GestionDesGreffons;
import org.linotte.moteur.entites.Prototype;
import org.linotte.moteur.entites.PrototypeGraphique;
import org.linotte.moteur.outils.Ressources;
import org.linotte.moteur.xml.analyse.Grammaire;
import org.linotte.moteur.xml.analyse.multilangage.Langage;
import org.linotte.moteur.xml.api.IHM;
import org.linotte.moteur.xml.api.Librairie;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe doit être initialisée qu'une seule fois. Elle contient la
 * grammaire du langage et la structure des espèces
 *
 * @author CPC
 */
public class Linotte {

    private static final String prefix_grammaire = "grammaires/grammaire_";
    private static final String prefix_definitions = "grammaires/definitions_";

    private static boolean greffonscharges = false;
    public List<Prototype> especeModeleMap = new ArrayList<Prototype>();
    private Grammaire grammaire = null;
    private Librairie<?> lib = null;
    private IHM ihm = null;
    private RegistreDesActions registreDesEtats;
    private Langage langage;

    public Linotte(Librairie<?> plib, IHM pihm, Langage langageDef) {
        lib = plib;
        ihm = pihm;
        langage = langageDef;
        initVM();
    }

    private void initVM() {
        // On utilise le proxy du système :
        // http://www.rgagnon.com/javadetails/java-0085.html
        try {
            System.setProperty("java.net.useSystemProxies", "true");
        } catch (Exception e) {
            System.out.println("Pas de proxy, en mode bac à sable");
        }

        grammaire = new Grammaire(Ressources.getFromRessources(prefix_grammaire + langage.getFichier()),
                Ressources.getFromRessources(prefix_definitions + langage.getFichier()), langage);

        registreDesEtats = new RegistreDesActions();

        synchronized (especeModeleMap) {
            try {
                // A faire une seule fois !
                if (!greffonscharges) {
                    // Initialisation des objets graphiques :
                    // Enregistrement des especes graphiques sur la toile :
                    PrototypeGraphique.init();
                    greffonscharges = true;
                }
                // Especes et greffons internes :
                Bibliotheque.genererEspecesGraphiquesEtGreffonsInternes(lib, this);
                // initialisation des greffons externes (java / python / ruby):
                GestionDesGreffons.initGreffons(lib, this);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public Librairie<?> getLibrairie() {
        return lib;
    }

    public Grammaire getGrammaire() {
        return grammaire;
    }

    public RegistreDesActions getRegistreDesEtats() {
        return registreDesEtats;
    }

    public IHM getIhm() {
        return ihm;
    }

    public void setIhm(IHM ihm) {
        this.ihm = ihm;
    }

    public Langage getLangage() {
        return langage;
    }

}
