package br.com.gym.trainingmap.domain.entity

enum class MuscleGroup(val muscleGroup : String) {

    CHEST("PEITO"),
    CARDIO("CARDIO"),
    GLUTES("GLÚTEOS"),
    BICEPS("BÍCEPS"),
    ABDOMEN("ABDÔMEN"),
    TRAPS("TRAPÉZIOS"),
    TRICEPS("TRICEPS"),
    QUADS("QUADRÍCEPS"),
    SHOULDERS("OMBROS"),
    OBLIQUES("OBLÍQUOS"),
    FOREARM("ANTEBRAÇO"),
    ADDUCTORS("ADUTORES"),
    CALVES("PANTURRILHAS"),
    ABDUCTORS("ABDUTORES"),
    HAMSTRINGS("POSTERIORES");

    companion object {
        private val map = values()
                .associateBy(MuscleGroup::muscleGroup)
        fun fromString(value: String) = map[value]
    }
}