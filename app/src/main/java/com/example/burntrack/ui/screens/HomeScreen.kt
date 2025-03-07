package com.example.burntrack.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import com.example.burntrack.ui.components.AppTitle
import com.example.burntrack.ui.components.MainTopBar
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Alignment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.burntrack.ui.components.BodyPartButtonGrid
import com.example.burntrack.viewmodel.BodyPartViewModel


@Composable
fun HomeScreen(navController: NavController, bodyPartViewModel: BodyPartViewModel = viewModel()) {
    Scaffold (
        topBar = { MainTopBar("BurnTrack", navController) }
    ){ innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Image(
                painter = painterResource(id = R.drawable.body),
                contentDescription = "BurnTrack home",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            BodyPartButtonGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                bodyPartViewModel.bodyParts
            )
        }
    }


}