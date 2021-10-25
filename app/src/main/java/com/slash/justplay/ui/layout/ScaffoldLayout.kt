package com.slash.justplay.ui.layout

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import com.slash.justplay.ui.viewgroup.topAppBarWithBack

/**
 * @author Slash.R.Wei
 * on 2021/10/20
 */
@Composable
fun CommonScaffold(scaffoldState: ScaffoldState = rememberScaffoldState()) {
    val composableScope = rememberCoroutineScope()
    topAppBarWithBack(
        name = "test",
        scaffoldState = scaffoldState,
        composableScope = composableScope
    )
}