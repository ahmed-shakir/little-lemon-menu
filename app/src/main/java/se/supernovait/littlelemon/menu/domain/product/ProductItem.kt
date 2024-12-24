package se.supernovait.littlelemon.menu.domain.product

import androidx.annotation.DrawableRes
import java.io.Serializable

data class ProductItem(
    val title: String,
    val price: Double,
    val category: String,
    @DrawableRes val image: Int
) : Serializable
