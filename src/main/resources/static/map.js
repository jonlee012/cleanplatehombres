// //
// // // new edits
// //
// //
// // "use strict";
// //
// function geocode(search, token) {
//     var baseUrl = 'https://api.mapbox.com';
//     var endPoint = '/geocoding/v5/mapbox.places/';
//     return fetch(baseUrl + endPoint + encodeURIComponent(search) + '.json' + "?" + 'access_token=' + token)
//         .then(function(res) {
//             return res.json();
//             // to get all the data from the request, comment out the following three lines...
//         }).then(function(data) {
//             return data.features[0].center;
//         });
// }
//
// // function reverseGeocode(coordinates, token) {
// //     var baseUrl = 'https://api.mapbox.com';
// //     var endPoint = '/geocoding/v5/mapbox.places/';
// //     return fetch(baseUrl + endPoint + coordinates.lng + "," + coordinates.lat + '.json' + "?" + 'access_token=' + token)
// //         .then(function(res) {
// //             return res.json();
// //         })
// //         // to get all the data from the request, comment out the following three lines...
// //         .then(function(data) {
// //             return data.features[2].place_name;
// //         });
// // }
// // var longitude = 98.4946
// // var latitude = 29.4252
//
//
// mapboxgl.accessToken = MAPBOX_KEY
// var map = new mapboxgl.Map({
//     container: 'map', // HTML container id
//     style: 'mapbox://styles/mapbox/streets-v9', // style URL
//     center: [-98.4916, 29.4252],
//     zoom: 13
// });
// // Map Nav Controls
// map.addControl(new mapboxgl.NavigationControl());
//
// //Starting Draggable Marker (default point)
// var marker = new mapboxgl.Marker({
//     draggable: true
// })
//     .setLngLat([-98.4916, 29.4252])
//     .addTo(map);
//
// // starting point for weather
// var weatherOptions = {
//     lat: 29.4241,
//     lon: -98.4936,
//     // appid: "8dba1fe72474760cbb96da7c28d67b5e",
//     units: 'imperial'
// };
//
// function onDragEnd() {
//     var lngLat = marker.getLngLat();
//     var lat = lngLat.lat
//     var lng = lngLat.lng
//
//     weatherOptions.lng = lng
//     weatherOptions.lat = lat
//     // renderWeather()
//
// }
//
// marker.on('dragend', onDragEnd);
//
// $(".btn").click(function (e) {
//     e.preventDefault()
//     let searchInput = $("#input").val();
//     geocode(searchInput, MAPBOX_KEY).then(function (data) {
//         longitude = data[0];
//         latitude = data[1];
//         getData();
//     })
// })
//
//
//
//
//
//
//


// second try

mapboxgl.accessToken = MAPBOX_KEY;
const layerList = document.getElementById('orgMark');
const inputs = layerList.getElementsByTagName('input');
for (const input of inputs) {
    input.onclick = (layer) => {
        const layerId = layer.target.id;
        map.setStyle('mapbox://styles/mapbox/' + layerId);
    };
}
const nav = new mapboxgl.NavigationControl({
    showZoom: true
});

$(document).ready(function () {
    $('#zoom5').click(function (e) {
        map.flyTo({zoom: 5});
    });
    $(document).ready(function () {
        $('#zoom10').click(function (e) {
            map.flyTo({zoom: 10});
        });
        $(document).ready(function () {
            $('#zoom15').click(function (e) {
                map.flyTo({zoom: 15});
            })
        });
    });
});


$(document).ready(function () {
    $(".removeMarkers").click(function () {
        $('marker').toggle()
    });
});

const geojson = {
    'type': 'FeatureCollection',
    'features': [
        {
            'type': 'Feature',
            'properties': {
                'description':
                organizationName,
                'icon': 'theatre-15'
            },
            'geometry': {
                'type': 'Point',
                'coordinates': [-98.4916, 29.4260]
            }
        }
    ]
}

var map = new mapboxgl.Map({
    container: 'map',
    style: 'mapbox://styles/mapbox/streets-v11',
    center: [-98.4916, 29.4252],
    zoom: 10
});

const description = geojson.features[0].properties.description;
// Add markers to the map.

const geocode = (inputLocation, inputName, inputReviews) => {
    fetch(`https://api.mapbox.com/geocoding/v5/mapbox.places/${inputLocation}.json?&access_token=${MAPBOX_KEY}`)
        .then(res => res.json())
        .then(data => {
            console.log(data);
            try {
                map.flyTo({center: data.features[0].center, essential: true, zoom: 15})

            } catch (e) {
                console.log(e);
            }
            for (const feature of geojson.features) {
// create a HTML element for each feature

                const el = document.createElement('div');
                el.className = 'mapMarker';

// make a marker for each feature and add it to the map

                new mapboxgl.Marker(el)
                    .setLngLat(data.features[0].center).addTo(map)
                    .setPopup(new mapboxgl.Popup({closeButton: false, offset: 45})
                        // .setHTML(inputName  + inputLocation + inputHours + inputReviews)
                        .setHTML(`
${inputName} <br> ${inputLocation} <br>
`)
                        .addTo(map))
                    .setLngLat(data.features[0].center).addTo(map);

            }
        })
}

// $(window).ready( function(){

$(document).on("mousemove", "#mapboxData", function () {
    console.log(this)
    let organizationLocation = this.querySelector('#location').innerText
    let organizationName = this.getElementsByTagName("p")[0].innerText
    console.log("organizationName", organizationName);
    geocode(organizationLocation, organizationName)
    // })
});
