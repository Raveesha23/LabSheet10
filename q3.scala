class Account(var balance: Double) {
  
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
    println(s"Deposited $$${amount}. New balance: $$${balance}")
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    if (amount <= balance) {
      balance -= amount
      println(s"Withdrew $$${amount}. New balance: $$${balance}")
    } else {
      println(s"Insufficient funds. Withdrawal of $$${amount} failed.")
    }
  }

  def transfer(amount: Double, toAccount: Account): Unit = {
    require(amount > 0, "Transfer amount must be positive")
    if (amount <= balance) {
      this.withdraw(amount)
      toAccount.deposit(amount)
      println(s"Transferred $$${amount} to the other account.")
    } else {
      println(s"Insufficient funds. Transfer of $$${amount} failed.")
    }
  }
}



object TestAccount extends App{
    val account1 = new Account(1000.0)
    val account2 = new Account(500.0)

    account1.deposit(200.0)       
    account1.withdraw(150.0)      
    account1.transfer(300.0, account2) 
    println(s"Account 1 balance: $$${account1.balance}") 
    println(s"Account 2 balance: $$${account2.balance}") 

}