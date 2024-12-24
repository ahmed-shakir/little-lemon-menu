package se.supernovait.littlelemon.menu.presentation.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import se.supernovait.littlelemon.menu.domain.product.ProductItem
import se.supernovait.littlelemon.menu.domain.product.Products

@Composable
fun ProductsGrid(products: Products, startProductActivity: (ProductItem) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = products.items,
            itemContent = { productItem: ProductItem ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = productItem.image),
                        contentDescription = productItem.title,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.clickable {
                            startProductActivity(productItem)
                        }
                    )
                    Text(text = productItem.title)
                }
            }
        )
    }
}