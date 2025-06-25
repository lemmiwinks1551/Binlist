package com.example.binlist.domain.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/** Карточка банка */

@Composable
fun BinInfoCard(info: BinInfoUiModel) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Схема: ${info.scheme}")
            Text("Тип: ${info.type}")
            info.brand?.let { Text("Бренд: $it") }
            Text("Страна: ${info.countryName}")
            Text("Банк: ${info.bankName}, ${info.bankCity ?: ""}")
            info.bankPhone?.let { Text("Телефон: $it") }
            info.bankUrl?.let { Text("Сайт: $it") }
        }
    }
}
