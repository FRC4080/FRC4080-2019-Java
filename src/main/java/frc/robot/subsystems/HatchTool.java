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
 * Mechanism for retrieving hatch panels from feeder and depositing on low goals.
 * The bench top test version will just test solenoids (and switches?)
 */
public class HatchTool extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // ** Components **
  private final Solenoid claw_solenoid;
  private final Solenoid extender_solenoid;

  public HatchTool() {
    super("Hatch Tool");
    claw_solenoid = new Solenoid(RobotMap.HATCH_CLAW_GRAB);
    this.extender_solenoid = new Solenoid(RobotMap.HATCH_TOLL_EXTEND);

    this.extender_solenoid.set(false);

  }

  @Override
  public void initDefaultCommand() {
  }

  public void stowTool() {
    // retract into frame perimeter
    // set pcm ports for a single to off
    this.extender_solenoid.set(false);
  }

  public void exstendTool() {
    // extend outside frame perimeter
    // set pcm ports for a single to on
    this.extender_solenoid.set(true);
  }

  public void releaseHatch() {
    // close hatch claw
    // turn a double solenoid forward
    this.claw_solenoid.set(false);
  }

  public void grabHatch() {
    // open hatch claw
    // turn a double solenoid reverse
    this.claw_solenoid.set(true);
  }

  public boolean getIsExtended() {
    return this.extender_solenoid.get();
  }
}
