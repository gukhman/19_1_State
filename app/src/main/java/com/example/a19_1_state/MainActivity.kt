package com.example.a19_1_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Start()
        }
    }
}

@Composable
fun Start() {

    val fruits = mapOf(
        "Яблоки" to "Apples",
        "Мандарины" to "Mandarins",
        "Киви" to "Kiwis",
        "Нектарины" to "Nectarines",
        "Виноград" to "Grapes",
        "Бананы" to "Bananas",
        "Манго" to "Mangoes"
    )

    var isRussian = rememberSaveable { mutableStateOf(true) }

    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .background(Color(0xFFEFEFEF)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                ) {
                    Text(
                        text = if (isRussian.value) "Список фруктов" else "Fruit list",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 12.dp)
                            .clickable { isRussian.value = !isRussian.value }
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                fruits.forEach { (rus, eng) ->
                    Text(
                        text = if (isRussian.value) rus else eng,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = if (isRussian.value) "Switch to English" else "Переключить на Русский",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,

                    modifier = Modifier
                        .clickable { isRussian.value = !isRussian.value }
                )
            }
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview() {
    Start()
}