// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ShareableAuto;
import frc.robot.generated.TunerConstants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer 
{
  private final Drivetrain m_Drivetrain = new Drivetrain(TunerConstants.DrivetrainConstants, TunerConstants.FrontLeft,
                      TunerConstants.FrontRight, TunerConstants.BackLeft, TunerConstants.BackRight);

  public RobotContainer() 
  {
    configureBindings();
  }

  private void configureBindings() 
  {}

  public Command getAutonomousCommand() 
  {
    return new ShareableAuto(m_Drivetrain, 0, 0);
  }
}
