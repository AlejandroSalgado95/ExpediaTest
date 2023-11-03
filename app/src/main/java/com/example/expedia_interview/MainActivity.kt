package com.example.expedia_interview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expedia_interview.ui.Item
import com.example.expedia_interview.ui.theme.Expedia_interviewTheme
import kotlinx.coroutines.delay
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Expedia_interviewTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen(Modifier.fillMaxSize())
                }
            }
        }
    }
}


@Composable
fun MyScreen(modifier: Modifier) {

    var state by remember { mutableStateOf(listOf<Item>()) }
    var number by remember { mutableStateOf(0) }

    LaunchedEffect(key1 = true){
        while(true){
            delay(1000)
            state += Item(number)
            number++
        }
    }


    Column(modifier = modifier) {
        LazyColumn() {
            items(state.size) { i ->
                ItemView(myItem = state[i])
            }
        }

    }
}

@Composable
fun ItemView(myItem: Item) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {

        Text(
            modifier = Modifier
                .padding(2.dp),
            text = myItem.randomInt.toString(),
            fontSize = 16.sp,
            color = Color.Black
        )

    }

}
