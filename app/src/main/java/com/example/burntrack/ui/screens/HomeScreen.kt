package com.example.burntrack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.burntrack.R
import com.example.burntrack.ui.components.MainTopBar
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.burntrack.ui.components.BodyPartButtonGrid
import com.example.burntrack.viewmodel.BodyPartUiState
import com.example.burntrack.viewmodel.BodyPartViewModel





@Composable
fun HomeScreen(navController: NavController, bodyPartViewModel: BodyPartViewModel = viewModel()) {
    Scaffold (
        topBar = { MainTopBar(stringResource(R.string.Title), navController) }
    ){ innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            when (val state = bodyPartViewModel.bodyPartUiState) {
                is BodyPartUiState.Loading -> LoadingScreen()
                is BodyPartUiState.Error -> ErrorScreen()
                is BodyPartUiState.Success -> {
                    Image(
                        painter = painterResource(id = R.drawable.body),
                        contentDescription = stringResource(R.string.burntrack_home),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.primary,
                            )
                            .shadow(
                                elevation = 12.dp,
                            )
                    )

                    BodyPartButtonGrid(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        state.bodyParts,
                        navController
                    )
                }
            }

        }
    }


}