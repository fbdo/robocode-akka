package com.wirecard.codingdojo.robocodeakka

import robocode.{Robot, ScannedRobotEvent}

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
class AkkaRobot extends Robot {

  override def run() = {
    while (true) {
      ahead(100);
      turnGunRight(360);
      back(100);
      turnGunRight(360);
    }
  }

  override def onScannedRobot(e: ScannedRobotEvent) = {
    fire(1)
  }
}
