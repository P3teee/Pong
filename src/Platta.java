import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by bepe14 on 2017-03-03.
 */

/**
 * Sätter upp variabler som behövs för att rita ut plattan och bestämma deras position
 * Hämtar också bilden för platta
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

    /**
     * Sätter tile till bilden på plattan
     *
     */
    public Platta() {
        Tile = new ImageIcon("img/plattan.png").getImage();

    }

    /**
     * Ritar ut 2 plattor
     * @param g
     */
    public void drawPlatta(Graphics g) {

        g.drawImage(platta, x1, y1, null);
        g.drawImage(platta, x2, y2, null);

    }

    /**
     * Flyttar den första(vänstra) plattan upp
     */
    public void plattaMoveYplus() {

        y1 = y1-20;

    }

    /**
     * Flyttar den första(vänstra) plattan ner
     */
    public void plattaMoveYminus() {

        y1 = y1+20;

    }

    /**
     * Flyttar den andra(högra) plattan upp
     */
    public void plattaMoveYplus2() {

        y2 = y2-20;

    }

    /**
     * Flyttar den andra(högra) plattan ner
     */
    public void plattaMoveYminus2() {

        y2 = y2+20;

    }

    /**
     * Skickar information om vart den första(vänstra) plattan är är i x och y led, gör en "hitbox" runt den
     * @return Skickar information om vart den första(vänstra) plattan är är i x och y led, gör en "hitbox" runt den
     *
     */
    public Rectangle getBounds() {
        return new Rectangle(x1, y1, diax, diay);
    }

    /**
     * Skickar information om vart den andra(högra) plattan är i x och y led, gör en "hitbox" runt den
     * @return Skickar information om vart den andra(högra) plattan är i x och y led, gör en "hitbox" runt den
     */
    public Rectangle getBounds2() {
        return new Rectangle(x2, y2, diax, diay);
    }


}
