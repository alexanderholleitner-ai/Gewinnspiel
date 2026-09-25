package gewinnspiel;

import javax.swing.*;
import java.awt.*;

/**
 * @author Alexander Holleitner
 * @version 2026-09-25
 */
public class GewinnView extends JFrame {
    private JLabel lRunde;
    private JLabel lGesamt;
    private JTextField tfSpieler;
    private JTextField tfComputer;
    private JButton bNochmal;

    public GewinnView(GewinnController c) {
        super("Zahlen-Gewinnspiel (v1.0)");

        Font normal = new Font("Arial", Font.PLAIN, 16);
        Font fett = new Font("Arial", Font.BOLD, 16);
        Font gross = new Font("Arial", Font.BOLD, 28);

        JLabel l1 = new JLabel("Rundenergebnis:", JLabel.CENTER);
        JLabel l2 = new JLabel("Gesamtpunkte:", JLabel.CENTER);
        JLabel l3 = new JLabel("Deine Zahl:", JLabel.CENTER);
        JLabel l4 = new JLabel("Computer:", JLabel.CENTER);
        l1.setFont(normal);
        l2.setFont(normal);
        l3.setFont(normal);
        l4.setFont(normal);

        lRunde = new JLabel("Tippe eine Zahl von 1 bis 9", JLabel.CENTER);
        lRunde.setFont(fett);
        lRunde.setOpaque(true);
        lRunde.setBackground(Color.WHITE);

        lGesamt = new JLabel("Gesamtpunkte: 30", JLabel.CENTER);
        lGesamt.setFont(fett);
        lGesamt.setOpaque(true);
        lGesamt.setBackground(Color.WHITE);

        tfSpieler = new JTextField();
        tfSpieler.setFont(gross);
        tfSpieler.setHorizontalAlignment(JTextField.CENTER);
        tfSpieler.setActionCommand("eingabe");
        tfSpieler.addActionListener(c);

        tfComputer = new JTextField();
        tfComputer.setFont(gross);
        tfComputer.setHorizontalAlignment(JTextField.CENTER);
        tfComputer.setEditable(false);
        tfComputer.setBackground(Color.WHITE);

        bNochmal = new JButton("Noch einmal!");
        bNochmal.setFont(normal);
        bNochmal.setActionCommand("nochmal");
        bNochmal.addActionListener(c);

        JPanel oben = new JPanel(new GridLayout(3, 2, 4, 2));
        oben.add(l1);
        oben.add(l2);
        oben.add(lRunde);
        oben.add(lGesamt);
        oben.add(l3);
        oben.add(l4);

        JPanel mitte = new JPanel(new GridLayout(1, 2, 10, 0));
        mitte.add(tfSpieler);
        mitte.add(tfComputer);

        JPanel unten = new JPanel();
        unten.add(bNochmal);

        this.add(oben, BorderLayout.NORTH);
        this.add(mitte, BorderLayout.CENTER);
        this.add(unten, BorderLayout.SOUTH);

        this.setSize(460, 280);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public String getEingabe() {
        return tfSpieler.getText();
    }

    public void zeigeRunde(int computer, int ergebnis, int gesamt, boolean gewonnen, boolean verloren) {
        tfComputer.setText("" + computer);
        if (gewonnen) {
            lRunde.setText("Gewonnen");
        } else if (verloren) {
            lRunde.setText("Verloren");
        } else if (ergebnis > 0) {
            lRunde.setText("+" + ergebnis);
        } else {
            lRunde.setText("" + ergebnis);
        }
        lGesamt.setText("" + gesamt);
    }

    public void zeigeFehler(String text) {
        lRunde.setText(text);
        tfSpieler.setText("");
    }

    public void loeschen() {
        tfSpieler.setText("");
        tfComputer.setText("");
        lRunde.setText("Tippe eine Zahl von 1 bis 9");
        tfSpieler.requestFocus();
    }

    public void setGesamt(String text) {
        lGesamt.setText(text);
    }
}
