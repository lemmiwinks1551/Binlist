package com.example.binlist.presentation.ui.screens.history

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.binlist.domain.model.BinInfoCard

@Composable
fun HistoryScreen(viewModel: HistoryViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(state.history) { item ->
            BinInfoCard(info = item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
