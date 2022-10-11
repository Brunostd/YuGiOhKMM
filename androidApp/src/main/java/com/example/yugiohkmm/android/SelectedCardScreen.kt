package com.example.yugiohkmm.android.ui.theme

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import com.example.yugiohkmm.android.Base64Custom
import com.example.yugiohkmm.android.DETAIL_ARGUMENT_KEY
import com.example.yugiohkmm.android.DETAIL_ARGUMENT_KEY2
import com.example.yugiohkmm.android.DETAIL_ARGUMENT_KEY3
import com.example.yugiohkmm.model.InfoModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun SelectedScreen(
    navController: NavController,
    arguments: Bundle?
){

    val scrollState = rememberScrollState()

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
        ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ){
            Row {
                Text(text = "<-",
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(10.dp)
                    )
                Text(text = "VOLTAR",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            navController.popBackStack()
                        })
            }
            Text(text = arguments?.getString(DETAIL_ARGUMENT_KEY).toString(),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
                fontSize = 28.sp
                )
            Box(Modifier.fillMaxWidth()) {
                GlideImage(imageModel = Base64Custom().decodificarBase64(arguments?.getString(DETAIL_ARGUMENT_KEY2).toString()),
                    modifier = Modifier
                        .width(300.dp)
                        .height(500.dp)
                        .align(Alignment.Center)
                )
            }
            Text(text = arguments?.getString(DETAIL_ARGUMENT_KEY3).toString())
        }
    }
}