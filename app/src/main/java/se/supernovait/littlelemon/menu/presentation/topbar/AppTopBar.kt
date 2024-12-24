package se.supernovait.littlelemon.menu.presentation.topbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import se.supernovait.littlelemon.menu.R
import se.supernovait.littlelemon.menu.domain.filter.FilterType
import se.supernovait.littlelemon.menu.domain.sort.SortType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    showMenu: Boolean = true,
    stateHolder: TopBarMenuStateHolder = rememberTopBarMenuStateHolder(false),
    onAction: (TopBarAction) -> Unit = { }
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_name),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        actions = {
            if(showMenu) {
                IconButton(onClick = { stateHolder.setIsExpanded(!stateHolder.isExpanded) }) {
                    Icon(Icons.Default.MoreVert, contentDescription = "More options")
                }
            }
            ActionDropdownMenu(
                expanded = stateHolder.isExpanded,
                onAction = {
                    if(it !is TopBarAction.OnDismiss) {
                        onAction(it)
                    }
                    stateHolder.setIsExpanded(false)
                }
            )
        }
    )
}

@Composable
fun ActionDropdownMenu(
    expanded: Boolean,
    onAction: (TopBarAction) -> Unit
) {
    DropdownMenu(expanded = expanded, onDismissRequest = { onAction(TopBarAction.OnDismiss) }) {
        DropdownMenuItem(
            text = { Text(stringResource(R.string.sort_a_z)) },
            onClick = { onAction(TopBarAction.OnSort(SortType.Alphabetically)) }
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.sort_price_ascending)) },
            onClick = { onAction(TopBarAction.OnSort(SortType.PriceAsc)) }
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.sort_price_descending)) },
            onClick = { onAction(TopBarAction.OnSort(SortType.PriceDesc)) }
        )

        HorizontalDivider()

        DropdownMenuItem(
            text = { Text(stringResource(R.string.filter_all)) },
            onClick = { onAction(TopBarAction.OnFilter(FilterType.All)) }
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.filter_drinks)) },
            onClick = { onAction(TopBarAction.OnFilter(FilterType.Drinks)) }
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.filter_food)) },
            onClick = { onAction(TopBarAction.OnFilter(FilterType.Food)) }
        )
        DropdownMenuItem(
            text = { Text(stringResource(R.string.filter_dessert)) },
            onClick = { onAction(TopBarAction.OnFilter(FilterType.Dessert)) }
        )
    }
}
