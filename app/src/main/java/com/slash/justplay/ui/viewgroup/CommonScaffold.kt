package com.slash.justplay.ui.viewgroup

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ProvideWindowInsets
import kotlinx.coroutines.CoroutineScope

/**
 * @author Slash.R.Wei
 * on 2021/10/27
 */
@Composable
fun commonScaffold(
    composableScope: CoroutineScope = rememberCoroutineScope(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    topBar: @Composable () -> Unit = {
        commonTopBar(composableScope = composableScope, scaffoldState = scaffoldState)
    },
    drawerContent: @Composable ColumnScope.() -> Unit = {
        Surface(
            color = MaterialTheme.colors.primary
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Text(
                    text = "more test",
                    style = MaterialTheme.typography.h5,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    },
    drawerShape: Shape = MaterialTheme.shapes.small,
    bottomBar: @Composable () -> Unit = {
        commonBottomBar()
    },
    backgroundColor: Color = Color.LightGray.copy(alpha = 0.3f),
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = topBar,
        drawerContent = drawerContent,
        drawerShape = drawerShape,
        bottomBar = bottomBar,
        scaffoldState = scaffoldState,
        backgroundColor = backgroundColor,
        content = content
    )
}
