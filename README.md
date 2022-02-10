#Тестовое задание - Список продуктов

Задача: Сделать сервис с использованием Spring Boot, Postgresql.
Сервис должен иметь несколько API endpoint’ов. Формат запроса и ответа - json.
Сохранение: web сервис, который будет сохранять по API:
-	Product
-	List
-	добавлять Product в созданный List 
Получение: API должно давать возможность получать списки:
-	Product
-	List со всеми Product, которые относятся к данному List по id

api:

    - get-запросы:
        /api/getproducts  - получить список всех продуктов
        /api/getproductslists  - получить все списки с продуктами
        /api/getproductlist  - получить список продуктов по id (параметр запроса - "id")
    - post-запросы:
        /api/addnewproduct  - добавить новый продукт в базу 
        /api/addnewproductlist  - добавить новый список в базу
        /api/addproducttolist  - добавить продукт в список продуктов (параметры запроса: "product" - имя продукта, "list" - имя списка продуктов)