package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.Command;

public class SketchyDriveSubsytem extends SubsystemBase{
    SparkMax topLeftSystem;
    SparkMax bottomLeftSystem;
    SparkMax topRightSystem;
    SparkMax bottomRightSystem; 
    
    public SketchyDriveSubsytem() {
        topLeftSystem = new SparkMax(
            DriveConstants.topLeftDriveCanId, 
            MotorType.kBrushless
        );
        bottomLeftSystem = new SparkMax(
            DriveConstants.bottomLeftDriveCanId,
            MotorType.kBrushless
        );
        topRightSystem = new SparkMax(
            DriveConstants.topRightDriveCanId,
            MotorType.kBrushless
        );
        bottomRightSystem = new SparkMax(
            DriveConstants.bottomRightDriveCanId,
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
    public Command rightSystemDrive() {
        return runOnce(
            () -> {
                topRightSystem.setVoltage(DriveConstants.driveMotorVoltagePositive);
                bottomRightSystem.setVoltage(DriveConstants.driveMotorVoltagePositive);
            }
        );
    }
    public Command rightSystemReverse() {
        return runOnce(
            () -> {
                topRightSystem.setVoltage(DriveConstants.driveMotorVoltageNegative);
                bottomRightSystem.setVoltage(DriveConstants.driveMotorVoltageNegative);
            }
        );
    }
    public Command systemStop() {
        return runOnce(
            () -> {
                topRightSystem.setVoltage(0);
                bottomRightSystem.setVoltage(0);
                topLeftSystem.setVoltage(0);
                bottomLeftSystem.setVoltage(0);
            }
        );
    }
}
