# CryptoCurrencyWatcher

Simple REST service for viewing cryptocurrency quotes

**What technologies I used on the project:** Java, Hibernate,
Spring Data JPA, Spring Core, Spring MVC,
Spring AOP, REST API, Tomcat, MySql, Git, log4j, JSON

**Application functionality:**
- viewing the list of available cryptocurrencies
- viewing the current price for the specified cryptocurrency
- write to the log a message about a change in the price of the currency selected by the user by more than 1%
- log writes in server log
- once a minute, the current prices for available cryptocurrencies are requested from an external source CoinLore 
  and stored in the database(https://api.coinlore.net/api/ticker/?id=90 (BTC)).

Do not forget to include the url of the embedded database in the file: src/main/resources/application.properties.
To create tables use the script resourses/createTable.sql.

REST methods:

    1. http://localhost:8080/currencies/
    use to viewing the list of available cryptocurrencies
    
    2. http://localhost:8080/currencies/currency?id=80
    use to viewing the current price for the specified cryptocurrency

    3. http://localhost:8080/currencies/notify?username=petya&symbol=ETH
    use to get order to log a message about a change in the price of the selected  currency by more than 1%