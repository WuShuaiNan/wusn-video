#!/bin/sh
# 程序的根目录
basedir="/usr/local/wusn-video"

PID=$(cat "$basedir/wusn-video.pid")
kill "$PID"
