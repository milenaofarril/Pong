package movimentacao;

import cenario.Scenario;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import fase.Level;

public class MovBall {

    private static float ballX = 0.0f;
    private static float ballY = 5f;
    private static float ballSpeedX = 2f;
    private static float ballSpeedY = 2f;
    private float obstacleWidth = 50;
    private float obstacleHeight = 13;
    private static int score;
    private final Scenario scenario = new Scenario();


    public void moveBall(GL2 gl, GLUT glut, float translate) {
        gl.glPushMatrix();
        gl.glTranslatef(ballX, ballY, 0);
        scenario.ball(gl, glut);
        gl.glPopMatrix();

        ballX += ballSpeedX;
        ballY += ballSpeedY;

        if (ballX < -90f || ballX > 90f) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballY > 80f) {
            ballSpeedY = -ballSpeedY;
        }
        checkCollision(translate);
    }

    private void checkCollision(float translate) {
        if (ballY <= -85 && ballX >= translate - 15 && ballX <= translate + 15) {
            ballSpeedY = -ballSpeedY;
            increasesScore();
        }

        if (ballX <= -200 || ballX >= 200) {
            ballSpeedX = -Math.abs(ballSpeedX);
        }
    }

    private void increasesScore() {
        if(Level.getLevel() == 1){
            score += 50;
        }else if(Level.getLevel() == 2){
            score += 25;
        }
    }

    public void checkCollisionObs(){
        for (int i = 0; i < 3; i++) {
            float obstacleX = i * 66.6f;
            float obstacleY = 72;
            if (checkBallObstacleCollision(ballX, ballY, obstacleX, obstacleY, obstacleWidth, obstacleHeight)) {
                ballSpeedY = -ballSpeedY;
            }
        }

        for (int i = 0; i < 3; i++) {
            float obstacleX = i * 66.6f;
            float obstacleY = 62;
            if (checkBallObstacleCollision(ballX, ballY, obstacleX, obstacleY, obstacleWidth, obstacleHeight)) {
                ballSpeedY = -ballSpeedY;
            }
        }

        for (int i = 0; i < 3; i++) {
            float obstacleX = i * -66.6f;
            float obstacleY = 48;

            if (checkBallObstacleCollision(ballX, ballY, obstacleX, obstacleY, obstacleWidth, obstacleHeight)) {
                ballSpeedY = -ballSpeedY;
            }
        }
    }

    private boolean checkBallObstacleCollision(float ballX, float ballY, float obstacleX, float obstacleY, float obstacleWidth, float obstacleHeight) {
        float obstacleLeft = obstacleX - obstacleWidth / 2;
        float obstacleRight = obstacleX + obstacleWidth / 2;
        float obstacleTop = obstacleY + obstacleHeight / 2;
        float obstacleBottom = obstacleY - obstacleHeight / 2;

        return ballX >= obstacleLeft && ballX <= obstacleRight && ballY >= obstacleBottom && ballY <= obstacleTop;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setBallSpeedX(float ballSpeedX) {
        this.ballSpeedX = ballSpeedX;
    }

    public void setBallSpeedY(float ballSpeedY) {
        this.ballSpeedY = ballSpeedY;
    }

    public void setBallY(float ballY) {
        this.ballY = ballY;
    }

    public float getBallSpeedX() {
        return ballSpeedX;
    }

    public float getBallSpeedY() {
        return ballSpeedY;
    }

    public float getBallY() {
        return ballY;
    }

    public float getBallX() {
        return ballX;
    }

    public void setBallX(float ballX) {
        this.ballX = ballX;
    }
}
