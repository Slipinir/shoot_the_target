import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Janela extends BaseTutorial {

    private BufferedImage missel;

    private BufferedImage alvo;
    
    // Coordenadas do missel
    private int misselX, misselY;

    private int alvoX, alvoY;

    // Executa apenas uma vez, quando inicia a janela
    public void init() {
        try {
            // Cria a imagem
            missel = ImageIO.read(new File("../img/tiro.png"));
            // Coordenadas do missel
            misselX = misselY = 0;
            // Coordenadas do alvo (alterar para ficar centralizado na tela)
            alvoX = alvoY = 0;
            // Cria o alvo
            alvo = ImageIO.read(new File("../img/tiro.png"));
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
                    break;
                case 40:
                    misselY += 10;
                    break;
                case 37:
                    misselX -= 10;
                    break;
                case 39:
                    misselX += 10;
                    break;
            }
        }
        // Mostra o missel na tela, de acordo com as variaveis x e y
        g.drawImage(missel, misselX, misselY, this);

        // Mostra o alvo sempre no mesmo lugar
        g.drawImage(alvo, alvoX, alvoY, this);

        // Aqui verifica se o missel entrou em contato com o alvo
        //if (mise) {
        //}
        // Se entrar em contato, finalize a tela (veja os exemplos que o professor deu)
        // Mostre alguma mensagem que o jogador conseguiu atingir o alvo
    }

    public static void main(String[] args) {
        new Start(new Janela());
    }
}
