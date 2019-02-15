/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.gamepads.F310;
import frc.robot.commands.balltool.SetLauncherElevation;
import frc.robot.commands.hatchtool.*;
import frc.robot.commands.liftjack.SetLift;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private final Joystick operatorJoystick = new Joystick(0);
  private final Joystick driverJoystick = new Joystick(1);
  private final Button operatorABtn = new JoystickButton(operatorJoystick, F310.A_BTN),
    operatorBBtn = new JoystickButton(operatorJoystick, F310.B_BTN),
    operatorXBtn = new JoystickButton(operatorJoystick, F310.X_BTN),
    operatorYButton = new JoystickButton(operatorJoystick, F310.Y_BTN),
    driverRTrigger = new JoystickButton(driverJoystick, F310.RIGHT_TRG);

  public OI() {
    operatorABtn.whenPressed(new SetHatchClaw(SetHatchClaw.RELEASE));
    operatorBBtn.whenPressed(new SetHatchClaw(SetHatchClaw.GRAB));
    operatorYButton.whenPressed(new SetHatchToolExtension(SetHatchToolExtension.TOGGLE));
    operatorXBtn.whenPressed(new SetLauncherElevation(SetLauncherElevation.TOGGLE));
    driverRTrigger.whenPressed(new SetLift(SetLift.TOGGLE));
  }
  
  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public Joystick getOperatorJoystick() {
    return operatorJoystick;
  }

  public Joystick getDriverJoystick() {
    return driverJoystick;
  }
}
