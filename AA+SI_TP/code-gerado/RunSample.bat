@echo off
if "%OS%"=="Windows_NT" @setlocal
if "%OS%"=="WINNT" @setlocal

set _CLASSES=classes
set _CLASSPATH=%CLASSPATH%;"lib\orm.jar"
set _ARGS=

if "%JAVA_HOME%" == "" goto noJavaHome
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaHome
goto javaHome

:noJavaHome
set _JAVACMD=java.exe
goto args

:javaHome
set _JAVACMD=%JAVA_HOME%\bin\java.exe
goto args

:args
if "%1"=="" goto run
set _ARGS=%_ARGS% %1
shift
goto args

:run
"%_JAVACMD%" -cp %_CLASSES%;%_CLASSPATH% %_ARGS%

set _ARGS=
set _JAVACMD=
set _CLASSES=
set _CLASSPATH=
if "%OS%"=="Windows_NT" @endlocal
if "%OS%"=="WINNT" @endlocal
