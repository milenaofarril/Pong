package fase;

import cenario.Cenario;
import cenario.Menu;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;
import movimentacao.MovBall;
import renderizacao.Cena;

import java.awt.*;

public class Fases {

    private final Cenario cenario = new Cenario();
    private final Menu menu = new Menu();
    private final MovBall mov = new MovBall();

    public static int nivel = 0;
    public static boolean pause = false;

    private void initGame(GL2 gl, GLUT glut, TextRenderer text100, TextRenderer text40) {
        menu.titulo(gl, glut, text100, Color.GREEN);
        menu.controles(gl, glut, text40, Color.YELLOW);

    }

    private void primeiraFase(GL2 gl, GLUT glut, float translacao, TextRenderer text30) {
        buildCenario(gl, glut, translacao, text30);
    }

    private void segundaFase(GL2 gl, GLUT glut, float translacao, TextRenderer text30) {
        buildCenario(gl, glut, translacao, text30);
        cenario.listaDeObstaculo(gl, glut);

    }

    private void gameOver(GL2 gl, GLUT glut) {

    }

    public void fase(GL2 gl, GLUT glut, float translacao, TextRenderer text100, TextRenderer text40,
                     TextRenderer text30) {
        switch (nivel) {
            case 0:
                initGame(gl, glut, text100, text40);
                break;
            case 1:
                primeiraFase(gl, glut, translacao, text30);
                break;
            case 2:
                segundaFase(gl, glut, translacao, text30);
                break;
            case 3:
                gameOver(gl, glut);
                break;
        }

    }

    private void buildCenario(GL2 gl, GLUT glut, float translacao, TextRenderer text30) {
        cenario.barra(gl, glut, translacao);
        mov.moveBall(gl, glut, translacao);
        cenario.pontuacao(gl, glut, text30, Color.GREEN);
        cenario.listaDeCoracoes(gl);
    }
}
