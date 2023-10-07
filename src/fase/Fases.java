package fase;

import cenario.Menu;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;

import java.awt.*;

public class Fases {

    private static void initGame(GL2 gl, GLUT glut, TextRenderer textRenderer, Color color) {

    }

    private static void primeiraFase(GL2 gl, GLUT glut, float translacao) {

    }

    private static void segundaFase(GL2 gl, GLUT glut, float translacao) {

    }

    private static void gameOver(GL2 gl, GLUT glut) {

    }

    public static void Fase(GL2 gl, GLUT glut, float translacao, TextRenderer textRenderer, Color color) {
        int nivel = 0;
        switch (nivel) {
            case 0:
                initGame(gl,glut,textRenderer, color);
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
}
