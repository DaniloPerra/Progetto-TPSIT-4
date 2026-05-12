package ProggettoInformaticaTpsit;

import javax.swing.*;
import java.awt.*;

public class MainCPL_GamblingGUI extends JFrame {

    private CPL_Gambling cpl;
    private SlotMachine slot;

    private JLabel infoLabel;
    private JLabel[][] celle;
    private JButton giocaButton;
    private JTextArea risultatoArea;

    public MainCPL_GamblingGUI() {
        cpl = new CPL_Gambling();
        slot = new SlotMachine();

        cpl.aggiungiGioco(slot.getNome());

        setTitle("CPL Gambling");
        setSize(600, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        creaInterfaccia();

        setVisible(true);
    }

    private void creaInterfaccia() {
        JPanel pannelloTitolo = new JPanel();
        pannelloTitolo.setBackground(new Color(30, 30, 30));
        pannelloTitolo.setLayout(new GridLayout(3, 1));

        JLabel titleLabel = new JLabel("🎰 BENVENUTO IN CPL GAMBLING 🎰", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JLabel subtitleLabel = new JLabel("Gioco disponibile: " + slot.getNome(), SwingConstants.CENTER);
        subtitleLabel.setForeground(Color.LIGHT_GRAY);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        infoLabel = new JLabel(
                "Partite giocate: " + cpl.getPartiteGiocate() +
                        " | Partite rimanenti: " + cpl.getPartiteRimanenti(),
                SwingConstants.CENTER
        );
        infoLabel.setForeground(Color.YELLOW);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 15));

        pannelloTitolo.add(titleLabel);
        pannelloTitolo.add(subtitleLabel);
        pannelloTitolo.add(infoLabel);

        add(pannelloTitolo, BorderLayout.NORTH);

        JPanel pannelloSlot = new JPanel();
        pannelloSlot.setLayout(new GridLayout(slot.getRighe(), slot.getColonne(), 10, 10));
        pannelloSlot.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));
        pannelloSlot.setBackground(new Color(50, 50, 50));

        celle = new JLabel[slot.getRighe()][slot.getColonne()];

        for (int i = 0; i < slot.getRighe(); i++) {
            for (int j = 0; j < slot.getColonne(); j++) {
                celle[i][j] = new JLabel("❔", SwingConstants.CENTER);
                celle[i][j].setFont(new Font("Segoe UI Emoji", Font.BOLD, 45));
                celle[i][j].setOpaque(true);

                if (i == slot.getRighe() / 2) {
                    celle[i][j].setBackground(new Color(255, 215, 0));
                } else {
                    celle[i][j].setBackground(Color.WHITE);
                }

                celle[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                pannelloSlot.add(celle[i][j]);
            }
        }

        add(pannelloSlot, BorderLayout.CENTER);

        JPanel pannelloBasso = new JPanel();
        pannelloBasso.setLayout(new BorderLayout());

        giocaButton = new JButton("GIOCA");
        giocaButton.setFont(new Font("Arial", Font.BOLD, 22));
        giocaButton.setBackground(new Color(0, 150, 80));
        giocaButton.setForeground(Color.WHITE);
        giocaButton.setFocusPainted(false);

        risultatoArea = new JTextArea();
        risultatoArea.setEditable(false);
        risultatoArea.setFont(new Font("Arial", Font.PLAIN, 15));
        risultatoArea.setLineWrap(true);
        risultatoArea.setWrapStyleWord(true);
        risultatoArea.setText(
                "Probabilità di vincita:\n" +
                        "TRIS: 0,14%\n" +
                        "COPPIA: 29,63%\n" +
                        "TUTTI DIVERSI: 69,14%\n\n" +
                        "Premi GIOCA per iniziare!"
        );

        risultatoArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        giocaButton.addActionListener(e -> gioca());

        pannelloBasso.add(giocaButton, BorderLayout.NORTH);
        pannelloBasso.add(new JScrollPane(risultatoArea), BorderLayout.CENTER);

        add(pannelloBasso, BorderLayout.SOUTH);
    }

    private void gioca() {
        if (!cpl.iniziaPartita()) {
            risultatoArea.setText("Hai raggiunto il limite massimo di partite!");
            giocaButton.setEnabled(false);
            return;
        }

        slot.gira();

        String[][] griglia = slot.getGriglia();

        for (int i = 0; i < slot.getRighe(); i++) {
            for (int j = 0; j < slot.getColonne(); j++) {
                celle[i][j].setText(griglia[i][j]);
            }
        }

        int premio = slot.controllaVincita();

        if (premio > 0) {
            risultatoArea.setText(
                    "🎉 JACKPOT! 🎉\n" +
                            "Hai vinto " + premio + " gettoni!\n" +
                            "Simbolo vincente: " + griglia[slot.getRighe() / 2][0] + "\n\n" +
                            "Partite giocate: " + cpl.getPartiteGiocate() + "\n" +
                            "Partite rimanenti: " + cpl.getPartiteRimanenti()
            );
        } else {
            risultatoArea.setText(
                    "Nessuna vincita, riprova!\n\n" +
                            "Partite giocate: " + cpl.getPartiteGiocate() + "\n" +
                            "Partite rimanenti: " + cpl.getPartiteRimanenti()
            );
        }

        aggiornaInfoPartite();

        if (!cpl.puoiGiocare()) {
            giocaButton.setEnabled(false);
            risultatoArea.append("\n\nLimite massimo di partite raggiunto!");
        }
    }

    private void aggiornaInfoPartite() {
        infoLabel.setText(
                "Partite giocate: " + cpl.getPartiteGiocate() +
                        " | Partite rimanenti: " + cpl.getPartiteRimanenti()
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainCPL_GamblingGUI::new);
    }
}