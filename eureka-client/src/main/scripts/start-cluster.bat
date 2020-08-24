@echo off
start java -jar -Dxmx=150m ..\..\..\target\service-hello-1.0.0.jar --server.port=2100

@echo off
start java -jar -Dxmx=150m ..\..\..\target\service-hello-1.0.0.jar --server.port=2101

@echo off
start java -jar -Dxmx=150m ..\..\..\target\service-hello-1.0.0.jar --server.port=2102
