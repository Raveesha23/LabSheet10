class Account(var balance: Double) {
  
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    if (amount <= balance) {
      balance -= amount
    } else {
      println("Insufficient funds.")
    }
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }

  override def toString: String = s"Account(balance: $$${balance})"
}

class Bank(accounts: List[Account]) {

  def accountsWithNegativeBalances: List[Account] = {
    accounts.filter(_.balance < 0)
  }

  def sumOfAllBalances: Double = {
    accounts.map(_.balance).sum
  }

  def applyInterestToAllAccounts(): Unit = {
    accounts.foreach(_.applyInterest())
  }

  def finalBalances: List[Double] = {
    accounts.map(_.balance)
  }
}

object TestBank extends App{
    val account1 = new Account(1000.0)
    val account2 = new Account(-200.0)
    val account3 = new Account(500.0)
    val account4 = new Account(-50.0)

    val bank = new Bank(List(account1, account2, account3, account4))

    // 4.1 List of Accounts with negative balances
    println("Accounts with negative balances:")
    bank.accountsWithNegativeBalances.foreach(println)

    // 4.2 Calculate the sum of all account balances
    val totalBalance = bank.sumOfAllBalances
    println(s"Total balance of all accounts: $$${totalBalance}")

    // 4.3 Apply interest and calculate final balances
    bank.applyInterestToAllAccounts()
    println("Final balances after applying interest:")
    bank.finalBalances.foreach(balance => println(s"$$${balance}"))
 
}


