// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.File;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer 
{
   private final SwerveSubsystem drivetrain  = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
                                                                                "swerve"));


  public RobotContainer() 
  {
    configureBindings();
  }

  private void configureBindings() 
  {}

  public Command getAutonomousCommand() 
  {
    return new YAShareableAuto(
            drivetrain,
            new Translation2d(1.0, 0.0), // Move forward at 1 m/s
            0.0, 
            true,
            1.0 
        );  
  }
}
