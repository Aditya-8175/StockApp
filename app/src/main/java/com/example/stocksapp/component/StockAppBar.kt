package com.example.stocksapp.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockAppBar(
    title: String = "Stock App",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 0.dp,
    navController: NavController = NavController(LocalContext.current),
//    viewModel: FavoriteViewModel = hiltViewModel(),
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {}
) {

    val showIt = remember {
        mutableStateOf(false)
//
    }
    val context = LocalContext.current

    TopAppBar(title = {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = title,
                style = TextStyle(fontWeight = FontWeight.Bold,
                    fontSize = 17.sp, color = Color.Black)
            )
        }
    }, modifier = Modifier.wrapContentWidth(Alignment.CenterHorizontally),
        actions = {

            Row(horizontalArrangement = Arrangement.Center) {

                if (isMainScreen) Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    IconButton(onClick = {
                        onAddActionClicked.invoke()
                    }) {

                        Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")

                    }
                    IconButton(onClick = {
//                        showDialog.value = true
                    }) {
                        Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "more")
                    }
                } else Box {}
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
        navigationIcon = {

            if (icon != null) {
                Icon(imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.clickable { onButtonClicked.invoke() })
            }
            if (isMainScreen) {
                //Check to see if this city is already a favorite, if so, don't show the fav icon
//                val isAlreadyFav = viewModel.favList.collectAsState().value.filter { item ->
//                    (item.city == title.split(",")[0])
//
//                }

            }

            // Icon(imageVector = Icons.Default.Delete, contentDescription = null)

        })
}
