# Flaze

Flaze - это API для создания и чтения статей. Этот проект предоставляет простой и удобный способ управления статьями через RESTful интерфейс.

## Использование

### Создание статьи

Чтобы создать новую статью, выполните HTTP POST запрос на `/api/v1/articles/add?userId=идентифекатор пользователя` с JSON телом статьи. Пример запроса:

```http
POST //api/v1/articles/add?userId=1
Content-Type: application/json

{
  "title": "Название статьи",
  "description": "Описание статьи",
  "text": "Текст статьи",
  "author": {
    "id": 123,
    "username": "автор",
    "age": 30,
    "email": "автор@example.com"
  }
}
```

### Чтение статьи

Чтобы прочитать статью, выполните HTTP GET запрос на `/articles/{articleId}`, где `{articleId}` - это идентификатор статьи. Пример запроса:

```http
GET /articles/1
```

### Документация Swagger

Вы можете ознакомиться с документацией Swagger для этого API, перейдя по следующему URL:

```
http://your-api-domain.com/swagger-ui.html
```

## Установка и запуск

1. Клонируйте репозиторий:

```bash
git clone https://github.com/yourusername/flaze.git
```

2. Перейдите в директорию проекта:

```bash
cd flaze
```

3. Установите зависимости:

```bash
npm install
```

4. Запустите проект:

```bash
npm start
```

## Лицензия

Этот проект лицензируется в соответствии с [Лицензией MIT](LICENSE).