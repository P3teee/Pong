
/**
 * Created by bepe14 on 2017-02-24.
 */

import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 *  Sätter upp variabler som behövs för att skapa våran spelplan.
 */

public class Spelplan extends JPanel implements Runnable {

    static final int GWIDTH = 1024, GHEIGHT = 576;
    private Image dbImage;
    private Graphics dbg;
    private Thread spel;
    private volatile boolean running = false;
    World world;
    Boll boll;


    /**
     *
     *  Bygger upp spelplanen
     *
     * @throws IOException
     */
    public Spelplan() throws IOException {
        boll = new Boll();
        world = new World();
        JFrame frame = new JFrame("JFrame Example");
        setSize(1044, 596);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        requestFocus();


        /**
         *
         * Sätter upp kontrollerna för att kunna styra platterna.
         */
    addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed (KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_W) {
                boll.platta.plattaMoveYplus();
            }
            if (e.getKeyCode() == KeyEvent.VK_S) {
                boll.platta.plattaMoveYminus();
            }
            if (e.getKeyCode() == KeyEvent.VK_O) {
                boll.platta.plattaMoveYplus2();
            }
            if (e.getKeyCode() == KeyEvent.VK_L) {
                boll.platta.plattaMoveYminus2();
            }
        }
@Override
    public void keyReleased(KeyEvent e) {

    }
@Override
    public void keyTyped(KeyEvent e) {

    }
});
        }

    /**
     *
     * Här bestämms vad som händer när man kör programmet med hjälp av methoder från andra klasser.
     */
    public void run() {
        while (running) {
            spelRender();
            paintScreen();
            boll.bollMovey();
            boll.bollMovex();
            boll.overlaps();



        }
    }

    /**
     *
     * Här rendreras det som ska vara på spelplanen
     *
     */
    private void spelRender() {
        if (dbImage == null) {
            dbImage = createImage(GWIDTH, GHEIGHT);
            if (dbImage == null) {
                System.out.println("dbImage is still null");
                return;
            } else {
                dbg = dbImage.getGraphics();
            }
        }
        dbg.setColor(Color.WHITE);
        dbg.fillRect(0, 0, GWIDTH, GHEIGHT);
        draw(dbg);
    }


    /**
     * Här hämtas grafiken för de olika sakerna
     * @param g
     */
    public void draw(Graphics g) {
        world.draw(g);
        boll.platta.drawPlatta(g);
        boll.drawBoll(g);

    }

    /**
     *
     * Här ritar den ut vad som ska visas på skärmen
     */
    private void paintScreen() {
        Graphics g;
        try {
            g = this.getGraphics();
            if (dbImage != null && g != null) {
                g.drawImage(dbImage, 0, 0, null);
            }
            g.dispose();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     *
     *
     */
    public void addNotify() {
        super.addNotify();
        startSpel();
    }

    /**
     *
     * Vad som händer när spelet startas
     */
    private void startSpel() {
        if (spel == null || !running) {
            spel = new Thread(this);
            spel.start();
            running = true;
        }
    }



}