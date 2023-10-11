package cenario;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

import static com.jogamp.opengl.GL.GL_FRONT_AND_BACK;
import static com.jogamp.opengl.GL2GL3.GL_FILL;
import static com.jogamp.opengl.math.FloatUtil.TWO_PI;

public class Cenario {


    public static void barra(GL2 gl, GLUT glut, float translacao) {
        gl.glPushMatrix();
        gl.glTranslatef(translacao, 0, 0);
        gl.glColor3f(1, 1, 1);
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        gl.glTranslatef(0, -92, 0);
        gl.glScalef(0.5f, 0.15f, 1);
        glut.glutSolidCube(50);
        gl.glPopMatrix();
    }

    public static void bolinha(GL2 gl, GLUT glut) {
        gl.glPushMatrix();
        gl.glColor3f(1, 0, 0);
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        gl.glScalef(0.1f, 0.17f, 0);
        glut.glutSolidSphere(50, 50, 50);
        gl.glPopMatrix();

    }

    public static void vida(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(-95, 92, 0);
        gl.glScalef(0.02F, 0.027F, 0);
        gl.glColor3f(1, 0, 0);
        gl.glBegin(GL2.GL_POLYGON);
        for (double a = 0; a < TWO_PI; a += 0.01F) {
            double radius = 10;
            double x = 16 * Math.pow(Math.sin(a), 3) * radius;
            double y = (13 * Math.cos(a) - 5 * Math.cos(2 * a) - 2 * Math.cos(3 * a) -
                    Math.cos(4 * a)) * radius;
            gl.glVertex2d(x, y);
        }
        gl.glEnd();
        gl.glPopMatrix();
    }

    public static void listaDeCoracoes(GL2 gl) {
        for (int i = 0; i < 3; i++) {
            gl.glPushMatrix();
            gl.glTranslatef(i * 7, 0, 0);
            vida(gl);
            gl.glPopMatrix();
        }
    }

    public static void obstaculo(GL2 gl, GLUT glut) {
        gl.glPushMatrix();
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        gl.glTranslatef(-66.6f, 80, 0);
        gl.glScalef(1.328f, 0.15f, 1);
        glut.glutSolidCube(50);
        gl.glPopMatrix();

    }

    public static void listaDeObstaculo(GL2 gl, GLUT glut) {
        for (int i = 0; i < 3; i++) {

            //Obstaculo Azul
            gl.glPushMatrix();
            gl.glColor3f(0, 0, 0.5f);
            gl.glTranslatef(i * 66.6f, 0, 0);
            obstaculo(gl, glut);
            gl.glPopMatrix();

            //Obstaculo Roxo
            gl.glPushMatrix();
            gl.glColor3f(0.5f, 0, 0.5f);
            gl.glTranslatef(i * 66.6f, -8f, 0);
            obstaculo(gl, glut);
            gl.glPopMatrix();

            //Obstaculo Amarelo
            gl.glPushMatrix();
            gl.glColor3f(1f, 1f, 0);
            gl.glTranslatef(i * 66.6f, -16.2f, 0);
            obstaculo(gl, glut);
            gl.glPopMatrix();
        }
    }
}

