#!/bin/bash

cd /disk1/kafka
FILE=my.pid
if [ -f "$FILE" ]; 
  then
        PID=`cat $FILE`
	# echo "$pid"
	
	
	if [ -n "$PID" -a -e /proc/$PID ];
	    then
   		 echo "kafka is running with $PID"
            else 
               echo "kafka is not running with $PID"
	fi
	
else 
    echo " hello $FILE file not found"
fi

