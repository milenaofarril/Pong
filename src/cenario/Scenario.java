package cenario;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import textura.Texture;

import static com.jogamp.opengl.GL.GL_FRONT_AND_BACK;
import static com.jogamp.opengl.GL2GL3.GL_FILL;
import static com.jogamp.opengl.math.FloatUtil.TWO_PI;

public class Scenario {
    private final Lighting lighting = new Lighting();
    public float limit = 1;
    private Texture texture = new Texture(5);
    public static final String FACE1 = "src/image/backgroundMenu.png";
    public static final String FACE2 = "src/image/background.png";
    public static final String FACE3 = "src/image/gameover.png";
    public static final String FACE4 = "src/image/pause.png";
    public static final String FACE5 = "src/image/final.png";
    private static int numHeart = 5;
    public float[][] obstacleProperties = {
            {0, 0, 0.5f},
            {0.5f, 0, 0.5f},
            {1f, 1f, 0}
    };


    public void bar(GL2 gl, GLUT glut, float translation) {
        gl.glPushMatrix();
        gl.glTranslatef(translation, 0, 0);
        gl.glColor3f(0, 0, 0);
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        gl.glTranslatef(0, -92, 0);
        gl.glScalef(0.5f, 0.15f, 1);
        glut.glutSolidCube(50);
        gl.glPopMatrix();
    }

    public void ball(GL2 gl, GLUT glut) {
        gl.glPushMatrix();
        gl.glColor3f(1, 0, 0);
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        glut.glutSolidSphere(5, 50, 50);

        if (lighting.on) {
            lighting.ambientLighting(gl);
            lighting.lightsOn(gl);
        }
        gl.glPopMatrix();
    }

    public void life(GL2 gl) {
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

    public void HeartList(GL2 gl) {
        for (int i = 0; i < numHeart; i++) {
            gl.glPushMatrix();
            gl.glTranslatef(i * 7, 0, 0);
            life(gl);
            gl.glPopMatrix();
        }
    }

    public void removeHeart() {
        if (numHeart > 0) {
            numHeart--;
        }
    }

    public void drawObstacle(GL2 gl, GLUT glut) {
        gl.glPushMatrix();
        gl.glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
        gl.glTranslatef(-66.6f, 40, 0);
        gl.glScalef(0.6f, 0.15f, 1);
        glut.glutSolidCube(50);
        gl.glPopMatrix();

    }

    public void obstaclesList(GL2 gl, GLUT glut) {
        for (int i = 0; i < 3; i++) {
                gl.glPushMatrix();
                gl.glColor3f(obstacleProperties[i][0], obstacleProperties[i][1], obstacleProperties[i][2]);
                gl.glTranslatef(i * 66f, 8.2f, 0);
                drawObstacle(gl, glut);
                gl.glPopMatrix();
        }
    }

    public void backgroundMenu(GL2 gl) {
        gl.glPushMatrix();
        texture.setAutomatic(false);

        texture.createTexture(gl, FACE1, 0);

        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-100.0f, -100.0f, -1);
        gl.glTexCoord2f(0.0f, limit);
        gl.glVertex3f(-100.0f, 100.0f, -1);
        gl.glTexCoord2f(limit, limit);
        gl.glVertex3f(100.0f, 100.0f, -1);
        gl.glTexCoord2f(limit, 0.0f);
        gl.glVertex3f(100.0f, -100.0f, -1);
        gl.glEnd();

        texture.disableTexture(gl, 0);
        gl.glPopMatrix();
    }

    public void imgBackground(GL2 gl) {
        gl.glPushMatrix();
        texture.setAutomatic(false);

        texture.createTexture(gl, FACE2, 1);

        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-100.0f, -100.0f, -1);
        gl.glTexCoord2f(0.0f, limit);
        gl.glVertex3f(-100.0f, 100.0f, -1);
        gl.glTexCoord2f(limit, limit);
        gl.glVertex3f(100.0f, 100.0f, -1);
        gl.glTexCoord2f(limit, 0.0f);
        gl.glVertex3f(100.0f, -100.0f, -1);
        gl.glEnd();

        texture.disableTexture(gl, 1);
        gl.glPopMatrix();
    }

    public void imgGameOver(GL2 gl) {
        gl.glPushMatrix();
        texture.setAutomatic(false);

        texture.createTexture(gl, FACE3, 2);

        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-100.0f, -100.0f, 1);
        gl.glTexCoord2f(0.0f, limit);
        gl.glVertex3f(-100.0f, 100.0f, 1);
        gl.glTexCoord2f(limit, limit);
        gl.glVertex3f(100.0f, 100.0f, 1);
        gl.glTexCoord2f(limit, 0.0f);
        gl.glVertex3f(100.0f, -100.0f, 1);
        gl.glEnd();

        texture.disableTexture(gl, 2);
        gl.glPopMatrix();
    }

    public void imgPause(GL2 gl) {
        gl.glPushMatrix();
        texture.setAutomatic(false);

        texture.createTexture(gl, FACE4, 3);

        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-100.0f, -100.0f, 1);
        gl.glTexCoord2f(0.0f, limit);
        gl.glVertex3f(-100.0f, 100.0f, 1);
        gl.glTexCoord2f(limit, limit);
        gl.glVertex3f(100.0f, 100.0f, 1);
        gl.glTexCoord2f(limit, 0.0f);
        gl.glVertex3f(100.0f, -100.0f, 1);
        gl.glEnd();

        texture.disableTexture(gl, 3);
        gl.glPopMatrix();
    }

    public void imgFinal(GL2 gl) {
        gl.glPushMatrix();
        texture.setAutomatic(false);

        texture.createTexture(gl, FACE5, 4);

        gl.glColor3f(1f, 1f, 1f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-100.0f, -100.0f, 1);
        gl.glTexCoord2f(0.0f, limit);
        gl.glVertex3f(-100.0f, 100.0f, 1);
        gl.glTexCoord2f(limit, limit);
        gl.glVertex3f(100.0f, 100.0f, 1);
        gl.glTexCoord2f(limit, 0.0f);
        gl.glVertex3f(100.0f, -100.0f, 1);
        gl.glEnd();

        texture.disableTexture(gl, 4);
        gl.glPopMatrix();
    }

    public int getNumHeart() {
        return numHeart;
    }

    public void setNumHeart(int numHeart) {
        this.numHeart = numHeart;
    }
}

