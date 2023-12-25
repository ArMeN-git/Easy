#!/usr/bin/env python

# import sys because we need to read and write data to STDIN and STDOUT
import sys
sys.stdin.readline()

# reading entire line from STDIN (standard input)
for line in sys.stdin:
    # to remove leading and trailing whitespace
    line = line.strip()
    # split the line into words
    data = line.split(',')
    price = (float(data[1]) + float(data[4]))/2
    
    data_str = data[0]  # Assuming the date is in the first column
    year,month,day = data_str.split("-")
    print(f"\t{year}.{month}\t%.2f" % price)

    