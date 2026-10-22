package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TacosMotorSubsystem extends SubsystemBase {
    SparkMax m_TacosMotor;

    public TacosMotorSubsystem () {
        m_TacosMotor = new SparkMax(TacosMotorConstants.kTacosMotorCanID, MotorType.kBrushless);
    }

    public Command turnOn() {
        return runOnce (
            () -> {
                m_TacosMotor.setVoltage(TacosMotorConstants.kTacosMotorVoltage);
            }
        );
    }

    public Command turnOff() {
        return runOnce (
        () -> { 
            m_TacosMotor.setVoltage(0);
        }
        );
    }

    public Command reverse() {
        return runOnce (
            () -> {
                m_TacosMotor.setVoltage(TacosMotorConstants.kTacosMotorReverseVoltage);
            }
        );
    }
}
