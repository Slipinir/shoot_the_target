import java.awt.Graphics;

public class Janela extends BaseTutorial {

    public void init() {
    }

    public void paint(Graphics g) {
        if (keyPressed && keyCode == 32)
        g.drawImage(Tiro.getTiro(), 0, 0, this);
    }

    public static void main(String[] args) {
        new Start(new Janela());
    }
}
