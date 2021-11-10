package com.slash.justplay.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.slash.justplay.constant.IS_IN_MAIN
import com.slash.justplay.ui.theme.JustPlayTheme
import com.slash.justplay.ui.viewgroup.CommonContentList
import com.slash.justplay.ui.viewgroup.CommonContentMain
import com.slash.justplay.ui.viewgroup.commonScaffold

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustPlayTheme {
                ProvideWindowInsets {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        commonScaffold() {
                            if (IS_IN_MAIN.value) {
                                CommonContentMain()
                            } else {
                                CommonContentList()
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JustPlayTheme {
        commonScaffold() {

        }
    }
}

