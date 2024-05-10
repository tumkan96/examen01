package com.example.examen01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.UiSettings

class MainActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var myMap: GoogleMap
    lateinit var mMapView: MapView
    private val MAPVIEW_BUNDLE_KEY = "MapViewBundleKey"
    private val lt = -21.5360986
    private val lg = -64.7154756

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // *** IMPORTANT ***
        // MapView requires that the Bundle you pass contain _ONLY_ MapView SDK
        // objects or sub-Bundles.
        var mapViewBundle: Bundle? = null
        if (savedInstanceState != null) {
            mapViewBundle = savedInstanceState.getBundle(MAPVIEW_BUNDLE_KEY)
        }

        mMapView = findViewById(R.id.mapView)
        mMapView.onCreate(mapViewBundle)
        mMapView.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        myMap = googleMap

        val markerOptions1 = MarkerOptions().position(LatLng(-21.585975, -64.700308)).title("Mi Ubicacion 1")
        myMap.addMarker(markerOptions1)

        val markerOptions2 = MarkerOptions().position(LatLng(lt, lg)).title("Mi Ubicacion 2")
        myMap.addMarker(markerOptions2)

        val uiSettings: UiSettings = myMap.uiSettings
        uiSettings.isZoomControlsEnabled = true // Habilitar controles de zoom

        val liberty = CameraPosition.builder().target(LatLng(lt, lg)).zoom(16f).bearing(0f).tilt(45f).build()
        myMap.moveCamera(CameraUpdateFactory.newCameraPosition(liberty))
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mMapView.onLowMemory()
    }

    override fun onPause() {
        super.onPause()
        mMapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mMapView.onDestroy()
    }

    override fun onResume() {
        super.onResume()
        mMapView.onResume()
    }

    override fun onStart() {
        super.onStart()
        mMapView.onStart()
    }

    override fun onStop() {
        super.onStop()
        mMapView.onStop()
    }
}
