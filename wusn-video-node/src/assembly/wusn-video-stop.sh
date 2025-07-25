#!/bin/sh
# 程序的根目录
basedir="/usr/local/rtsp2webrtc"

PID=$(cat "$basedir/rtsp2webrtc.pid")
kill "$PID"
