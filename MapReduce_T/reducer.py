import sys

current_date = None
total_sum = 0
count = 0

# Read input from STDIN
for line in sys.stdin:
    # Remove leading and trailing whitespace
    line = line.strip()
    # Split the line into date and price
    date, price = line.split('\t', 1)
    # Convert price to float
    try:
        price = float(price)
    except ValueError:
        # Price was not a number, so ignore this line
        continue
    
    # If the date is the same as the current date, accumulate the sum and count
    if current_date == date:
        total_sum += price
        count += 1
    else:
        # If a new date is encountered and it's not the first date, calculate and output the average
        if current_date:
            average_price = total_sum / count
            print('%s\t%f' % (current_date, average_price))

        # Update current_date and reset total_sum and count for the new date
        current_date = date
        total_sum = price
        count = 1

# Output the average for the last date
if current_date:
    average_price = total_sum / count
    print('%s\t%f' % (current_date, average_price))