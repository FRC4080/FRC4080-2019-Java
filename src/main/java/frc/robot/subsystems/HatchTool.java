/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
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
  private final DoubleSolenoid claw_solenoid;


  public HatchTool() {
    super("Hatch Tool");
    claw_solenoid = new DoubleSolenoid(RobotMap.HATCH_CLAW_FWD, RobotMap.HATCH_CLAW_REV);
  }

  @Override
  public void initDefaultCommand() {
  }

  public void ejectHatch() {
    // Push hatch away
    // exstend tool and release hatch
  }

  public void stowTool() {
    // retract into frame perimeter
    // set pcm ports for a double to reverse and another single to off
  }

  public void exstendTool() {
    // extend outside frame perimeter
    // set pcm ports for a double to forward and another single to on
  }

  public void releaseHatch() {
    // close hatch claw
    // turn a double solenoid forward
    claw_solenoid.set(Value.kForward);
  }

  public void grabHatch() {
    // open hatch claw
    // turn a double solenoid reverse
    claw_solenoid.set(Value.kReverse);
  }
}
