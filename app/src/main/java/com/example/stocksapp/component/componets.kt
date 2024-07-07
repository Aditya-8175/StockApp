package com.example.stocksapp.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stocksapp.R


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AssetIcon(iconDrawable: Int = R.drawable.ic_launcher_foreground) {

    Box(modifier = Modifier.size(50.dp), contentAlignment = Alignment.Center) {

        Canvas(modifier = Modifier, onDraw = {
            val radius = 65f
            drawCircle(
                color = Color.White,
                radius = radius
            )
        })

        Icon(
            painter = painterResource(id = iconDrawable),
            contentDescription = "Asset Icon",
            tint = Color.Black,
            modifier = Modifier
                .size(25.dp)
                .padding(bottom = 3.dp)
        )
    }

}
@Preview(showBackground = true)
@Composable
fun TickerName(name: String = "Apple Inc.", tickerName: String = "AAPL") {
    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 5.dp)
            .width(80.dp)
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2
        )
        Text(text = tickerName, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun ValueView(currentValue: String = "113.02211f", total: String = "1356f") {
    Column(
        modifier = Modifier
            .padding(start = 10.dp),
        horizontalAlignment = Alignment.End
    ) {
        Text(
            text = currentValue.toString(),
            style = MaterialTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Text(
            text = "$${total.toInt()}",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray
        )
    }
}

