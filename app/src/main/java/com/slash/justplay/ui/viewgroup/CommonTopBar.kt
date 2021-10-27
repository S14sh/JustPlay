package com.slash.justplay.ui.viewgroup

import android.app.Instrumentation
import android.view.KeyEvent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.slash.justplay.ui.theme.Black
import com.slash.justplay.ui.theme.White
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Slash.R.Wei
 * on 2021/10/25
 */

@Composable
fun commonTopBar(
    composableScope: CoroutineScope = rememberCoroutineScope(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    title: @Composable () -> Unit = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "test",
                color = if (isSystemInDarkTheme()) {
                    White
                } else {
                    Black
                }
            )
        }
    },
    leftFunction: () -> Unit = {
        composableScope.launch(Dispatchers.IO) {
            //默认模拟back键
            Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_BACK)
        }
    },
    leftIcon: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "This is a back icon.",
            tint = if (isSystemInDarkTheme()) {
                White
            } else {
                Black
            }
        )
    },
    rightFunction: () -> Unit = {
        composableScope.launch {
            scaffoldState.drawerState.open()
        }
    },
    rightIcon: @Composable () -> Unit = {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "This is a more icon.",
            tint = if (isSystemInDarkTheme()) {
                White
            } else {
                Black
            }
        )
    },

    ) {
    TopAppBar(
        title = title,
        navigationIcon = {
            IconButton(onClick = leftFunction, content = leftIcon)
        },
        actions = {
            IconButton(onClick = rightFunction, content = rightIcon)
        }
    )
}