package br.com.gym.trainingmap.domain.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "TRAINING")
data class Training(
        @Id
        @Column(name = "IDT_TRAINING")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "DES_TRAINING_SEQUENCE", nullable = false)
        val trainingSequence: String,

        @Column(name = "DAT_EXPIRATION")
        var expirationDate: LocalDate,

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

        @ManyToOne()
        @JoinColumn(name = "IDT_GYM_STUDENT")
        val client: Client,

        @OneToOne()
        @JoinColumn(name = "IDT_TEACHER")
        val teacher: Teacher

){

}