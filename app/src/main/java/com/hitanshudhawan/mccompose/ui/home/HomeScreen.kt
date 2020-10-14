package com.hitanshudhawan.mccompose.ui.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.hitanshudhawan.mccompose.data.HomeRepository
import com.hitanshudhawan.mccompose.ui.components.SearchBar
import com.hitanshudhawan.mccompose.ui.components.SpotlightCard
import com.hitanshudhawan.mccompose.ui.theme.McComposeTheme

@Composable
fun HomeScreen() {

    val data = HomeRepository.getHomeData()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "McDonald's") }
            )
        }
    ) {

        // TODO : Use a global size here, e.g. like in shapes and colors (theme)
        val horizontalPadding = 16.dp

        ScrollableColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Text(
                text = "Hi ${data.user.name}!",
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(horizontal = horizontalPadding)
            )

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            SearchBar(
                text = "Find what you want...",
                modifier = Modifier.padding(horizontal = horizontalPadding)
            )

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            ScrollableRow {
                Spacer(modifier = Modifier.preferredWidth(horizontalPadding))
                data.categories.forEach { category ->
                    SpotlightCard(
                        imageUrl = category.image,
                        title = category.name
                    )
                    Spacer(modifier = Modifier.preferredWidth(horizontalPadding))
                }
            }

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Text(
                text = "Popular",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = horizontalPadding)
            )

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            // TODO : Use LazyColumnFor
            ScrollableColumn {
                //Spacer(modifier = Modifier.preferredHeight(horizontalPadding))
                data.popularMenuItems.forEach { menuItem ->
                    MenuItemCard(menuItem = menuItem)
                    Spacer(modifier = Modifier.preferredHeight(horizontalPadding))
                }
            }

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            Text(
                text = "Recommended",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(horizontal = horizontalPadding)
            )

            Spacer(modifier = Modifier.preferredHeight(16.dp))

            // TODO : Use LazyColumnFor
            ScrollableColumn {
                //Spacer(modifier = Modifier.preferredHeight(horizontalPadding))
                data.recommendedMenuItems.forEach { menuItem ->
                    MenuItemCard(menuItem = menuItem)
                    Spacer(modifier = Modifier.preferredHeight(horizontalPadding))
                }
            }

            Spacer(modifier = Modifier.preferredHeight(16.dp))
        }

    }
}

@Preview("HomeScreen")
@Composable
fun HomeScreenPreview() {
    McComposeTheme {
        HomeScreen()
    }
}

@Preview("HomeScreen • Dark")
@Composable
fun HomeScreenDarkPreview() {
    McComposeTheme(lightTheme = false) {
        HomeScreen()
    }
}