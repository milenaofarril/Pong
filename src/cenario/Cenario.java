package cenario;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

import static com.jogamp.opengl.GL.GL_FRONT_AND_BACK;
import static com.jogamp.opengl.GL2GL3.GL_FILL;
import static com.jogamp.opengl.math.FloatUtil.TWO_PI;

public class Cenario {



    //public static void coracao(GL2 gl) {
    //    double limite = Math.PI;
    //    double i, cX, cY, rX, rY;
    //
    //    cX = -0.9f;
    //    cY = 0.9f;
    //    rX = 0.03f;
    //    rY = 0.03f;
    //
    //    double limite2 = Math.PI;
    //    double cX2, cY2, rX2, rY2;
    //
    //    cX2 = -0.95f;
    //    cY2 = 0.9f;
    //    rX2 = 0.03f;
    //    rY2 = 0.03f;
    //
    //    gl.glPushMatrix();
    //    gl.glRotatef(0, 1, 0, 1);
    //    gl.glColor3f(1, 0.1f, 0.2f);
    //    gl.glBegin(GL2.GL_TRIANGLES);
    //    gl.glVertex2f(-0.98f, 0.9f);
    //    gl.glVertex2f(-0.87f, 0.9f);
    //    gl.glVertex2f(-0.924f, 0.84f);
    //    gl.glEnd();
    //    gl.glPopMatrix();
    //
    //    gl.glPushMatrix();
    //    gl.glColor3f(1, 0.1f, 0.2f);
    //    gl.glBegin(GL2.GL_POLYGON);
    //    for (i = 0; i < limite; i += 0.01) {
    //        gl.glVertex2d(cX + rX * Math.cos(i), cY + rY * Math.sin(i));
    //    }
    //    gl.glEnd();
    //    gl.glPopMatrix();
    //
    //
    //    gl.glPushMatrix();
    //    gl.glColor3f(1, 0.1f, 0.2f);
    //    gl.glBegin(GL2.GL_POLYGON);
    //    for (i = 0; i < limite2; i += 0.01) {
    //        gl.glVertex2d(cX2 + rX2 * Math.cos(i), cY2 + rY2 * Math.sin(i));
    //    }
    //    gl.glEnd();
    //    gl.glPopMatrix();
    //}


    public static void barra (GL2 gl, GLUT glut, float translacao){
        gl.glPushMatrix();
        gl.glTranslatef(translacao, 0, 0);
        gl.glColor3f(0, 0,0);
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        gl.glTranslatef(0, -92, 0);
        gl.glScalef(0.5f,0.15f,1);
        glut.glutSolidCube(50);
        gl.glPopMatrix();
    }

    public static void bolinha(GL2 gl, GLUT glut){
        gl.glPushMatrix();
        gl.glColor3f(1, 0,0);
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        gl.glScalef(0.1f,0.17f,0);
        glut.glutSolidSphere(50, 50, 50);
        gl.glPopMatrix();

    }



    public static void vida(GL2 gl) {
        gl.glPushMatrix();
        gl.glTranslatef(-95, 92, 0);
        gl.glScalef(0.02F,0.027F,0);
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

    public static void obstaculoAzul (GL2 gl, GLUT glut){
        gl.glPushMatrix();
            gl.glColor3f(0, 0,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(-66.6f, 80, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();

        gl.glPushMatrix();
            gl.glColor3f(0, 0,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(0, 80, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();

        gl.glPushMatrix();
            gl.glColor3f(0, 0,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(66.6f, 80, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();
    }

    public static void obstaculoRoxo (GL2 gl, GLUT glut){
        gl.glPushMatrix();
        gl.glColor3f(0.6f, 0,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(-66.6f, 72.4f, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(0.6f, 0,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(0, 72.4f, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(0.6f, 0,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(66.6f, 72.4f, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();
    }

    public static void obstaculoAzulClaro (GL2 gl, GLUT glut){
        gl.glPushMatrix();
        gl.glColor3f(0, 0.6f,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(-66.6f, 64.8f, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(0, 0.6f,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(0, 64.8f, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();

        gl.glPushMatrix();
        gl.glColor3f(0, 0.6f,1);
            gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
            gl.glTranslatef(66.6f, 64.8f, 0);
            gl.glScalef(1.328f,0.15f,1);
            glut.glutSolidCube(50);
        gl.glPopMatrix();
    }
}