package se.supernovait.littlelemon.menu.domain

sealed class SortType {
    data object Alphabetically : SortType()
    data object PriceAsc : SortType()
    data object PriceDesc : SortType()
}
