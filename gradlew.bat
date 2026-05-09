@echo off
set APP_HOME=%~dp0
set GRADLE_VERSION=8.10.2
set DIST=%USERPROFILE%\.gradle\wrapper\dists\gradle-%GRADLE_VERSION%-bin\gradle-%GRADLE_VERSION%
if not exist "%DIST%\bin\gradle.bat" (
  mkdir "%USERPROFILE%\.gradle\wrapper\dists\gradle-%GRADLE_VERSION%-bin" 2>nul
  powershell -NoProfile -ExecutionPolicy Bypass -Command "Invoke-WebRequest https://services.gradle.org/distributions/gradle-%GRADLE_VERSION%-bin.zip -OutFile $env:USERPROFILE\.gradle\wrapper\dists\gradle-%GRADLE_VERSION%-bin\gradle-%GRADLE_VERSION%-bin.zip; Expand-Archive -Force $env:USERPROFILE\.gradle\wrapper\dists\gradle-%GRADLE_VERSION%-bin\gradle-%GRADLE_VERSION%-bin.zip $env:USERPROFILE\.gradle\wrapper\dists\gradle-%GRADLE_VERSION%-bin"
)
"%DIST%\bin\gradle.bat" -p "%APP_HOME%" %*
