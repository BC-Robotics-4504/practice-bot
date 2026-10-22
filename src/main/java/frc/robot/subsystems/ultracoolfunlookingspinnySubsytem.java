package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.koolConstants;

public class ultracoolfunlookingspinnySubsytem extends SubsystemBase{
    SparkMax m_67ebikeMotor;

    public ultracoolfunlookingspinnySubsytem() {
        m_67ebikeMotor = new SparkMax(
            koolConstants.koolMotorCanId,
            MotorType.kBrushless,   
        );
    }

    public Command runHigh() {
        return runOnce(
            () -> {
                m_67ebikeMotor.setVoltage(koolConstants.koolMotorVoltage2)
            }
        );
    }

    public Command runNHigh() {
        return runOnce(
            () -> {
                m_67ebikeMotor.setVoltage(koolConstants.koolMotorVoltageN2)
            }
        );
    }

    public Command runLow() {
        return runOnce(
            () -> {
                m_67ebikeMotor.setVoltage(koolConstants.koolMotorVoltage1)
            }
        );
    }

    public Command runNLow() {
        return runOnce(
            () -> {
                m_67ebikeMotor.setVoltage(koolConstants.koolMotorVoltageN1)
            }
        );
    }
     public Command runOff() {
        return runOnce(
            () -> {
                m_67ebikeMotor.setVoltage(0);
            }
        );
     }
}
