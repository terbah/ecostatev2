package fil.pai.ecostate;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.HeatmapTileProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    FloatingActionButton def;
    FloatingActionButton ac;
    private TileOverlay mOverlay;
    private int[] colors = {
            Color.rgb(174, 223, 249),    // blue
            Color.rgb(102, 225, 0) // green
    };
    private float[] startPoints = {
            0.2f, 1f
    };
    Gradient gradient = new Gradient(colors, startPoints);
    private GoogleMap mMap;
    // Declare a variable for the cluster manager.
    private ClusterManager<MyItem> mClusterManager;

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney, Australia, and move the camera.
        LatLng lille = new LatLng(50.640560, 3.075010);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(lille));
        addHeatMap();
        // setUpClusterer();
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10.0f));

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Switch aSwitch = getView().findViewById(R.id.switchHeat);
        aSwitch.setChecked(true);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (aSwitch.isChecked()) {
                    mMap.clear();
                    mOverlay.clearTileCache();
                    addHeatMap();
                    getView().findViewById(R.id.imageView4).setVisibility(View.VISIBLE);
                } else {
                    mMap.clear();
                    mOverlay.clearTileCache();
                    setUpClusterer();
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(10.0f));
                    getView().findViewById(R.id.imageView4).setVisibility(View.INVISIBLE);

                }
            }
        });
        /*
        def.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }
        );
        */


    }

    private void addHeatMap() {

        HeatmapTileProvider mProvider;
        //TileOverlay mOverlay;

        List<LatLng> list = null;

        // Get the data: latitude/longitude positions of police stations.
        try {
            list = readItems(R.raw.police_stations);
        } catch (JSONException e) {
            Toast.makeText(getContext(), "Problem reading list of locations.", Toast.LENGTH_LONG).show();
        }

        // Create a heat map tile provider, passing it the latlngs of the police stations.

        mProvider = new HeatmapTileProvider.Builder()
                .data(list)
                .gradient(gradient)
                .build();
        // Add a tile overlay to the map, using the heat map tile provider.
        mOverlay = mMap.addTileOverlay(new TileOverlayOptions().tileProvider(mProvider));

    }

    private ArrayList<LatLng> readItems(int resource) throws JSONException {
        ArrayList<LatLng> list = new ArrayList<LatLng>();
        InputStream inputStream = getResources().openRawResource(resource);
        String json = new Scanner(inputStream).useDelimiter("\\A").next();
        JSONArray array = new JSONArray(json);
        for (int i = 0; i < array.length(); i++) {
            JSONObject object = array.getJSONObject(i);
            double lat = object.getDouble("lat");
            double lng = object.getDouble("lng");
            list.add(new LatLng(lat, lng));
        }
        return list;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_map, container, false);
        def = v.findViewById(R.id.fab1);
        ac = v.findViewById(R.id.fab2);
        def.setOnClickListener(v1 -> {
            Fragment selectedFragment = DefiCommunautaireFragment.newInstance();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_main, selectedFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        });
        ac.setOnClickListener(v12 -> {
            Fragment selectedFragment = ActionsFragment.newInstance();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_main, selectedFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        });
        return v;
    }

    private void setUpClusterer() {
        mClusterManager = new ClusterManager<MyItem>(getActivity(), mMap);
        mMap.setOnCameraIdleListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        addItems();
    }

    private void addItems() {
        try {
            for (LatLng latLng : readItems(R.raw.police_stations)) {
                MyItem offsetItem = new MyItem(latLng.latitude, latLng.longitude);
                mClusterManager.addItem(offsetItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
