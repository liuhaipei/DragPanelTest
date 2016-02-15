import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class TopPanel extends JPanel {

    public TopPanel(){
        this.setSize(1000, 1000);
        //this.setBackground(Color.white);
        this.setVisible(true);

        TestAdapter testAdapter = new TestAdapter();
        this.addMouseMotionListener(testAdapter);

//        MouseEventListener mouseListener = new MouseEventListener(this);
//        this.addMouseListener(mouseListener);
//        this.addMouseMotionListener(mouseListener);
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.gray);
        int x = 5;
        int y = 7;
        g2.draw(new Line2D.Double(x, y, 1000, 1000));
        g2.drawString("Line", x, 250);
    }
}

class MouseEventListener implements MouseInputListener {

    Point origin;
    //鼠标拖拽想要移动的目标组件
    JPanel panel;

    public MouseEventListener(JPanel jp) {
        this.panel = jp;
        origin = new Point();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    /**
     * 记录鼠标按下时的点
     */
    @Override
    public void mousePressed(MouseEvent e) {
        origin.x = e.getX();
        origin.y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    /**
     * 鼠标移进标题栏时，设置鼠标图标为移动图标
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    /**
     * 鼠标移出标题栏时，设置鼠标图标为默认指针
     */
    @Override
    public void mouseExited(MouseEvent e) {
        panel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }

    /**
     * 鼠标在标题栏拖拽时，设置窗口的坐标位置
     * 窗口新的坐标位置 = 移动前坐标位置+（鼠标指针当前坐标-鼠标按下时指针的位置）
     */
    @Override
    public void mouseDragged(MouseEvent e) {

        Point p = panel.getLocation();
        int x = p.x + (e.getX() - origin.x);
        int y = p.y + (e.getY() - origin.y);



        if((x>0) || (y>0)){
            panel.setLocation(0,0);
        }

        else if((x<-400) || (y<-400)){
            panel.setLocation(-400,-400);
        }
        else {
            panel.setLocation(
                    p.x + (e.getX() - origin.x),
                    p.y + (e.getY() - origin.y));
        }
        //System.out.println("panel x: " + p.x + (e.getX() - origin.x));
        //System.out.println("panel y: " + p.y + (e.getY() - origin.y));
    }

    @Override
    public void mouseMoved(MouseEvent e) {}

    private boolean move(){

        return true;
    }





}