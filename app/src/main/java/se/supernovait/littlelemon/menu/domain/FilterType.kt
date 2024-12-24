package se.supernovait.littlelemon.menu.domain

sealed class FilterType {
    data object All : FilterType()
    data object Drinks : FilterType()
    data object Food : FilterType()
    data object Dessert : FilterType()
}
