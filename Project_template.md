## Задание 1

Уточнения и допущения:
1) Пользователь может оплачивать подписку вручную через API, а также подписка может быть с автопродлением и автооплатой
2) Обновление каталога фильмов инициируется Кибербездной по cron из внешних онлайн-кинотеатров
3) Кибербездна периодически отправляет в рекомендательную систему данные о пользователе, необходимые для рекомендаций (история просмотров, оценки, предпочтения) 
4) Рекомендательная система регулярно пересчитывает рекомендации и отправляет результат в RabbitMQ
5) Рекомендательная система не готова перейти с RabbitMQ на Kafka

[Диаграмма контейнеров C4 (to be)](diagrams/container/cinema_to_be.puml)


## Задание 2

1) [Реализация proxy-server](src/microservices/proxy)
2) [Реализация events-server](src/microservices/events)
3) [Скриншот тестов](screenshot/run_tests.png)
4) [Скриншот кафка_топиков](screenshot/kafka_topics.png)

## Задание 3

1) [скриншот логов при вызове https://cinemaabyss.example.com/api/movies](screenshot/movies_proxy.png)
2) [скриншот вывода event-service после вызова тестов](screenshot/events_on_test.png)


## Задание 4

1) [скриншот старта helm](screenshot/helm_start.png)
2) [скриншот логов при вызове https://cinemaabyss.example.com/api/movies](screenshot/helm_movies_proxy.png)


# Задание 5
1) [скриншот статистики](screenshot/istio_sircuit_breaker.png)