package se.supernovait.littlelemon.menu.presentation.topbar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

class TopBarMenuStateHolder(isExpanded: Boolean) {
    var isExpanded by mutableStateOf(isExpanded)
        private set

    fun setIsExpanded(isExpanded: Boolean) {
        this.isExpanded = isExpanded
    }
}

@Composable
fun rememberTopBarMenuStateHolder(isExpanded: Boolean): TopBarMenuStateHolder {
    return rememberSaveable(saver = listSaver(
        save = {
            listOf(it.isExpanded)
        },
        restore = {
            TopBarMenuStateHolder(it[0])
        }
    )) {
        TopBarMenuStateHolder(isExpanded)
    }
}
