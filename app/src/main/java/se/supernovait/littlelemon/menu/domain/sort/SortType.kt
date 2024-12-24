package se.supernovait.littlelemon.menu.domain.sort

sealed class SortType {
    data object Alphabetically : SortType()
    data object PriceAsc : SortType()
    data object PriceDesc : SortType()
}
