package com.mu.fishermannotes.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    /*primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80*/

    primary = lightBlue50,
    secondary = lightBlue50,
    tertiary = lightBlue50,
    background = lightBlue50,
    surface = lightBlue50,
    onPrimary = lightBlue50,
    onSecondary = lightBlue50,
    onTertiary = lightBlue50,
    onBackground = lightBlue50,
    onSurface = lightBlue50
)

private val LightColorScheme = lightColorScheme(
    primary = lightBlue50,
    secondary = lightBlue50,
    tertiary = lightBlue50,
    background = lightBlue50,
    surface = lightBlue50,
    onPrimary = lightBlue50,
    onSecondary = lightBlue50,
    onTertiary = lightBlue50,
    onBackground = lightBlue50,
    onSurface = lightBlue50

    /*primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40*/

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),*/
)

@Composable
fun FishermanNotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
// Dynamic color is available on Android 12+
    //dynamicColor: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    /*val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }*/

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}