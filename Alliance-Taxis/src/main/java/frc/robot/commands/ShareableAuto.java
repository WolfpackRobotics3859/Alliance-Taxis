package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class ShareableAuto extends Command 
{
  private final Drivetrain drivetrain;
  private final Timer timer = new Timer();
  private final double thrust;
  private final double duration;

  public ShareableAuto(Drivetrain drivetrain, double thrust, double duration) 
  {
    this.drivetrain = drivetrain;
    this.thrust = thrust;
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
    drivetrain.drive(thrust, 0.0, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) 
  {
    drivetrain.stop();
    timer.stop();    
    System.out.println("Drive Forward Auto Ended");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() 
  {
    return timer.get() >= duration; // Stop after duration seconds  
  }
}