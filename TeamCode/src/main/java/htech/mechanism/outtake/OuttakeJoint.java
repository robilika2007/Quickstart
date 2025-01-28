package htech.mechanism.outtake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import htech.config.PositionsOuttake;
import htech.config.Servos;

public class OuttakeJoint {
    private final Servo servoLeft;
    private final Servo servoRight;

    int rotLevel = 0;


    private double currentPositionLeft;
    private double currentPositionRight;

    public OuttakeJoint(HardwareMap hardwareMap) {
        servoLeft = hardwareMap.get(Servo.class, Servos.outtakeLeft);
        servoRight = hardwareMap.get(Servo.class, Servos.outtakeRight);

//        servoLeft.setPosition(PositionsOuttake.jointTransferLeft + PositionsOuttake.jointRotation90 * rotLevel);
//        servoRight.setPosition(PositionsOuttake.jointTransferRight + PositionsOuttake.jointRotation90 * rotLevel);

        currentPositionLeft = PositionsOuttake.jointTransferLeft;
        currentPositionRight = PositionsOuttake.jointTransferRight;
    }

    public void goToTransfer() {
        rotLevel = 0;
        servoLeft.setPosition(PositionsOuttake.jointTransferLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(PositionsOuttake.jointTransferRight + PositionsOuttake.jointRotation90 * rotLevel);

        currentPositionLeft = PositionsOuttake.jointTransferLeft;
        currentPositionRight = PositionsOuttake.jointTransferRight;
    }

    public void goToTransferSample() {
        rotLevel = 0;
        servoLeft.setPosition(PositionsOuttake.jointTransferSampleLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(PositionsOuttake.jointTransferSampleRight + PositionsOuttake.jointRotation90 * rotLevel);

        currentPositionLeft = PositionsOuttake.jointTransferSampleLeft;
        currentPositionRight = PositionsOuttake.jointTransferSampleRight;
    }

    public void goToSpecimenScore() {
        servoLeft.setPosition(PositionsOuttake.jointSpecimenLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(PositionsOuttake.jointSpecimenRight + PositionsOuttake.jointRotation90 * rotLevel);

        currentPositionLeft = PositionsOuttake.jointSpecimenLeft;
        currentPositionRight = PositionsOuttake.jointSpecimenRight;
    }

    public void goToBasketScore() {
        servoLeft.setPosition(PositionsOuttake.jointBasketLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(PositionsOuttake.jointBasketRight + PositionsOuttake.jointRotation90 * rotLevel);

        currentPositionLeft = PositionsOuttake.jointBasketLeft;
        currentPositionRight = PositionsOuttake.jointBasketRight;
    }

    public int getRot() {
        return 90 * rotLevel;
    }

    public void rotateLeft() {
        rotLevel++;
        if(rotLevel > 1) rotLevel = 1;

        servoLeft.setPosition(currentPositionLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(currentPositionRight + PositionsOuttake.jointRotation90 * rotLevel);
    }

    public void goToAfterTransfer() {
        rotLevel = 0;
        servoLeft.setPosition(PositionsOuttake.afterTransferLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(PositionsOuttake.afterTransferRight + PositionsOuttake.jointRotation90 * rotLevel);

        currentPositionLeft = PositionsOuttake.afterTransferLeft;
        currentPositionRight = PositionsOuttake.afterTransferRight;
    }

    public void rotateRight() {
        rotLevel--;
        if(rotLevel < -2) rotLevel = -1;

        servoLeft.setPosition(currentPositionLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(currentPositionRight + PositionsOuttake.jointRotation90 * rotLevel);
    }

    public void dropPos(){
        rotLevel = 0;
        servoLeft.setPosition(PositionsOuttake.jointDropLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(PositionsOuttake.jointDropRight + PositionsOuttake.jointRotation90 * rotLevel);

        currentPositionLeft = PositionsOuttake.jointDropLeft;
        currentPositionRight = PositionsOuttake.jointDropRight;
    }

    public void catapultarePos(){
        servoLeft.setPosition(PositionsOuttake.jointCatapultareLeft + PositionsOuttake.jointRotation90 * rotLevel);
        servoRight.setPosition(PositionsOuttake.jointCatapultareRight + PositionsOuttake.jointRotation90 * rotLevel);

        currentPositionLeft = PositionsOuttake.jointCatapultareLeft;
        currentPositionRight = PositionsOuttake.jointCatapultareRight;
    }
}
