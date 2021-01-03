package br.com.gym.trainingmap.domain.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TEACHER")
data class Teacher(
        @Id
        @Column(name = "IDT_TEACHER")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "NAM_TEACHER", nullable = false)
        var name: String,

        @Column(name = "DES_EMAIL", nullable = false)
        var email: String,

        @Column(name = "DAT_CREATION")
        @CreationTimestamp
        val dateCreation: LocalDateTime = LocalDateTime.now(),

        @Column(name = "DAT_UPDATE")
        @UpdateTimestamp
        var dateUpdate: LocalDateTime =  LocalDateTime.now(),

        @Column(name = "DES_CHANGE_AGENT", nullable = false)
        var changeAgent : String,

        @OneToOne
        @JoinColumn(name = "IDT_USER")
        val user : User
){
    override fun toString(): String {
        return super.toString()
    }
}