import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tiro {
    private static BufferedImage tiro;

    public static BufferedImage getTiro() {
        try {
            if (tiro == null)
                tiro = ImageIO.read(new File("../img/tiro.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return tiro;
    }
}
