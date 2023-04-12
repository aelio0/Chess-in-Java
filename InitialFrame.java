import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialFrame implements ActionListener {
    JFrame frame;
    JButton btnplay;
    JLabel lbltitle;
    JTextArea txtrules;
    Font fontlbl;
    Font fonttxt;


    public InitialFrame(){
        frame=new JFrame("Scacchi by Fornoni & Aliaj");

        lbltitle=new JLabel("Scacchi Semplificato",SwingConstants.CENTER);
        fontlbl=new Font(Font.SERIF,Font.PLAIN, 30);
        lbltitle.setFont(fontlbl);
        //lbl.setForeground(Color.RED);


        txtrules=new JTextArea("""
                   Regole speciali:
                  - no pareggio
                  - no arrocco
                  - no en passant
                  - mosse illegali lecite
                  - vince chi mangia il re""");

        fonttxt=new Font(Font.SERIF,Font.PLAIN, 18);
        txtrules.setFont(fonttxt);
        txtrules.setEditable(false);

        btnplay=new JButton("Gioca");
        btnplay.addActionListener(this);

        frame.setLayout(new BorderLayout());
        frame.add(lbltitle,BorderLayout.NORTH);
        frame.add(txtrules,BorderLayout.CENTER);
        frame.add(btnplay,BorderLayout.SOUTH);

        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        InitialFrame frame=new InitialFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnplay) {
            ChessFrame Chessboard=new ChessFrame();
            frame.dispose();
        }
    }
}
