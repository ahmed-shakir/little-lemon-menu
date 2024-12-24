package se.supernovait.littlelemon.menu.data

import se.supernovait.littlelemon.menu.R
import se.supernovait.littlelemon.menu.domain.ProductCategory
import se.supernovait.littlelemon.menu.domain.ProductItem

object ProductsWarehouse {

    fun getProducts() =
        mutableListOf(
            ProductItem("Black tea", 3.00, ProductCategory.DRINKS, R.drawable.black_tea),
            ProductItem("Green tea", 3.00, ProductCategory.DRINKS, R.drawable.green_tea),
            ProductItem("Espresso", 5.00, ProductCategory.DRINKS, R.drawable.espresso),
            ProductItem("Cappuccino", 8.00, ProductCategory.DRINKS, R.drawable.cappuccino),
            ProductItem("Latte", 8.00, ProductCategory.DRINKS, R.drawable.latte),
            ProductItem("Mocha", 10.00, ProductCategory.DRINKS, R.drawable.mocha),
            ProductItem("Boeuf bourguignon", 15.00, ProductCategory.FOOD, R.drawable.boeuf_bourguignon),
            ProductItem("Bouillabaisse", 20.00, ProductCategory.FOOD, R.drawable.bouillabaisse),
            ProductItem("Lasagna", 15.00, ProductCategory.FOOD, R.drawable.lasagna),
            ProductItem("Onion soup", 12.00, ProductCategory.FOOD, R.drawable.onion_soup),
            ProductItem("Salmon en papillote", 25.00, ProductCategory.FOOD, R.drawable.salmon_en_papillote),
            ProductItem("Quiche Lorraine", 17.00, ProductCategory.DESSERT, R.drawable.quiche_lorraine),
            ProductItem("Custard tart", 14.00, ProductCategory.DESSERT, R.drawable.custard_tart),
            ProductItem("Croissant", 7.00, ProductCategory.DESSERT, R.drawable.croissant),
        )
}
