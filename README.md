# Sistema de transacciones bancarias
## Desarrollo del proyecto integrador dentro del desarrollo del BootCamp de desarrollo web BackEnd de MAKAIA.
### Equipo de trabajo:
  * Paula Múnera
  * Yeisson Vahos

### El repositorio corresponde al desarrollo del proyecto integrador dentro del bootcamp de MAKAIA, en él se desarrollará la simulación de un sistema de transacciones bancaria utilizando Java, MySQL, SpringBoot, SpringData, Spring security, JWT, JUnit y Swagger.

## Introducción

### Los sistemas de transacciones bancarias desempeñan un papel fundamental al facilitar y agilizar la gestión de los movimientos de dinero entre cuentas y entidades financieras. Estos sistemas representan la columna vertebral de las operaciones bancarias, permitiendo a individuos, empresas e instituciones realizar una variedad de transacciones de manera segura, eficiente y conveniente.

## Objetivo
### El objetivo de este ejercicio es simular un sistema de transacciones bancarias básico. Los usuarios podrán abrir cuentas, realizar depósitos en sus cuentas, y transferir dinero entre cuentas.

## Features

### Requerimientos funcionales
1. Cuentas
   1.1. Apertura de Cuentas
   1.2. Depósitos en Cuentas
   1.3. Transferencias entre Cuentas
   1.4. Consultar cuenta
2. Bolsillos
   2.1. Creación de Bolsillos
   2.2. Transferencias a Bolsillos
   2.3. Consulta de Bolsillos
3. Implementar Autenticación en el API REST

### Requerimientos no funcionales
1. Documentar el API

## Especificaciones

1. Cuentas

1. 1. Apertura de Cuentas
### Endpoint para Abrir una Cuenta: permite a los usuarios abrir una nueva cuenta bancaria proporcionando su nombre y saldo inicial. POST -> /api/accounts
```json
{
    "initialBalance": 0,
    "owner":{
        "person":{
            "id": "1020475585",
            "firstName": "Yeisson",
            "lastName": "Vahos",
            "email": "yvahosc@gmail.com",
            "phone": "+57-3046406015"
        },
        "password": "1234"
    }
}
```

1. 2. Depósitos en cuentas
### Endpoint para Realizar un Depósito: permite a los usuarios realizar un depósito en una cuenta existente proporcionando el número de cuenta y la cantidad a depositar. POST -> /api/accounts/{account_number}/deposit
```json
{
  "amount": 10000
}
```

1. 3. Transferencias entre cuentas
### Endpoint para Realizar una Transferencia: permite a los usuarios transferir dinero de una cuenta a otra, proporcionando los números de cuenta de origen y destino, así como la cantidad a transferir. POST -> /api/accounts/transfer
```json
{
  "sourceAccountNumber": 791534917141140,
  "destinationAccountNumber": 523754106790787,
  "amount": 20000
}
```

1. 4. Consultar cuenta
### Endpoint para Consultar una Cuenta: permite a los usuarios consultar los detalles y el saldo actual de una cuenta específica en el sistema de transacciones bancarias. GET -> /api/accounts/{account_number}


2. Bolsillos

2. 1. Creación de bolsillos
### Endpoint para Crear un Bolsillo: permite a los usuarios crear un bolsillo (subcuenta) asociado a su cuenta principal. El dinero almacenado en el bolsillo se descuenta del saldo de la cuenta principal. POST -> /api/pockets
```json
{
  "accountNumber": 464783411264004,
  "name": "Vacaciones",
  "initialBalance": 1000
}
```

2. 2. Transferencias a bolsillos
### Endpoint para Transferir Dinero al Bolsillo: permite a los usuarios transferir dinero desde la cuenta principal a un bolsillo existente, proporcionando el número de cuenta y bolsillo, así como la cantidad a transferir. POST -> /api/pockets/transfer
```json
{
  "accountNumber": 464783411264004,
  "pocketNumber": 1,
  "amount": 1000
}
```

2. 3. Consulta de bolsillos
### Endpoint para Obtener Bolsillos de una Cuenta: permite a los usuarios obtener una lista de los bolsillos asociados a una cuenta específica. GET -> /api/accounts/{account_number}/pockets



![DER](https://github.com/yvahosc/transactionBankingSystem/assets/97228219/82321c89-d2ec-47c4-b4e5-bc32f77c318a)


