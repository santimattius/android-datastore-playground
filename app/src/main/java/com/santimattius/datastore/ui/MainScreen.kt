package com.santimattius.datastore.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.santimattius.datastore.R
import com.santimattius.datastore.ui.theme.AndroidDatastorePlaygroundTheme
import com.santimattius.datastore.ui.viewmodels.MainViewModel

@Composable
fun MainScreenRoute(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    MainScreen(
        state = state,
        onIncrement = viewModel::increment,
        onRestart = viewModel::restart
    )
}

@Composable
fun MainScreen(
    state: MainState,
    onIncrement: () -> Unit = { },
    onRestart: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.medium))
                )
            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = onIncrement,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(R.string.text_desc_increment)
                    )
                },
                text = { Text(stringResource(R.string.text_desc_increment)) }
            )
        },
        bottomBar = {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.standard_padding)),
                onClick = onRestart,
                enabled = state.value > 0
            ) {
                Icon(
                    Icons.Filled.Refresh,
                    contentDescription = stringResource(R.string.text_desc_restart),
                    modifier = Modifier.size(ButtonDefaults.IconSize)
                )
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text(stringResource(R.string.text_desc_restart))
            }

        }
    ) {
        CounterText(value = state.value)
    }
}

@Composable
fun CounterText(value: Int) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Current value", fontSize = 38.sp)
            if (value >= 0) {
                Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.title_size)))
                Text(text = "$value", fontSize = 56.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidDatastorePlaygroundTheme {
        MainScreen(MainState()) {}
    }
}