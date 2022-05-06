package com.santimattius.datastore

import android.app.Application
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.santimattius.datastore.ui.theme.AndroidDatastorePlaygroundTheme
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application()

@Composable
fun AndroidDatastorePlayground(content: @Composable () -> Unit) {
    AndroidDatastorePlaygroundTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background) {
            content()
        }
    }
}