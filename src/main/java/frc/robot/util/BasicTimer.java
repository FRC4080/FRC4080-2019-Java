/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.util;

import java.time.Instant;

/**
 * Add your docs here.
 */
public class BasicTimer {

    private Instant runUntil;
    private long targetDuration;

    public BasicTimer(long targetDuration){
        this.runUntil = Instant.now().plusMillis(targetDuration);
        this.targetDuration = targetDuration;
    }

    public boolean timeElapsed(){
        return Instant.now().isAfter(this.runUntil);
    }
        
    public void restartTimer(){
        this.runUntil = Instant.now().plusMillis(this.targetDuration);
    }
    
    public void resetTimer(long targetDuration) {
        this.runUntil = Instant.now().plusMillis(targetDuration);
    }

}
