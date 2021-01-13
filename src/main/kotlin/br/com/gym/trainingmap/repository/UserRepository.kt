package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.Client
import br.com.gym.trainingmap.domain.entity.User
import br.com.gym.trainingmap.domain.entity.UserType
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<User, Long> {
    abstract fun findByUserNameAndUserType(userName: String, userType: UserType): Optional<User>

}