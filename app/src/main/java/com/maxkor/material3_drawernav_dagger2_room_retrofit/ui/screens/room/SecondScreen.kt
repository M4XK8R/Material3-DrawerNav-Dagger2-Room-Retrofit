package com.maxkor.material3_drawernav_dagger2_room_retrofit.ui.screens.room

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maxkor.material3_drawernav_dagger2_room_retrofit.R
import com.maxkor.material3_drawernav_dagger2_room_retrofit.data.room.MyEntity
import kotlinx.coroutines.launch

@Composable
fun SecondScreen() {
    val viewModel: SecondViewModel = viewModel()

    val itemsState = viewModel
        .getAllItems()
        .collectAsState(initial = emptyList())

    val coroutine = rememberCoroutineScope()

    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        var textState by remember {
            mutableStateOf("")
        }
        Column {
            Text(
                text = "Second screen",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp)
            )

            Spacer(modifier = Modifier.size(30.dp))

            TextField(
                value = textState,
                onValueChange = { textState = it }
            )

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(itemsState.value.asReversed()) {
                    ListItem(
                        headlineContent = {
                            Text(
                                text = it.headlineContent,
                                fontSize = 22.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(12.dp)
                            )
                        },
                        modifier = Modifier.clickable {
                            coroutine.launch {
                                viewModel.deleteFromDb(it)
                            }
                        }
                    )
                }
            }
        }

        FloatingActionButton(
            onClick = {
                coroutine.launch {
                    viewModel.insertToDb(MyEntity(textState))
                }
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 12.dp, end = 12.dp),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.baseline_add_circle_outline_64
                ),
                contentDescription = null,
            )
        }
    }
}