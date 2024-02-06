package com.nqh.a7minutesworkout

class ExerciseModel(
    private var id:Int,
    private var name: String,
    private var image: Int,
    private var completed: Boolean,
    private var selected: Boolean
) {
    fun getId(): Int {
        return id
    }
    fun setId(id: Int){
        this.id
    }
    fun getName(): String {
        return name
    }
    fun setName(name: String){
        this.name
    }
    fun getImage(): Int{
        return image
    }
    fun setImage(image: Int){
        this.image
    }
    fun getCompleted(): Boolean{
        return completed
    }
    fun setCompleted(completed: Boolean){
        this.completed
    }
    fun getSelected(): Boolean{
        return selected
    }
    fun setSelected(selected: Boolean){
        this.selected
    }
}