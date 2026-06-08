class BankAccount: 
    # TODO: Add class and instance attributes at their appropriate places
    total_balance = 0
    total_account = 0

    def __init__(self, name: str, balance: int) -> None:
        self.name = name
        self.balance = balance
        BankAccount.total_balance += balance
        BankAccount.total_account += 1


# TODO: Create two accounts
account_alice = BankAccount('Alice',1000)
account_bob = BankAccount('Bob',2000)
# TODO: Print the information using the mentioned format
print(f"Alice's balance: ${account_alice.balance}")
print(f"Bob's balance: ${account_bob.balance}")
print(f"Total Accounts: {BankAccount.total_account}")
print(f"Total Balance: ${BankAccount.total_balance}")
