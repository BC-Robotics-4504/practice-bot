package frc.robot.subsystems;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.Spark.ClosedLoopController;
import com.revrobotics.spark.SparkBase.ControlType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SpinnerConstants;
import frc.robot.Constants.SwerveConstants;

public class DriveSubsystem extends SubsystemBase {
    SparkMax m_swerveMotor;

    public SwerveSubsystem() {
    m_swerveMotor = new SparkMax(
            SwerveConstants.kMotorCanId,
            MotorType.kBrushless
        );
  
    }

    public Command turnOn() {
        return runOnce(
            () -> {
                ;m_controller.setSetpoint(0, ControlType.kPosition);
            
        )
    }




}
