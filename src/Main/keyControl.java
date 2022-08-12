package Main;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;

public class keyControl implements KeyListener{
    public boolean isPressUp, isPressDown, isPressLeft, isPressRight;
    public boolean isPressInteract;
    public boolean isPressEnter;
    public boolean isPressTab;
    public gamePanel gp;
    public boolean isAttack;
    public keyControl(gamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int input = e.getKeyCode();
        if(input == KeyEvent.VK_ENTER && this.gp.gameState == this.gp.dialogueState){
            isPressEnter = true;
            this.gp.UI.continueDialogue();
        }
        //command in the start screen
        if(this.gp.gameState == this.gp.startState){
            if(input == KeyEvent.VK_S){
                if(this.gp.UI.startMenuChoose<2){
                    this.gp.UI.startMenuChoose++;
                }
            }
            if(input == KeyEvent.VK_W){
                if(this.gp.UI.startMenuChoose>0){
                    this.gp.UI.startMenuChoose--;
                }
            }
            if(input == KeyEvent.VK_ENTER && this.gp.UI.startMenuChoose == 0){
                gp.gameState = gp.playingState;
            }
            if(input == KeyEvent.VK_ENTER && this.gp.UI.startMenuChoose == 2){
                System.exit(0);
            }
        }
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
        if(input == KeyEvent.VK_E){
            isPressInteract = true;
        }
        if(gp.gameState == gp.playingState&&input == KeyEvent.VK_J){
            isAttack = true;
        }
        if(input == KeyEvent.VK_P&&gp.gameState == gp.playingState) {
            isPressTab = true;
            gp.gameState = gp.propertyState;
        }else if(gp.gameState == gp.propertyState && input == KeyEvent.VK_P){
            gp.gameState = gp.playingState;
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
        if(input == KeyEvent.VK_E){
            isPressInteract = false;
        }
        if(input == KeyEvent.VK_ENTER){
            isPressEnter = false;
        }
        if(input == KeyEvent.VK_P){
            isPressTab = false;
        }
        if(input == KeyEvent.VK_J){
            isAttack = false;
        }
    }
}
