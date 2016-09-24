package com.wirecard.codingdojo.robocodeakka.messages

import akka.actor.ActorSelection
import robocode.Robot

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
abstract class RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit
}

case class DoNothing() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    robot.doNothing()
  }
}

case class Fire(power: Double) extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    robot.fire(power)
  }
}

case class Ahead(distance: Double) extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    robot.ahead(distance)
  }
}

case class TurnGunRight(degrees: Double) extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    robot.turnGunRight(degrees)
  }
}

case class TurnGunLeft(degrees: Double) extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    robot.turnGunLeft(degrees)
  }
}

case class Back(distance: Double) extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    robot.back(distance)
  }
}

case class GetHeading() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    ref ! Heading(robot.getHeading())
  }
}

case class GetX() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    ref ! X(robot.getX())
  }
}

case class GetY() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    ref ! Y(robot.getY())
  }
}

case class TurnLeft(degrees: Double) extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    robot.turnLeft(degrees)
  }
}

case class TurnRight(degrees: Double) extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    robot.turnRight(degrees)
  }
}

case class GetGunHeading() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    ref ! GunHeading(robot.getGunHeading())
  }
}

case class GetGunHeat() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    ref ! GunHeat(robot.getGunHeat())
  }
}

case class GetOthers() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    ref ! Others(robot.getOthers())
  }
}

case class GetRadarHeading() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    ref ! RadarHeading(robot.getRadarHeading())
  }
}

case class GetVelocity() extends RobotCommand {
  def apply(robot: Robot, ref: ActorSelection): Unit = {
    ref ! Velocity(robot.getVelocity())
  }
}




