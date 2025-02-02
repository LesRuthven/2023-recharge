// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;

public class AutoBalance extends CommandBase {
  PIDController initPidController = new PIDController(0.015, 0, 0); //0.027, 0, 0
  PIDController finalPidController = new PIDController(0.01, 0, 0.003);

  /** Creates a new AutoBalance. */
  public AutoBalance() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(RobotContainer.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(Math.abs(RobotContainer.drivetrain.getRoll()) > 15.0){
      double speed = initPidController.calculate(RobotContainer.drivetrain.getRoll(), 0.0);
      speed = Math.abs(RobotContainer.drivetrain.getHeading()) > 165 ? -speed : speed;
      RobotContainer.drivetrain.swerveDrive(-speed, 0.0, 0.0, 0.0, true, false, false);
    }
    else if(Math.abs(RobotContainer.drivetrain.getRoll()) > 2.5 && Math.abs(RobotContainer.drivetrain.getRoll()) < 15.0){
      double speed = finalPidController.calculate(RobotContainer.drivetrain.getRoll(), 0.0);
      speed = Math.abs(RobotContainer.drivetrain.getHeading()) > 165 ? -speed : speed;
      RobotContainer.drivetrain.swerveDrive(-speed, 0.0, 0.0, 0.0, true, false, false);
    }
    else if(Math.abs(RobotContainer.drivetrain.getPitch()) > 15.0){
      double speed = initPidController.calculate(RobotContainer.drivetrain.getPitch(), 0.0);
      speed = Math.abs(RobotContainer.drivetrain.getHeading() - 90) > 15 ? -speed : speed;
      RobotContainer.drivetrain.swerveDrive(speed, 0.0, 0.0, 0.0, true, false, false);
    }
    else if(Math.abs(RobotContainer.drivetrain.getPitch()) > 2.5 && Math.abs(RobotContainer.drivetrain.getPitch()) < 15.0){
      double speed = finalPidController.calculate(RobotContainer.drivetrain.getPitch(), 0.0);
      speed = Math.abs(RobotContainer.drivetrain.getHeading() - 90) > 15 ? -speed : speed;
      RobotContainer.drivetrain.swerveDrive(speed, 0.0, 0.0, 0.0, true, false, false);
    }
    else{
      RobotContainer.drivetrain.swerveDrive(0.0, 0.0, 0.0, 0.0, true, false, false);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}