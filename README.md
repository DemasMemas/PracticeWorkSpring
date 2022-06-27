Приложение подразумевает под собой серверную/бек-энд/API часть для приложения, которое работает с абстрактным набором данных о работниках, оффисах и организациях в которых они работают

Функциональные требования для приложения:  
Разработать обработчик 15 различных http запросов, принимающие данные из body запроса, если запрос имеет метод Post, и дающий ответ в зависимости от полученных данных.  
Запросы:  
Регистрация, Активация кода регистрации, Логин  
Вывод списка, одиночного экземпляра, обновления и добавления нового: Работника, Офиса и Организации  
Также у Работника должны быть документы и данные о стране проживания  

Диаграмма вариантов использования:  
![image](https://user-images.githubusercontent.com/57756987/175766056-6aeb95a4-ec5e-4a3a-8644-17db25ed986d.png)  

Диаграмма классов:  
![class](https://user-images.githubusercontent.com/57756987/175766096-47cbcefc-1d9c-454a-b170-c661906d4b88.png)  

Диаграмма компонентов:  
![component](https://user-images.githubusercontent.com/57756987/175766415-b699d483-296c-4d5a-b4c0-976812ffa23c.jpeg)  

Диаграмма последовательности:  
![image](https://user-images.githubusercontent.com/57756987/175884877-ae39a844-7c2a-4721-82b5-5381cfb21485.png)

Интеграции:  
Для разработки такого невероятного приложения был использован фреймворк Spring и СУБД Postgres, так же был выбран ЯП Java и фреймворк для сборки проектов Maven, при помощи которого и были интегрированы Spring и PostgreSQl. Postgres является одной из самых распространных СУБД с открытым кодом, которая работает быстрее аналогов от Oracle. Spring же упрощает работу с классами и связями между ними, подразумевая "Контекст", который хранит и связывает в себе классы и их сущности. Spring data, являясь частью Spring плотно взаимодействует с ним и с БД, обрабатывая и передавая запросы в СУБД и возвращая полученные значения из неё.   
![image](https://user-images.githubusercontent.com/57756987/175495150-10793a95-1ae8-4796-b51f-911f52b8bc34.png)  

Интеграционное тестирование:  
Пока не уверен, что тестирую
