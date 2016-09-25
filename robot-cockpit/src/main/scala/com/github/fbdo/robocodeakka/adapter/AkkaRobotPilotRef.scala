package com.github.fbdo.robocodeakka.adapter

import akka.actor.{ActorSelection, ActorSystem}
import com.typesafe.config.{Config, ConfigFactory}

/**
  * @author <a href="mailto:fabio.oliveira@wirecard.com">Fabio Oliveira</a>
  */
object AkkaRobotPilotRef {

  val system = ActorSystem()
  private val config: Config = ConfigFactory.load();
  private var configIdx: Int = 0

  def ref(): ActorSelection = {
    val addrs = config.getStringList("cockpit.pilots")
    val addr = addrs.get(configIdx)
    configIdx = configIdx + 1

    system.actorSelection(addr)
  }

  def reset(): Unit = configIdx = 0



}
