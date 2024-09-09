from typing import List
from copy import deepcopy

def is_possible(amount: int, used_coins: List[int], coin: int) -> bool:
    return (coin + sum(used_coins)) <= amount


def get_options(amount: int, coins: List[int]) -> int:
    
    def recurse(amount: int, used_coins: List[int], solutions: List[List[int]]) -> None:
        if sum(used_coins) == amount:
            solutions.append(deepcopy(used_coins))  
            return
        
        if sum(used_coins) > amount:
            return 
        
        for coin in coins:
            if is_possible(amount, used_coins, coin):
                recurse(amount, used_coins + [coin], solutions)

    solutions: List[List[int]] = []
    recurse(amount, [], solutions)
    unique_solutions = set(tuple(sol) for sol in solutions)
    return unique_solutions, len(unique_solutions)


# test code
get_options(6, [1,2,3])
