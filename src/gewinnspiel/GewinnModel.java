package gewinnspiel;

/**
 * @author Alexander Holleitner
 * @version 2026-09-25
 */
public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * 9) + 1;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        if (spielerZahl == computerZahl) {
            rundenErgebnis = 20;
        } else if (spielerZahl == computerZahl + 1 || spielerZahl == computerZahl - 1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }
        gesamtPunkte = gesamtPunkte + rundenErgebnis;
    }

    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}
