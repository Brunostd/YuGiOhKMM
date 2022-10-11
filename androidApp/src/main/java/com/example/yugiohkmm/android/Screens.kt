package com.example.yugiohkmm.android

const val DETAIL_ARGUMENT_KEY = "name"
const val DETAIL_ARGUMENT_KEY2 = "image"
const val DETAIL_ARGUMENT_KEY3 = "desc"

sealed class Screens(val route: String){
    object home: Screens(route = "home_screen")
    object selected: Screens(route = "selected_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}/{$DETAIL_ARGUMENT_KEY3}"){
       fun detailPassName(cardName: String): String{
            return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = cardName)
        }
//        fun selectedPassNameAndImageAndDesc(name: String, image: String, desc: String):String{
//
//            return "selected_screen/$name,$image,$desc"
//
//        }
    }
}
