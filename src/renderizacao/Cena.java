package renderizacao;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;
import fase.Fases;
import textura.Textura;

import java.awt.*;

public class Cena implements GLEventListener {
    private static GL2 gl;
    private static GLUT glut;
    private float xMin, xMax, yMin, yMax, zMin, zMax;
    GLU glu;
    public float angulo;
    public float translacao;
    public float eixoX;
    public float eixoY;
    private final Fases fases = new Fases();
    public float limite;
    private Textura textura = null;
    private int totalTextura = 4;
    public static final String FACE1 = "image/backgroundMenu.png";
    public static final String FACE2 = "image/background.png";
    public static final String FACE3 = "image/gameover.png";
    public static final String FACE4 = "image/pause.png";



    @Override
    public void init(GLAutoDrawable drawable) {
        glu = new GLU();
        GL2 gl = drawable.getGL().getGL2();

        xMin = yMin = zMin = -100;
        xMax = yMax = zMax = 100;

        gl.glEnable(GL2.GL_DEPTH_TEST);
        angulo = 0;
        translacao = 0.0f;
        eixoY = 0;
        eixoX = 0;
        limite = 1;

        textura = new Textura(totalTextura);

    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();


        gl.glClearColor(0, 0, 0, 0);
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_LINE);

        fases.fase(gl,glut,translacao);

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
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }

}