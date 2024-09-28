package com.unlam.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.unlam.marvel.ui.screen.listscreen.ListScreen
import com.unlam.marvel.ui.screen.listscreen.ListScreenViewmodel
import com.unlam.marvel.ui.theme.AppTheme
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            AppTheme {
                val viewmodel = getViewModel<ListScreenViewmodel>()
                ListScreen(modifier = Modifier.fillMaxSize(), viewmodel = viewmodel)
            }
        }
    }
}
