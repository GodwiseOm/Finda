package com.example.finda.ui.Ui

import android.icu.number.NumberFormatter
import android.icu.text.NumberFormat
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.PlatformSpanStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.finda.R
import com.example.finda.data.BarBerShopKind
import com.example.finda.data.Boutique
import com.example.finda.data.Category
import com.example.finda.data.RestaurantKind
import com.example.finda.ui.Ui.theme.FinDaTheme
import com.example.finda.ui.Ui.theme.dmsansForSmalldisplay
import com.example.finda.ui.Ui.theme.dmsansForsmallBody


@Composable
fun ThirdScreen(shop: Category) {
    if (shop is RestaurantKind) {
        DisplayForRestaurantKind(shop)

    } else if (shop is BarBerShopKind) {
        DisplayForBarberShopKind(shop)
    } else {
        if (shop is Boutique)
            DisplayForBoutique(shop)
    }
}

@Composable
fun ImageDisplay(shop: Category, modifier: Modifier = Modifier) {
    Image(contentScale = ContentScale.Crop,
        modifier = modifier.background(color = Color(0xFFFFCB6B) ),
        painter = painterResource(id = shop.image),
        contentDescription = stringResource(id = shop.name)
    )

}


@Composable
fun DisplayForBarberShopKind(shopKind: BarBerShopKind) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFCB6B))) {
        ImageDisplay(
            shop = shopKind, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp)
                .fillMaxHeight(0.4f)
        )
        AboutTextDisplay(
            modifier = Modifier.fillMaxHeight(0.6f),
            nameOfBuss = shopKind.name,
            reviewOfBuss = shopKind.review,
            locationOfBuss = shopKind.location
        )

    }
}

@Composable
fun DisplayForRestaurantKind(shopKind: RestaurantKind) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFCB6B))){
        ImageDisplay(
            shop = shopKind, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp)
                .fillMaxHeight(0.4f)
        )
        AboutTextDisplay(
            modifier = Modifier.fillMaxHeight(0.6f),
            nameOfBuss = shopKind.name,
            aboutOfBuss = shopKind.about,
            reviewOfBuss = shopKind.review,
            locationOfBuss = shopKind.location,
            priceOfBuss = shopKind.price
        )

    }
}

@Composable
fun DisplayForBoutique(shopKind: Boutique) {
    Column (modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFCB6B))){
        ImageDisplay(
            shop = shopKind, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp)
                .fillMaxHeight(0.4f)
        )
        AboutTextDisplay(
            modifier = Modifier.fillMaxHeight(0.6f),
            nameOfBuss = shopKind.name,
            aboutOfBuss = shopKind.about,
            reviewOfBuss = shopKind.review,
            locationOfBuss = shopKind.location,
            categoryOfBuss = shopKind.category
        )

    }

}

@Composable
fun AboutTextDisplay(
    modifier: Modifier = Modifier,
    @StringRes nameOfBuss: Int,
    @StringRes reviewOfBuss: Int,
    @StringRes aboutOfBuss: Int? = null,
    @StringRes servicesOfBuss: Int? = null,
    @StringRes locationOfBuss: Int,
    @StringRes categoryOfBuss: Int? = null,
    @StringRes priceOfBuss: Int? = null
) {
    val nameOfBusiness = stringResource(id = nameOfBuss)
    val reviewOfBussiness = stringResource(id = reviewOfBuss)
    val aboutOfBussiness = if (aboutOfBuss != null) stringResource(id = aboutOfBuss) else null
    val locationOfBussiness = stringResource(id = locationOfBuss)

    val categoryOfBussiness =
        if (categoryOfBuss != null) stringResource(id = categoryOfBuss) else null


    val servicesOfBussiness = if (servicesOfBuss != null) {
        stringResource(id = priceOfBuss!!)
    } else null
    val priceOfBusiness = if (priceOfBuss != null) {

        NumberFormat.getCurrencyInstance().format(priceOfBuss).toString()
    } else null


    // headers for the respective description parameters
    val name = stringResource(R.string.name_e)
    val about = stringResource(R.string.about)
    val address = stringResource(R.string.address)
    val services = stringResource(R.string.services)
    val category = stringResource(R.string.categories)
    val popularView = stringResource(R.string.popular_review)
    val price = stringResource(R.string.price)
Column (modifier = modifier.padding(end = 4.dp).background(color = Color(0xFFFFCB6B) )){


    Text(buildAnnotatedString {
        withStyle(style = ParagraphStyle(textAlign = TextAlign.Justify, lineBreak = LineBreak.Paragraph)){
        withStyle(
            style = SpanStyle( color = Color.White,
                fontFamily = dmsansForSmalldisplay,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(name)
        }
        withStyle(style = SpanStyle(color = Color.White,fontFamily = dmsansForsmallBody)) {
            append(nameOfBusiness)
        }}
    })
    if (aboutOfBussiness != null) {
        Text(buildAnnotatedString {
            withStyle(style = ParagraphStyle(textAlign = TextAlign.Justify, lineBreak = LineBreak.Paragraph)){
            withStyle(
                style = SpanStyle(color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = dmsansForSmalldisplay
                )
            ) {
                append(about)
            }
            withStyle(style = SpanStyle(color = Color.White,fontFamily = dmsansForsmallBody)) {
                append(aboutOfBussiness)
            }}
        })
    }
    Text(buildAnnotatedString {
        withStyle(style = ParagraphStyle(textAlign = TextAlign.Justify, lineBreak = LineBreak.Paragraph)){
        withStyle(
            SpanStyle(
                color = Color.White,
                fontFamily = dmsansForSmalldisplay,
                fontWeight = FontWeight.Bold
            )
        ) {
            append(address)
        }
        withStyle(style = SpanStyle(color = Color.White, fontFamily = dmsansForsmallBody)) {
            append(locationOfBussiness)
        }}
    })

    Text(buildAnnotatedString {
        withStyle(style = ParagraphStyle(TextAlign.Justify,lineBreak = LineBreak.Paragraph)) {
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontFamily = dmsansForSmalldisplay,
                    fontWeight = FontWeight.Bold
                )
            ) {
                append(popularView)
            }

        withStyle(style = SpanStyle(color = Color.White,fontFamily = dmsansForsmallBody)) {
            append(reviewOfBussiness)
        }}
    })
    if (servicesOfBuss != null)
        Text(buildAnnotatedString {
            withStyle(SpanStyle(color = Color.White,fontFamily = dmsansForSmalldisplay, fontWeight = FontWeight.Bold)) {
                append(services)
            }
            withStyle(style = SpanStyle(color = Color.White,fontFamily = dmsansForsmallBody)) {
                append(servicesOfBussiness)
            }
        })

    if (categoryOfBussiness != null) {
        Text(buildAnnotatedString {
            withStyle(
                style = SpanStyle(color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = dmsansForSmalldisplay
                )
            ) {
                append(category)
            }
            withStyle(style = SpanStyle(color = Color.White,fontFamily = dmsansForsmallBody)) {
                append(categoryOfBussiness)
            }
        })
    }



    if (priceOfBusiness != null) Text(buildAnnotatedString {
        withStyle(SpanStyle(color = Color.White,fontFamily = dmsansForSmalldisplay, fontWeight = FontWeight.Bold)) {
            append(price)
        }
        withStyle(style = SpanStyle(color = Color.White,fontFamily = dmsansForsmallBody)) {
            append(priceOfBusiness)
        }
    })

}
}

@Preview
@Composable
fun ThirdScreenPreview() {

    val shop = RestaurantKind(
        name = R.string.Amala_And_More_Grillerz_Garden_name,
        location = R.string.Amala_And_More_Grillerz_Garden_location,
        about = R.string.Amala_And_More_Grillerz_Garden_about,
        review = R.string.Amala_And_More_Grillerz_Garden_review,
        image = R.drawable.amala_and_more_grillerz_garden,
        price = 2

    )
    FinDaTheme {
        Surface {
            ThirdScreen(shop = shop)
        }
    }
}