package org.firstinspires.ftc.teamcode.opmode.teleop

import org.firstinspires.ftc.teamcode.opmode.BaseOpMode

class GBTeleop : BaseOpMode() {
    override fun initialize() {
        super.initialize()



        driveSys.setDefaultCommand(driveSys.driveArcade(gamepadEx1.leftY, gamepadEx1.rightX))
    }
}