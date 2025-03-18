package frc.robot.subsystems;

import java.util.function.Supplier;


import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.swerve.SwerveRequest;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.generated.TunerConstants;

public class Drivetrain extends CommandSwerveDrivetrain 
{
    private final SwerveRequest.FieldCentric m_OperatorDriveRequest = new SwerveRequest.FieldCentric()
        .withDeadband(TunerConstants.MaxSpeed * 0.05).withRotationalDeadband(TunerConstants.MaxAngularRate * 0.05) // Add a 10% deadband
        .withDeadband(TunerConstants.MaxSpeed * 0.05).withRotationalDeadband(TunerConstants.MaxAngularRate * 0.05) // Add a 10% deadband
        .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors

    public Drivetrain(SwerveDrivetrainConstants constants, SwerveModuleConstants<?, ?, ?>... modules)
    {
        super(constants, modules);        
    }

    @Override
    public void periodic() 
    {}

    public Command DefaultDrive(Supplier<Double> thrust, Supplier<Double> strafe, Supplier<Double> rotation)
    {
        return this.applyRequest(() -> this.m_OperatorDriveRequest.withVelocityX(-thrust.get() * TunerConstants.MaxSpeed * 0.8)
                                                                  .withVelocityY(-strafe.get() * TunerConstants.MaxSpeed * 0.8)
                                                                  .withRotationalRate(-rotation.get() * TunerConstants.MaxAngularRate));
    }
}
