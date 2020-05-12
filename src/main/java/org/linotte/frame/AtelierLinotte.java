package org.linotte.frame;

import com.formdev.flatlaf.FlatIntelliJLaf;
import console.Jinotte;
import org.linotte.frame.gui.SplashWindow;
import org.linotte.frame.outils.Tools;
import org.linotte.moteur.outils.Preference;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

public class AtelierLinotte {

    public static void main(String[] args) {

        Preference.CAN_WRITE = true;
        if (args != null && args.length > 0) {
            // Mode console
            Jinotte.main(args);
        } else {
            try {
                // Mode graphique
                AtomicReference<SplashWindow> splashWindow1 = new AtomicReference<>();
                FlatIntelliJLaf.install();
                SwingUtilities.invokeAndWait(() -> {
                    splashWindow1.set(new SplashWindow(new Frame()));
                });
                Atelier.initialisationFrameAtelierEtToile();
                splashWindow1.get().fermer();
            } catch (Throwable e) {
                e.printStackTrace();
                Tools.showError(e);
                System.exit(-1);
            }

        }
    }

}