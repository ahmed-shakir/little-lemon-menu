package se.supernovait.littlelemon.menu.presentation.topbar

import se.supernovait.littlelemon.menu.domain.filter.FilterType
import se.supernovait.littlelemon.menu.domain.sort.SortType

sealed interface TopBarAction {
    data class OnFilter(val filterType: FilterType): TopBarAction
    data class OnSort(val sortType: SortType): TopBarAction
    data object OnDismiss: TopBarAction
}
