package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphicalUserInterface {
    public static void main(String[] args){
        JFrame window = new JFrame();
        JTextArea out = new JTextArea();
        JButton bad = new JButton("BÖSER BUTTON. NICHT DRÜCKEN!");
        JButton button = new JButton("Füllen");


        window.getContentPane().setLayout(null);
        window.setTitle("Hier könnte ihre Werbung stehen!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500,350);

        out.setBounds(10,10,200,250);
        out.setEditable(false);
        out.setLineWrap(true);
        out.setWrapStyleWord(true);

        window.getContentPane().add(out);
        button.setBounds(300,110,100,30);
        window.getContentPane().add(button);
        button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent actionEvent) {
                String numbers = "";
                for(int i = 0; i<1000;i++){
                    int insert = ((int)(Math.random()*1000) + 1 );
                    numbers= numbers + insert+ "; ";
                }

                out.setText(numbers);
                bad.setVisible(true);

            }
        });


        bad.setBounds(220, 180, 270, 30);
        bad.setVisible(false);
        window.getContentPane().add(bad);
        bad.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent actionEvent) {
                    bad.setText("DA SPRINGT ER!");
                    int x = (int)(Math.random()*400) + 1;
                    int y = (int)(Math.random()*320) + 1;
                    bad.setBounds(x,y,300,30);
                }
            });

        window.setVisible(true);



    }
}
