package tictactoe.timer;

import tictactoe.components.Initiator;

/**
 * @author Khoi Nguyen
 */

public class Timer implements java.lang.Runnable{
    private volatile boolean isRunning = true;

    @Override
    public void run(){
        this.countDown();
    }

    private void countDown(){
        int timer = 11;
        while(timer > 0 && isRunning && !Thread.interrupted()){
            try{
                timer--;
                Thread.sleep(1000L);
            } catch (InterruptedException exception){
                isRunning = false;
            }
            Initiator.GUI.setTimeRemaining(timer);
        }

        restartTimer();
    }

    private void restartTimer(){
        Initiator.player.switchPlayer();
        startTimer();
    }

    public void startTimer(){
        Initiator.thread = new Thread(new Timer());
        Initiator.thread.start();
    }
}
