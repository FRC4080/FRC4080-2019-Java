/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class BallTool extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // ** Components **
  private final Solenoid elevation_solenoid;
  private final Solenoid launchSolenoid;

  // Ball Tool States
  private Boolean isElevationUp; // tells me if the elevation has been set to be up or down

  public BallTool() {
    super("Ball Tool");
    elevation_solenoid = new Solenoid(RobotMap.LAUNCHER_UP);
    launchSolenoid = new Solenoid(RobotMap.LAUNCH_BALL);

    elevation_solenoid.set(false);
    isElevationUp = false;
  }

  @Override
  public void initDefaultCommand() {
    
    // Set the default command for a subsystem here.
  }

  public void extendLauncher() {
    launchSolenoid.set(true);
  }

  public void retractLauncher() {
    launchSolenoid.set(false);
  }

  public void elevationUp() {
    elevation_solenoid.set(true);
    this.isElevationUp = true;
  }

  public void elevationDown() {
    elevation_solenoid.set(false);
    this.isElevationUp = false;
  }

  public boolean isElevationUp() {
    return this.isElevationUp;
  }
}
