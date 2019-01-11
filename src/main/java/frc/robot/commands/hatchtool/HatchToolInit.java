/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.hatchtool;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class HatchToolInit extends CommandGroup {
  /**
   * Puts the hatch tool in its initial state
   */
  public HatchToolInit() {

    addParallel(new StowHatchTool());
    addParallel(new SetHatchClaw(SetHatchClaw.GRAB));
  }
}
