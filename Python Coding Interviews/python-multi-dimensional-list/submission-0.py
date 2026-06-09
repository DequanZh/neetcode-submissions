from typing import List
import math

def find_max_in_each_list(nested_arr: List[List[int]]) -> List[int]:
    result_list = []
    for arr in nested_arr:
        max_val = -math.inf
        for n in arr:
            if n > max_val:
                max_val = n
        result_list.append(max_val)
    return result_list


# do not modify below this line
print(find_max_in_each_list([[1, 2], [3, 4, 2]]))
print(find_max_in_each_list([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
print(find_max_in_each_list([[5, 6, 2, 8], [9], [9, 10], [11, 10, 11]]))
