package net.ivanvega.milocationymapascompose.ui.maps

import androidx.compose.runtime.Composable
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapEffect

@Composable
fun ExperimentalMapScreen(){
    GoogleMap(
        // ...
    ) {
        MapEffect { map ->
            // map is the GoogleMap
        }
    }
}