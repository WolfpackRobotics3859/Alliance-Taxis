// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.SwerveSubsystem;

public class YAShareableAuto extends Command 
{
  private final SwerveSubsystem drivetrain;
  private final Timer timer = new Timer();
  private final Translation2d translation;
  private final double rotation;
  private final boolean fieldRelative;
  private final double duration;

  public YAShareableAuto(SwerveSubsystem drivetrain, Translation2d translation, double rotation, boolean fieldRelative, double duration)
  {
    this.drivetrain = drivetrain;
    this.translation = translation;
    this.fieldRelative = fieldRelative;
    this.rotation = rotation;
    this.duration = duration;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() 
  {
    System.out.println("Drive Forward Auto Started!");
    timer.reset();
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    drivetrain.drive(translation, rotation, fieldRelative); // Start moving, but with YAGSL parameters
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    drivetrain.drive(translation, rotation, fieldRelative); // Stop moving
    timer.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return timer.get() >= duration; // Stop after duration seconds  
  }
}
