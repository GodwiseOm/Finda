package com.example.finda.ui.Ui

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(currentCategory: String, onClick: () -> Unit, modifier:Modifier ){
    TopAppBar(
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors(
            navigationIconContentColor = Color.White,
            containerColor = Color(0xffffa500) ,
            titleContentColor = Color.White
        ),
        title = {
            Text(modifier = Modifier.padding(top =12.dp),
                text = currentCategory,
                fontSize = 28.sp,
                style = MaterialTheme.typography.labelSmall
            )
        },
        navigationIcon = {
            IconButton(modifier = Modifier.padding(top = 7.dp), onClick = onClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "go back"
                )
            }
        }
    )

}
@Composable
fun botom(){
    BottomAppBar {

    }
}