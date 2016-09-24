package com.wirecard.codingdojo.robocodeakka.messages

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
abstract class RobotEvents

case class NextCommand() extends RobotEvents

case class ScannedRobot(name: String, energy: Double, heading: Double, bearing: Double, distance: Double, velocity: Double, sentryRobot: Boolean) extends RobotEvents

case class BattleEnded() extends RobotEvents

case class Heading(heading: Double) extends RobotEvents

case class X(value: Double) extends RobotEvents

case class Y(value: Double) extends RobotEvents
