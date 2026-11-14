package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj2.command.Command;

public class SketchyDriveSubsytemRight extends SubsystemBase{
    SparkMax topRightSystem;
    SparkMax bottomRightSystem; 
    
    public SketchyDriveSubsytemRight() {
        topRightSystem = new SparkMax(
            DriveConstants.topRightDriveCanId,
            MotorType.kBrushless
        );
        bottomRightSystem = new SparkMax(
            DriveConstants.bottomRightDriveCanId,
            MotorType.kBrushless
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
            }
        );
    }
}
