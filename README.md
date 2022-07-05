# Getting Started
This simple application is a Java web application that simulates the NIBSS Instant Paymentss (NIP) transfer operation between bank accounts.

### Creating the Database
In the application.properties file, set the following properties:

`spring.datasource.url=jdbc:postgresql://localhost:5432/nibss_db`
`spring.datasource.username=#{postgres_user}`
`spring.datasource.password=#{postgres_password}`
`spring.flyway.enabled=true`
`spring.flyway.baselineOnMigration=true`
`spring.flyway.locations=classpath:db/migration`
`spring.jpa.show-sql=true`
`spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect`
`spring.jpa.properties.hibernate.format_sql=true`
`server.error.include-message=always`

Once the DB is up and running, you will need to start the application by running it (Click the play button, assuming you're using an IDE like IntelliJ).

## API Structure
This simple NIBSS API is based on a HTTP/REST architecture. API clients issue HTTP GET requests with parameters specified in the query string and HTTP POST requests with request body in JSON format. API responses use standard HTTP response codes with messages encoded in JSON format.

## API Endpoints
|       Name       |                                Description                                 |
|:----------------:|:--------------------------------------------------------------------------:|
|  Create Account  |          Creates a new account that will be used for transactions          |
|   Get Accounts   | Retrieves the available accounts created that can be used for transactions |
|  Bank Transfer   |     Initiates a bank transfer from an account to another bank account      |
| Get Transactions |  Retrieves a list of transactions that occurred during a particular time   |

### Create Account Request

Request URL: <br /> 
`POST http://localhost:8080/api/v1/account/addAccount`
 
Request Body: <br />
```
{
    "firstName": "Bolaji",
    "lastName": "Lakoroye",
    "balance": 47780,
    "accountNumber": "6363002001"
}
```

Request Parameters:

| Name          | Type   | Description                     |
|:--------------|:-------|:--------------------------------|
| firstName     | string | The first name of the user      |
| lastName      | string | The last name of the user       |
| balance       | double | The account balance of the user |
| accountNumber | string | The account number of the user  |

### Create Account Response

A successful request will return the following JSON encoded response

**HTTP 200 OK**
```
{
    "id": 3,
    "firstName": "Bolaji",
    "lastName": "Lakoroye",
    "balance": 47780.0,
    "accountNumber": "6363002051"
}
```

Response Object Fields:

| Name          | Type   | Description                                |
|:--------------|:-------|:-------------------------------------------|
| id            | long   | Unique ID used for identifying the account |
| firstName     | string | The first name of the user                 |
| lastName      | string | The last name of the user                  |
| balance       | double | The account balance of the user            |
| accountNumber | string | The account number of the user             |

### Transfer Request

Request URL: <br />
```POST http://localhost:8080/api/v1/transfers/addTransfer```

Request Body: <br />
```
{
    "sourceAccount": "6363002051",
    "destinationAccount": "6398589912",
    "amount": 10,
    "description": "Milkose Candy",
    "status": "Successful"
}
```

Request Parameters:

| Name               | Type   | Description                                           |
|:-------------------|:-------|:------------------------------------------------------|
| sourceAccount      | string | The account where the money is to be transferred from |
| destinationAccount | string | The account where the money is to be sent             |
| amount             | double | The cost of the item to be purchased                  |
| description        | string | The narration of what the cost is meant for           |
| status             | string | The condition of the transaction                      |

### Create Account Response

A successful request will return the following JSON encoded response

**HTTP 200 OK**
```
{
    "id": 17,
    "sourceAccount": "6363002001",
    "destinationAccount": "6398589912",
    "amount": 10.0,
    "description": "Milkose Candy",
    "status": "Successful"
}
```

Response Object Fields:

| Name               | Type   | Description                                           |
|:-------------------|:-------|:------------------------------------------------------|
| id                 | long   | The transaction's identifier in the database          |
| sourceAccount      | string | The account where the money is to be transferred from |
| destinationAccount | string | The account where the money is to be sent             |
| amount             | double | The cost of the item to be purchased                  |
| description        | string | The narration of what the cost is meant for           |
| status             | string | The condition of the transaction                      |

### Get Transaction Request

Request URL: <br />
```POST http://localhost:8080/api/v1/transactions/getTransactions```

### Get Transactions Response

A successful request will return the following JSON encoded response

**HTTP 200 OK**
```
[
    {
        "id": 1,
        "transactionReference": "trxn01cae440",
        "amount": 5600.0,
        "transactionFee": 28.0,
        "billedAmount": 5628.0,
        "description": "Payment for Petrol",
        "createdDate": "2022-07-03T08:52:52.211517",
        "status": "SUCCESSFUL",
        "commissionWorthy": true,
        "commission": 0.0
    },
    {
        "id": 7,
        "transactionReference": "trxn09fbd47a-b",
        "amount": 10.0,
        "transactionFee": 0.05,
        "billedAmount": 10.05,
        "description": "Milkose Candy",
        "createdDate": "2022-07-05T21:37:23.126015",
        "status": "SUCCESSFUL",
        "commissionWorthy": false,
        "commission": 0.01
    }
]
```

Response Object Fields:

| Name                 | Type          | Description                                                                                                 |
|:---------------------|:--------------|:------------------------------------------------------------------------------------------------------------|
| id                   | long          | The transaction's identifier in the database                                                                |
| transactionReference | string        | generated string that uniquely references every transaction request. It cannot be repeated in a new request |
| amount               | double        | The cost of the item to be purchased                                                                        |
| transactionFee       | double        | The calculated fee of the transaction                                                                       |
| billedAmount         | double        | The amount that was billed for the transaction                                                              |
| description          | string        | The transaction's description                                                                               |
| createdDate          | LocalDateTime | The date time the transaction was performed                                                                 |

### Create Account Response

A successful request will return the following JSON encoded response

**HTTP 200 OK**
```
{
    "id": 17,
    "sourceAccount": "6363002001",
    "destinationAccount": "6398589912",
    "amount": 10.0,
    "description": "Milkose Candy",
    "status": "Successful"
}
```

Response Object Fields:

| Name               | Type   | Description                                           |
|:-------------------|:-------|:------------------------------------------------------|
| id                 | long   | The transaction's identifier in the database          |
| sourceAccount      | string | The account where the money is to be transferred from |
| destinationAccount | string | The account where the money is to be sent             |
| amount             | double | The cost of the item to be purchased                  |
| description        | string | The narration of what the cost is meant for           |
| status             | string | The condition of the transaction                      |

### Get Transactions by Date Request

Request URL: <br />
```POST http://localhost:8080/api/v1/transactions/fetchTransactionsByDate?startDate=2022-07-04```

Request Parameters: <br />
```
startDate: 2022-07-04
```
Request Parameters: <br />

| Name      | Description                      |
|:----------|:---------------------------------|
| startDate | Starting Date of the transaction |

### Get Transactions by Date Response

A successful request will return the following JSON encoded response

**HTTP 200 OK**
```
[
   {
        "id": 6,
        "transactionReference": "trxn2e69b25d-0",
        "amount": 10.0,
        "transactionFee": 0.05,
        "billedAmount": 10.05,
        "description": "Milkose Candy",
        "createdDate": "2022-07-04T11:04:18.334651",
        "status": "SUCCESSFUL",
        "commissionWorthy": false,
        "commission": 0.01
    },
    {
        "id": 7,
        "transactionReference": "trxn09fbd47a-b",
        "amount": 10.0,
        "transactionFee": 0.05,
        "billedAmount": 10.05,
        "description": "Milkose Candy",
        "createdDate": "2022-07-05T21:37:23.126015",
        "status": "SUCCESSFUL",
        "commissionWorthy": false,
        "commission": 0.01
    }
]
```

Response Object Fields:

| Name                 | Type          | Description                                                                                                 |
|:---------------------|:--------------|:------------------------------------------------------------------------------------------------------------|
| id                   | long          | The transaction's identifier in the database                                                                |
| transactionReference | string        | generated string that uniquely references every transaction request. It cannot be repeated in a new request |
| amount               | double        | The cost of the item to be purchased                                                                        |
| transactionFee       | double        | The calculated fee of the transaction                                                                       |
| billedAmount         | double        | The amount that was billed for the transaction                                                              |
| description          | string        | The transaction's description                                                                               |
| createdDate          | LocalDateTime | The date time the transaction was performed                                                                 |
| status               | string        | Condition of the transaction                                                                                |
| commissionWorthy     | boolean       | The date time the transaction was performed                                                                 |

### Get Transactions by Parameters Request

Request URL: <br />
```POST http://localhost:8080/api/v1/transactions/fetchTransactions?commissionWorthiness=true&status=SUCCESSFUL```

Request Parameters: <br />
```
commissionWorthiness: false
status: SUCCESSFUL
```
Request Parameters: <br />

| Name                 | Description                      |
|:---------------------|:---------------------------------|
| commissionWorthiness | State of the commission          |
| status               | The condition of the transaction |

### Get Transactions Response

A successful request will return the following JSON encoded response

**HTTP 200 OK**
```
[
   {
        "id": 6,
        "transactionReference": "trxn2e69b25d-0",
        "amount": 10.0,
        "transactionFee": 0.05,
        "billedAmount": 10.05,
        "description": "Milkose Candy",
        "createdDate": "2022-07-04T11:04:18.334651",
        "status": "SUCCESSFUL",
        "commissionWorthy": false,
        "commission": 0.01
    },
    {
        "id": 7,
        "transactionReference": "trxn09fbd47a-b",
        "amount": 10.0,
        "transactionFee": 0.05,
        "billedAmount": 10.05,
        "description": "Milkose Candy",
        "createdDate": "2022-07-05T21:37:23.126015",
        "status": "SUCCESSFUL",
        "commissionWorthy": false,
        "commission": 0.01
    }
]
```

Response Object Fields:

| Name                 | Type          | Description                                                                                                 |
|:---------------------|:--------------|:------------------------------------------------------------------------------------------------------------|
| id                   | long          | The transaction's identifier in the database                                                                |
| transactionReference | string        | generated string that uniquely references every transaction request. It cannot be repeated in a new request |
| amount               | double        | The cost of the item to be purchased                                                                        |
| transactionFee       | double        | The calculated fee of the transaction                                                                       |
| billedAmount         | double        | The amount that was billed for the transaction                                                              |
| description          | string        | The transaction's description                                                                               |
| createdDate          | LocalDateTime | The date time the transaction was performed                                                                 |
| status               | string        | Condition of the transaction                                                                                |
| commissionWorthy     | boolean       | The date time the transaction was performed                                                                 |

### Get Transactions by Parameters Details

Request URL: <br />
```http://localhost:8080/api/v1/transactions/findByDetails?startDate=2022-07-04&endDate=2022-07-04&commissionWorthiness=true&status=SUCCESSFUL```

Request Parameters: <br />
```
startDate: 2022-07-04
endDate: 2022-07-04
commissionWorthiness: true
status: SUCCESSFUL
```
Request Parameters: <br />

| Name                 | Description                      |
|:---------------------|:---------------------------------|
| startDate            | Starting date of the transaction |
| endDate              | Ending date of the transaction   |
| commissionWorthiness | true                             |
| status               | SUCCESSFUL                       |

### Get Transactions Response

A successful request will return the following JSON encoded response

**HTTP 200 OK**
```
[
    {
        "id": 6,
        "transactionReference": "trxn2e69b25d-0",
        "amount": 10.0,
        "transactionFee": 0.05,
        "billedAmount": 10.05,
        "description": "Milkose Candy",
        "createdDate": "2022-07-04T11:04:18.334651",
        "status": "SUCCESSFUL",
        "commissionWorthy": true,
        "commission": 0.01
    },
    {
        "id": 1,
        "transactionReference": "trxn01cae440",
        "amount": 5600.0,
        "transactionFee": 28.0,
        "billedAmount": 5628.0,
        "description": "Payment for Petrol",
        "createdDate": "2022-07-03T08:52:52.211517",
        "status": "SUCCESSFUL",
        "commissionWorthy": true,
        "commission": 0.0
    },
    {
        "id": 7,
        "transactionReference": "trxn09fbd47a-b",
        "amount": 10.0,
        "transactionFee": 0.05,
        "billedAmount": 10.05,
        "description": "Milkose Candy",
        "createdDate": "2022-07-05T21:37:23.126015",
        "status": "SUCCESSFUL",
        "commissionWorthy": true,
        "commission": 0.01
    }
]
```

Response Object Fields:

| Name                 | Type          | Description                                                                                                 |
|:---------------------|:--------------|:------------------------------------------------------------------------------------------------------------|
| id                   | long          | The transaction's identifier in the database                                                                |
| transactionReference | string        | generated string that uniquely references every transaction request. It cannot be repeated in a new request |
| amount               | double        | The cost of the item to be purchased                                                                        |
| transactionFee       | double        | The calculated fee of the transaction                                                                       |
| billedAmount         | double        | The amount that was billed for the transaction                                                              |
| description          | string        | The transaction's description                                                                               |
| createdDate          | LocalDateTime | The date time the transaction was performed                                                                 |
| status               | string        | Condition of the transaction                                                                                |
| commissionWorthy     | boolean       | The date time the transaction was performed                                                                 |
