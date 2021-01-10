package br.com.gym.trainingmap.domain.response

import br.com.gym.trainingmap.domain.entity.Client
import java.time.LocalDateTime

class ClientResponse(
        val name: String,
  
        val userName: String,

        val datCreation: LocalDateTime
){
    object ModelMapper {
        fun from(client: Client) =
                ClientResponse(client.name, client.user.userName, client.dateCreation)
    }
}
