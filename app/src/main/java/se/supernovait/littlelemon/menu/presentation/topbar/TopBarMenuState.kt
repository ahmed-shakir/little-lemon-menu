package se.supernovait.littlelemon.menu.presentation.topbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class TopBarMenuState(isExpanded: Boolean) {
    var isExpanded by mutableStateOf(isExpanded)
        private set

    fun setIsExpanded(isExpanded: Boolean) {
        this.isExpanded = isExpanded
    }
}

@Composable
fun rememberTopBarMenuState(isExpanded: Boolean): TopBarMenuState {
    return rememberSaveable(saver = listSaver(
        save = {
            listOf(it.isExpanded)
        },
        restore = {
            TopBarMenuState(it[0])
        }
    )) {
        TopBarMenuState(isExpanded)
    }
}
