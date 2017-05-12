import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by bepe14 on 2017-03-03.
 */
public class Platta {
    public Rectangle platta1;
    public Rectangle platta2;

    int diax = 30;
    int diay = 250;

    private Image Tile;
    int y1 = 163;
    int x1 = 30;
    int x2 = 900;
    int y2 = 163;




    Image platta = new ImageIcon("img/platta.png").getImage();

    public Platta() {
        Tile = new ImageIcon("img/plattan.png").getImage();
        platta1 = new Rectangle(x1, y1, 50, 250);
        platta2 = new Rectangle(x2, y2, 50, 250);

        loadPlatta();
        }

        public void loadPlatta() {

            platta1 = new Rectangle(x1, y1, 50, 250);
            platta2 = new Rectangle(x2, y2, 50, 250);
    }

    public void draw(Graphics g) {

        g.drawImage(platta, x1, y1, null);
        g.drawImage(platta, x2, y2, null);

    }


    public void plattaMoveYplus() {

        y1 = y1-10;

    }

    public void plattaMoveYminus() {

        y1 = y1+10;

    }

    public void plattaMoveYplus2() {

        y2 = y2-10;

    }

    public void plattaMoveYminus2() {

        y2 = y2+10;

    }

    public Rectangle getBounds() {
        return new Rectangle(x1, y1, diax, diay);
    }
    public Rectangle getBounds2() {
        return new Rectangle(x2, y2, diax, diay);
    }


}
