package cenario;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;


public class Menu {
    public void titulo(GL2 gl, GLUT glut){
        gl.glPushMatrix();
        gl.glColor3f(0,1,0);
        desenhaTextoGrande(gl,0, 65,"PONG");
        gl.glPopMatrix();


    }
    public void controles(GL2 gl){

        gl.glColor3f(1,1,0);
        desenhaTextoMedio(gl,-30, 50, "S | Start (Inicia o jogo)");
        desenhaTextoMedio(gl,-30, 40, " P | Pause (Pausa o jogo)");
        desenhaTextoMedio(gl,-30, 30, " R | Resume (Retoma o jogo)");
        desenhaTextoMedio(gl,-30, 20, " F | Finish (Menu inicial)");
        desenhaTextoMedio(gl,-30, 10, "-> | Mover para direita");
        desenhaTextoMedio(gl,-30, 0, "<- | Mover para esquerda");
        desenhaTextoMedio(gl,-30, -10, "Objetivo:  Evitar a bolinha de cair");
        desenhaTextoMedio(gl,-30, -20, "Como Jogar: Movimentar a barra inferior para a esquerda e direita");
        desenhaTextoMedio(gl,-30, -30, "Jogador vence ao completar todas as fases sem perder as 5 vidas.");

    }

    public void pausaJogo(GL2 gl){

        desenhaTextoGrande(gl,0, 0, "PAUSE");

    }



    public void desenhaTextoGrande(GL2 gl, int x, int y, String frase) {

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
        GLUT glut = new GLUT();
        gl.glRasterPos2f(x, y);;
        glut.glutBitmapString(GLUT.BITMAP_TIMES_ROMAN_24, frase);

    }
    public void desenhaTextoMedio(GL2 gl, int x, int y, String frase) {
        GLUT glut = new GLUT();
        gl.glRasterPos2f(x, y);
        glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, frase);
    }

    public void desenhaTextoPequeno(GL2 gl, int x, int y, String frase) {
        GLUT glut = new GLUT();
        gl.glRasterPos2f(x, y);
        glut.glutBitmapString(GLUT.BITMAP_9_BY_15, frase);
    }



}