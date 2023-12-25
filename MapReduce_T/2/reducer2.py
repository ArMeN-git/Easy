import sys

current_date = None
total_sum = 0
count = 0

for line in sys.stdin:
    line = line.strip()
    date,change = line.split("\t",1)
    
    try:
        change = float(change)
    except ValueError:
        continue
    
    if current_date == date:
        total_sum += change
        count += 1
    else:
        if current_date:
            average_change = total_sum/count
            print(f"%s\t%.2f" % (current_date,average_change))
            
        current_date = date
        total_sum = change
        count = 1
        
if current_date:
    average_change = total_sum/count
    print(f"%s\t%.2f" % (current_date,average_change))