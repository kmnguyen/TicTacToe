package tictactoe.timer;

import tictactoe.components.Initiator;

/**
 * @author Khoi Nguyen
 */

/**
 * This class will run a thread to keep track of a timer. The original purpose was to have an AI
 * playing against a player but I could not get to making an AI
 */
public class Timer implements java.lang.Runnable{

    // This is here as an attempt to stop thread without using thread.stop()
    private volatile boolean isRunning = true;


    @Override
    public void run(){
        this.countDown();
    }

    /**
     * Timer countdown
     */
    private void countDown(){
        int timer = 11;

        // Counting down
        while(timer > 0 && isRunning && !Thread.interrupted()){
            try{
                timer--;
                Thread.sleep(1000L);
            } catch (InterruptedException exception){
                isRunning = false;
            }
            Initiator.GUI.setTimeRemaining(timer);
        }

        // Restart if timer reach 0 and player should be switched
        restartTimer();
    }

    /**
     * Switch player and start the timer thread
     */
    private void restartTimer(){
        Initiator.player.switchPlayer();
        startTimer();
    }

    /**
     * Start new timer thread
     */
    public void startTimer(){
        Initiator.thread = new Thread(new Timer());
        Initiator.thread.start();
    }
}
