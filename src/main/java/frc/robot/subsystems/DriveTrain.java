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
import frc.robot.commands.drivetrain.ManualDrive;

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

  // current limmit values
  private final int stallLimit = 35, freeLimit = 45;

  public DriveTrain() {
    super("Drivetrain");
    // set motor type and CAN port
    leftMaster = new CANSparkMax(RobotMap.L_DRIVE_MASTER_CAN,
      CANSparkMaxLowLevel.MotorType.kBrushless);
    leftFollower = new CANSparkMax(RobotMap.L_DRIVE_FOLLOWER_CAN,
      CANSparkMaxLowLevel.MotorType.kBrushless);

    rightMaster = new CANSparkMax(RobotMap.R_DRIVE_MASTER_CAN,
      CANSparkMaxLowLevel.MotorType.kBrushless);
    rightFollower = new CANSparkMax(RobotMap.R_DRIVE_FOLLOWER_CAN,
      CANSparkMaxLowLevel.MotorType.kBrushless);

    // set followers
    leftFollower.follow(leftMaster);
    rightFollower.follow(rightMaster);

    // set current limits
    leftMaster.setSmartCurrentLimit(stallLimit, freeLimit);
    leftFollower.setSmartCurrentLimit(stallLimit, freeLimit);
    rightMaster.setSmartCurrentLimit(stallLimit, freeLimit);
    rightFollower.setSmartCurrentLimit(stallLimit, freeLimit);

    // set inversion
    leftMaster.setInverted(false);
    leftFollower.setInverted(false);
    rightMaster.setInverted(true); 
    rightFollower.setInverted(true);

    // set speed to 0
    leftMaster.set(0);
    rightMaster.set(0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManualDrive());
  }

  /**
   * Used for basic differential steering.
   * @param left Left side power +1 to -1 (+%100 to -%100)
   * @param right Right side power +1 to -1 (+%100 to -%100)
   */
  public void differentialDrive(double left, double right) {
    leftMaster.set(left);
    rightMaster.set(right);
  }
}
