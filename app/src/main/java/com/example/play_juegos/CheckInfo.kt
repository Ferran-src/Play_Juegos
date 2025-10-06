package com.example.play_juegos
data class CheckInfo(var title:String, var selected:Boolean, var
onCheckedChange:(Boolean)->Unit)