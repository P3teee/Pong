import javax.swing.*;
import java.io.IOException;

/**
 * Created by bepe14 on 2017-02-24.
 */
public class Spel extends JFrame {
    Spelplan sp;

    public Spel() throws IOException {
        sp = new Spelplan();
        setSize(1040, 615);
        setVisible(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(sp);
    }

    public static void main (String[] args) throws IOException {
        Spel test = new Spel();

    }
}
