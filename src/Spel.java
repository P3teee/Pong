import javax.swing.*;
import java.io.IOException;

/**
 * Created by bepe14 on 2017-02-24.
 */
public class Spel extends JFrame {
    Spelplan sp;

    /**
     * Här hämtar den spelplanen från spelplan och ritar upp den
     * @throws IOException
     */

    public Spel() throws IOException {
        sp = new Spelplan();
        setSize(1040, 615);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(sp);
    }


    /**
     * Startar spelet
     * @param args
     * @throws IOException
     */
    public static void main (String[] args) throws IOException {
        Spel test = new Spel();

    }
}
