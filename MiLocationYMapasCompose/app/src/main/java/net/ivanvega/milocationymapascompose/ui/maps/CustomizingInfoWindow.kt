package net.ivanvega.milocationymapascompose.ui.maps

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.GoogleMapOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PinConfig
import com.google.maps.android.compose.AdvancedMarker
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerInfoWindowContent
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberMarkerState
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun RecomposingWithCustomingInfoScreen(){
    val singapore = LatLng(23.6345, 102.5528)
    val markerState = rememberMarkerState(position = singapore)

    GoogleMap(
        googleMapOptionsFactory = {
            GoogleMapOptions().mapId("DEMO_MAP_ID")
        },
    ) {

        /*MarkerInfoWindowContent(
            markerState
        ) { marker ->
            Text(marker.title ?: "Default Marker Title", color = Color.Red)
        }*/

        MarkerInfoWindow(
            markerState
        ) { marker ->
            // Implement the custom info window here
            Column {
                Text(marker.title ?: "Default Marker Title", color = Color.Red)
                Text(marker.snippet ?: "Default Marker Snippet", color = Color.Red)
            }
        }
    }

    LaunchedEffect(Unit) {
        repeat(10) {
            delay(5.seconds)
            val old = markerState.position
            markerState.position = LatLng(old.latitude + 1.0, old.longitude + 2.0)
        }
    }
}