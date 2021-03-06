/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.balltool;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.util.BasicTimer;
import frc.robot.subsystems.BallTool;

public class LaunchBall extends Command {

  private final BallTool BALL_TOOL = Robot.ballTool;

  private final int EXTEND_WAIT_MILLI; // how long should we wait to retract?

  private BasicTimer timer;

  public LaunchBall() {
    requires(BALL_TOOL);
    this.EXTEND_WAIT_MILLI = 1500; // wait for 1.5 second(s) before retracting
    this.timer = new BasicTimer(this.EXTEND_WAIT_MILLI);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // extend launch cylender
    BALL_TOOL.extendLauncher();
    timer.restartTimer();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // hass time elaped?
    if(timer.timeElapsed()) {
      // then return true
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    // retract launch cylender
    BALL_TOOL.retractLauncher();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    // retract launch cylender
    BALL_TOOL.retractLauncher();
  }
}
