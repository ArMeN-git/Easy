import sys

current_date = None
total_sum = 0
count = 0

for line in sys.stdin:
    line = line.strip()
    date,price = line.split("\t",1)
    
    try:
        price = float(price)
    except ValueError:
        continue
    
    if current_date == date:
        total_sum += price
        count +=1
        
    else:
        if current_date:
            average_price = total_sum/count
            print(f"%s\t%.2f" %(current_date,average_price))
        
        current_date = date
        total_sum = price
        count = 1
        
        
if current_date:
     average_price = total_sum/count
     print(f"%s\t%.2f" %(current_date,average_price))
        
        