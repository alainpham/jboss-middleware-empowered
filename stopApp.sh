#/bin/sh
ps -aux | grep event-collector | grep -v grep | awk '{print $2}' | xargs kill -KILL
ps -aux | grep trade-service | grep -v grep | awk '{print $2}' | xargs kill -KILL
ps -aux | grep dashboard | grep -v grep | awk '{print $2}' | xargs kill -KILL
rm log.txt
