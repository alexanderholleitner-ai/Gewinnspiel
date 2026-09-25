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
        int zahl = Integer.parseInt(view.getEingabe());
        model.berechneComputerZahl();
        model.berechneRunde(zahl);
        view.zeigeRunde(model.getComputerZahl(), model.getRundenErgebnis(), model.getGesamtPunkte(),
                model.hatGewonnen(), model.hatVerloren());
    }

    public static void main(String[] args) {
        new GewinnController();
    }
}
