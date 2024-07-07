package com.example.stocksapp.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.stocksapp.component.StockAppBar
import com.example.stocksapp.data.TopGainer
import com.example.stocksapp.data.TopGainersLosers
import com.example.stocksapp.data.TopLoser
import com.example.stocksapp.dataorexception.DataOrException
import com.example.stocksapp.module.CompanyOverviewResponse
import com.example.stocksapp.navigation.StockNavigation

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavController, viewModel: StockViewModel = hiltViewModel<StockViewModel>()) {

    val getData = produceState<DataOrException<TopGainersLosers, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) { value = viewModel.getTopGainersLosers() }.value

//    var symboldata = getData.data!!.top_gainers.first().ticker  // null as not check if null or data
    val getOverview = produceState<DataOrException<CompanyOverviewResponse, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) { value = viewModel.getCompany(symbol = "IBM") }.value

    if (getData.loading == true && getOverview.loading == true)
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    else if (getData.data != null && getOverview.data != null) {

//        Log.d("top gainers here", "MainScreen: ${getData.data!!.top_gainers[0]}")

        val selectedTabIndex = remember { mutableIntStateOf(0) }

        Scaffold(
            topBar = { StockAppBar(title = "Stock App") },
            bottomBar = {
                BottomAppBar(modifier = Modifier.height(56.dp)) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(4.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TabRow(selectedTabIndex = selectedTabIndex.value, modifier = Modifier) {
                            Tab(selected = selectedTabIndex.value == 0, onClick = { selectedTabIndex.value = 0 }) {
                                Text("Top Gainers", style = TextStyle(fontSize = 16.sp, color = Color.Black))
                            }
                            VerticalDivider(modifier = Modifier.align(alignment = Alignment.End))
                            Tab(selected = selectedTabIndex.value == 1, onClick = { selectedTabIndex.value = 1 }) {
                                Text("Top Losers", style = TextStyle(fontSize = 16.sp, color = Color.Black))
                            }
                        }
                    }
                }
            }
        ) {

            Modifier.padding(it)
            Column (modifier = Modifier
                .padding(top = 70.dp)
                .fillMaxSize()){
                when (selectedTabIndex.intValue) {
                    0 -> StockGrid(stocks = getData.data!!.top_gainers,overview = getOverview.data!!, navController = navController ) {
                        symbol -> navController.navigate(StockNavigation.DetailScreen.name+"/$symbol")
                    }
                    1 -> StockGrid2(stocks = getData.data!!.top_losers,overview = getOverview.data!!, navController = navController)
                }
            }


        }
    }

}

@Composable
fun ImageGrid(imageList: List<Int>, onItemClick: (Int) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        items(imageList.size) { index ->
//            StockGrid(index, imageList, onItemClick)
        }
    }
}


@Composable
fun StockGrid(
    stocks: List<TopGainer>,
    navController: NavController,
    overview: CompanyOverviewResponse,
    onItemClick: (String) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(20.dp)
    ) {
        items(stocks.size) { index ->
            val stock = stocks[index]

            Card(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(start = 5.dp, end = 5.dp, bottom = 5.dp)
                    .clickable {
//                        val news = Uri.encode(Gson().toJson(stock))

//                        Log.d("TAG", "StockGrid:${stock.ticker} ")
                        val symbol = stock.ticker
                        onItemClick.invoke(symbol)
//                        navController.navigate(route = StockNavigation.DetailScreen.name+"/$symbol")


                    },
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .padding(16.dp)
//                                .fillMaxWidth()
                ) {

//                    AssetIcon()
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 5.dp)
                            .width(80.dp)
                    ) {
                        if(overview != null){

                            Text(
                                text = overview.Name,
                                style = MaterialTheme.typography.labelMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.Black,
                                overflow = TextOverflow.Ellipsis,
                                maxLines = 2
                            )
                            Text(text = overview.Symbol, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                        }
                    }
//                    TickerName(name = overview.Name, tickerName = overview.Symbol)
                    Column(
                        modifier = Modifier
                            .padding(start = 10.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = stock.price,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "$${stock.change_percentage}",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.Gray
                        )
                    }
//                    ValueView(currentValue = stock.price, total = stock.change_percentage)

                }
            }
        }
    }
}


@Composable
fun StockGrid2(
    stocks: List<TopLoser>,
    navController: NavController,
    overview: CompanyOverviewResponse
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        items(stocks.size) { index ->
            val stock = stocks[index]

            Card(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable {
//                        navController.navigate("productScreen/${stock.symbol}")

                    },
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Column(
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = stock.ticker, style = MaterialTheme.typography.headlineLarge)
                    Text(text = stock.price, style = MaterialTheme.typography.bodyMedium)
                    Text(text = stock.change_amount, style = MaterialTheme.typography.bodyMedium)
                    Text(text = stock.volume, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}


/*
 when (stocks) {
                is TopGainer -> {
                   Text(text = stocks.price)
                }
                is TopLoser -> {
                    StockItem(
                        ticker = stock.ticker,
                        price = stock.price,
                        changeAmount = stock.change_amount,
                        volume = stock.volume,
                        onClick = {
                            // Handle click event
                        }
                    )
                }
//            Card(
//                modifier = Modifier
//                    .padding(4.dp)
//                    .clickable {
////                        navController.navigate("productScreen/${stock.symbol}")
//                    },
//                elevation = CardDefaults.cardElevation(2.dp)
//            ) {
//                Column(
//                    modifier = Modifier.padding(8.dp)
//                ) {
//                    Text(text = stock., style = MaterialTheme.typography.headlineLarge)
//                    Text(text = stock.price, style = MaterialTheme.typography.bodyMedium)
//                    Text(text = stock.change_amount, style = MaterialTheme.typography.bodyMedium)
//                    Text(text = stock.volume, style = MaterialTheme.typography.bodyMedium)
//                }
//            }
//        }
//    }
}
 */


