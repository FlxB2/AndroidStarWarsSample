package xyz.felixb.starwars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import xyz.felixb.starwars.ui.StarWarsApp
import xyz.felixb.starwars.ui.theme.StarWarsSampleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StarWarsSampleTheme {
                StarWarsApp()
            }
        }
    }
}