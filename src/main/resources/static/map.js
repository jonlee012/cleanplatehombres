//
// // new edits
//
//
// "use strict";
//
function geocode(search, token) {
    var baseUrl = 'https://api.mapbox.com';
    var endPoint = '/geocoding/v5/mapbox.places/';
    return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
        .then(function(res) {
            return res.json();
            // to get all the data from the request, comment out the following three lines...
        }).then(function(data) {
            return data.features[0].center;
        });
}

// function reverseGeocode(coordinates, token) {
//     var baseUrl = 'https://api.mapbox.com';
//     var endPoint = '/geocoding/v5/mapbox.places/';
//     return fetch(baseUrl + endPoint + coordinates.lng + "," + coordinates.lat + '.json' + "?" + 'access_token=' + token)
//         .then(function(res) {
//             return res.json();
//         })
//         // to get all the data from the request, comment out the following three lines...
//         .then(function(data) {
//             return data.features[2].place_name;
//         });
// }
// var longitude = 98.4946
// var latitude = 29.4252


mapboxgl.accessToken = MAPBOX_KEY
var map = new mapboxgl.Map({
    container: 'map', // HTML container id
    style: 'mapbox://styles/mapbox/streets-v9', // style URL
    center: [-98.4916, 29.4252],
    zoom: 13
});
// Map Nav Controls
map.addControl(new mapboxgl.NavigationControl());

//Starting Draggable Marker (default point)
var marker = new mapboxgl.Marker({
    draggable: true
})
    .setLngLat([-98.4916, 29.4252])
    .addTo(map);

// starting point for weather
var weatherOptions = {
    lat: 29.4241,
    lon: -98.4936,
    appid: "8dba1fe72474760cbb96da7c28d67b5e",
    units: 'imperial'
};

function onDragEnd() {
    var lngLat = marker.getLngLat();
    var lat = lngLat.lat
    var lng = lngLat.lng

    weatherOptions.lng = lng
    weatherOptions.lat = lat
    // renderWeather()

}

marker.on('dragend', onDragEnd);

$(".btn").click(function (e) {
    e.preventDefault()
    let searchInput = $("#input").val();
    geocode(searchInput, MAPBOX_KEY).then(function (data) {
        longitude = data[0];
        latitude = data[1];
        getData();
    })
})







