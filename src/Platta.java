import javax.swing.*;
import java.awt.*;

/**
 * Created by bepe14 on 2017-03-03.
 */
public class Platta {
    private Rectangle blocks;

    private Image Tile;

    Image platta = new ImageIcon("img/platta.png").getImage();

    public Platta() {
        Tile = new ImageIcon("img/plattan.png").getImage();
        blocks = new Rectangle();

        loadPlatta();
        }

        public void loadPlatta() {
            int x = 30;
            int y = 163;
            blocks = new Rectangle(x, y, 50, 250);
    }

    public void draw(Graphics g) {
        g.drawImage(platta, 32, 163, null);
    }
}
