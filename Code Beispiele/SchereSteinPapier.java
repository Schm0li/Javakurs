import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SchereSteinPapier {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setLayout(null);
        window.setSize(430,160);

        JTextField in = new JTextField();
        in.setBounds(10,10,400,25);

        JTextField out = new JTextField();
        out.setBounds(10,80,400,25);

        JButton schere = new JButton("Schere");
        schere.setBounds(10,40,120,30);

        JButton stein = new JButton("Stein");
        stein.setBounds(150,40,120,30);

        JButton papier = new JButton("Papier");
        papier.setBounds(290,40,120,30);

        window.getContentPane().add(in);
        window.getContentPane().add(out);
        window.getContentPane().add(schere);
        window.getContentPane().add(stein);
        window.getContentPane().add(papier);
        window.setVisible(true);

        schere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "Schere gegen ";
                int number = (int) (Math.random() * 3);
                switch(number){
                    case 0:
                        text += "Schere";
                        out.setText("Unentschieden.");
                        break;
                    case 1:
                        text += "Stein";
                        out.setText("Computer hat gewonnen.");
                        break;
                    default:
                        text += "Papier";
                        out.setText("Spieler hat gewonnen.");
                        break;
                }
                in.setText(text);
            }
        });

        stein.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "Stein gegen ";
                int number = (int) (Math.random() * 3);
                switch(number){
                    case 0:
                        text += "Schere";
                        out.setText("Spieler hat gewonnen.");
                        break;
                    case 1:
                        text += "Stein";
                        out.setText("Unentschieden.");
                        break;
                    default:
                        text += "Papier";
                        out.setText("Computer hat gewonnen.");
                        break;
                }
                in.setText(text);
            }
        });

        papier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = "Papier gegen ";
                int number = (int) (Math.random() * 3);
                switch(number){
                    case 0:
                        text += "Schere";
                        out.setText("Computer hat gewonnen.");
                        break;
                    case 1:
                        text += "Stein";
                        out.setText("Spieler hat gewonnen.");
                        break;
                    default:
                        text += "Papier";
                        out.setText("Unentschieden.");
                        break;
                }
                in.setText(text);
            }
        });
    }
}
