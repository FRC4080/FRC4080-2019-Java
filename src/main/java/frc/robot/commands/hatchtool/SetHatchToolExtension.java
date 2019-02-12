/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatchtool;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.HatchTool;


public class SetHatchToolExtension extends Command {

  // potential settings
  public static final int IN = 0;
  public static final int OUT = 1;
  public static final int TOGGLE = 2;
  private final int setting;

  private static final HatchTool HATCH_TOOL = Robot.hatchTool;

  public SetHatchToolExtension(int setting) {
    this.setting = setting;
    requires(Robot.hatchTool);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch (this.setting) {
      case 0:
        HATCH_TOOL.stowTool();
        break;
      
      case 1:
        HATCH_TOOL.exstendTool();
        break;

      case 2:
        if(HATCH_TOOL.getIsExtended() == true) {
          HATCH_TOOL.stowTool();
        } else {
          HATCH_TOOL.exstendTool();
        }
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
    // Run once
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
