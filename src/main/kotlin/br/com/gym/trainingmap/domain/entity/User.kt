package br.com.gym.trainingmap.domain.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "USER")
data class User(
        @Id
        @Column(name = "IDT_USER")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @Column(name = "DES_USER_NAME", nullable = false)
        var userName: String,

        @Column(name = "DES_PASSWORD", nullable = false)
        var password: String,

        @Column(name = "FLG_ACTIVE", nullable = false)
        var active: Boolean = true,

        @Column(name = "DAT_CREATION")
        @CreationTimestamp
        val dateCreation: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DAT_UPDATE")
        @UpdateTimestamp
        var dateUpdate: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DES_CHANGE_AGENT", nullable = false)
        var changeAgent : String,

        @Enumerated(EnumType.STRING)
        val userType : UserType
){

}