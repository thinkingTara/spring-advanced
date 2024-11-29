
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

--responseBody id 삭제 후 --

responseBody: {
    "userName": "jy22",
    "currencyName": "yen",
    "amountKrw": 10000,
    "amountAfter": 1111.111,
    "symbol": "y"
}

#### 특정사용자의 환전 내역 GET : localhost:8080/user-currencies/{id}
responseBody : [
    {
        "userName": "jy",
        "currencyName": "yen",
        "amountKrw": 10000,
        "amountAfter": 1111.11,
        "symbol": "y",
        "createAt": "2024-11-29T11:56:48.111738"
    },
    {
        "userName": "jy",
        "currencyName": "dollar",
        "amountKrw": 10000,
        "amountAfter": 714.29,
        "symbol": "$",
        "createAt": "2024-11-29T11:56:52.178023"
    },
    {
        "userName": "jy",
        "currencyName": "dollar",
        "amountKrw": 110000,
        "amountAfter": 7857.14,
        "symbol": "$",
        "createAt": "2024-11-29T11:57:00.524681"
    }
]

