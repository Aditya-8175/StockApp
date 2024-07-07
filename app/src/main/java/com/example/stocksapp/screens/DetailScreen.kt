package com.example.stocksapp.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.stocksapp.R
import com.example.stocksapp.component.StockAppBar
import com.example.stocksapp.data.TopGainersLosers
import com.example.stocksapp.dataorexception.DataOrException
import com.example.stocksapp.module.CompanyOverviewResponse
import com.google.gson.Gson

//@Preview(showSystemUi = true)
@Composable
fun DetailScreen(
    viewModel: StockViewModel = hiltViewModel(),
    navController: NavController ,
    symbol: String 
) {

//    val newsItem = Gson().fromJson(symbol, CompanyOverviewResponse::class.java)
    
    
    val symbol = symbol.ifEmpty { "IBM" }


//    val overViewData = produceState<DataOrException<CompanyOverviewResponse, Boolean, Exception>>(
//        initialValue = DataOrException(loading = true)
//        ) { value = viewModel.getCompany(symbol) }.value

//    Text(text = newsItem.Description)

//    if (overViewData.loading == true){
//        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
//            CircularProgressIndicator()
//        }
//
//    }
//    else if(overViewData.data != null){
//
//        val ActualOverview = overViewData.data
//
//        Scaffold(
//            topBar = {
//                StockAppBar(
//                    title = "Detail Screen",
//                    isMainScreen = false,
//                    onButtonClicked = {
//                        navController.popBackStack()
//                    }
//
//                )
//            }
//        ) {
//            Column(modifier = Modifier
//                .padding(it)
//                .fillMaxSize()) {
//
//                Row(
//                    horizontalArrangement = Arrangement.SpaceBetween,
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .padding(15.dp)
//                        .fillMaxWidth()
//                ) {
//
//                    Box(modifier = Modifier.size(50.dp), contentAlignment = Alignment.Center) {
//
//                        Canvas(modifier = Modifier, onDraw = {
//                            val radius = 65f
//                            drawCircle(
//                                color = Color.White,
//                                radius = radius
//                            )
//                        })
//
//                        Icon(
//                            painter = painterResource(id = R.drawable.ic_launcher_background),
//                            contentDescription = "Asset Icon",
////                        tint = Color.Black,
//                            modifier = Modifier
//                                .size(25.dp)
//                                .padding(bottom = 3.dp)
//                        )
//                    }
//                    Text(
//                        text = ActualOverview!!.Symbol,
//                        style = MaterialTheme.typography.labelMedium,
//                        fontWeight = FontWeight.Bold,
//                        color = Color.Black,
//                        overflow = TextOverflow.Ellipsis,
//                        maxLines = 2
//                    )
//                    Text(text = ActualOverview.Name, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
//
//                }
//
//                Box(modifier = Modifier.padding(20.dp), contentAlignment = Alignment.Center) {
//                    Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "" , modifier = Modifier.fillMaxSize())
//                }
//
//                Box(modifier = Modifier.padding(20.dp), contentAlignment = Alignment.Center) {
//                    Column(modifier = Modifier.padding(12.dp)) {
//                        Text(text = ActualOverview!!.Name, fontSize = 16.sp, fontWeight = FontWeight.Bold )
//                        HorizontalDivider()
//                        Text(text = ActualOverview.Description, style = MaterialTheme.typography.labelMedium)
//
//                        // 2 button 
//
//                        Button(onClick = {}, enabled = false, shape = RoundedCornerShape(corner = CornerSize(20.dp))) {
//
//                            Text(text = "Industry ${ActualOverview.Industry}")
//
//                        }
//                        Button(onClick = {}, enabled = false) {
//
//                            Text(text = "Sector ${ActualOverview.Sector}")
//
//                        }
//
//                    }
//
//                }
//
//
//            }
//
//        }
//    }
//    
//    else{
//        Text(text = overViewData.e!!.message.toString())
//    }



    }




@Composable
fun ProductScreen(viewModel: StockViewModel, symbol: String) {
//    val companyOverview by viewModel.companyOverview.observeAsState()

//    LaunchedEffect(key1 = symbol) {
////        viewModel.fetchCompanyOverview(symbol, Constant.Api_Key)
//    }

//    companyOverview?.let { overview ->
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = overview.Name, style = MaterialTheme.typography.headlineLarge)
//            Text(text = overview.Description, style = MaterialTheme.typography.bodySmall)
//
//            // Display a line graph here
//            LineGraph(prices = listOf(1f, 2f, 3f, 4f)) // Mock data for now
//        }
//    }
}

@Composable
fun LineGraph(prices: List<Float>) {
    // Implement a line graph using Canvas or a third-party library
}



