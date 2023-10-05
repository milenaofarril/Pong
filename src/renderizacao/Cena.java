package renderizacao;

import cenario.Cenario;
import cenario.Menu;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;

import java.awt.*;

public class Cena implements GLEventListener {
    private float xMin, xMax, yMin, yMax, zMin, zMax;
    GLU glu;
    public float angulo;
    public float translacao;
    private TextRenderer text15;
    private TextRenderer text20;

    @Override
    public void init(GLAutoDrawable drawable) {
        glu = new GLU();
        GL2 gl = drawable.getGL().getGL2();

        xMin = yMin = zMin = -100;
        xMax = yMax = zMax = 100;

        gl.glEnable(GL2.GL_DEPTH_TEST);
        angulo = 0;
        translacao = 0;

        text15 = new TextRenderer(new Font("Arial", Font.BOLD, 15));
        text20 = new TextRenderer(new Font("Arial", Font.BOLD, 20));
    }

    @Override
    public void display(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();


        gl.glClearColor(1, 1, 1, 1);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);


        gl.glColor3f(1, 0, 0);


        //Cenario.coracao(gl);
        Cenario.bolinha(gl, glut);
        Cenario.barra(gl, glut, translacao);
        Cenario.vida(gl);
        //Menu.inicio(gl, glut, text15, Color.GREEN);
        Cenario.obstaculoAzul(gl, glut);
        Cenario.obstaculoRoxo(gl, glut);
        Cenario.obstaculoAzulClaro(gl, glut);

        gl.glFlush();

    }


    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL2 gl = drawable.getGL().getGL2();

        if (height == 0)
            height = 1;

        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(xMin, xMax, yMin, yMax, zMin, zMax);

        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        System.out.println("Reshape: " + width + ", " + height);
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

}