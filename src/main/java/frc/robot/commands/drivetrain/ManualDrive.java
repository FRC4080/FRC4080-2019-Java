/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.gamepads.F310;
import frc.robot.subsystems.LiftJack;
/*
* Driver contorlled (Manual) driving.
*/
public class ManualDrive extends Command {

  private Joystick driverJoystick = Robot.m_oi.getDriverJoystick();
  private LiftJack liftJack = Robot.liftJack;

  private final double JACK_DOWN_SPEED;
  public static final double REDUCED_SPEED_VALUE = 0.75;
  private final double SPEED_MULTIPLYER;

  public ManualDrive(double speedMultiplyer) {
    requires(Robot.driveTrain);
    this.JACK_DOWN_SPEED = 0.5;
    this.SPEED_MULTIPLYER = speedMultiplyer;
  }

  public ManualDrive() {
    requires(Robot.driveTrain);
    this.JACK_DOWN_SPEED = 0.5;
    this.SPEED_MULTIPLYER = 1d;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(liftJack.jackExtendedState()){
      Robot.driveTrain.differentialDrive(driverJoystick.getRawAxis(F310.LEFT_Y) * JACK_DOWN_SPEED,
                                     driverJoystick.getRawAxis(F310.RIGHT_Y) * JACK_DOWN_SPEED);
    } else {
      Robot.driveTrain.differentialDrive(driverJoystick.getRawAxis(F310.LEFT_Y) * SPEED_MULTIPLYER,
                                    driverJoystick.getRawAxis(F310.RIGHT_Y) * SPEED_MULTIPLYER);
    }

    
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
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
