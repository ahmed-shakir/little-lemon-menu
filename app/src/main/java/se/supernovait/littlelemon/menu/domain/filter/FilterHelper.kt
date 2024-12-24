package se.supernovait.littlelemon.menu.domain.filter

import se.supernovait.littlelemon.menu.domain.product.ProductCategory
import se.supernovait.littlelemon.menu.domain.product.ProductItem

object FilterHelper {

    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            FilterType.All -> productsList
            FilterType.Dessert -> productsList.filter { it.category == ProductCategory.DESSERT }
            FilterType.Drinks -> productsList.filter { it.category == ProductCategory.DRINKS }
            FilterType.Food -> productsList.filter { it.category == ProductCategory.FOOD }
        }
    }
}