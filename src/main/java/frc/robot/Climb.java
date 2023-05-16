package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class Climb{
    private DoubleSolenoid climb;
    public Climb(){
        this.climb = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.PNUEMATIC_PORTS[0], Constants.PNUEMATIC_PORTS[1]);
    }

    public void run(){
        if(Robot.driverController.getAButton()){
            climb.set(DoubleSolenoid.Value.kForward);
        }else {
            climb.set(DoubleSolenoid.Value.kReverse);

        }
    }
}