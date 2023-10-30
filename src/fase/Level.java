package fase;

import cenario.Scenario;
import cenario.Menu;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import movimentacao.MovBall;

public class Level {

    private final Scenario scenario = new Scenario();
    private final Menu menu = new Menu();
    private final MovBall mov = new MovBall();
    private static int level;
    private static boolean pause;

    private void initGame(GL2 gl) {
        menu.title(gl);
        scenario.backgroundMenu(gl);
    }

    private void firstLevel(GL2 gl, GLUT glut, float translation) {
        if (scenario.getNumHeart() > 0 && !isPause()) {
            buildScenario(gl, glut, translation);
        } else if (scenario.getNumHeart() <= 0) {
            gameOver(gl);
        } else {
            pause(gl);
        }
        if (mov.getScore() == 200) {
            level = 2;
            mov.setBallSpeedX(3.5f);
            mov.setBallSpeedY(3.5f);
        }

        if (mov.getBallY() < -100f) {
            mov.setBallX(0);
            mov.setBallY(5f);
            scenario.removeHeart();
            mov.setBallSpeedY(2f);
            mov.setBallSpeedX(2f);
        }
    }

    private void secondLevel(GL2 gl, GLUT glut, float translation) {
        if (mov.getScore() == 400) {
            youWon(gl);
        } else if (scenario.getNumHeart() > 0 && !isPause()) {
            buildScenario(gl, glut, translation);
        } else if (scenario.getNumHeart() <= 0) {
            gameOver(gl);
        } else {
            pause(gl);
        }

        if (mov.getBallY() < -100f) {
            mov.setBallX(0);
            mov.setBallY(5f);
            mov.setBallSpeedX(3.5f);
            mov.setBallSpeedY(3.5f);
            scenario.removeHeart();
        }
    }


    private void pause(GL2 gl) {
        menu.title(gl);
        scenario.imgPause(gl);
    }

    private void gameOver(GL2 gl) {
        menu.title(gl);
        scenario.imgGameOver(gl);
    }

    private void youWon(GL2 gl) {
        menu.title(gl);
        scenario.imgFinal(gl);
    }

    public void reset() {
        setLevel(0);
        setPause(false);
        mov.setScore(0);
        mov.setBallX(0);
        mov.setBallY(5f);
        mov.setBallSpeedX(2f);
        mov.setBallSpeedY(2f);
        scenario.setNumHeart(5);

    }

    public void level(GL2 gl, GLUT glut, float translation) {
        switch (level) {
            case 0:
                initGame(gl);
                break;
            case 1:
                firstLevel(gl, glut, translation);
                break;
            case 2:
                secondLevel(gl, glut, translation);
                break;
        }

    }

    private void buildScenario(GL2 gl, GLUT glut, float translation) {
        scenario.bar(gl, glut, translation);
        mov.moveBall(gl, glut, translation);
        menu.points(gl);
        scenario.HeartList(gl);
        scenario.imgBackground(gl);
        if(getLevel() == 2){
            scenario.obstaclesList(gl, glut);
            mov.checkCollisionObs();
        }
    }

    public static int getLevel() {
        return level;
    }

    public static void setLevel(int level) {
        Level.level = level;
    }

    public static boolean isPause() {
        return pause;
    }

    public static void setPause(boolean pause) {
        Level.pause = pause;
    }
}
