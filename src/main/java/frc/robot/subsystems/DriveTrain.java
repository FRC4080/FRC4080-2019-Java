/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

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

  public DriveTrain() {
    super("Drivetrain");
    leftMaster = new CANSparkMax(RobotMap.L_DRIVE_MASTER_CAN,
      CANSparkMaxLowLevel.MotorType.kBrushless);
    leftFollower = new CANSparkMax(RobotMap.L_DRIVE_FOLLOWER_CAN,
      CANSparkMaxLowLevel.MotorType.kBrushless);

    rightMaster = new CANSparkMax(RobotMap.R_DRIVE_MASTER_CAN,
      CANSparkMaxLowLevel.MotorType.kBrushless);
    rightFollower = new CANSparkMax(RobotMap.R_DRIVE_FOLLOWER_CAN,
      CANSparkMaxLowLevel.MotorType.kBrushless);
  }

  @Override
  public void initDefaultCommand() {
  }
}
