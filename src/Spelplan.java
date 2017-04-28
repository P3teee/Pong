
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

public class Spelplan extends JPanel implements Runnable {

    static final int GWIDTH = 1024, GHEIGHT = 576;
    private Image dbImage;
    private Graphics dbg;
    private Thread spel;
    private volatile boolean running = false;
    World world;
    Platta platta;
    Boll boll;

    /* Image plattaa = ImageIO.read(new File("img/platta.png"));
    JLabel picLabel = new JLabel(new ImageIcon(plattaa)); */


    public Spelplan() throws IOException {
        boll = new Boll();
        platta = new Platta();
        world = new World();
        JFrame frame = new JFrame("JFrame Example");
        setSize(1044, 596);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        requestFocus();



    addKeyListener(new KeyAdapter() {
        @Override
        public void keyPressed (KeyEvent e){
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                platta.plattaMove(-10);
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                platta.plattaMove(10);
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


    public void run() {
        while (running) {
            spelRender();
            paintScreen();
            boll.bollMove(1);

        }
    }

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


    public void draw(Graphics g) {
        world.draw(g);
        platta.draw(g);
        boll.draw(g);

    }

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

    public void addNotify() {
        super.addNotify();
        startSpel();
    }

    private void startSpel() {
        if (spel == null || !running) {
            spel = new Thread(this);
            spel.start();
            running = true;
        }
    }



}