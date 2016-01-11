package com.saitej3.medaramjathara;

import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.saitej3.medaramjathara.DataBase.DataBaseHandler;
import com.saitej3.medaramjathara.activity.MyDialog;
import com.saitej3.medaramjathara.helper.AbstractRouting;
import com.saitej3.medaramjathara.helper.Route;
import com.saitej3.medaramjathara.helper.Routing;
import com.saitej3.medaramjathara.helper.RoutingListener;
import com.saitej3.medaramjathara.model.MarkerItem;

import java.util.ArrayList;
import java.util.List;

import static android.support.v4.app.ActivityCompat.startActivity;

public class MapsActivity extends FragmentActivity implements RoutingListener,GoogleApiClient.OnConnectionFailedListener, GoogleApiClient.ConnectionCallbacks,MyDialog.Communicator {
    protected ArrayList<MarkerItem>markers;
    protected ArrayList<MarkerItem>markerscamp;
    protected ArrayList<MarkerItem>markerstemple;
    protected ArrayList<MarkerItem>markersplaces;
    protected GoogleMap map;
    protected GoogleApiClient mGoogleApiClient;
    protected LatLng start;
    protected LatLng end;
    private Polyline polyline;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_maps);

        //map markers

        markers = new ArrayList<>();
        markers.add(new MarkerItem(1, "Helipad at Medaram", 80.241976, 18.318956));
        markers.add(new MarkerItem(2, "VIP  Parking Place", 80.248239, 18.308466));
        markers.add(new MarkerItem(3, "Chintal 'X' road Parking Place 2", 80.208382, 18.297904));
        markers.add(new MarkerItem(4, "Chintal 'X' road Parking Place 1", 80.207901, 18.298847));
        markers.add(new MarkerItem(5, "Aremalla Gutta Parking Place", 80.207206, 18.290028));
        markers.add(new MarkerItem(6, "Erra Cheruvu Parking Place 1", 80.207543, 18.284121));
        markers.add(new MarkerItem(7, "Erra Cheruvu Parking Place 2", 80.206608, 18.279084));
        markers.add(new MarkerItem(8, "Mettugutta Parking Place", 80.188299, 18.238476));
        markers.add(new MarkerItem(9, "VVIP Parking Place", 80.244183, 18.318038));
        markers.add(new MarkerItem(10, "Vengalapur Parking Place", 80.203632, 18.269525));
        markers.add(new MarkerItem(11, "Ballani Chintal Parking Place", 80.20187, 18.264437));
        markers.add(new MarkerItem(12, "Kalvapally 'X' Road Parking Place 2", 80.209746, 18.315459));
        markers.add(new MarkerItem(13, "Kannepally Parking Place", 80.226724, 18.330212));
        markers.add(new MarkerItem(14, "Bayyakkapet Parking Place", 80.199724, 18.315164));
        markers.add(new MarkerItem(15, "Kalvapally 'X' road Parking Place 1", 80.21015200000001, 18.318128));
        markers.add(new MarkerItem(16, "Jampanna Vai Parking Place", 80.226304, 18.329196));
        markers.add(new MarkerItem(17, "Manasura Parking Place", 80.223382, 18.326562));
        markers.add(new MarkerItem(18, "Kalvapally check post", 80.210512, 18.319158));
        markers.add(new MarkerItem(19, "Kothur Parking Place - 2", 80.216524, 18.327826));
        markers.add(new MarkerItem(20, "Thurkani chintal Parking Place", 80.202808, 18.266136));
        markers.add(new MarkerItem(21, "Pochamma Bandan Parking Place", 80.223198, 18.32606));
        markers.add(new MarkerItem(22, "Kothur Parking Place - 1", 80.215589, 18.323283));
        markers.add(new MarkerItem(23, "Kamaram Parking Place", 80.303504, 18.252803));
        markers.add(new MarkerItem(24, "Oorattam Parking Place-II", 80.232492, 18.338437));
        markers.add(new MarkerItem(25, "Oorattam Parking Palce-I", 80.232757, 18.338855));
        markers.add(new MarkerItem(26, "Oorattam Parking Place-III", 80.234059, 18.339005));

        markerscamp=new ArrayList<>();
        markerscamp.add(new MarkerItem(27,"POLICE CAMPS",80.242738,18.320016));
        markerscamp.add(new MarkerItem(28,"Atmakur Camp",79.738939,18.075642));
        markerscamp.add(new MarkerItem(29,"Jangalapally Camp",79.985974,18.209421));
        markerscamp.add(new MarkerItem(30,"Bayyakkapet Camp",80.138050,18.345766));
        markerscamp.add(new MarkerItem(31,"Gollabuddaram Camp",80.044432,18.436869));
        markerscamp.add(new MarkerItem(32,"Kamalapur Camp",79.923513,18.471919));
        markerscamp.add(new MarkerItem(33,"Gandhinagar Camp",79.826475,18.322026));
        markerscamp.add(new MarkerItem(34,"Bhupalpally Camp",79.872574,18.444028));
        markerscamp.add(new MarkerItem(35,"Parkal Camp",79.705956,18.194349));
        markerscamp.add(new MarkerItem(36,"Ramappa Camp",79.940651,18.259966));
        markerscamp.add(new MarkerItem(37,"Mulug Camp",79.946536,18.191489));
        markerscamp.add(new MarkerItem(38,"Police Camp at Vengalapur",80.206510,18.275475));
        markerscamp.add(new MarkerItem(39,"Pasra Camp",80.167460,18.192068));
        markerscamp.add(new MarkerItem(40,"Police Camp at Medaram",80.240542,18.313683));
        markerscamp.add(new MarkerItem(41,"Police Camp at Narlapur School",80.205776,18.310038));
        markerscamp.add(new MarkerItem(42,"Command Control at Medaram",80.242738,18.320016));
        markerscamp.add(new MarkerItem(43,"Jampanna Vaagu Camp",80.231019,18.326800));
        markerscamp.add(new MarkerItem(44,"RTC Camp",80.240853,18.312411));
        markerscamp.add(new MarkerItem(45,"Tadvai Police Station Camp",80.315564,18.235236));
        markerscamp.add(new MarkerItem(46,"MEDARAM Main Camp",80.242987,18.320054));
        markerscamp.add(new MarkerItem(47,"Kothur Camp",80.216538,18.322774));

        markerstemple=new ArrayList<>();
        markerstemple.add(new MarkerItem(48,"Pagididda Raju Temple",80.212639,18.002964));
        markerstemple.add(new MarkerItem(49,"SARALAMMA Temple",80.218006,18.335098));
        markerstemple.add(new MarkerItem(50,"Gattamma Temple",79.914717,18.188457));

        markersplaces=new ArrayList<>();
        markersplaces.add(new MarkerItem(50,"Narsampet",79.894554,17.928098));
        markersplaces.add(new MarkerItem(51,"Medaram, Telangana",80.240788,18.322632));
        markersplaces.add(new MarkerItem(52,"warangal - Eturnagaram Rd,Uppukunta",80.190828,18.196816));
        markersplaces.add(new MarkerItem(53,"mahadevpur",79.98383200000001,18.731814));
        markersplaces.add(new MarkerItem(54,"medaram",80.240788,18.322632));
        markersplaces.add(new MarkerItem(55,"manugur",80.82649600000001,17.930954));
        markersplaces.add(new MarkerItem(56,"eturnagaram",80.429576,18.337895));
        markersplaces.add(new MarkerItem(57,"Kothur",80.2175438,18.3227516));
        markersplaces.add(new MarkerItem(58,"Kannepally",80.2165246,18.3343671));
        markersplaces.add(new MarkerItem(59,"Kalvapally",80.1878303,18.3491488));
        markersplaces.add(new MarkerItem(60,"Singaram",80.1575696,18.4105739));
        markersplaces.add(new MarkerItem(61,"Regulagudem",80.13040959999999,18.4677439));
        markersplaces.add(new MarkerItem(62,"Nandigama",80.08865830000001,18.4657289));
        markersplaces.add(new MarkerItem(63,"Azamnagar",80.0635958,18.5106012));
        markersplaces.add(new MarkerItem(64,"Mutharam Mahadevpur",80.02286909999999,18.5314969));
        markersplaces.add(new MarkerItem(65,"Ankushapur",79.95062110000001,18.5787112));
        markersplaces.add(new MarkerItem(66,"Raghavapatnam",80.15837430000001,18.210600));
        markersplaces.add(new MarkerItem(67,"Tappamancha",80.180583,18.2305691));
        markersplaces.add(new MarkerItem(68,"Kamalapur",80.48506740000001,18.2681927));
        markersplaces.add(new MarkerItem(69,"Chinnaboinapally",80.39685489999999,18.2896271));
        markersplaces.add(new MarkerItem(70,"Bayyakkapet",80.1381075,18.3455541));
        markersplaces.add(new MarkerItem(71,"Dudekulapally",80.08553620000001,18.4164272));
        markersplaces.add(new MarkerItem(72,"Rampur",80.0039434,18.4597044));
        markersplaces.add(new MarkerItem(73,"Gandhinagar Junction",79.82531,18.32246));
        markersplaces.add(new MarkerItem(74,"Mangapet",80.5093414,18.252482));
        markersplaces.add(new MarkerItem(75,"Mallur",80.5570579,18.2200778));
        markersplaces.add(new MarkerItem(76,"Rajupet",80.6225896,18.165446));
        markersplaces.add(new MarkerItem(77,"Brahmanapally",80.632267,18.1446283));
        markersplaces.add(new MarkerItem(78,"Vaajedu of Khammam",80.4795742,18.4401231));
        markersplaces.add(new MarkerItem(79,"Mulug",79.9430251,18.1916836));
        markersplaces.add(new MarkerItem(80,"Jakaram",79.8863071,18.1774338));
        markersplaces.add(new MarkerItem(81,"Mallampally",79.8503709,18.112693));
        markersplaces.add(new MarkerItem(82,"Itikalapally",79.90658999999999,17.992346));
        markersplaces.add(new MarkerItem(83,"Kataram",79.9386263,18.6259939));
        markersplaces.add(new MarkerItem(84,"Bhoopalpatnam",80.38284299999999,18.8638947));
        markersplaces.add(new MarkerItem(85,"Chelpur",79.84268899999999,18.3706343));
        markersplaces.add(new MarkerItem(86,"Bhupalpally",79.8674297,18.438189));



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //window.setStatusBarColor(getResources().getColor(R.color.myPrimaryDarkColor));
        }
        // ATTENTION: This "addApi(AppIndex.API)"was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Places.GEO_DATA_API)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .addApi(ActivityRecognition.API)
                .addOnConnectionFailedListener(this)
                .addApi(AppIndex.API).build();


        MapsInitializer.initialize(this);
        mGoogleApiClient.connect();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        if (mapFragment == null) {
            mapFragment = SupportMapFragment.newInstance();
            getSupportFragmentManager().beginTransaction().replace(R.id.map, mapFragment).commit();
        }
        map = mapFragment.getMap();

        CameraUpdate center = CameraUpdateFactory.newLatLng(new LatLng(18.32328, 80.215589));
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(12);
        map.moveCamera(center);
        map.animateCamera(zoom);


        addMarkers();


    }


    public void addMarkers() {
        List<Marker> MarkerMain=new ArrayList<>();
        for (MarkerItem markerItem : markers) {
            Marker m=map.addMarker(new MarkerOptions().position(new LatLng(markerItem.getLat(), markerItem.getLon())).title(markerItem.getName()).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_park1)).draggable(true))  ;
            MarkerMain.add(m);
        }

        for(MarkerItem markerItem:markerscamp)
        {
            Marker m=map.addMarker(new MarkerOptions().position(new LatLng(markerItem.getLat(), markerItem.getLon())).title(markerItem.getName()).icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_marker_camp)).draggable(true))  ;
            MarkerMain.add(m);
        }

        for(MarkerItem markerItem:markersplaces)
        {
            Marker m=map.addMarker(new MarkerOptions().position(new LatLng(markerItem.getLat(), markerItem.getLon())).title(markerItem.getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)).draggable(true))  ;
            MarkerMain.add(m);
        }

        map.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                route(marker.getPosition());
            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

            }
        });


    }


    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    public void route(LatLng l)
    {
        Location mLastLocation= LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if(mLastLocation!= null)
            start=new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());

        Marker marker=map.addMarker(new MarkerOptions().position(start).title("You Are Here"));
        end=l;
        Log.d("lat cordinate", String.valueOf(end.latitude));
        Log.d("long cordinate", String.valueOf(end.longitude));
        progressDialog = ProgressDialog.show(this, "Please wait.",
                "Fetching  Information.", true);

        Routing routing = new Routing.Builder()
                .travelMode(AbstractRouting.TravelMode.DRIVING)
                .withListener(this)
                .waypoints(start, end)
                .build();
        routing.execute();
    }


    @Override
    public void onRoutingFailure() {
        progressDialog.dismiss();
        Toast.makeText(this, "Something went wrong, Try again", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onRoutingStart() {

    }

    @Override
    public void onRoutingSuccess(PolylineOptions mPolyOptions, Route route) {

        progressDialog.dismiss();
        CameraUpdate center = CameraUpdateFactory.newLatLng(start);
        CameraUpdate zoom = CameraUpdateFactory.zoomTo(16);

        map.moveCamera(center);


        if(polyline!=null)
            polyline.remove();

        polyline=null;
        //adds route to the map.
        PolylineOptions polyOptions = new PolylineOptions();
        polyOptions.color(getResources().getColor(R.color.direction_color));
        polyOptions.width(10);
        polyOptions.addAll(mPolyOptions.getPoints());
        polyline=map.addPolyline(polyOptions);

        // Start marker
        MarkerOptions options = new MarkerOptions();
        options.position(start);
        map.addMarker(options);

        // End marker
        options = new MarkerOptions();
        options.position(end);
        map.addMarker(options);

    }

    @Override
    public void onRoutingCancelled() {

        Log.i("op", "Operation was cancelled.");

    }

    public void showDialog(View v)
    {
        FragmentManager fm=getFragmentManager();
        MyDialog myDialog=new MyDialog();
        myDialog.show(fm, "select");

    }

    @Override
    public void onDialogMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        store(message);
    }

    public void store(String message)
    {
        LatLng currLocation=null;
        Location mLastLocation= LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if(mLastLocation!= null)
            currLocation=new LatLng(mLastLocation.getLatitude(),mLastLocation.getLongitude());


        if(currLocation==null)
        {
            Toast.makeText(this,"There is an issue with the network",Toast.LENGTH_SHORT).show();
        }
        DataBaseHandler db=new DataBaseHandler(this);

        com.saitej3.medaramjathara.model.Location l=new com.saitej3.medaramjathara.model.Location();

        l.setName(message);
        l.setLat(String.valueOf(currLocation.latitude));
        l.setLon(String.valueOf(currLocation.longitude));
        db.addLocation(l);
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        mGoogleApiClient.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.saitej3.medaramjathara/http/host/path")
        );
        AppIndex.AppIndexApi.start(mGoogleApiClient, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.saitej3.medaramjathara/http/host/path")
        );
        AppIndex.AppIndexApi.end(mGoogleApiClient, viewAction);
        mGoogleApiClient.disconnect();
    }
}





