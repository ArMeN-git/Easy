#!/usr/bin/env python

import sys

monthly_change = {}
yearly_change = {}


for line in sys.stdin:
    line = line.strip()
    date, change = line.split('\t', 1)
    try:
        change = float(change)
    except ValueError:
        continue

    if date not in monthly_change:
        monthly_change[date] = {'change': 0.0, 'count': 0}

    monthly_change[date]['change'] += change
    monthly_change[date]['count'] += 1

for month, values in monthly_change.items():
    avg_change = int(values['change'] / values['count'])
    print(f"{month} - {avg_change} %")


for date, values in monthly_change.items():
    year = date.split(".")[0]

    if year not in yearly_change:
        yearly_change[year] = {'change': 0.0, 'count': 0}

    yearly_change[year]['change'] += values['change']
    yearly_change[year]['count'] += values['count']

for year, values in yearly_change.items():
    avg_change = int(values['change'] / values['count'])
    print(f"{year} - {avg_change} %")
