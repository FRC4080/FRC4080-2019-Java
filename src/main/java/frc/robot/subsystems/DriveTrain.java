/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Robot drivetrain. Will be 4 REV NEOs (possibly + 2 MiniCIMs).
 * All controllers on CAN bus.
 */
public class DriveTrain extends Subsystem {
  // ** Components **
  private final CANSparkMax leftMaster;
  private final CANSparkMax leftFollower;
  private final CANSparkMax rightMaster;
  private final CANSparkMax rightFollower;

  @Override
  public void initDefaultCommand() {
  }
}
