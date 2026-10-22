package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.SpinnerConstants;

public class SpinnerSubsystem extends SubsystemBase {
    SparkMax m_spinnerMotor;

    public SpinnerSubsystem() {
        m_spinnerMotor = new SparkMax(
            SpinnerConstants.kMotorCanId,
            MotorType.kBrushless
        );
    }

    public Command turnOn() {
        return runOnce(
            () -> {
                m_spinnerMotor.setVoltage(SpinnerConstants.kMotorVoltage);
            }
        );
    }

    public Command turnOff() {
        return runOnce(
            () -> {
                m_spinnerMotor.setVoltage(0);
            }
        );
    }
}
