package org.linotte.frame.atelier;

import org.linotte.frame.Atelier;

import javax.swing.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;

public class CopyL extends AbstractAction {
    private final Atelier atelier;

    public CopyL(Atelier atelier) {
        this.atelier = atelier;
    }

    public void actionPerformed(ActionEvent e) {
        String selection = atelier.getCahierCourant().getSelectedText();
        if (selection == null)
            return;
        StringSelection clipString = new StringSelection(selection);
        atelier.clipbd.setContents(clipString, clipString);
    }
}
