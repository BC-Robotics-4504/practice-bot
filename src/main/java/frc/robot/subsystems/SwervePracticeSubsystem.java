package frc.robot.subsystems;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.sConstants;

public class SwervePracticeSubsystem  extends SubsystemBase{
    SparkMax m_swervePractice; // Mad Skillz W Aura + Even more MAd Skillz
    SparkClosedLoopController m_Controller;
 
    public SwervePracticeSubsystem() {
        m_swervePractice = new SparkMax(
            sConstants.sDriveCanId,
            MotorType.kBrushless
        );
        m_Controller = m_swervePractice.getClosedLoopController();
    }
    public Command sixtySeven() {
        return runOnce(
            () -> {
                m_Controller.setSetpoint(
                    67.0 / 360.0,
                    ControlType.kPosition
                );
            }
        );
    }
    public Command sixty() {
        return runOnce(
            () -> {
                m_Controller.setSetpoint(
                    60.0 / 360.0,
                    ControlType.kPosition
                ); 
            }
        );
    }
    public Command seventy() {
        return runOnce(
            () -> {
                m_Controller.setSetpoint(
                    70.0 / 360.0,
                    ControlType.kPosition
                );
            }
        );
    }
    public Command zero() {
        return runOnce(
            () -> {
                m_Controller.setSetpoint(
                    0.0,
                    ControlType.kPosition
                );
            }
        );
    }
}
