package com.example.finda.ui.Ui.theme

import android.os.Build
import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finda.R


@OptIn(ExperimentalTextApi::class)
val dmsansForSmalldisplay = FontFamily(
    Font(
        R.font.dmsans_variablefont_opsz_wght,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(variablefontSmalldisplay.weight),

        )
    )
)

@OptIn(ExperimentalTextApi::class)
val dmsansForsmallBody = FontFamily(
    Font(
        R.font.dmsans_variablefont_opsz_wght,
        variationSettings = FontVariation.Settings(FontVariation.weight(400))
    )
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    displaySmall = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        TextStyle(fontFamily = dmsansForSmalldisplay)
    } else {
        TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Bold)
    },
    bodySmall = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        TextStyle(fontFamily = dmsansForsmallBody)
    }    else {TextStyle(fontFamily = FontFamily.Default, fontWeight = FontWeight.Normal)}

    /* Other default text styles to override
    titleLarge = TextStyle(fraphy
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)