class Account:
    def __init__(self, name: str, balance: int):
        self.name = name
        self.balance = balance
    
    def _display_balance(self):
        print(f'Balance: ${self.balance}')
    
    def display_balance(self) -> None:
        self._display_balance()


# Do not modify the code below this line
account = Account("John", 1000)
account.display_balance()
