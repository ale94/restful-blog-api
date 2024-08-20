# BlogAPI Publica Rápidamente con esta API Minimalista

## Introducción

¡Descubre BlogAPI! Este proyecto personal se creó con el objetivo específico de 
aprender tecnologías del lado del back, centrándose en el uso de Spring Boot. Con un 
enfoque minimalista, esta API REST te proporciona un espacio práctico y sencillo para 
explorar las funcionalidades básicas de un blog. Ideal para aquellos que desean adentrarse 
en el desarrollo con Spring Boot y construir sus habilidades en el ámbito del backend. 
¡Bienvenido a BlogAPI, donde el aprendizaje y la construcción van de la mano!

## Configuración
Para utilizar la API REST en tu entorno local, sigue estos pasos:

1. Clona este repositorio: `https://github.com/ale94/Book-REST-API-CRUD.git`
2. Crear base de datos H2 Console: `create database testdb`
3. Cambie el nombre de usuario y la contraseña de H2 Console según su instalación:
    - open src/main/resources/application.properties
    - change spring.datasource.username and spring.datasource.password según su instalación de H2
4. Compile y ejecute la aplicación usando maven: `mvn spring-boot:run`
5. La aplicación comenzará a ejecutarse en http://localhost:8080.

## Endpoints

### Comments

| Method     | URI                               | Action                                                  |
|------------|-----------------------------------|---------------------------------------------------------|
| `POST`     | `comments`                        | `App\Http\Controllers\CommentsController@createComment` |
| `GET/HEAD` | `comments`                        | `App\Http\Controllers\CommentsController@getComments`   |
| `GET/HEAD` | `comments/{id}`                   | `App\Http\Controllers\CommentsController@getComment`    |
| `DELETE`   | `comments/{id}`                   | `App\Http\Controllers\CommentsController@deleteComment` |
| `PUT`      | `comments/{id}`                   | `App\Http\Controllers\CommentsController@updateComment` |

### Posts

| Method     | URI                               | Action                                                  |
|------------|-----------------------------------|---------------------------------------------------------|
| `POST`     | `posts`                           | `App\Http\Controllers\PostsController@createPost`       |
| `GET/HEAD` | `posts`                           | `App\Http\Controllers\PostsController@getPosts`         |
| `PUT`      | `posts/{id}`                      | `App\Http\Controllers\PostsController@updatePost`       |
| `GET/HEAD` | `posts/{id}`                      | `App\Http\Controllers\PostsController@getPost`          |
| `DELETE`   | `posts/{id}`                      | `App\Http\Controllers\PostsController@deletePost`       |

### Users

| Method     | URI                               | Action                                                  |
|------------|-----------------------------------|---------------------------------------------------------|
| `GET/HEAD` | `users`                           | `App\Http\Controllers\UsersController@getUsers`         |
| `POST`     | `users`                           | `App\Http\Controllers\UsersController@createUser`       |
| `PUT`      | `users/{id}`                      | `App\Http\Controllers\UsersController@updateUser`       |
| `GET/HEAD` | `users/{id}`                      | `App\Http\Controllers\UsersController@getUser`          |
| `DELETE`   | `users/{id}`                      | `App\Http\Controllers\UsersController@deleteUser`       |
| `GET/HEAD` | `users/{id}/comments`             | `App\Http\Controllers\UsersController@getUserComments`  |
| `GET/HEAD` | `users/{id}/comments/{commentId}` | `App\Http\Controllers\UsersController@getUserComment`   |
| `GET/HEAD` | `users/{id}/posts`                | `App\Http\Controllers\UsersController@getUserPosts`     |
| `GET/HEAD` | `users/{id}/posts/{postId}`       | `App\Http\Controllers\UsersController@getUserPost`      |
