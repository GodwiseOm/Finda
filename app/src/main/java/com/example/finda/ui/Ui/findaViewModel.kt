package com.example.finda.ui.Ui

import androidx.annotation.StringRes
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat.getString
import androidx.lifecycle.ViewModel
import com.example.finda.R
import com.example.finda.data.Category
import com.example.finda.data.allAutoMobileShops
import com.example.finda.data.allBarberShops
import com.example.finda.data.allFemaleBoutiques
import com.example.finda.data.allHotels
import com.example.finda.data.allMaleBoutique
import com.example.finda.data.allRestaurants
import com.example.finda.data.uiState

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class findaViewModel():ViewModel(){
    val appBarTittle = MutableStateFlow<Int>(0)
  private val _uiState = MutableStateFlow(uiState())
    val uiState:StateFlow<uiState> = _uiState.asStateFlow()

  private val _firstScreenDisplay = MutableStateFlow( uiState.value.allCategories)
  val  firstScreenDisplay = _firstScreenDisplay.asStateFlow()

    private val _screenTwoDisplay = MutableStateFlow(_uiState.value.screenTwoDisplay)
    val screenTwoDisplay :StateFlow<List<Category>> = _screenTwoDisplay.asStateFlow()

    fun updateAppBarTitle(@StringRes tittleId:Int){
        appBarTittle.value = tittleId

    }

    fun firstScreenDiplayShop() {
        _firstScreenDisplay.value = uiState.value.shopLists
        _uiState.update { uiState -> uiState.copy(showingShop = false) }
    }

 fun categoryClicked(@StringRes categoryName:Int){
   when(categoryName){
     R.string.restaurant ->   _uiState.update {  uiState -> uiState.copy(screenTwoDisplay = allRestaurants) }
     R.string.mechanics-> _uiState.update {uiState ->  uiState.copy (screenTwoDisplay = allAutoMobileShops) }
     R.string.hotel ->_uiState.update { uiState ->  uiState.copy(screenTwoDisplay = allHotels) }
     R.string.barber_shop -> _uiState.update { uiState ->  uiState.copy(screenTwoDisplay = allBarberShops) }
     R.string.boutique-> _uiState.update { uiState -> uiState.copy(screenTwoDisplay = allMaleBoutique) }
     R.string.men_boutique-> _uiState.update { uiState -> uiState.copy(screenTwoDisplay = allMaleBoutique) }
     else -> _uiState.update {uiState -> uiState.copy(screenTwoDisplay = allFemaleBoutiques)  }
   }

 }
  fun shopClicked(shop:Int){

   val category =  _uiState.value.screenTwoDisplay
    val selectedShop = category.find { it.name == shop }
    if(selectedShop!=null){
    _uiState.value.copy(screenThreeDisplay = selectedShop)}
  }


}