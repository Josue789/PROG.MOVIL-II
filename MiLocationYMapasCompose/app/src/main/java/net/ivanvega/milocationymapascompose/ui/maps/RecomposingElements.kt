package net.ivanvega.milocationymapascompose.ui.maps

import android.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PinConfig
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun RecomposingScreen(){
    val singapore = LatLng(23.6345, 102.5528)
    val markerState = rememberMarkerState(position = singapore)

    GoogleMap(
        googleMapOptionsFactory = {
            GoogleMapOptions().mapId("DEMO_MAP_ID")
        },
    ) {
        val pinConfig = PinConfig.builder()
            .setBackgroundColor(Color.MAGENTA)
            .build()

        AdvancedMarker(
            state = markerState,
            title = "Magenta marker in Sydney",
            pinConfig = pinConfig
        )
    }

    LaunchedEffect(Unit) {
        repeat(10) {
            delay(5.seconds)
            val old = markerState.position
            markerState.position = LatLng(old.latitude + 1.0, old.longitude + 2.0)
        }
    }
}