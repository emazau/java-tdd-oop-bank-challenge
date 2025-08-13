As a customer,
So I can safely store and use my money,
I want to create a current account.

As a customer,
So I can save for a rainy day,
I want to create a savings account.

As a customer,
So I can keep a record of my finances,
I want to generate bank statements with transaction dates, amounts, and balance at the time of transaction.

As a customer,
So I can use my account,
I want to deposit and withdraw funds.

| Classes    | Variables       | Method                                                      | Scenario                             | Output                    |
|------------|-----------------|-------------------------------------------------------------|--------------------------------------|---------------------------|
| Customer   | Account.balance | Account Customer.createAccount(String type)                 | If type is valid and account created | Account                   |
| Account    |                 |                                                             | if type is invalid                   | null                      |
|            |                 |                                                             | if account already created           | null                      |
|            |                 |                                                             |                                      |                           |
|            | Account.balance | Float Customer.withdrawFunds(Float amount, Account account) | if amount is less than balance       | the amount left i account |
|            |                 |                                                             | if amount is more than balance       | -1.00f                    |
|            | Account.balance | Float Customer.depositFunds(Float amount, Account account)  | Parameters are valid                 | the amount in account     |
|            |                 |                                                             | parameters are not valid             | null                      |
|            |                 |                                                             |                                      |                           |
|            | transactions    | String Customer.generateBankStatement(Account account)      | if the account has transactions      | return the bank statement |
|            |                 |                                                             | if no transactions                   | return " "                |
|            |                 |                                                             |                                      |                           |
|            |                 |                                                             |                                      |                           |
|            |                 |                                                             |                                      |                           |
|            |                 |                                                             |                                      |                           |
|            |                 |                                                             |                                      |                           |
