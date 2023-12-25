#!/usr/bin/env python

import sys

sys.stdin.readline()

for line in sys.stdin:
    line = line.strip()
    item = line.split(",")
    price = (float(item[4]) + float(item[1])) / 2
    date = item[0].split("-")
    output_date = date[0] + "." + date[1]
    print("%s\t%s" % (output_date, price))



