package com.wirecard.codingdojo.robocodeakka.messages

import robocode.Robot

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
abstract class RobotCommand {
  def apply(robot: Robot): Unit
}

case class DoNothing() extends RobotCommand {
  def apply(robot: Robot): Unit = {
    robot.doNothing()
  }
}

case class Fire(power: Double) extends RobotCommand {
  def apply(robot: Robot): Unit = {
    robot.fire(power)
  }
}

case class Ahead(distance: Double) extends RobotCommand {
  def apply(robot: Robot): Unit = {
    robot.ahead(distance)
  }
}

case class TurnGunRight(degrees: Double) extends RobotCommand {
  def apply(robot: Robot): Unit = {
    robot.turnGunRight(degrees)
  }
}

case class TurnGunLeft(degrees: Double) extends RobotCommand {
  def apply(robot: Robot): Unit = {
    robot.turnGunLeft(degrees)
  }
}

case class Back(distance: Double) extends RobotCommand {
  def apply(robot: Robot): Unit = {
    robot.back(distance)
  }
}




