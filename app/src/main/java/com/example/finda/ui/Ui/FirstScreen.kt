package com.example.finda.ui.Ui

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finda.R
import com.example.finda.ui.Ui.theme.FinDaTheme


@Composable
fun FirstScreen(
    modifier: Modifier = Modifier,
    shop: Int,
    shopClick: (Int) -> Unit,
    content: List<Int>,
    onContentClick: (Int) -> Unit,
    showingShop:Boolean = true
) {
    @StringRes val clickedCategory by rememberSaveable {
        mutableIntStateOf(0)
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xffffa500))
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(28.dp),
            modifier = Modifier
                .fillMaxHeight(3 / 7f)
                .fillMaxWidth(4 / 7f)
                .align(Alignment.Center)

        ) {
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
                content.forEach {
                    CategoryDisplay(category = it, onContentClick = onContentClick)


                }
                if(!showingShop){
                CategoryDisplay(category = shop, onContentClick = shopClick)}


            }
        }

    }

}

// display for the diffrent categories, restaurant, hotel etc.
@Composable
fun CategoryDisplay(
    @StringRes category: Int,
    modifier: Modifier = Modifier,
    onContentClick: (Int) -> Unit
) {
    Card(
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xffffa500)),
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 2.dp)
            .clickable { onContentClick(category) }
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 8.dp, bottom = 8.dp),
            style = MaterialTheme.typography.displaySmall,
            text = stringResource(id = category),
            textAlign = TextAlign.Center,
            color = Color.White
        )

    }
}


@Preview
@Composable
fun Preview() {
    FinDaTheme {
        Surface {
            FirstScreen(
                content = listOf(
                    R.string.boutique,
                    R.string.mechanics,
                    R.string.hotel
                ), onContentClick = {},
                shop = R.string.boutique,
                shopClick = {},
                )
        }
    }
}