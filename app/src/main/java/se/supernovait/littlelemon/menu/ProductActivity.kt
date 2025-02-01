package se.supernovait.littlelemon.menu

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import se.supernovait.littlelemon.menu.domain.product.ProductItem
import se.supernovait.littlelemon.menu.presentation.product.ProductDetails
import se.supernovait.littlelemon.menu.presentation.topbar.TopBar
import se.supernovait.littlelemon.menu.ui.theme.LittleLemonMenuTheme

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productItem = if(Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra("data", ProductItem::class.java)
        } else {
            intent.getSerializableExtra("data") as ProductItem // Can be removed when min SDK is 33+
        } ?: ProductItem(title = "", price = 0.0, category = "", image = 0)

        setContent {
            LittleLemonMenuTheme {
                Scaffold(
                    topBar = { TopBar(showMenu = false) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        ProductDetails(productItem)
                    }
                }
            }
        }
    }
}
