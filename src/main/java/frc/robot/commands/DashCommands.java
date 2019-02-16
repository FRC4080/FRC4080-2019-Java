/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.balltool.InitBallTool;
import frc.robot.commands.balltool.LaunchBall;
import frc.robot.commands.balltool.SetLauncherElevation;
import frc.robot.commands.hatchtool.HatchToolInit;
import frc.robot.commands.hatchtool.SetHatchClaw;
import frc.robot.commands.hatchtool.SetHatchToolExtension;
import frc.robot.commands.liftjack.InitLift;
import frc.robot.commands.liftjack.SetLift;

/**
 * Add your docs here.
 */
public class DashCommands {
    public DashCommands() {
        // Lift Commands
        SmartDashboard.putData("Init Lift", new InitLift());
        SmartDashboard.putData("SetLift: Toggle", new SetLift(SetLift.TOGGLE));
        SmartDashboard.putData("SetLift: Lift", new SetLift(SetLift.LIFT));
        SmartDashboard.putData("SetLift: Retract", new SetLift(SetLift.RETRACT));

        // Hatch Tool Commands
        SmartDashboard.putData("Init Hatch Tool", new HatchToolInit());
        SmartDashboard.putData("Set Claw: Release", new SetHatchClaw(SetHatchClaw.RELEASE));
        SmartDashboard.putData("Set Claw: Grab", new SetHatchClaw(SetHatchClaw.GRAB));
        SmartDashboard.putData("Hatch Tool Extension: In", new SetHatchToolExtension(SetHatchToolExtension.IN));
        SmartDashboard.putData("Hatch Tool Extension: Out", new SetHatchToolExtension(SetHatchToolExtension.OUT));
        SmartDashboard.putData("Hatch Tool Extension: Toggle", new SetHatchToolExtension(SetHatchToolExtension.TOGGLE));

        // Ball Tool Commands
        SmartDashboard.putData("Init Ball Tool", new InitBallTool());
        SmartDashboard.putData("Launch Ball", new LaunchBall());
        SmartDashboard.putData("Set Launcher Elevation: Up", new SetLauncherElevation(SetLauncherElevation.UP));
        SmartDashboard.putData("Set Launcher Elevation: Down", new SetLauncherElevation(SetLauncherElevation.DOWN));
        SmartDashboard.putData("Set Launcher Elevation: Toggle", new SetLauncherElevation(SetLauncherElevation.TOGGLE));

        // Auto Modes
        SmartDashboard.putData("Driver Control Auto", new DriverConnAuto());
    }
}
