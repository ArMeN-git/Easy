#!/usr/bin/env python

import sys

sys.stdin.readline()

for line in sys.stdin:
    line = line.strip()
    items = line.split(",")
    price = (float(items[1]) + float(items[4]))/2
    input_date = items[0].split("-")
    output_date = input_date[0] + "." + input_date[1]
    print('%s\t%s' % (output_date, price))

