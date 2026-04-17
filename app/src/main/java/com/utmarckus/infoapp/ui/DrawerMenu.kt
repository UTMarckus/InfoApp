package com.utmarckus.infoapp.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.utmarckus.infoapp.R
import com.utmarckus.infoapp.ui.theme.MainRed
import com.utmarckus.infoapp.ui.theme.White
import com.utmarckus.infoapp.ui.theme.WhiteTransparent

@Composable
fun DrawerMenu(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.drawer_list_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Header()
            Body()
        }
    }
}

@Composable
fun Header(modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(168.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, MainRed)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.header_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(R.string.drawer_title),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                color = White,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MainRed)
            )
        }
    }
}

@Composable
fun Body(modifier: Modifier = Modifier) {
    val menuList = stringArrayResource(R.array.drawer_list)

    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(menuList) { index, title ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                colors = CardDefaults.cardColors(containerColor = WhiteTransparent)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                        .wrapContentWidth()
                        .clickable {

                        }
                )
            }
        }
    }
}
