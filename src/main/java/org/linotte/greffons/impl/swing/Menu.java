package org.linotte.greffons.impl.swing;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.linotte.greffons.externe.Composant;

/**
 * 
 * @author R.M
 * 
 */
public class Menu extends ComposantSwing {

	JMenu menu;

	@Override
	public void initialisation() throws GreffonException {
		if (menu != null) {
			return;
		}

		setVisible(getAttributeAsString("visible").equals("oui"));
		String texte = getAttributeAsString("texte");
		menu = new JMenu(texte);
		menu.setVisible(isVisible());
	}

	@Override
	public void ajouterComposant(Composant pcomposant) throws GreffonException {
		ComposantSwing composant = (ComposantSwing) pcomposant;
		if (composant instanceof SousMenu) {
			menu.add((JMenuItem) composant.getJComponent());
		} else if (composant instanceof Menu) {
			menu.add((JMenu) composant.getJComponent());
		} else if (composant instanceof Bouton) {
			menu.add((JButton) composant.getJComponent());
		} else if (composant instanceof MenuCaseACocher) {
			menu.add((JCheckBoxMenuItem) composant.getJComponent());
		}
	}

	@Override
	public JComponent getJComponent() throws GreffonException {
		return menu;
	}

	@Override
	public void destruction() throws GreffonException {
		if (menu != null) {
			//menu.dispose();
			menu = null;
		}
	}

	@Override
	public boolean enregistrerPourDestruction() {
		return true;
	}

	@Override
	public boolean fireProperty(String clef) throws GreffonException {
		if (!super.fireProperty(clef)) {
			if (menu != null && "texte".equals(clef) &&
			// Patch de mise à jour intenpestif
					!menu.getText().equals(((Acteur) getAttribute(clef)).getValeur())) {
				menu.setText((String) ((Acteur) getAttribute(clef)).getValeur());
				return true;
			}
		}
		return false;
	}

}
