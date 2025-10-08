package com.example.play_juegos

import androidx.compose.ui.graphics.painter.Painter

data class CheckInfo(var title:String, var image: Painter, var selected:Boolean, var
onCheckedChange:(Boolean)->Unit)