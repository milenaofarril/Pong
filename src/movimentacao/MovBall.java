package movimentacao;

import cenario.Cenario;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

public class MovBall {

    private static float ballX = 0.0f;

    private static float ballY = 80f;

    private static float ballSpeedX = 1f;

    private static float ballSpeedY = 1f;
    private int score = 0;
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

        if (ballY > 80f) {
            ballSpeedY = -ballSpeedY;
        }

        if (ballY < -100f) {
            ballX = 0f;
            ballY = 80f;
        }
        checkCollision(translacao);
    }

    private void checkCollision(float translacao) {
        if (ballY <= -85 && ballX >= translacao - 15 && ballX <= translacao + 15) {
            ballSpeedY = -ballSpeedY;
            increasesScore();
        }

        if (ballX <= -200) {
            ballSpeedX = -Math.abs(ballSpeedX);
        }

        if (ballX >= 200) {
            ballSpeedX = -Math.abs(ballSpeedX);
        }
    }

    private void increasesScore() {
        score += 50;
    }
}
