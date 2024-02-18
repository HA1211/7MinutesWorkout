package com.nqh.a7minutesworkout

object Constants {
    fun defaultExerciseList(): ArrayList<ExerciseModel> {
        val exerciseList = ArrayList<ExerciseModel>()

        val coBungTren = ExerciseModel(1, "CƠ BỤNG TRÊN", R.drawable.co_bung_tren, false, false)
        exerciseList.add(coBungTren)
        val coLienSuon = ExerciseModel(2, "CƠ LIÊN SƯỜN", R.drawable.co_lien_suon, false, false)
        exerciseList.add(coLienSuon)
        val coXuongChau = ExerciseModel(3, "CƠ XƯƠNG CHẬU", R.drawable.co_xuong_chau, false, false)
        exerciseList.add(coXuongChau)
        val khopGoi = ExerciseModel(4, "KHỚP GỐI", R.drawable.khop_goi, false, false)
        exerciseList.add(khopGoi)

        return exerciseList
    }
}