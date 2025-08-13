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

| Classes    | Variables       | Method                                                               | Scenario                                         | Output                                          |
|------------|-----------------|----------------------------------------------------------------------|--------------------------------------------------|-------------------------------------------------|
| Customer   | Account.balance | Account Customer.createAccount(String type)                          | If type is valid and account created             | Account                                         |
| Account    |                 |                                                                      | if type is invalid                               | null                                            |
|            |                 |                                                                      | if account already created                       | null                                            |
|            |                 |                                                                      |                                                  |                                                 |
|            | Account.balance | Float Customer.withdrawFunds(Float amount, Account account)          | if amount is less than balance                   | the amount left i account                       |
|            |                 |                                                                      | if amount is more than balance                   | -1.00f                                          |
|            | Account.balance | Float Customer.depositFunds(Float amount, Account account)           | Parameters are valid                             | the amount in account                           |
|            |                 |                                                                      | parameters are not valid                         | null                                            |
|            |                 |                                                                      |                                                  |                                                 |
|            | transactions    | String Customer.generateBankStatement(StringType)                    | if the account has transactions                  | return the bank statement                       |
|            |                 |                                                                      | if no transactions                               | return " "                                      |
|            |                 |                                                                      |                                                  |                                                 |
|            |                 | Float Customer.getBalanceHardWay(String Type)                        | account has transactions                         | return the balance                              |
|            |                 |                                                                      | if transactions is empty                         | -1.00f                                          |
|            |                 |                                                                      |                                                  |                                                 |
|            | branch          | boolean Customer.setBranch(String branch)                            | if place is a place                              | true                                            |
|            |                 |                                                                      | if place is " "                                  | false                                           |
|            |                 |                                                                      |                                                  |                                                 |
|            |                 | boolean Customer.overdraft(Float amount )                            | if amount is more than 200 over bal and approved | false                                           |
|            |                 |                                                                      | if it is less than 200 over bal                  | true                                            |
|            |                 |                                                                      | if the amount is less than bal                   | false                                           |
|            |                 |                                                                      |                                                  |                                                 |
|            |                 | boolean Customer.createRequests(Float amount)                        | if amount is overdraft and is under 400          | List created and  return true                   |
|            |                 |                                                                      | if overdraft is over 400                         | nothing happens return true                     |
|            |                 |                                                                      | if i write something else                        |                                                 |
|            |                 |                                                                      |                                                  |                                                 |
|            |                 | boolean Customer.approveRequest( Float request, boolean approved)    | if approved is true                              | hashmap is updated and deleted when set through |
|            |                 |                                                                      | if approved is false                             | request is declined and entry is deleted.       |
|            |                 |                                                                      | if request found                                 | false                                           |
|            |                 |                                                                      | if request not found but approved is true        | false                                           |
|            |                 |                                                                      |                                                  |                                                 |
|            |                 |                                                                      |                                                  |                                                 |
