import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BottomPanel extends JPanel{
    TopPanel tp = new TopPanel();

    public BottomPanel(){
        this.setSize(600, 600);
        this.setBackground(Color.darkGray);
        this.setVisible(true);
        this.setLayout(null);
        this.add(tp);


    }
}

