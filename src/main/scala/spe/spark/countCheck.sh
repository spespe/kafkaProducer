#!/bin/bash

PATH=${1}
PATTERN=${2}
FINAL_FILE=${3}

REGISTER=(`hadoop fs -ls ${PATH}/* | grep "${PATTERN}" | awk '{print $8}'`)

NUM=0
for el in ${REGISTER[@]}; do
C=`hadoop fs -text ${el} | wc -l`
NUM=$(( ${NUM} + ${C} ))
echo "FILE:${el} - ROW_COUNT:${C} - TOTAL ROWCOUNT: ${NUM}" >> ${FINAL_FILE}
done

