package com.example.yugiohkmm.android

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.core.text.htmlEncode
import androidx.navigation.NavController
import com.example.yugiohkmm.model.InfoModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

@SuppressLint("UnrememberedMutableState", "CoroutineCreationDuringComposition")
@Composable
fun HomeScreen(
    navController: NavController
){

    val mainScope = MainScope()
    var auxList: MutableState<List<InfoModel>> = mutableStateOf(arrayListOf())
    var url: MutableState<String> = mutableStateOf("")

    mainScope.launch {
        runCatching {
            com.example.yugiohkmm.Greeting().getCard()
        }.onSuccess {
            auxList.value = it.data
        }.onFailure {

        }
    }

    Column() {
        Text(
            text = "CARTAS YU-GI-OH",
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            fontSize = 22.sp
        )
        LazyColumn(modifier = Modifier.padding(10.dp)){
            items(auxList.value){ i ->
                Card(modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                ) {
                    Text(text = i.name, Modifier.clickable {
                        i.card_images.forEach {
                            url.value = Base64Custom().codificarBase64(it.image_url).toString()
                        }
                        navController.navigate(route = "selected_screen/"+i.name+"/"+url.value+" /"+i.desc)
                    })
                }
                //GlideImage(imageModel = i.card_images.elementAt(0).image_url)
                //Text(text = i.desc)
            }
        }
    }
}