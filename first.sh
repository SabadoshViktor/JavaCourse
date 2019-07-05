#!/bin/bash

echo "WARNING....Are you shure you want delete /...."
sleep 3
echo "YES"
sleep 2
echo "I am so sory....By-by"
sleep 1

j=5

for ((i=1;i<=5;i++));
do
      echo $j
      j=$[$j-1]
      sleep 1
done
echo "Privet ot Maksa"
