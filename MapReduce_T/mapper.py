#!/usr/bin/env python

# import sys because we need to read and write data to STDIN and STDOUT
import sys
import datetime
from datetime import datetime
sys.stdin.readline()

# reading entire line from STDIN (standard input)
for line in sys.stdin:
    # to remove leading and trailing whitespace
    line = line.strip()
    # split the line into words
    data = line.split(',')
    price = (float(data[1]) + float(data[4]))/2

    date_str = data[0]  # Assuming the date is in the first column
    date = datetime.strptime(date_str, '%Y-%m-%d')
    year_month = date.strftime('%Y.%m')
    #date = datetime.datetime.strptime(data[0],"%Y-%m")
    # we are looping over the words array and printing the word

    print(f'\t{year_month}\t%.2f' % (price))