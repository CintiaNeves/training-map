package br.com.gym.trainingmap.domain.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "EXERCISE")
data class Exercise(
        @Id
        @Column(name = "IDT_EXERCISE")
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = 0,

        @Column(name = "NAM_EXERCISE", nullable = false)
        val name: String,

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
        val exerciseMember: ExerciseMember
){
    override fun toString(): String {
        return super.toString()
    }
}