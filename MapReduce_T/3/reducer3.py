# import sys 
# current_date = None
# current_change = None
# change_count = 0
# total_change = 0
# change_counts = {}  

# for line in sys.stdin:
#     line = line.strip()
#     date,change = line.split('\t',1)

#     try:
#         change_value = float(change)
#     except ValueError:
#         continue
    
#     for next_change in change:
#         if current_change == change_value:
#             change_count += 1
#         else:
#             if current_change is not None:
#                 print(f"{current_change:.2f}% - {change_count}")

#             current_change = change_value
#             change_count = 1

#         total_change += change_value

# if current_change is not None:
#     print(f"{current_change:.2f}% - {change_count}")

import sys 
from collections import Counter

current_date = None
total_sum = 0
count = 0
count_change = 0
average = []


def count_occurrences(lst):
    # Initialize an empty dictionary to store counts
    occurrences = {}

    # Count occurrences for each element in the list
    for element in lst:
        if element in occurrences:
            occurrences[element] += 1
        else:
            occurrences[element] = 1

    # Return dictionary containing occurrences of each item
    return occurrences
    

for line in sys.stdin:
    line = line.strip()
    date,change = line.split("\t",1)
    
    try:
        change = float(change)
    except:
        continue
    
    if current_date == date:
        total_sum += change
        count += 1
        
    else:
        if current_date:
            average_change = total_sum/count
            average.append(average_change)
        
        current_date = date
        total_sum = change
        count = 1
        
if current_date:
    average_change = total_sum/count
    average.append(average_change)

result = count_occurrences(average)
for item, count in result.items():
    print(f"{item}: {count}")
    
    
# $ hadoop jar path/to/hadoop-streaming.jar -mapper mapper.py -reducer reducer.py -input input_data -output output_directory
# Replace path/to/hadoop-streaming.jar, mapper.py, reducer.py, input_data, and output_directory with the actual paths and filenames relevant to your setup.







        
        