#!/usr/bin/env sh
set -eu
APP_HOME=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
GRADLE_VERSION="8.10.2"
DIST="$HOME/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}-bin/gradle-${GRADLE_VERSION}"
if [ ! -x "$DIST/bin/gradle" ]; then
  mkdir -p "$HOME/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}-bin"
  ZIP="$HOME/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}-bin/gradle-${GRADLE_VERSION}-bin.zip"
  if [ ! -f "$ZIP" ]; then
    curl -L "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -o "$ZIP"
  fi
  unzip -q -o "$ZIP" -d "$HOME/.gradle/wrapper/dists/gradle-${GRADLE_VERSION}-bin"
fi
exec "$DIST/bin/gradle" -p "$APP_HOME" "$@"
