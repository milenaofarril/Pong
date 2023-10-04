package cenario;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import renderizacao.Cena;

import static com.jogamp.opengl.GL.GL_FRONT_AND_BACK;
import static com.jogamp.opengl.GL2GL3.GL_FILL;

public class Cenario {


    public static void coracao(GL2 gl) {
        double limite = Math.PI;
        double i, cX, cY, rX, rY;

        cX = -0.9f;
        cY = 0.9f;
        rX = 0.03f;
        rY = 0.03f;

        double limite2 = Math.PI;
        double cX2, cY2, rX2, rY2;

        cX2 = -0.95f;
        cY2 = 0.9f;
        rX2 = 0.03f;
        rY2 = 0.03f;

        gl.glPushMatrix();
        gl.glRotatef(0, 1, 0, 1);
        gl.glColor3f(1, 0.1f, 0.2f);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex2f(-0.98f, 0.9f);
        gl.glVertex2f(-0.87f, 0.9f);
        gl.glVertex2f(-0.924f, 0.84f);
        gl.glEnd();
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(1, 0.1f, 0.2f);
        gl.glBegin(GL2.GL_POLYGON);
        for (i = 0; i < limite; i += 0.01) {
            gl.glVertex2d(cX + rX * Math.cos(i), cY + rY * Math.sin(i));
        }
        gl.glEnd();
        gl.glPopMatrix();


        gl.glPushMatrix();
        gl.glColor3f(1, 0.1f, 0.2f);
        gl.glBegin(GL2.GL_POLYGON);
        for (i = 0; i < limite2; i += 0.01) {
            gl.glVertex2d(cX2 + rX2 * Math.cos(i), cY2 + rY2 * Math.sin(i));
        }
        gl.glEnd();
        gl.glPopMatrix();

    }

    public static void barra (GL2 gl, GLUT glut, float translacao){
        gl.glTranslatef(translacao, 0, 0);
        gl.glPushMatrix();
            gl.glColor3f(0, 0,0);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(0, -85, 0);
            gl.glScalef(0.5f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();
    }

    public static void bolinha(GL2 gl, GLUT glut){
        gl.glPushMatrix();
            gl.glColor3f(1, 0,0);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glScalef(0.1F,0.1F,0);
            glut.glutSolidSphere(50, 50, 50);
        gl.glPopMatrix();

    }
}
