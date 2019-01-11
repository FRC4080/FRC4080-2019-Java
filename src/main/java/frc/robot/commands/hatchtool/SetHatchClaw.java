/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatchtool;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetHatchClaw extends Command {

  public static final Boolean GRAB = true;
  public static final Boolean RELEASE = false;
  private final Boolean setting;

  public SetHatchClaw(Boolean setting) {
    super("Set Hatch");
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.hatchTool);

    this.setting = setting;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (this.setting) {
      // Grab
      Robot.hatchTool.grabHatch();
    } else {
      // Release
      Robot.hatchTool.releaseHatch();
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
