#!/bin/bash
nohup java -cp "barracuda-bill-1.0.0.jar:libs/*" com.barracuda.barracudabill.BarracudaBillApplication --spring.profiles.active=pro > ba-bill.log 2>&1 &