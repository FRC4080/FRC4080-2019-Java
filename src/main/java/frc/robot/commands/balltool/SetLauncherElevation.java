/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.balltool;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.BallTool;

public class SetLauncherElevation extends Command {

  // potential settings
  public static final int UP = 0;
  public static final int DOWN = 1;
  public static final int TOGGLE = 2;
  private final int setting;

  private static final BallTool BALL_TOOL = Robot.ballTool;

  public SetLauncherElevation(int setting) {
    requires(Robot.ballTool);
    this.setting = setting;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch (this.setting) {
      case 0:
        BALL_TOOL.elevationUp();
        break;
      
      case 1:
        BALL_TOOL.elevationDown();
        break;

      case 2:
        if (BALL_TOOL.isElevationUp()) {
          BALL_TOOL.elevationDown();
        } else {
          BALL_TOOL.elevationUp();
        }
        break;

      default:
        break;
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
