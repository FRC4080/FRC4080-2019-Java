/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.balltool;

import java.util.Date;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.BallTool;

public class LaunchBall extends Command {

  private final BallTool BALL_TOOL = Robot.ballTool;

  private final int EXTEND_WAIT_MILLI; // how long should we wait to retract?
  private long targetTime;
  Date date = new Date();

  public LaunchBall() {
    requires(BALL_TOOL);
    this.EXTEND_WAIT_MILLI = 1000; // wait for 1 second before retracting
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // extend launch cylender
    BALL_TOOL.extendLauncher();
    this.targetTime = EXTEND_WAIT_MILLI + date.getTime();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    BALL_TOOL.extendLauncher();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // hass time elaped?
    if(date.getTime() > this.targetTime) {
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
