package cenario;

import com.jogamp.opengl.GL2;


public class Iluminacao {
    public boolean liga  = true;
    public int tonalizacao = GL2.GL_SMOOTH;

    public void iluminacaoAmbiente(GL2 gl){

        float luzAmbiente[] = {0.2f,0f,0f,0.5f};
        float posicaoLuz[] = {-50.0f,50.0f,100.0f,1.0f};

        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, posicaoLuz, 0);

    }

    public void ligaLuz(GL2 gl){

        gl.glEnable(GL2.GL_COLOR_MATERIAL);

        gl.glEnable(GL2.GL_LIGHTING);

        gl.glEnable(GL2.GL_LIGHT0);

        gl.glShadeModel(tonalizacao);


    }

    public void iluminacaoDifusa(GL2 gl) {
        float luzDifusa[] = {1f, 1.0f, 1,0f, 1.0f}; //cor
        float posicaoLuz[] = {-0.0f, 0.0f, 100.0f, 0.0f}; //1.0 pontual

        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_DIFFUSE, luzDifusa, 0);
        gl.glLightfv(GL2.GL_LIGHT0, GL2.GL_POSITION, posicaoLuz, 0);
    }

}
