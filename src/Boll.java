import javax.swing.*;
import java.awt.*;
/**
 * Created by bepe14 on 2017-03-03.
 */
public class Boll {
    private Rectangle blocks;
    Platta platta;

    int diameter = 32;





    private Image Tile;

    Image boll = new ImageIcon("img/boll.png").getImage();

    int x = 500;
    int y = 250;
    int ydirr = 1;
    int xdirr = 1;

    public Boll() {
        Tile = new ImageIcon("img/boll.png").getImage();
        blocks = new Rectangle(x, y, 32, 32);

        platta = new Platta();

        platta.loadPlatta();


        loadBoll();
    }

        public void loadBoll() {
            blocks = new Rectangle(x, y, 32, 32);


        }

        public void draw(Graphics g) {
            g.drawImage(boll, x, y, null);
        }



        public void bollMovey() {
            y = y+ydirr;
            if(y >= 522) {
                ydirr = -1;
            }
            if(y <= 0) {
                ydirr = 1;
            }



        }

        public void bollMovex(){
            x = x-xdirr;
            if(collision()) {
                xdirr = -1;
            }
        }

        public boolean overlaps () {

            if(platta.getBounds().intersects(getBounds())) {
                xdirr = -1;
                System.out.println("lol");
            }
            if(platta.getBounds2().intersects(getBounds())) {
                xdirr = 1;
            }
            return platta.getBounds().intersects(getBounds());
        }

        public boolean collision() {
            return platta.getBounds().intersects(getBounds());
        }

    public boolean collision2() {
        return platta.getBounds2().intersects(getBounds());
    }

        public Rectangle getBounds() {
            return new Rectangle(x, y, diameter, diameter);
        }


}
