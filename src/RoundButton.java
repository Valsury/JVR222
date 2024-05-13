import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class RoundButton extends JButton {
    private Color color = new Color(193, 198, 196);

    public RoundButton(String label) {
        super(label);
        Dimension size = getPreferredSize();
        size.width = size.height = Math.min(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);

    }

    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.lightGray);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width-1, getSize().height-1);
        super.paintComponent(g);

    }
    protected  void paintBorder(Graphics g)
    {
        g.setColor(color);
        g.fillOval(0, 0, getSize().width-1, getSize().height-1);
    }

    Shape shape;
    public boolean contains(int x, int y)
    {
        if(shape == null ||
        !shape.getBounds().equals(getBounds()))
        {
            shape = new Ellipse2D() {
                @Override
                public double getX() {
                    return 0;
                }

                @Override
                public double getY() {
                    return 0;
                }

                @Override
                public double getWidth() {
                    return 0;
                }

                @Override
                public double getHeight() {
                    return 0;
                }

                @Override
                public boolean isEmpty() {
                    return false;
                }

                @Override
                public void setFrame(double x, double y, double w, double h) {

                }

                @Override
                public Rectangle2D getBounds2D() {
                    return null;
                }
            };
        }
        return  shape.contains(x,y);
    }
    public  Color getColor(){return  color;}

    public  void setColor(Color color){this.color = color;}

}