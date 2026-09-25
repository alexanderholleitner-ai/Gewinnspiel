package gewinnspiel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Alexander Holleitner
 * @version 2026-09-25
 */
public class GewinnController implements ActionListener {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController() {
        model = new GewinnModel();
        view = new GewinnView(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("eingabe")) {
            if (model.hatGewonnen() || model.hatVerloren()) {
                return;
            }
            int zahl;
            try {
                zahl = Integer.parseInt(view.getEingabe());
            } catch (NumberFormatException ex) {
                view.zeigeFehler("Ungültige Eingabe!");
                return;
            }
            if (zahl < 1 || zahl > 9) {
                view.zeigeFehler("Nur 1 bis 9 erlaubt!");
                return;
            }
            model.berechneComputerZahl();
            model.berechneRunde(zahl);
            view.zeigeRunde(model.getComputerZahl(), model.getRundenErgebnis(), model.getGesamtPunkte(),
                    model.hatGewonnen(), model.hatVerloren());
        }
    }

    public static void main(String[] args) {
        new GewinnController();
    }
}
