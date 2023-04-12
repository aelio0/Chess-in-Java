import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePawnFrame implements ActionListener {
    JFrame frame;
    JButton[] btn=new JButton[4];
    JLabel[] lbl=new JLabel[4];

    Piece[][] matrix;
    boolean white;
    int i,j;


    public ChangePawnFrame(Piece[][] matrix,boolean white, int i, int j){
        int cnt;

        this.matrix=matrix;
        this.white=white;
        this.i=i;
        this.j=j;

        frame=new JFrame("Cambia il pedone in una nuova pedina");
        for(cnt=0;cnt<4;cnt++){
            btn[cnt]=new JButton();
            btn[cnt].addActionListener(this);
        }
        btn[0].setText("Rook");
        btn[1].setText("Horse");
        btn[2].setText("Bishop");
        btn[3].setText("Queen");

        for(cnt=0;cnt<4;cnt++){
            lbl[cnt]=new JLabel("",SwingConstants.CENTER);
        }

        if(white){
            try {
                Image imgR = ImageIO.read(getClass().getResource("Images/Wrook.png"));
                lbl[0].setIcon(new ImageIcon(imgR));
                Image imgH = ImageIO.read(getClass().getResource("Images/WHorse.png"));
                lbl[1].setIcon(new ImageIcon(imgH));
                Image imgB = ImageIO.read(getClass().getResource("Images/WBishop.png"));
                lbl[2].setIcon(new ImageIcon(imgB));
                Image imgQ = ImageIO.read(getClass().getResource("Images/WQueen.png"));
                lbl[3].setIcon(new ImageIcon(imgQ));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        else{
            try {
                Image imgR = ImageIO.read(getClass().getResource("Images/Brook.png"));
                lbl[0].setIcon(new ImageIcon(imgR));
                Image imgH = ImageIO.read(getClass().getResource("Images/BHorse.png"));
                lbl[1].setIcon(new ImageIcon(imgH));
                Image imgB = ImageIO.read(getClass().getResource("Images/BBishop.png"));
                lbl[2].setIcon(new ImageIcon(imgB));
                Image imgQ = ImageIO.read(getClass().getResource("Images/BQueen.png"));
                lbl[3].setIcon(new ImageIcon(imgQ));
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }


        frame.setLayout(new GridLayout(2,4));
        frame.add(lbl[0]);
        frame.add(lbl[1]);
        frame.add(lbl[2]);
        frame.add(lbl[3]);

        frame.add(btn[0]);
        frame.add(btn[1]);
        frame.add(btn[2]);
        frame.add(btn[3]);

        frame.setSize(500, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn[0]) {
            matrix[i][j].setPiece('r');
            frame.dispose();
        }
        if (e.getSource() == btn[1]) {
            matrix[i][j].setPiece('h');
            frame.dispose();
        }
        if (e.getSource() == btn[2]) {
            matrix[i][j].setPiece('b');
            frame.dispose();
        }
        if (e.getSource() == btn[3]) {
            matrix[i][j].setPiece('q');
            frame.dispose();
        }
    }
}
