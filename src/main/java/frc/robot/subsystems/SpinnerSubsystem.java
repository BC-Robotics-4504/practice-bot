package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
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
        return runOnce(() -> m_spinnerMotor.setVoltage(SpinnerConstants.kMotorVoltage));
    }

    public Command turnOff() {
        return runOnce(() -> m_spinnerMotor.setVoltage(0));
    }

    public Command dot() {
        return turnOn().andThen(Commands.waitSeconds(SpinnerConstants.kDitSeconds)).andThen(turnOff());
    }

    public Command dash() {
        return turnOn().andThen(Commands.waitSeconds(SpinnerConstants.kDitSeconds * 3)).andThen(turnOff());
    }

    public Command ditSpace() {
        return Commands.waitSeconds(SpinnerConstants.kDitSeconds);
    }

    public Command characterSpace() {
        return Commands.waitSeconds(SpinnerConstants.kDitSeconds * 3);
    }

    public Command wordSpace() {
        return Commands.waitSeconds(SpinnerConstants.kDitSeconds * 7);
    }

    public Command charToMorse(char c) {
        switch (c) {
            case 'a':
                return composeMorseChar(dot())
        }
    }

    private Command composeMorseChar(Command... dits) {
        Command command = Commands.waitSeconds(0);
        for (int i = 0; i < dits.length; i++) {
           
        }
        return command;
    }
}
