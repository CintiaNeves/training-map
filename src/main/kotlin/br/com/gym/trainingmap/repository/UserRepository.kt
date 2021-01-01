package br.com.gym.trainingmap.repository

import br.com.gym.trainingmap.domain.entity.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User, Long> {

}