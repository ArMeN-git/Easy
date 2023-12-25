#!/usr/bin/env python

import sys

monthly_min_price = {}
yearly_min_price = {}

for line in sys.stdin:
    line = line.strip()
    date, price = line.split('\t')

    try:
        price = float(price)
    except ValueError:
        continue

    if date not in monthly_min_price or price < monthly_min_price[date]:
        monthly_min_price[date] = price

    year = date.split(".")[0]
    if year not in yearly_min_price or price < yearly_min_price[year]:
        yearly_min_price[year] = price

for date, price in monthly_min_price.items():
    print(f"{date} - {price}")

for year, price in yearly_min_price.items():
    print(f"{year} - {price}")
