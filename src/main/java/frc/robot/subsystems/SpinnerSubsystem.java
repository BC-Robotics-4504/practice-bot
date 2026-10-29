package frc.robot.subsystems;

import java.util.ArrayList;

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

    public Command letterToMorse(char c) {
        switch (c) {
            case 'a':
                return composeMorseChar(dot(), dash());
            case 'b':
                return composeMorseChar(dash(), dot(), dot(), dot());
            case 'c':
                return composeMorseChar(dash(), dot(), dash(), dot());
            case 'd':
                return composeMorseChar(dash(), dot(), dot());
            case 'e':
                return composeMorseChar(dot());
            case 'f':
                return composeMorseChar(dot(), dot(), dash(), dot());
            case 'g':
                return composeMorseChar(dash(), dash(), dot());
            case 'h':
                return composeMorseChar(dot(), dot(), dot(), dot());
            case 'i':
                return composeMorseChar(dot(), dot());
            case 'j':
                return composeMorseChar(dot(), dash(), dash(), dash());
            case 'k':
                return composeMorseChar(dash(), dot(), dash());
            case 'l':
                return composeMorseChar(dot(), dash(), dot(), dot());
            case 'm':
                return composeMorseChar(dash(), dash());
            case 'n':
                return composeMorseChar(dash(), dot());
            case 'o':
                return composeMorseChar(dash(), dash(), dash());
            case 'p':
                return composeMorseChar(dot(), dash(), dash(), dot());
            case 'q':
                return composeMorseChar(dash(), dash(), dot(), dash());
            case 'r':
                return composeMorseChar(dot(), dash(), dot());
            case 's':
                return composeMorseChar(dot(), dot(), dot());
            case 't':
                return composeMorseChar(dash());
            case 'u':
                return composeMorseChar(dot(), dot(), dash());
            case 'v':
                return composeMorseChar(dot(), dot(), dot(), dash());
            case 'w':
                return composeMorseChar(dot(), dash(), dash());
            case 'x':
                return composeMorseChar(dash(), dot(), dot(), dash());
            case 'y':
                return composeMorseChar(dash(), dot(), dash(), dash());
            case 'z':
                return composeMorseChar(dash(), dash(), dot(), dot());
            default:
                throw new IllegalArgumentException("Unsupported character: " + c);
        }
    }

    public Command wordToMorse(String s) {
        ArrayList<Command> charCommands = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            charCommands.add(letterToMorse(s.charAt(i)));
        }

        return composeMorseWord(charCommands.toArray(new Command[0]));
    }

    public Command sentanceToMorse(String s) {
        String[] words = s.split("\\s+");
        ArrayList<Command> wordCommands = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            wordCommands.add(wordToMorse(words[i]));
        }

        return composeMorseSentance(wordCommands.toArray(new Command[0]));
    }

    // private Command composeMorseChar(Command... dits) {
    //     Command command = dits[0].andThen(ditSpace());

    //     for (int i = 1; i < dits.length-1; i++) {
    //        command = command.andThen(dits[i]).andThen(ditSpace());
    //     }

    //     return command.andThen(dits[dits.length-1]);
    // }

    // private Command composeMorseWord(Command... chars) {
    //     Command command = chars[0].andThen(characterSpace());

    //     for (int i = 1; i < chars.length-1; i++) {
    //        command = command.andThen(chars[i]).andThen(characterSpace());
    //     }

    //     return command.andThen(chars[chars.length-1]);
    // }

    // private Command composeMorseSentance(Command... words) {
    //     Command command = words[0].andThen(wordSpace());

    //     for (int i = 1; i < words.length-1; i++) {
    //        command = command.andThen(words[i]).andThen(wordSpace());
    //     }

    //     return command.andThen(words[words.length-1]);
    // }
    private Command composeMorseChar(Command... dits) {
        ArrayList<Command> commands = new ArrayList<>();

        for (int i = 0; i < dits.length; i++) {
            commands.add(dits[i]);

            if (i < dits.length - 1) {
                commands.add(ditSpace());
            }
        }

        return Commands.sequence(commands.toArray(new Command[0]));
    }

    private Command composeMorseWord(Command... chars) {
        ArrayList<Command> commands = new ArrayList<>();

        for (int i = 0; i < chars.length; i++) {
            commands.add(chars[i]);

            if (i < chars.length - 1) {
                commands.add(characterSpace());
            }
        }

        return Commands.sequence(commands.toArray(new Command[0]));
    }

    private Command composeMorseSentance(Command... words) {
        ArrayList<Command> commands = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            commands.add(words[i]);

            if (i < words.length - 1) {
                commands.add(wordSpace());
            }
        }

        return Commands.sequence(commands.toArray(new Command[0]));
    }
}
