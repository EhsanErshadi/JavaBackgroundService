"C:\Program Files\RedHat\commons-daemon-1.1.0-bin-windows\amd64\prunsrv.exe" install jbs ^
--StartPath=%cd% ^
--Classpath=%cd%\target\jbs-0.0.1-SNAPSHOT.jar ^
--StartMode=jvm ^
--StartClass=com.example.jbs.App ^
--StartMethod=start ^
--StartParams=start ^
--StopMode=jvm ^
--StopClass=com.example.jbs.App ^
--StopMethod=stop ^
--StopParams=stop ^
--StdOutput=%cd%\stdout.log ^
--StdError=%cd%\stderr.log ^
--Jvm="C:\Program Files\Java\jdk1.8.0_161\jre\bin\server\jvm.dll" ^
--Startup=auto 
