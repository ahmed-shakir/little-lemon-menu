package se.supernovait.littlelemon.menu.domain

import org.junit.Assert
import org.junit.Test
import se.supernovait.littlelemon.menu.R

class FilterHelperTest {
    private val sampleProductsList = mutableListOf(
        ProductItem(title = "Black tea", price = 3.00, category = "Drinks", R.drawable.black_tea),
        ProductItem(title = "Croissant", price = 7.00, category = "Dessert", R.drawable.croissant),
        ProductItem(title = "Bouillabaisse", price = 20.00, category = "Food", R.drawable.bouillabaisse)
    )

    @Test
    fun filterProducts_filterTypeDessert_croissantReturned() {
        val filteredProductItem = FilterHelper.filterProducts(FilterType.Dessert, sampleProductsList)
        Assert.assertNotNull(filteredProductItem)
        Assert.assertEquals(1, filteredProductItem.size)
        Assert.assertEquals("Croissant", filteredProductItem.first().title)
        Assert.assertEquals(ProductCategory.DESSERT, filteredProductItem.first().category)
    }
}