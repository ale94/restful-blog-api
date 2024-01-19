# BlogAPI: Publica Rápidamente con esta API Minimalista

¡Descubre BlogAPI! Este proyecto personal se creó con el objetivo específico de 
aprender tecnologías del lado del back, centrándose en el uso de Spring Boot. Con un 
enfoque minimalista, esta API REST te proporciona un espacio práctico y sencillo para 
explorar las funcionalidades básicas de un blog. Ideal para aquellos que desean adentrarse 
en el desarrollo con Spring Boot y construir sus habilidades en el ámbito del backend. 
¡Bienvenido a BlogAPI, donde el aprendizaje y la construcción van de la mano!

## Features

- RESTful routing
- Models with proper relationships
- Controllers/Models etc with proper separation of concerns
- JWT Authentication
- RESTful errors

## Routes List:

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
