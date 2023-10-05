package cenario;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;
import renderizacao.Renderer;

import java.awt.*;
import static com.jogamp.opengl.GL.GL_FRONT_AND_BACK;
import static com.jogamp.opengl.GL2GL3.GL_FILL;

public class Menu {
    public static void inicio(GL2 gl, GLUT glut, TextRenderer textRenderer, Color cor){
        gl.glPushMatrix();
        gl.glColor3f(0, 0,0);
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        gl.glScalef(1,1.5f,1);
        glut.glutSolidCube(70);
        gl.glPopMatrix();

        texto(gl,250, 440, cor, "PONG", textRenderer);

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