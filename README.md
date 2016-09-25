# robocode-akka
A Robocode thin layer to allow players to code using Scala and Akka. To learn and have fun with asynchronous messages in a real-time environment.

It's uses the Robot API to translate the local events and commands in messages, sending them to a remote "pilot" that will receive all events as messages and need to respond commands using messages too.

# How to build
In the project root, just do a 

gradlew shadowJar

to build fat jars of both the robot message dispather and the robot remote pilot.

# How to run
- Copy from robot-cockpit/build/libs the fat jar robot-cockpit-<version>-all.jar to <ROBOCODE_HOME>/robots folder.
- Add the options to allow full access to network for all robots in the robocode.[bat|sh]. The final file should look like that:

```bash
#!/bin/sh
#
# Copyright (c) 2001-2016 Mathew A. Nelson and Robocode contributors
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://robocode.sourceforge.net/license/epl-v10.html
#

pwd=`pwd`
cd "${0%/*}"
java -Xmx512M -DNOSECURITY=true -Dsun.io.useCanonCaches=false -cp libs/robocode.jar robocode.Robocode $*
cd "${pwd}"
```

After those steps you will see a new robot in the list of robots when starting a new battle.

# Starting the remote pilot
In folder robot-pilot/build/libs/ you will find the robot-pilot-<version>-all.jar, a fat jar with all dependecies to run the remote pilot. Just run:

java -jar robot-pilot/build/libs/robot-pilot-1.0.0-SNAPSHOT-all.jar

To run it locally.

Both the robot and the pilot are configured to run in the same machine, but you can easily configure them to run remotely in different machines.






