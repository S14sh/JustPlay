package com.slash.justplay.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.slash.justplay.R
import kotlinx.coroutines.launch

/**
 * @author Slash.R.Wei
 * on 2021/10/20
 */
@Composable
fun CommonScaffold(scaffoldState: ScaffoldState = rememberScaffoldState()) {
    val composableScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = {

                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "This is a back icon."
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {
                        composableScope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.MoreVert,
                            contentDescription = "This is a menu icon."
                        )
                    }
                }
            )
        },
        drawerContent = {
            Surface(color = MaterialTheme.colors.primary) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.menu),
                        style = MaterialTheme.typography.h5,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        },
        scaffoldState = scaffoldState, backgroundColor = Color.LightGray.copy(alpha = 0.3f)
    ) {

    }
}