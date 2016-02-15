import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame{
    BottomPanel bp = new BottomPanel();

    public TestFrame(){
        this.setSize(800, 600);
        this.setBackground(Color.gray);
        this.setVisible(true);
        this.add(bp);


    }



}
