package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.entity.User
import br.com.gym.trainingmap.domain.entity.UserType
import br.com.gym.trainingmap.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService {

    @Autowired
    lateinit var repository: UserRepository

    fun create(email: String, password: String, changeAgent: String, userType: UserType): User {
        return repository.save(User(userName = email, password = password, changeAgent = changeAgent, userType = userType))
    }

}