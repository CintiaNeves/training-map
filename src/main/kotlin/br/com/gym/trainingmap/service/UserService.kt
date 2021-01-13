package br.com.gym.trainingmap.service

import br.com.gym.trainingmap.domain.entity.User
import br.com.gym.trainingmap.domain.entity.UserType
import br.com.gym.trainingmap.exception.UserAlreadyRegisteredException
import br.com.gym.trainingmap.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class UserService {

    @Autowired
    lateinit var repository: UserRepository

    fun create(userName: String, password: String, changeAgent: String, userType: UserType): User {
        if(repository.findByUserNameAndUserType(userName, userType).isPresent)
            throw UserAlreadyRegisteredException()
        return repository.save(User(userName = userName, password = password, changeAgent = changeAgent, userType = userType))
    }
}