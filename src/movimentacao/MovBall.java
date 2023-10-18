package movimentacao;

import cenario.Cenario;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class MovBall {

    public static float paddleX = 0.0f;

    private static float ballX = 0.0f;

    private static float ballY = 0.0f;

    private static float ballSpeedX = 0.8f;

    private static float ballSpeedY = 0.8f;

    private Cenario cenario = new Cenario();


    public void moveBall(GL2 gl, GLUT glut, float translacao) {
        gl.glPushMatrix();
        gl.glTranslatef(ballX, ballY, 0);
        cenario.bolinha(gl, glut);
        gl.glPopMatrix();

        ballX += ballSpeedX;
        ballY += ballSpeedY;


        if (ballX < -90f || ballX > 90f) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballY > 90f) {
            ballSpeedY = -ballSpeedY;
        }


        if(ballY > -80f && (ballX >= translacao - 10f && ballX <= translacao + 10f)) {
            ballSpeedY = -ballSpeedY;
        }

    }
}
