@echo off
if "%OS%"=="Windows_NT" @setlocal
if "%OS%"=="WINNT" @setlocal

set _SOURCEPATH=src
set _CLASSES=classes
set _CLASSPATH=%CLASSPATH%;"lib\orm.jar"
if "%JAVA_HOME%" == "" goto noJavaHome
if not exist "%JAVA_HOME%\bin\java.exe" goto noJavaHome
goto javaHome

:noJavaHome
echo The JAVA_HOME environment variable not find.
echo if compile fail, please set the JAVA_HOME environment variable!
set _JAVACCMD=javac.exe
goto compile

:javaHome
set _JAVACCMD=%JAVA_HOME%\bin\javac.exe
goto compile

:compile
if not exist "%_CLASSES%" md %_CLASSES%
"%_JAVACCMD%" -encoding UTF-8 -d %_CLASSES% -classpath %_CLASSPATH% %_SOURCEPATH%\*.java 
if not exist "%_CLASSES%\ormmapping" md %_CLASSES%\ormmapping
if not %_SOURCEPATH% == %_CLASSES% xcopy %_SOURCEPATH%\ormmapping %_CLASSES%\ormmapping /s


set _JAVACCMD=
set _CLASSES=
set _CLASSPATH=
set _SOURCEPATH=
if "%OS%"=="Windows_NT" @endlocal
if "%OS%"=="WINNT" @endlocal
