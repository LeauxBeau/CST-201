import random
import time

#creating an array for 100 unsorted integers
array = [random.randint(1, 1000) for _ in range(100)]

#intializing the variables to store the max value
max_value = array[0]
step_count = 1 #initializing with one comparison

#starting stopwatch
start_time = time.time()

#iterating through the array to find the max value
for num in array[1:]:
    step_count += 1
    if num > max_value:
        max_value = num
#ending stopwatch
end_time = time.time()
elapsed_time = end_time - start_time
elapsed_time_milliseconds = elapsed_time*1000

#showing results
print(f"Largest number in array: {max_value}")
print(f"Number of computational steps: {step_count}")
print(f" Elasped time: {elapsed_time_milliseconds: 0.6f} ms")