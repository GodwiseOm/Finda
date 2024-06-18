package com.example.finda.ui.Ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column



import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.finda.R
import com.example.finda.data.Category
import com.example.finda.data.allBarberShops
import com.example.finda.ui.Ui.theme.FinDaTheme


@Composable
fun SecondScreen(
    onShopClicked:(Int)-> Unit,
    modifier: Modifier = Modifier,
    categoryItems: List<Category>,

) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFD68C))
    ) {

        ItemList(itemList = categoryItems, paddingValues = PaddingValues(top = 20.dp), onShopClicked = onShopClicked)

    }


}



//list of items under a particular category
@Composable
fun ItemList(
    onShopClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    itemList: List<Category>,
    paddingValues: PaddingValues
) {
    LazyColumn(contentPadding = paddingValues) {

        items(itemList, key = { item -> item.name }) { item ->
            CategoryItem(image = item.image, description = item.name, onShopClicked = {onShopClicked(item.name)} )
        }

    }

}

// category items listed under the different categories, hotels for hotel, restaurants for restaurant
@Composable
fun CategoryItem(
    onShopClicked: (Int) -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes image: Int,
    @StringRes description: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()

            .padding(start = 1.dp, end = 4.dp, bottom = 36.dp).clickable { onShopClicked(description) }
            .height(100.dp)
            .background(color = Color(0xffC7B99E))
    ) {

       Card(shape = RectangleShape, modifier = Modifier.size(100.dp).align(Alignment.CenterVertically)) {
           Image(
               contentScale = ContentScale.Crop,
               painter = painterResource(id = image), modifier = Modifier.clipToBounds().fillMaxSize(),
               contentDescription = stringResource(id = description)
           )
       }
        Text(
            modifier = Modifier.padding(start = 8.dp, top = 12.dp).align(Alignment.CenterVertically),
            style = MaterialTheme.typography.displaySmall,
            text = stringResource(id = description),
            color = Color.White
        )
    }

}

@Preview
@Composable
fun SecondScreenPreview() {

    FinDaTheme {
        Surface {
            SecondScreen(
                categoryItems = allBarberShops,
                onShopClicked = { }

            )
        }
    }
}