package fase;

import cenario.Cenario;
import cenario.Menu;
import com.jogamp.opengl.GL2;

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

    private void initGame(GL2 gl, GLUT glut) {
        menu.titulo(gl, glut);
        menu.controles(gl);
        cenario.imagemFundo(gl);

    }

    private void primeiraFase(GL2 gl, GLUT glut, float translacao) {
        buildCenario(gl, glut, translacao);
    }

    private void segundaFase(GL2 gl, GLUT glut, float translacao) {
        buildCenario(gl, glut, translacao);
        cenario.listaDeObstaculo(gl, glut);
        cenario.imagemFundo(gl);

    }

    private void gameOver(GL2 gl, GLUT glut) {

    }

    public void fase(GL2 gl, GLUT glut, float translacao) {
        switch (nivel) {
            case 0:
                initGame(gl, glut);
                break;
            case 1:
                primeiraFase(gl, glut, translacao);
                break;
            case 2:
                segundaFase(gl, glut, translacao);
                break;
            case 3:
                gameOver(gl, glut);
                break;
        }

    }

    private void buildCenario(GL2 gl, GLUT glut, float translacao) {
        cenario.barra(gl, glut, translacao);
        mov.moveBall(gl, glut, translacao);
        cenario.pontuacao(gl,glut);
        cenario.listaDeCoracoes(gl);
        cenario.imagemFundo(gl);
    }
}
