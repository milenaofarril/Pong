package cenario;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import movimentacao.MovBall;


public class Menu {

    private MovBall mov = new MovBall();
    public void title(GL2 gl){
        gl.glPushMatrix();
        gl.glColor3f(0,1,0);
        bigText(gl,0, 65,"");
        gl.glPopMatrix();
    }

    public void punctuation(GL2 gl) {
        bigText(gl,65, 90, "PONTUAÇÃO: ");
        bigText(gl, 85, 90, Integer.toString(mov.getScore()));
    }


    public void bigText(GL2 gl, int x, int y, String phrase) {
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        GLUT glut = new GLUT();
        gl.glRasterPos2f(x, y);
        glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, phrase);

    }
    public void averageText(GL2 gl, int x, int y, String phrase) {
        GLUT glut = new GLUT();
        gl.glRasterPos2f(x, y);
        glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, phrase);
    }

    public void smallText(GL2 gl, int x, int y, String phrase) {
        GLUT glut = new GLUT();
        gl.glRasterPos2f(x, y);
        glut.glutBitmapString(GLUT.BITMAP_9_BY_15, phrase);
    }
}