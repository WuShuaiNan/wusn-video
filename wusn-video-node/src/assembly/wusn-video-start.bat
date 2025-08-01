@echo off

rem 程序的根目录
SET basedir=C:\Program Files\wusn-video
rem 日志的根目录
SET logdir=%basedir%\logs

rem JVM 内存设置。
rem 如果您希望系统自动分配内存，注释掉下方注释...
SET jvm_memory_opts=^
  -Xmx100m ^
  -XX:MaxMetaspaceSize=130m ^
  -XX:ReservedCodeCacheSize=15m ^
  -XX:CompressedClassSpaceSize=15m
rem 并打开此注释。
rem SET jvm_memory_opts=

rem JAVA 日志编码配置。
rem 如果您希望程序使用默认编码，注释掉下方注释...
SET java_log_encoding_opts=^
  -Dlog.consoleEncoding=GBK ^
  -Dlog.fileEncoding=UTF-8
rem 并打开此注释。
rem SET java_log_encoding_opts=

rem JAVA JMXREMOTE 配置。
rem 如果您希望启用 JMX 远程管理，注释掉下方注释...
SET java_jmxremote_opts=
rem 并打开此注释。
rem SET java_jmxremote_opts=^
rem   -Dcom.sun.management.jmxremote.port=23000 ^
rem   -Dcom.sun.management.jmxremote.authenticate=false ^
rem   -Dcom.sun.management.jmxremote.ssl=false

rem JAVA 固定配置，请勿编辑此行。
SET java_fixed_opts=^
  -Dlog.dir="%logdir%" ^
  -Dlog4j.shutdownHookEnabled=false ^
  -Dlog4j2.is.webapp=false

rem 打开目录，执行程序
cd "%basedir%"
start "wusn-video" /MAX ^
  java -classpath "lib\*;libext\*" ^
  %jvm_memory_opts% ^
  %java_log_encoding_opts% ^
  %java_jmxremote_opts% ^
  %java_fixed_opts% ^
  ${mainClass}
