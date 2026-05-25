package com.goteborgaren.app.presentation.ui.about

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header CV
        item {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("👨‍💻", fontSize = 40.sp)
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Utvecklaren bakom Göteborgaren",
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        "Android-utvecklare | Clean Architecture | Compose",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                    )
                }
            }
        }

        // Tech Stack
        item {
            Text(
                "🛠️ Tech Stack",
                style = MaterialTheme.typography.titleLarge
            )
        }

        val techStack = listOf(
            "Kotlin 100% — Jetpack Compose + Material 3",
            "Clean Architecture — data/presentation/di",
            "MVVM + Hilt DI — Dependency Injection",
            "Coroutines + StateFlow — Reaktiv programmering",
            "Navigation Compose — Single Activity",
            "Retrofit + OkHttp — API-kommunikation",
            "Coil — Bildhantering",
            "Arkitekturredo för: Västtrafik API, SMHI, Google Places",
        )

        items(techStack) { tech ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("•", fontSize = 18.sp, color = MaterialTheme.colorScheme.primary)
                    Spacer(Modifier.width(10.dp))
                    Text(
                        tech,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }

        // Skills
        item {
            Spacer(Modifier.height(4.dp))
            Text(
                "💡 Kompetenser",
                style = MaterialTheme.typography.titleLarge
            )
        }

        val skills = listOf(
            Pair("Android (Kotlin)", "⭐️⭐️⭐️⭐️⭐️"),
            Pair("Compose + Material 3", "⭐️⭐️⭐️⭐️⭐️"),
            Pair("Clean Architecture / MVVM", "⭐️⭐️⭐️⭐️⭐️"),
            Pair("Hilt DI / Dagger", "⭐️⭐️⭐️⭐️"),
            Pair("REST APIs (Retrofit)", "⭐️⭐️⭐️⭐️⭐️"),
            Pair("Git / CI-CD", "⭐️⭐️⭐️⭐️"),
            Pair("Agila metoder / Scrum", "⭐️⭐️⭐️⭐️"),
        )

        items(skills) { (skill, level) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    skill,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    level,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        // Contact
        item {
            Spacer(Modifier.height(8.dp))
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "📬 Kontakt",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Redo för nästa utmaning!\n" +
                                "Byggd med ❤️ i Göteborg",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }

        item { Spacer(Modifier.height(16.dp)) }
    }
}
