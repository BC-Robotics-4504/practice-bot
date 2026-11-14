package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.Command;

public class SketchyDriveSubsystemLeft extends SubsystemBase{
    SparkMax topLeftSystem;
    SparkMax bottomLeftSystem;
    
    public SketchyDriveSubsystemLeft() {
        topLeftSystem = new SparkMax(
            DriveConstants.topLeftDriveCanId,
            MotorType.kBrushless

        );
        bottomLeftSystem = new SparkMax(
            DriveConstants.bottomLeftDriveCanId,
            MotorType.kBrushless
        );
    }
    public Command leftSystemDrive() {
    return runOnce(
        () -> {
                topLeftSystem.setVoltage(DriveConstants.driveMotorVoltagePositive);
                bottomLeftSystem.setVoltage(DriveConstants.driveMotorVoltagePositive);
            }
        );
    }
    public Command leftSystemReverse() {
        return runOnce(
            () -> {
                topLeftSystem.setVoltage(DriveConstants.driveMotorVoltageNegative);
                bottomLeftSystem.setVoltage(DriveConstants.driveMotorVoltageNegative);
            }
        );
    }
    public Command systemStop() {
        return runOnce(
            () -> {
                topLeftSystem.setVoltage(0);
                bottomLeftSystem.setVoltage(0);
            }     
        );
    }
}
