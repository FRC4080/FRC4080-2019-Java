/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.liftjack;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.LiftJack;

public class SetLift extends Command {

  private static final LiftJack LIFT_JACK = Robot.liftJack;

  public static final int LIFT = 0;
  public static final int RETRACT = 1;
  public static final int TOGGLE = 2;
  private final int setting;

  public SetLift(int setting) {
    requires(LIFT_JACK);

    this.setting = setting;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    switch (this.setting) {
      case 0:
        LIFT_JACK.extendJack();
        break;

      case 1:
        LIFT_JACK.retractJack();
        break;

      case 2:
        if (LIFT_JACK.jackExtendedState()) {
          LIFT_JACK.retractJack();
        } else {
          LIFT_JACK.extendJack();
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
