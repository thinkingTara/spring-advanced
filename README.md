
## User 의 API
#### POST url :  localhost:8080/users

requestBody : {
    "name": "jy",
    "email":"jj@jj"
}

resoponseBody : {
    "id": 1,
    "name": "jy",
    "email": "jj@jj"
}
#### 전체 GET  : localhost:8080/users

responseBody: [
    {
        "id": 1,
        "name": "jy",
        "email": "jj@jj"
    },
    {
        "id": 2,
        "name": "jy2",
        "email": "jj2@jj"
    }
]

#### GET {id}  : localhost:8080/users/1
responseBody: {
    "id": 1,
    "name": "jy",
    "email": "jj@jj"
}

---
## Currency API
#### POST : localhost:8080/currencies

requestBody: {
          "currencyName":"dollar",
            "exchangeRate":"14",
            "symbol":"$"
}

responseBody: {
    "id": 2,
    "currencyName": "dollar",
    "exchangeRate": 14,
    "symbol": "$"
}

#### GET : localhost:8080/currencies

responseBody: [
    {
        "id": 1,
        "currencyName": "yen",
        "exchangeRate": 9.00,
        "symbol": "y"
    },
    {
        "id": 2,
        "currencyName": "dollar",
        "exchangeRate": 14.00,
        "symbol": "$"
    }
]

---
## UserCurrency API
#### POST : localhost:8080/user-currencies

reqeustBody : {
    "userId":2,
    "currencyId":1,
    "amountKrw":10000
}

responseBody : {
    "id": 3,
    "userId": 2,
    "userName": "jy22",
    "currencyId": 1,
    "currencyName": "yen",
    "amountKrw": 10000,
    "amountAfter": 1111.111,
    "symbol": "y"
}
