#!/usr/bin/env python

import sys

sys.stdin.readline()

for line in sys.stdin:
    line = line.strip()
    item = line.split(",")
    change = ((float(item[4]) - float(item[1])) / float(item[1])) * 100
    input_date = item[0].split("-")
    output_date = input_date[0] + "." + input_date[1]
    print('%s\t%s' % (output_date, change))
