package com.utmarckus.infoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.utmarckus.infoapp.ui.DrawerMenu
import com.utmarckus.infoapp.ui.MainTopBar
import com.utmarckus.infoapp.ui.theme.InfoAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val scope = rememberCoroutineScope()
            val drawerState = rememberDrawerState(DrawerValue.Closed)

            InfoAppTheme {
                ModalNavigationDrawer(
                    drawerContent = { DrawerMenu() },
                    drawerState = drawerState
                ) {
                    Scaffold(
                        topBar = {
                            MainTopBar(
                                title = "InfoApp",
                                onBurgerClick = {
                                    scope.launch {
                                        drawerState.open()
                                    }
                                },
                                onFavoriteClick = {}
                            )
                        }
                    ) { paddingValues ->
                        Text(text = "Content", Modifier.padding(paddingValues))
                    }
                }
            }
        }
    }
}
