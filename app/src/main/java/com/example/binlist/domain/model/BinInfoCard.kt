package com.example.binlist.domain.model

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

/** Карточка банка */

@Composable
fun BinInfoCard(info: BinInfoUiModel) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Схема: ${info.scheme}")
            Text("Тип: ${info.type}")
            info.brand?.let { Text("Бренд: $it") }
            Text("Страна: ${info.countryName}")
            Text("Банк: ${info.bankName}, ${info.bankCity ?: ""}")

            info.bankPhone?.let {
                Text(
                    text = "Телефон: $it",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$it"))
                        context.startActivity(intent)
                    }
                )
            }

            info.bankUrl?.let {
                Text(
                    text = "Сайт: $it",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://$it"))
                        context.startActivity(intent)
                    }
                )
            }

            if (info.latitude != null && info.longitude != null) {
                Text(
                    text = "Открыть на карте",
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.clickable {
                        val geoUri = Uri.parse("geo:${info.latitude},${info.longitude}")
                        val intent = Intent(Intent.ACTION_VIEW, geoUri)
                        context.startActivity(intent)
                    }
                )
            }
        }
    }
}

