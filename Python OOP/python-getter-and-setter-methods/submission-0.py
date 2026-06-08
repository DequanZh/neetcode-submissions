class BankAccount:
    def __init__(self, balance: int):
        self.balance = balance
    
    # TODO: Add getter method for balance
    def get_balance(self) -> int:
        return self.balance
    
    # TODO: Add setter method for balance
    def set_balance(self, balance: int) -> None:
        if balance >= 0:
            self.balance = balance
        else:
            print('Cannot set negative balance!')


# Don't modify the code below this line
account = BankAccount(1000)
print(account.get_balance())
account.set_balance(-100)
print(account.get_balance())
account.set_balance(100)
print(account.get_balance())
account.set_balance(0)
print(account.get_balance())
