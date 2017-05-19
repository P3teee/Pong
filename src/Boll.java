import javax.swing.*;
import java.awt.*;
/**
 * Created by bepe14 on 2017-03-03.
 */

/**
 * Sätter upp variabler för plattan, diametern på bollen, vart bollen är och riktningen vart bollen är på väg i x och y
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

    /**
     * Bestämmer bilden på bollen och sätter upp klassen platta
     */
    public Boll() {
        Tile = new ImageIcon("img/boll.png").getImage();


        platta = new Platta();



    }


    /**
     * Ritar ut bollen
     * @param g
     */
    public void drawBoll(Graphics g) {
            g.drawImage(boll, x, y, null);
        }


    /**
     * Bestämmer vad som händer med bollen i y led och hur det rör sig i y led
     */
        public void bollMovey() {
            y = y+ydirr;
            if(y >= 522) {
                ydirr = -1;
            }
            if(y <= 0) {
                ydirr = 1;
            }



        }

    /**
     * Bestämmer vad som händer med bollen i x led och hur det rör sig i x led
     */

        public void bollMovex(){
            x = x-xdirr;

        }

    /**
     * Bestämmer om vad som ska hända om bollen rör vid en av plattorna
     * @return Skickar information om plattan och bollen rör vid varandra
     */
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


    /**
     * Hämtar information om vart bollen befinner sig i x och y led, gör en "hitbox" runt den
     * @return Hämtar information om vart bollen befinner sig i x och y led, gör en "hitbox" runt den
     */
    public Rectangle getBounds() {
            return new Rectangle(x, y, diameter, diameter);
        }


}
