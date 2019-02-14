/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.balltool.InitBallTool;
import frc.robot.commands.drivetrain.ManualDrive;
import frc.robot.commands.hatchtool.HatchToolInit;

public class DriverConnAuto extends CommandGroup {
  /**
   * Add your docs here.
   */
  public DriverConnAuto() {
    addParallel(new InitBallTool());
    addParallel(new HatchToolInit());
    addParallel(new ManualDrive());
  }
}
