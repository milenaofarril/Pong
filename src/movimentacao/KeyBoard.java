package movimentacao;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import fase.Level;
import renderizacao.Cena;

public class KeyBoard implements KeyListener {

    private final Cena cena;

    private final Level level = new Level();

    public KeyBoard(Cena cena) {
        this.cena = cena;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
            System.exit(0);

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && cena.translate < 90)
            cena.translate += 10;

        if (e.getKeyCode() == KeyEvent.VK_LEFT && cena.translate > -90)
            cena.translate -= 10;

        if (e.getKeyCode() == KeyEvent.VK_P) {
            level.setPause(true);
        } else if (e.getKeyCode() == KeyEvent.VK_R) {
            level.setPause(false);
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            level.setLevel(1);
        }
        if (e.getKeyCode() == KeyEvent.VK_F) {
            level.setLevel(0);
            level.reset();
        }

    }
}
