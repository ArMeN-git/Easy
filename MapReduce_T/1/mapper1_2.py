#!/usr/bin/env python

import sys
sys.stdin.readline()

for line in sys.stdin:
    line = line.strip()
    data = line.split(",")
    
    price = (float(data[1]) + float(data[4]))/2
    data_str = data[0]
    year,month,day = data_str.split("-")
    
    print(f"{year}\t%.2f" %price)