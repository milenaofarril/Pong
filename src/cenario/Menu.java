package cenario;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;
import renderizacao.Renderer;

import java.awt.*;
import static com.jogamp.opengl.GL.GL_FRONT_AND_BACK;
import static com.jogamp.opengl.GL2GL3.GL_FILL;

public class Menu {
    public static void titulo(GL2 gl, GLUT glut, TextRenderer textRenderer, Color cor){

        texto(gl,780, 850, cor, "PONG", textRenderer);

    }
    public static void controles(GL2 gl, GLUT glut, TextRenderer textRenderer, Color cor){

        texto(gl,750, 750, cor, "P | Pause (Pausa o jogo)", textRenderer);
        texto(gl,750, 700, cor, "F | Finish (Menu inicial)", textRenderer);
        texto(gl,750, 650, cor, "S | Start (Inicia o jogo)", textRenderer);
        texto(gl,750, 600, cor, "→ | Mover para direita", textRenderer);
        texto(gl,750, 550, cor, "← | Mover para esquerda", textRenderer);
        texto(gl,400, 400, cor, "Objetivo:  Evitar a bolinha de cair", textRenderer);
        texto(gl,400, 350, cor, "Como Jogar: Movimentar a barra inferior para a esquerda e direita", textRenderer);
        texto(gl,400, 300, cor, "Jogador vence ao completar todas as fases sem perder as 5 vidas.", textRenderer);
    }

    public static void texto(GL2 gl, int xPosicao, int yPosicao, Color cor, String frase, TextRenderer textRenderer){
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        textRenderer.beginRendering(Renderer.screenWidth, Renderer.screenHeight);
        textRenderer.setColor(cor);
        textRenderer.draw(frase, xPosicao, yPosicao);
        textRenderer.endRendering();
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
    }
}