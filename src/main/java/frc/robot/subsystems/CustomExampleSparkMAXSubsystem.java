package frc.robot.subsystems;

import com.revrobotics.spark.SparkClosedLoopController;
import com.revrobotics.spark.SparkLowLevel;
import com.revrobotics.spark.SparkMax;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.spark.SparkBase.ControlType;

public class CustomExampleSparkMAXSubsystem extends SubsystemBase {
    SparkMax m_testSparkMax; // Created Variable of Type SparkMax
    SparkClosedLoopController m_controller; // Created Variable of Type SparkClosedLoopController for rotational methods.

    public CustomExampleSparkMAXSubsystem() { // This NEEDS TO BE NAMED after the class!
        m_testSparkMax = new SparkMax( // Initializing the SparkMax variable.
                Constants.ExampleConstants.exampleSparkMaxCanId, // Any SparkMax Can ID is required here. We use Constants to easily edit these. The constant thing also applies to the rest of the file
                SparkLowLevel.MotorType.kBrushless // This is motor type when we should use kBrushed, but by default, just use kBrushless.
        );
        m_controller = m_testSparkMax.getClosedLoopController(); // This is necessary for the rotation method, I'm assuming it is assigning m_Controller to the getClosedLoopController() "method" maybe... IDRK man...
    }

    public Command exampleSparkMaxMethodSpin() { // This Method will demonstrate a subsystem that spins at a rate.
        return runOnce(
                () -> { // Lambda Baby
                    m_testSparkMax.setVoltage(Constants.ExampleConstants.exampleMotorVoltage); //Makes it spin with the power of 8 voltages, you can go to the constants file to check.
                }
        );
    }
    /*
    Also make sure to duplicate the above method but with zero so you can stop the motor.
    !! For the zero dupe, you don't need to make zero a constant because it will always be a zero, no need to easily change it.
     */

    public Command exampleSparkMaxMethodRotate() { // This Method will demonstrate a subsystem that rotates to a certain point.
        return runOnce(
                () -> {
                    m_controller.setSetpoint(
                            50.0 / 360.0, // We have to do division because the normal type for this is in rotations, so we need to turn it into degrees, also the .0 is there because FLOATS SUCK
                            ControlType.kPosition
                    );

                }
        );
    }
}
