import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyControl implements KeyListener{
    public boolean isPressUp, isPressDown, isPressLeft, isPressRight;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();
        if(input == KeyEvent.VK_W){
            isPressUp = true;
        }
        if(input == KeyEvent.VK_A){
            isPressLeft = true;
        }
        if(input == KeyEvent.VK_S){
            isPressDown = true;
        }
        if(input == KeyEvent.VK_D){
            isPressRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int input = e.getKeyCode();
        if(input == KeyEvent.VK_W){
            isPressUp = false;
        }
        if(input == KeyEvent.VK_A){
            isPressLeft = false;
        }
        if(input == KeyEvent.VK_S){
            isPressDown = false;
        }
        if(input == KeyEvent.VK_D){
            isPressRight = false;
        }
    }
}
