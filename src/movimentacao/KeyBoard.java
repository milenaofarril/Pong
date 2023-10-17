package movimentacao;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import fase.Fases;
import renderizacao.Cena;

public class KeyBoard implements KeyListener {

    private final Cena cena;

    public KeyBoard(Cena cena) {
        this.cena = cena;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE || e.getKeyCode() == KeyEvent.VK_F)
            System.exit(0);

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && cena.translacao < 90)
            cena.translacao += 10;

        if (e.getKeyCode() == KeyEvent.VK_LEFT && cena.translacao > -90)
            cena.translacao -= 10;

        if (e.getKeyCode() == KeyEvent.VK_S) {
            Fases.nivel = 1;
        }
    }
}