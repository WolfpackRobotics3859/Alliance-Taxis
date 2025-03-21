package frc.robot.subsystems;

import com.ctre.phoenix6.swerve.SwerveDrivetrainConstants;
import com.ctre.phoenix6.swerve.SwerveModule.DriveRequestType;
import com.ctre.phoenix6.swerve.SwerveModuleConstants;
import com.ctre.phoenix6.swerve.SwerveRequest;

import frc.robot.generated.TunerConstants;

public class Drivetrain extends CommandSwerveDrivetrain 
{
    private final SwerveRequest.FieldCentric m_OperatorDriveRequest = new SwerveRequest.FieldCentric()
        .withDeadband(TunerConstants.MaxSpeed * 0.05).withRotationalDeadband(TunerConstants.MaxAngularRate * 0.05) // Add a 10% deadband
        .withDriveRequestType(DriveRequestType.OpenLoopVoltage); // Use open-loop control for drive motors

    public Drivetrain(SwerveDrivetrainConstants constants, SwerveModuleConstants<?, ?, ?>... modules)
    {
        super(constants, modules);        
    }

    @Override
    public void periodic() 
    {
        // Intentionally empty
    }

    /**
     * Directly drives the drivetrain using field-centric control.
     *
     * @param thrust   Forward/backward speed (normalized to -1.0 to 1.0).
     * @param strafe   Left/right speed (normalized to -1.0 to 1.0).
     * @param rotation Rotational speed (normalized to -1.0 to 1.0).
     */
    public void drive(double thrust, double strafe, double rotation)
    {
        this.setControl(
            m_OperatorDriveRequest
                .withVelocityX(-thrust * TunerConstants.MaxSpeed * 0.8)
                .withVelocityY(-strafe * TunerConstants.MaxSpeed * 0.8)
                .withRotationalRate(-rotation * TunerConstants.MaxAngularRate)
        );
    }

    public void stop()
    {
        this.setControl(
            m_OperatorDriveRequest
                .withVelocityX(0)
                .withVelocityY(0)
                .withRotationalRate(0)
        );
    }
}