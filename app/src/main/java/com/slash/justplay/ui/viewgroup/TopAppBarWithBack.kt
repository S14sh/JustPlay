package com.slash.justplay.ui.viewgroup

import android.app.Instrumentation
import android.print.PrintAttributes
import android.view.KeyEvent
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author Slash.R.Wei
 * on 2021/10/25
 */

@Composable
fun topAppBarWithBack(
    composableScope: CoroutineScope = rememberCoroutineScope(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    name: String = "",
    backFunction: () -> Unit = {
        composableScope.launch(Dispatchers.IO) {
            //默认模拟back键
            Instrumentation().sendKeyDownUpSync(KeyEvent.KEYCODE_BACK)
        }
    },
    backIcon: @Composable () -> Unit = {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "This is a back icon.")
    },
    moreFunction: () -> Unit = {
        composableScope.launch {
            scaffoldState.drawerState.open()
        }
    },
    moreIcon: @Composable () -> Unit = {
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "This is a more icon.")
    },
    moreContent: @Composable ColumnScope.() -> Unit = {
        Surface(
            color = MaterialTheme.colors.primary
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp)
            ) {
                Text(
                    text = "more test",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.align(Alignment.Center),
                )
            }
        }
    },
    backgroundColor: Color = Color.LightGray.copy(alpha = 0.3f)
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = name)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = backFunction, content = backIcon)
                },
                actions = {
                    IconButton(onClick = moreFunction, content = moreIcon)
                }
            )
        },
        drawerContent = moreContent,
        scaffoldState = scaffoldState,
        backgroundColor = backgroundColor
    ) {

    }
}