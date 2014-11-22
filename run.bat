SET CATALINA_HOME=C:\work\apache-tomcat-7
start /B C:\work\apache-tomcat-7\bin\catalina.bat stop
start /B mvn clean package install

rem sleeping - sleeps by the supplied number of seconds
ping 192.0.2.2 -n 1 -w %500 > nul

start /B C:\work\apache-tomcat-7\bin\catalina.bat start
