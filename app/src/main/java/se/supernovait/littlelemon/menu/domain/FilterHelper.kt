package se.supernovait.littlelemon.menu.domain

class FilterHelper { //TODO create a FilterHelperTest and write a unit test for filterProducts

    fun filterProducts(type: FilterType, productsList: List<ProductItem>): List<ProductItem> {
        return when (type) {
            FilterType.All -> productsList
            FilterType.Dessert -> productsList.filter { it.category == ProductCategory.DESSERT }
            FilterType.Drinks -> productsList.filter { it.category == ProductCategory.DRINKS }
            FilterType.Food -> productsList.filter { it.category == ProductCategory.FOOD }
        }
    }
}