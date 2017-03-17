
/**
 * Created by bepe14 on 2017-02-24.
 */

import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Spelplan extends JPanel implements Runnable{

    static final int GWIDTH = 1024, GHEIGHT = 576;
    private Image dbImage;
    private Graphics dbg;
    private Thread spel;
    private volatile boolean running = false;
    World world;

    Image platta = ImageIO.read(new File("img/platta.png"));
    JLabel picLabel = new JLabel(new ImageIcon(platta));


    public Spelplan() throws IOException {


        world = new World();
        JFrame frame = new JFrame("JFrame Example");
        setSize(1044, 596);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setFocusable(true);
        requestFocus();

    }


    public void run() {
        while (running) {
            spelRender();
            paintScreen();
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