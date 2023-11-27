package com.compose.flyticketsbooking.feature.home.tabs.tabScreen.oneway

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.compose.flyticketsbooking.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun CustomPassengersPickerDialog(
    label: String,
    onDismissRequest: () -> Unit,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        PassengersPickerUI(label, onDismissRequest)
    }
}

@Composable
fun PassengersPickerUI(
    label: String,
    onDismissRequest: () -> Unit,
    viewModel: OneWayViewModel = koinViewModel()
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        elevation = 10.dp,
        backgroundColor = Color.White,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp, horizontal = 5.dp)
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(30.dp))

            val chosenAdult = remember { mutableStateOf(defaultValue) }
            val chosenChild = remember { mutableStateOf(defaultValue) }
            val chosenBaby = remember { mutableStateOf(defaultValue) }

            PassengersSelectionSection(
                onChildChosen = { chosenChild.value = it.toInt() },
                onAdultChosen = { chosenAdult.value = it.toInt() },
                onBabyChosen = { chosenBaby.value = it.toInt() },
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                shape = RoundedCornerShape(5.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                onClick = {
                    val result = "Child (${chosenChild.value}), Adult (${chosenAdult.value}), Baby (${chosenBaby.value})"
                        viewModel.setPassengers(result)
                    Log.e("pickedDate", result)
                    onDismissRequest()
                }
            ) {
                Text(
                    text = stringResource(id = R.string.done),
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun PassengersSelectionSection(
    onChildChosen: (String) -> Unit,
    onAdultChosen: (String) -> Unit,
    onBabyChosen: (String) -> Unit,
) {

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {
        SelectSection(
            text = "Baby",
            onItemSelected =  onBabyChosen
        )

        SelectSection(
            text = "Adult",
            onItemSelected =  onAdultChosen
        )

        SelectSection(
            text = "Child",
            onItemSelected = onChildChosen
        )
    }
}

@Composable
fun SelectSection(
    text: String,
    onItemSelected: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(120.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        InfinitePicker(
            onItemSelected = onItemSelected
        )
    }
}

@Composable
fun InfinitePicker(
    modifier: Modifier = Modifier,
    onItemSelected: (String) -> Unit,
) {

    val listState = rememberLazyListState(defaultValue)
    val currentValue = remember { mutableStateOf("") }
    val items = remember { mutableStateOf(count) }

    LaunchedEffect(key1 = !listState.isScrollInProgress) {
        onItemSelected(currentValue.value)
        listState.animateScrollToItem(index = listState.firstVisibleItemIndex)
    }

    Box(
        modifier = Modifier.height(106.dp)
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            state = listState,
            content = {
                items(count = Int.MAX_VALUE, itemContent = {
                    val index = it % items.value.size
                    if (it == listState.firstVisibleItemIndex + 1) {
                        currentValue.value = items.value[index]
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = items.value[index],
                        modifier = Modifier.alpha(if (it == listState.firstVisibleItemIndex + 1) 1f else 0.3f),
                        style = MaterialTheme.typography.h6,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(6.dp))
                })
            }
        )
    }
}

val defaultValue = 0
val count = (0..100).map { it.toString() }