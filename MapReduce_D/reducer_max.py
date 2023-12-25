#!/usr/bin/env python

import sys

monthly_max_price = {}
yearly_max_price = {}

for line in sys.stdin:
    line = line.strip()
    date, price = line.split('\t')

    try:
        price = float(price)
    except ValueError:
        continue

    if date not in monthly_max_price or price > monthly_max_price[date]:
        monthly_max_price[date] = price

    year = date.split('.')[0]
    if year not in yearly_max_price or price > yearly_max_price[year]:
        yearly_max_price[year] = price

for date, price in monthly_max_price.items():
    print(f"{date} - {price}")

for year, price in yearly_max_price.items():
    print(f"{year} - {price}")
