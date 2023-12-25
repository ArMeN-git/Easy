#!/usr/bin/env python

import sys

monthly_prices = {}
yearly_prices = {}


for line in sys.stdin:
    line = line.strip()
    output_date, price = line.split("\t")
    try:
        price = float(price)
    except ValueError:
        continue

    if output_date not in monthly_prices:
        monthly_prices[output_date] = {'total_price': 0.0, 'count': 0}

    monthly_prices[output_date]['total_price'] += price
    monthly_prices[output_date]['count'] += 1

for month, values in monthly_prices.items():
    average_price = values['total_price'] / values['count']
    print(f"{month} - {average_price}")


for month, values in monthly_prices.items():
    year = month.split('.')[0]

    if year not in yearly_prices:
        yearly_prices[year] = {'total_price': 0.0, 'count': 0}

    yearly_prices[year]['total_price'] += values['total_price']
    yearly_prices[year]['count'] += values['count']

for year, values in yearly_prices.items():
    average_price = values['total_price'] / values['count']
    print(f"{year} - {average_price}")
