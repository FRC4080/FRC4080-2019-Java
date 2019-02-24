/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
  // *** Drive Motors CAN ID ***
  public static final int L_DRIVE_MASTER_CAN = 12; // 12
  public static final int L_DRIVE_FOLLOWER_CAN = 13; // 13
  public static final int R_DRIVE_MASTER_CAN = 10; // 10
  public static final int R_DRIVE_FOLLOWER_CAN = 11; // 11

  // *** PCM Ports ***
  // Single Solenoid
  public static final int HATCH_CLAW_GRAB = 0;
  public static final int LAUNCHER_UP = 3;
  public static final int LIFT_ROBOT = 4;
  
  // Double solenoid
  public static final int HATCH_TOLL_EXTEND = 1; // Automation Direct
  public static final int LAUNCH_BALL = 2; // Automation Direct
}
