import javax.swing.*;
import java.awt.*;
/**
 * Created by bepe14 on 2017-03-03.
 */
public class Boll {
    private Rectangle blocks;

    private Image Tile;

    Image boll = new ImageIcon("img/boll.png").getImage();

    int x = 500;
    int y = 250;

    public Boll() {
        Tile = new ImageIcon("img/boll.png").getImage();
        blocks = new Rectangle();

        loadBoll();
    }

        public void loadBoll() {
            y = 250;
            x = 500;

        }

        public void draw(Graphics g) {
            g.drawImage(boll, x, y, null);
        }

        public void bollMove(int boll_dir) {
            y = y+boll_dir;
            x = x+boll_dir;
            if(y >= 500) {
                y = y-boll_dir;
            }
        }
}
