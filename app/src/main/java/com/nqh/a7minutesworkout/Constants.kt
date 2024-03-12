package com.nqh.a7minutesworkout

import com.nqh.a7minutesworkout.models.ExerciseModel

object Constants {
    fun defaultExerciseList(): ArrayList<ExerciseModel> {
        val exerciseList = ArrayList<ExerciseModel>()

        val exercise1 = ExerciseModel(1, "Lunge", R.drawable.image_lunge, false, false)
        exerciseList.add(exercise1)
        val exercise2 = ExerciseModel(2, "Abdominal crunch", R.drawable.image_abdominal_crunch, false, false)
        exerciseList.add(exercise2)
        val exercise3 = ExerciseModel(3, "Plank", R.drawable.image_plank, false, false)
        exerciseList.add(exercise3)
        val exercise4 = ExerciseModel(4, "Squat", R.drawable.image_squat, false, false)
        exerciseList.add(exercise4)
        val exercise5 = ExerciseModel(5, "High knees", R.drawable.image_high_knees_running_in_place, false, false)
        exerciseList.add(exercise5)
        val exercise6 = ExerciseModel(6, "Push up", R.drawable.image_push_up, false, false)
        exerciseList.add(exercise6)
        val exercise7 = ExerciseModel(7, "Push up and rotation", R.drawable.image_push_up_and_rotation, false, false)
        exerciseList.add(exercise7)
        val exercise8 = ExerciseModel(8, "Side plank", R.drawable.image_side_plank, false, false)
        exerciseList.add(exercise8)
        val exercise9 = ExerciseModel(9, "Step up onto chair", R.drawable.image_step_up_onto_chair, false, false)
        exerciseList.add(exercise9)
        val exercise10 = ExerciseModel(10, "Jumping", R.drawable.image_jumping_jacks, false, false)
        exerciseList.add(exercise10)
        val exercise11 = ExerciseModel(11, "Triceps dip on chair", R.drawable.image_triceps_dip_on_chair, false, false)
        exerciseList.add(exercise11)
        val exercise12 = ExerciseModel(12, "Wall sit", R.drawable.image_wall_sit, false, false)
        exerciseList.add(exercise12)

        return exerciseList
    }
}