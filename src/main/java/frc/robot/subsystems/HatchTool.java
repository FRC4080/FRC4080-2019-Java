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
import frc.robot.commands.hatchtool.HatchToolInit;

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

  // Hatch Tool States
  private Boolean isExtended; // tells me if the hatch tool has been set to be extended or not

  public HatchTool() {
    super("Hatch Tool");
    claw_solenoid = new Solenoid(RobotMap.HATCH_CLAW_GRAB);
    extender_solenoid = new Solenoid(RobotMap.HATCH_TOLL_EXTEND);

    extender_solenoid.set(false);
    this.isExtended = false;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new HatchToolInit());
  }

  public void stowTool() {
    // retract into frame perimeter
    // set pcm ports for a single to off
    extender_solenoid.set(false);
    this.isExtended = false;
  }

  public void exstendTool() {
    // extend outside frame perimeter
    // set pcm ports for a single to on
    extender_solenoid.set(true);
    this.isExtended = true;
  }

  public void releaseHatch() {
    // close hatch claw
    // turn a double solenoid forward
    claw_solenoid.set(false);
  }

  public void grabHatch() {
    // open hatch claw
    // turn a double solenoid reverse
    claw_solenoid.set(true);
  }

  public boolean getIsExtended() {
    return this.isExtended;
  }
}
