#!/usr/bin/env python

import sys
sys.stdin.readline()

for line in sys.stdin:
    line = line.strip()
    
    data = line.split(",")
    
    change = ((float(data[4]) - float(data[1]))/float(data[1]))*100
    
    date_str = data[0]
    year,month,day = date_str.split("-")
    
    print(f"{year}.{month}\t%.2f" %change)