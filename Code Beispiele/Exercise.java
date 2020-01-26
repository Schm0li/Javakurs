import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Exercise {
    public static void main(String[] args) {
        /** Fenster-Setup **/
        JFrame window = new JFrame();
        window.setLayout(null);
        window.setSize(500,200);

        JTextField in = new JTextField();
        in.setBounds(10,10,400,25);

        JTextField out = new JTextField();
        out.setBounds(10,100,400,25);

        JButton rev = new JButton("Reverse");
        rev.setBounds(15,40,80,30);

        JButton coord = new JButton("Coordinates");
        coord.setBounds(100,40,80,30);

        JButton fill = new JButton("Fill");
        fill.setBounds(185,40,80,30);

        window.getContentPane().add(in);
        window.getContentPane().add(out);
        window.getContentPane().add(rev);
        window.getContentPane().add(coord);
        window.getContentPane().add(fill);
        window.setVisible(true);

        rev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(in.getText().equals("")){
                    fill(in);
                }

                String text = in.getText();
                out.setText(reverse(text));
            }
        });

        coord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(in.getText().equals("")){
                    fill(in);
                }

                String text = in.getText();
                out.setText(coordinates(text));
            }
        });

        fill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fill(in);
            }
        });
    }

    public static void fill(JTextField textField){
        int x = (int)(Math.random()*180) + 1;
        int y = (int)(Math.random()*180) + 1;
        textField.setText("Current Location: " + x + ", " + y);
    }


    /** Hier dürft ihr euch austoben **/
    public static String reverse(String input){
        String res = "";



        return res;
    }

    public static String coordinates(String input){
        String res = "";


        return res;
    }
}

