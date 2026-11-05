package frc.robot.subsystems;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.ControlType;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.sConstants;

public class SwervePracticeSubsystem  extends SubsystemBase{
    SparkMax m_swervePractice;
    SparkClosedLoopController m_Controller;

    public void swervePracticeSubsystem() {
        m_swervePractice = new SparkMax(
            sConstants.sDriveCanId,
            MotorType.kBrushless
        );
    }
    public Command sixtySeven() {
        return runOnce(
            () -> {
                m_Controller.setSetpoint(
                    67,
                    ControlType.kPosition
                );
            }
        );
    }
    public Command sixty() {
        return runOnce(
            () -> {
                m_Controller.setSetpoint(
                    60,
                    ControlType.kPosition
                ); 
            }
        );
    }
    public Command seventy() {
        return runOnce(
            () -> {
                m_Controller.setSetpoint(
                    70,
                    ControlType.kPosition
                );
            }
        );
    }
    public Command zero() {
        return runOnce(
            () -> {
                m_Controller.setSetpoint(
                    0,
                    ControlType.kPosition
                );
            }
        );
    }
}
