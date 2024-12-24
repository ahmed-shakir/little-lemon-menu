package se.supernovait.littlelemon.menu

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import se.supernovait.littlelemon.menu.domain.ProductItem
import se.supernovait.littlelemon.menu.presentation.ProductDetails

class ProductActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productItem = if(Build.VERSION.SDK_INT >= 33) {
            intent.getSerializableExtra("data", ProductItem::class.java)
        } else {
            intent.getSerializableExtra("data") as ProductItem // Can be removed when min SDK is 33+
        } ?: ProductItem(title = "", price = 0.0, category = "", image = 0)

        setContent {
            ProductDetails(productItem)
        }
    }
}