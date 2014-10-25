SET CATALINA_HOME=C:\work\apache-tomcat-7
start /B C:\work\apache-tomcat-7\bin\catalina.bat stop
timeout 5
start /B C:\work\apache-tomcat-7\bin\catalina.bat start
