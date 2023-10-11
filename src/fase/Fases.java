package fase;

import cenario.Cenario;
import cenario.Menu;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;

import java.awt.*;

public class Fases {

    private static void initGame(GL2 gl, GLUT glut, TextRenderer text100, TextRenderer text40) {
        Menu.titulo(gl, glut, text100, Color.GREEN);
        Menu.controles(gl, glut, text40, Color.YELLOW);

    }

    private static void primeiraFase(GL2 gl, GLUT glut, float translacao) {
        buildCenario( gl, glut,translacao);

    }

    private static void segundaFase(GL2 gl, GLUT glut, float translacao) {
        buildCenario(gl, glut,translacao);
        Cenario.listaDeObstaculo(gl,glut);

    }

    private static void gameOver(GL2 gl, GLUT glut) {

    }

    public static void fase(GL2 gl, GLUT glut, float translacao, TextRenderer text100, TextRenderer text40) {
        int nivel = 0;
        switch (nivel) {
            case 0:
                initGame(gl,glut,text100,text40);
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
    public static void buildCenario(GL2 gl, GLUT glut, float translacao){
        Cenario.bolinha(gl, glut);
        Cenario.barra(gl, glut, translacao);
        Cenario.listaDeCoracoes(gl);

    }
}
