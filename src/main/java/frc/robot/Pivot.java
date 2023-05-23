package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.DigitalInput;

import com.revrobotics.CANSparkMax.ControlType;

public class Pivot {
    private CANSparkMax pivotMotor;
    private DigitalInput lowerLimit;

    public Pivot() {
        this.pivotMotor = new CANSparkMax(Constants.PIVOT_PORT, MotorType.kBrushless);
        this.lowerLimit = new DigitalInput(Constants.LOWER_LIMIT_PORT);

        pivotMotor.getPIDController().setP(Constants.PIVOT_KP);
        pivotMotor.getPIDController().setI(Constants.PIVOT_KI);
        pivotMotor.getPIDController().setD(Constants.PIVOT_KD);
        pivotMotor.getPIDController().setFF(Constants.PIVOT_KF);

        pivotMotor.getPIDController().setOutputRange(-Constants.PIVOT_AUTO_SPEED - 0.05, Constants.PIVOT_AUTO_SPEED);
    }

    private void calibrate() {
        pivotMotor.set(0);
        pivotMotor.getEncoder().setPosition(0);
    }

    private double getRev(){
        return -pivotMotor.getEncoder().getPosition();
    }

    private void teleopRun(){
        if(!lowerLimit.get() && Robot.operatorController.getLeftY()>0){
            calibrate();
            return;
        }

        if(getRev()<Constants.PIVOT_ZERO_THRESHOLD && Robot.operatorController.getLeftY()>0){
            pivotMotor.set(Robot.operatorController.getLeftY() * Constants.PIVOT_ZERO_SPEED);
            return;
        }

        if(getRev()>Constants.PIVOT_MAX_REVOLUTION && Robot.operatorController.getLeftY()<0){
            return;
        }
        pivotMotor.set(Robot.operatorController.getLeftY() * Constants.PIVOT_TELEOP_SPEED);
    }

    private void stop() {
        pivotMotor.set(0);
    }

    public void run() {
        if(Robot.operatorController.getXButton()) {
            calibrate();
        } else if(Math.abs(Robot.operatorController.getLeftY())>Constants.TRIGGER_THRESHOLD) {
            teleopRun();
        }else if(Robot.operatorController.getLeftStickButton()){
            setRev(0);
        } else {
            switch(Robot.operatorController.getPOV()){
                case 0:
                    setAgainst();
                    break;
                case 90:
                    setLine();
                    break;
                case 180:
                    setWheel();
                    break;
                case 270:
                    setTrench();
                    break;
                default:
                    stop();
                    break;
            }
        }
    }

    private void setAgainst() {
        setRev(79);
    }

    private void setLine() {
        setRev(16.35);
    }

    private void setWheel() {
        setRev(33);
    }

    private void setTrench() {
        setRev(7.5);
    }


    private void setRev(double rev) {
        double target = rev;
        if(rev<Constants.PIVOT_ZERO_THRESHOLD){
            target = 0;
        }
        if(rev>Constants.PIVOT_MAX_REVOLUTION){
            target = Constants.PIVOT_MAX_REVOLUTION;
        }
        pivotMotor.getPIDController().setReference(-target, ControlType.kPosition);
    }
}