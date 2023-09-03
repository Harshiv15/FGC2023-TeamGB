package org.firstinspires.ftc.teamcode.subsystems

import com.arcrobotics.ftclib.command.Command
import com.arcrobotics.ftclib.command.RunCommand
import com.arcrobotics.ftclib.command.SubsystemBase
import com.qualcomm.robotcore.hardware.DcMotorEx
import org.firstinspires.ftc.teamcode.Constants.joystickTransformFactor
import java.util.function.DoubleSupplier
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sign


class TankDriveSys (leftMotor: DcMotorEx, rightMotor: DcMotorEx) : SubsystemBase() {
    private val leftMotor: DcMotorEx
    private val rightMotor: DcMotorEx

    init {
        this.leftMotor = leftMotor
        this.rightMotor = rightMotor
    }

    fun driveDifferential (leftPow: Double, rightPow: Double) : Command {
        return RunCommand({
            leftMotor.power = joystickTransform(leftPow)
            rightMotor.power = joystickTransform(rightPow)
        }, this)
    }

    fun driveArcade (forwardPow: Double, turnPow: Double) : Command {
        return RunCommand({
            leftMotor.power = joystickTransform(forwardPow) + joystickTransform(turnPow)
            rightMotor.power = joystickTransform(forwardPow) - joystickTransform(turnPow)
        }, this)
    }

    private fun joystickTransform (input: Double) : Double {
        return (1.0 / (joystickTransformFactor - 1)
                * sign(input)
                * (joystickTransformFactor.pow(abs(input)) - 1))
    }
}