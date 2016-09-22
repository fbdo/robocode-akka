package com.wirecard.codingdojo.robocodeakka.messages

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
abstract class RobotCommand

case class DoNothing() extends RobotCommand

case class Fire(power: Double) extends RobotCommand

case class Ahead(distance: Double) extends RobotCommand

case class TurnGunRight(degrees: Double) extends RobotCommand

case class TurnGunLeft(degrees: Double) extends RobotCommand

case class Back(distance: Double) extends RobotCommand




