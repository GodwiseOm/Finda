package com.example.finda.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.finda.R

interface Category {
    val name: Int
    val location: Int
    val review: Int
    val image: Int
}

data class Boutique(
    @StringRes override val name: Int,
    @StringRes override val location: Int,
    @DrawableRes override val image: Int,
    @StringRes val about: Int,
    @StringRes override val review: Int,
    @StringRes val category: Int
) : Category


data class RestaurantKind(
    @DrawableRes override val image: Int,
    @StringRes override val name: Int,
    @StringRes override val location: Int,
    @StringRes val about: Int,
    @StringRes override val review: Int,
    val price: Int = 0

) : Category

data class BarBerShopKind(
    @DrawableRes override val image: Int,
    @StringRes override val name: Int,
    @StringRes override val location: Int,
    @StringRes override val review: Int,
    val price: Int = 0
) : Category

val aBoutique = Boutique(
    name = R.string.Dress_Island_Boutique_f_name,
    location = R.string.Dress_Island_Boutique_f_location,
    review = R.string.Dress_Island_Boutique_f_review,
    about = R.string.Dress_Island_Boutique_f_about,
    image = R.drawable.unique_couture,
    category = R.string.Dress_Island_Boutique_f_categories
)
val allRestaurants: List<RestaurantKind> = listOf(
    RestaurantKind(
        name = R.string.Amala_And_More_Grillerz_Garden_name,
        location = R.string.Amala_And_More_Grillerz_Garden_location,
        about = R.string.Amala_And_More_Grillerz_Garden_about,
        review = R.string.Amala_And_More_Grillerz_Garden_review,
        image = R.drawable.amala_and_more_grillerz_garden,
        price = 2

    ),
    RestaurantKind(
        name = R.string.Aviel_Restaurant_name,
        location = R.string.Aviel_Restaurant_address,
        about = R.string.Aviel_Restaurant_about,
        review = R.string.Aviel_Restaurant_review,
        image = R.drawable.aviel_restaurant, price = 4
    ),
    RestaurantKind(
        name = R.string.Mummy_Jay_Restaurant_and_Bar_name,
        location = R.string.Mummy_Jay_Restaurant_and_Bar_address,
        about = R.string.Mummy_Jay_Restaurant_and_Bar_about,
        review = R.string.Mummy_Jay_Restaurant_and_Bar_review,
        image = R.drawable.mummy_j_restaurant,
        price = 1500
    ),
    RestaurantKind(
        name = R.string.Owanbe_Cuisine_name,
        location = R.string.Owanbe_Cuisine_address,
        about = R.string.Owanbe_Cuisine_about,
        review = R.string.Owanbe_Cuisine_review_summary,
        image = R.drawable.owanbe_cusine, price = 1
    ),
    RestaurantKind(
        name = R.string.Amala_connect_name,
        location = R.string.Amala_Connect_location,
        about = R.string.Amala_Connect_About,
        review = R.string.Amala_Connect_review,
        image = R.drawable.amalaconnect,
        price = 2000
    )
)

val allBarberShops: List<BarBerShopKind> = listOf(
    BarBerShopKind(
        name = R.string.Ace_Of_Fades_Luxury_Barber_Shop_name,
        location = R.string.Ace_Of_Fades_Luxury_Barber_Shop_location,
        review = R.string.Ace_Of_Fades_Luxury_Barber_Shop_review,
        image = R.drawable.ace_of_fades_baber,
        price = 4500
    ), BarBerShopKind(
        name = R.string.GmG_Barbers_name,
        location = R.string.GmG_Barbers_location,
        review = R.string.GmG_Barbers_review,
        image = R.drawable.gmg_barberd, price = 3000
    ),
    BarBerShopKind(
        name = R.string.Stone_cutz_Abuja_name,
        location = R.string.Stone_cutz_Abuja_location,
        review = R.string.Stone_cutz_Abuja_review,
        image = R.drawable.stone_cutz,
        price = 3500
    ),
    BarBerShopKind(
        name = R.string.Tofboi_Barbers_name,
        location = R.string.Tofboi_Barbers_location,
        review = R.string.Tofboi_Barbers_review,
        image = R.drawable.tofboi_barber,
        price = 3000
    ),
    BarBerShopKind(
        name = R.string.Luxor_Spa_Abuja_Salon_and_Barbers_name,
        location = R.string.Luxor_Spa_Abuja_Salon_and_Barbers_location,
        review = R.string.Luxor_Spa_Abuja_Salon_and_Barbers_review,
        image = R.drawable.luxor,
        price = 5000
    )
)

val allHotels: List<RestaurantKind> = listOf(
    RestaurantKind(
        name = R.string.Aveon_Hotel_name,
        location = R.string.Aveon_Hotel_address,
        review = R.string.Aveon_Hotel_review,
        about = R.string.Aveon_Hotel_about,
        price = 60,
        image = R.drawable.avion_hotel
    ),
    RestaurantKind(
        name = R.string.Peace_Haven_Hotel_name,
        location = R.string.Peace_Haven_Hotel_address,
        review = R.string.Peace_Haven_Hotel_review,
        about = R.string.Peace_Haven_Hotel_about,
        price = 90000,
        image = R.drawable.peace_heaven
    ), RestaurantKind(
        name = R.string.Newton_Park_Hotels_and_Resort_name,
        location = R.string.Newton_Park_Hotels_and_Resort_address,
        review = R.string.Newton_Park_Hotels_and_Resort_review,
        about = R.string.Newton_Park_Hotels_and_Resort_about,
        price = 90000,
        image = R.drawable.newton_park
    ), RestaurantKind(
        name = R.string.Hawthorn_Suites_by_Wyndham_Abuja_name,
        location = R.string.Hawthorn_Suites_by_Wyndham_Abuja_address,
        review = R.string.Hawthorn_Suites_by_Wyndham_Abuja_review,
        about = R.string.Hawthorn_Suites_by_Wyndham_Abuja_about,
        price = 250000,
        image = R.drawable.howthorn
    ), RestaurantKind(
        name = R.string.Tranquil_Mews_Hotel_name,
        location = R.string.Tranquil_Mews_Hotel_address,
        review = R.string.Tranquil_Mews_Hotel_review,
        about = R.string.Tranquil_Mews_Hotel_about,
        price = 40000,
        image = R.drawable.tranquil_mews
    )
)

val allAutoMobileShops: List<RestaurantKind> = listOf(
    RestaurantKind(
        name = R.string.Auto_Centre_Abuja_name,
        location = R.string.Auto_Centre_Abuja_location,
        review = R.string.Auto_Centre_Abuja_review,

        image = R.drawable.auto_center_abuja,
        about = R.string.Auto_Centre_Abuja_services
    ),
    RestaurantKind(
        name = R.string.Auto_Spa_Limited_name,
        location = R.string.Auto_Spa_Limited_location,
        review = R.string.Auto_Spa_Limited_review,

        image = R.drawable.auto_spa,
        about = R.string.Auto_Spa_Limited_services
    ),
    RestaurantKind(
        name = R.string.Auto_Repair_Centre_Abuja_name,
        location = R.string.Auto_Repair_Centre_Abuja_location,
        review = R.string.Auto_Repair_Centre_Abuja_review,

        image = R.drawable.auto_repair_centre_abuja,
        about = R.string.Auto_Repair_Centre_Abuja_services
    ),
    RestaurantKind(
        name = R.string.CarFix_Service_Center_name,
        location = R.string.CarFix_Service_Center_location,
        review = R.string.CarFix_Service_Center_review,

        image = R.drawable.car_fix_center,
        about = R.string.CarFix_Service_Center_services
    ),
    RestaurantKind(
        name = R.string.Annapolis_Auto_Centre_name,
        location = R.string.Annapolis_Auto_Centre_location,
        review = R.string.Annapolis_Auto_Centre_review,

        image = R.drawable.annapolis,
        about = R.string.Annapolis_Auto_Centre_services
    )
)
val allMaleBoutique: List<Boutique> = listOf(
    Boutique(
        name = R.string.Potter_Image_Boutique_M_name,
        location = R.string.Potter_Image_Boutique_M_location,
        review = R.string.Potter_Image_Boutique_M_review,
        about = R.string.Potter_Image_Boutique_M_about,
        image = R.drawable.potter_boutique,
        category = R.string.Potter_Image_Boutique_M_categories
    ),
    Boutique(
        name = R.string.Iran_Femi_Best_Bespoke_Fashion_Designer_M_name,
        location = R.string.Iran_Femi_Best_Bespoke_Fashion_Designer_M_location,
        review = R.string.Iran_Femi_Best_Bespoke_Fashion_Designer_M_review,
        about = R.string.Iran_Femi_Best_Bespoke_Fashion_Designer_M_about,
        image = R.drawable.iran_femi_taylor,
        category = R.string.Iran_Femi_Category
    ),
    Boutique(
        name = R.string.DY_Unique_Closet_M_name,
        location = R.string.DY_Unique_Closet_M_location,
        review = R.string.DY_Unique_Closet_M_review,
        about = R.string.DY_Unique_Closet_M_about,
        image = R.drawable.dy_unique_men,
        category = R.string.DY_Unique_Closet_M_categories
    ),
    Boutique(
        name = R.string.Celio_M_name,
        location = R.string.Celio_M_location,
        review = R.string.Celio_M_review,
        about = R.string.Celio_M_about,
        image = R.drawable.celio,
        category = R.string.Celio_M_categories
    ),
    Boutique(
        name = R.string.Boutique_in_Apo_Pick_n_Wear_M_name,
        location = R.string.Boutique_in_Apo_Pick_n_Wear_M_location,
        review = R.string.Boutique_in_Apo_Pick_n_Wear_M_review,
        about = R.string.Boutique_in_Apo_Pick_n_Wear_M_about,
        image = R.drawable.apo_boutique,
        category = R.string.Boutique_in_Apo_Pick_n_Wear_M_categories
    )
)
val allFemaleBoutiques = listOf<Boutique>(
    Boutique(
        name = R.string.Brightway_Luxury_F_name,
        location = R.string.Brightway_Luxury_F_location,
        review = R.string.Brightway_Luxury_F_review,
        about = R.string.Brightway_Luxury_F_about,
        image = R.drawable.brightway_fashion,
        category = R.string.Brightway_Luxury_F_categories
    ),
    Boutique(
        name = R.string.Veras_Fashion_Emporium_F_name,
        location = R.string.Veras_Fashion_Emporium_F_location,
        review = R.string.Veras_Fashion_Emporium_F_review,
        about = R.string.Veras_Fashion_Emporium_F_about,
        image = R.drawable.vera_emporium,
        category = R.string.Veras_Fashion_Emporium_F_categories
    ),
    Boutique(
        name = R.string.Fashion_Feva_Boutique_F_name,
        location = R.string.Fashion_Feva_Boutique_F_location,
        review = R.string.Fashion_Feva_Boutique_F_review,
        about = R.string.Fashion_Feva_Boutique_F_about,
        image = R.drawable.fashion_feva_boutique,
        category = R.string.Fashion_Feva_Boutique_F_categories
    ),
    Boutique(
        name = R.string.Dress_Island_Boutique_f_name,
        location = R.string.Dress_Island_Boutique_f_location,
        review = R.string.Dress_Island_Boutique_f_review,
        about = R.string.Dress_Island_Boutique_f_about,
        image = R.drawable.unique_couture,
        category = R.string.Dress_Island_Boutique_f_categories
    ),
    Boutique(
        name = R.string.Uniqcouture_Fashion_House_F_name,
        location = R.string.Uniqcouture_Fashion_House_F_location,
        review = R.string.Uniqcouture_Fashion_House_F_review,
        about = R.string.Uniqcouture_Fashion_House_F_about,
        image = R.drawable.dress_island,
        category = R.string.Uniqcouture_Fashion_House_F_categories
    )
)


data class uiState(
    val showingShop:Boolean =true,
    var screenTwoDisplay:List<Category> = allAutoMobileShops,
    var screenThreeDisplay:Category = aBoutique,
    var allCategories: List<Int> = listOf(
        R.string.restaurant,
        R.string.hotel,
        R.string.barber_shop,
        R.string.mechanics,
        R.string.boutique
    ),
    @StringRes val boutique: Int = R.string.boutique,
    var subCategory: List<Int> = listOf(R.string.mechanics, R.string.boutique_women),
    var shopLists: List<Int> = listOf(R.string.men_boutique,R.string.boutique_women),
    var selectedShop: Category = Boutique(
        name = R.string.Uniqcouture_Fashion_House_F_name,
        location = R.string.Uniqcouture_Fashion_House_F_location,
        review = R.string.Uniqcouture_Fashion_House_F_review,
        about = R.string.Uniqcouture_Fashion_House_F_about,
        image = R.drawable.dress_island,
        category = R.string.Uniqcouture_Fashion_House_F_categories
    )

)