package se.supernovait.littlelemon.menu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import se.supernovait.littlelemon.menu.data.ProductsWarehouse
import se.supernovait.littlelemon.menu.domain.filter.FilterHelper
import se.supernovait.littlelemon.menu.domain.product.ProductItem
import se.supernovait.littlelemon.menu.domain.product.Products
import se.supernovait.littlelemon.menu.domain.sort.SortHelper
import se.supernovait.littlelemon.menu.presentation.product.ProductsGrid
import se.supernovait.littlelemon.menu.presentation.topbar.TopBar
import se.supernovait.littlelemon.menu.presentation.topbar.TopBarAction
import se.supernovait.littlelemon.menu.ui.theme.LittleLemonMenuTheme

class MainActivity : ComponentActivity() {
    private val products = ProductsWarehouse.getProducts()
    private val productsState: MutableStateFlow<Products> = MutableStateFlow(Products(products))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LittleLemonMenuTheme {
                Scaffold(
                    topBar = { TopBar(onAction = { handleAction(it) }) },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Column(Modifier.padding(innerPadding)) {
                        InitUI()
                    }
                }
            }
        }
    }

    @Composable
    fun InitUI() {
        val products by productsState.collectAsState()
        ProductsGrid(products = products, this::startProductActivity)
    }

    private fun startProductActivity(productItem: ProductItem) {
        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra("data", productItem)
        startActivity(intent)
    }

    private fun handleAction(action: TopBarAction) {
        when(action) {
            is TopBarAction.OnSort -> {
                productsState.update {
                    Products(SortHelper.sortProducts(action.sortType, products))
                }
            }
            is TopBarAction.OnFilter -> {
                productsState.update {
                    Products(FilterHelper.filterProducts(action.filterType, products))
                }
            }
            TopBarAction.OnDismiss -> {
                Log.d("AppTopBar", "TopBar menu dismissed")
            }
        }
    }
}
