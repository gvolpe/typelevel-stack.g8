package $package$.service

import cats.effect.IO
import $package$.TestUsers.users
import $package$.model.{UserName,User}
import $package$.repository.algebra.UserRepository

object TestUserService {

  private val testUserRepo: UserRepository[IO] = new UserRepository[IO] {
    def findUser(username: UserName): IO[Option[User]] = IO {
      users.find(_.username.value == username.value)
    }
  }

  val service: UserService[IO] = new UserService[IO](testUserRepo)

}
