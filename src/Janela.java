import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Rectangle;
import javax.swing.JOptionPane;

public class Janela extends BaseTutorial {
	
    private BufferedImage missel;
    private BufferedImage alvo;
    
    // Retângulos utilizados para detecção de colisão
    private Rectangle r1;
    private Rectangle r2;
    
    // Coordenadas gerais (Missel, Alvo, e Retângulos)
    private int misselX, misselY;
    private int alvoX, alvoY;
    private int r1x, r1y;

    // Executa apenas uma vez, quando inicia a janela
    public void init() {
        try {
			r1 = new Rectangle(128,128);
			r2 = new Rectangle(700, 0, 128,128);
            // Cria a imagem
            missel = ImageIO.read(new File("../img/missile.png"));
            // Coordenadas do missel
            misselX = misselY = 0;
            // Coordenadas do alvo (alterar para ficar centralizado na tela)
            alvoX = alvoY = 0;
            // Cria o alvo
            alvo = ImageIO.read(new File("../img/bullseye.png"));
            // Coordenadas dos retângulos
            r1x = r1y = 0;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
	
    public void paint(Graphics g) {
        // Verifica se alguma tecla foi pressionada
        if (keyPressed) { 
            // Verifica qual tecla foi pressionada
            // Se foi para cima, diminui o y para mover o missel para cima
            // Se foi para baixo, aumenta o y para mover o missel para baixo
            // Adapte a quantidade que se movimenta de acordo com a necessidade
            // E etc
            switch (keyCode) {
                case 38: 
                    misselY -= 10;
                    r1y -= 10;
                    break;
                case 40:
                    misselY += 10;
                    r1y += 10;
                    break;
                case 37:
                    misselX -= 10;
                    r1x -= 10;
                    break;
                case 39:
                    misselX += 10;
                    r1x += 10;
                    break;
            }
        }
        // Mostra o missel na tela, de acordo com as variaveis x e y
        g.drawImage(missel, misselX, misselY, this);
		
        // Mostra o alvo sempre no mesmo lugar
        // Para mostrar o alvo no meio do lado direito, x = 672 e y = (height/2)-80
        g.drawImage(alvo, 672, 0, this);
        
        r1.setLocation(r1x, r1y);

        // Aqui verifica se o missel entrou em contato com o alvo
        
        if(r1.intersects(r2)) {
			JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
			System.exit(ABORT);
        }
        
        // Se entrar em contato, finalize a tela (veja os exemplos que o professor deu)
        // Mostre alguma mensagem que o jogador conseguiu atingir o alvo
    }

    public static void main(String[] args) {
		Start start = new Start(new Janela());
		start.setSize(800,200);
    }
}
