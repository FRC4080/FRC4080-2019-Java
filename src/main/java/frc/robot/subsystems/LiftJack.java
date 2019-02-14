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
 * Lifts front wheels of the floor with pneumatic cyliders to get onto second step in hab zone
 */
public class LiftJack extends Subsystem {
  // ** components **
  private final Solenoid jack_solenoid;

  public LiftJack() {
    super("Lift Jack");
    jack_solenoid = new Solenoid(RobotMap.LIFT_ROBOT);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void extendJack() {
    jack_solenoid.set(true);
  }
  
  public void retractJack() {
    jack_solenoid.set(false);
  }
}
