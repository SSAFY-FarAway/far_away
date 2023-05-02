window.onload = function () {
    // 조회 해서 값가지오기
    initPlan();
}
const urlParams = new URLSearchParams(location.search);
const planId = urlParams.get("id");

function initPlan() {
    let url = root + "/plan/" + planId;
    fetch(url)
        .then((response) => {
            response.json().then((data) => {
                console.log(data)
                makeView(data);
            })
        })
}

function makeView(data) {
    // 1. 제목
    let title = data.title;
    document.getElementById("title").innerText = title;
    // 2. 내용
    let content = data.content;
    document.getElementById("content").innerText = content;
    // 3. 작성자
    let writerId = data.loginId;
    document.getElementById("writerId").innerText = "작성자: " + writerId;
    // 4. 내 경로
    makeMyPlan(data.attractionList);
    // 5. 최단 경로
    makeShoretestPlan(data.shortestPathList);
    // 6. 버튼 표시 여부 확인
    makeModifyButton(writerId);
}
function makeModifyButton(writerId) {
    let loginId = document.getElementById("loginId").innerText;
    if(loginId == writerId) {
        let modifyButtonDiv = document.getElementById("modify-button");
        let content = '<button id = "btn-modify" class="btn btn-outline-success shadow" type="button">' +
            'Modify' +
            '</button>';
        modifyButtonDiv.innerHTML += content;
        document.getElementById("btn-modify").addEventListener("click", () => {
            location.href= root + "/plan-modify?id=" + planId + "#share-plan-modify";
        })
    }
}
var attractions = [];
var positions; // marker  배열
var mapContainer = document.getElementById("map"), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
        level: 6, // 지도의 확대 레벨
    };

var map = new kakao.maps.Map(mapContainer, mapOption);
var overLays = [];
var markerList = [];
function makeMyPlan(attractionList) {
    attractions = attractionList;

    positions = [];
    attractions.forEach((attraction) => {
        let markerInfo  = {
            contentId: attraction.contentId,
            title: attraction.title,
            addr1: attraction.addr1,
            zipcode: attraction.zipcode,
            firstImage: attraction.firstImage,
            latlng: new kakao.maps.LatLng(attraction.latitude, attraction.longitude),
        };

        positions.push(markerInfo);
    })


    displayMarker();

    for (var i = 0; i < overLays.length; i++) {
        overLays[i].setMap(null);
    }
    overLays = [];
    addLine(markerList);

    for (var j = 0; j < positions.length; j++) {
        var content = '<div class="customoverlay">' +
            '<a>' +
            ' <span id="numbers">' + (j + 1) + '</span> <span class="title">' + positions[j].title + '</span>' +
            '</a>' +
            '</div>';
        addText(markerList[j].getPosition(), content, map);
    }

}

function displayMarker() {
    // 마커 이미지의 이미지 주소입니다
    for (var i = 0; i < markerList.length; i++) {
        markerList[i].setMap(null);
    }
    markerList = [];
    for (var i = 0; i < positions.length; i++) {

        // 마커를 생성합니다
        let marker = new kakao.maps.Marker({
            map: map, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].contentId,
        });
        markerList[i] = marker;
    }
    // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
    map.setCenter(positions[0].latlng);
}

var lines = [];
function addLine(markers) {
    var linePath = [];
    for (let i = 0; i < lines.length; i++) {
        lines[i].setMap(null);
    }
    for (let i = 0; i < markers.length; i++) {
        linePath.push(markers[i].getPosition());
    }

    var polyline = new kakao.maps.Polyline({
        path: linePath,
        strokeWeight: 2,
        strokeColor: 'orange',
        strokeOpacity: 0.7,
        strokeStlye: 'solid'
    });

    polyline.setMap(map);
    lines.push(polyline);
}

function addText(pos, con, map) {
    var customOverlay = new kakao.maps.CustomOverlay({
        map: map,
        position: pos,
        content: con,
        yAnchor: 0.3
    });
    overLays.push(customOverlay);
}

var shortestMapContainer = document.getElementById("shortest-map"), // 지도를 표시할 div
    shortestMapOption = {
        center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
        level: 6, // 지도의 확대 레벨
    };

var shortestMap = new kakao.maps.Map(shortestMapContainer, shortestMapOption);
var shortestOverLays = [];
var shortestMarkerList = [];
function makeShoretestPlan(shortestPathList) {
    positions = [];
    shortestPathList.forEach((i) => {
        let markerInfo = {
            contentId: attractions[i].contentId,
            title: attractions[i].title,
            addr1: attractions[i].addr1,
            zipcode: attractions[i].zipcode,
            firstImage: attractions[i].firstImage,
            latlng: new kakao.maps.LatLng(attractions[i].latitude, attractions[i].longitude),
        }
        positions.push(markerInfo);
    })

    displayShortestmarker();

    for (var i = 0; i < shortestOverLays.length; i++) {
        shortestOverLays[i].setMap(null);
    }
    shortestOverLays = [];
    addShortestPathLine(shortestMarkerList);

    for (var j = 0; j < positions.length; j++) {
        var content = '<div class="customoverlay">' +
            '<a>' +
            ' <span id="numbers">' + (j + 1) + '</span> <span class="title">' + positions[j].title + '</span>' +
            '</a>' +
            '</div>';
        addText(shortestMarkerList[j].getPosition(), content, shortestMap);
    }
}

function displayShortestmarker() {
    // 마커 이미지의 이미지 주소입니다
    for (var i = 0; i < shortestMarkerList.length; i++) {
        shortestMarkerList[i].setMap(null);
    }
    shortestMarkerList = [];
    for (var i = 0; i < positions.length; i++) {

        // 마커를 생성합니다
        let marker = new kakao.maps.Marker({
            map: shortestMap, // 마커를 표시할 지도
            position: positions[i].latlng, // 마커를 표시할 위치
            title: positions[i].contentId,
        });
        shortestMarkerList[i] = marker;
    }
    // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
    shortestMap.setCenter(positions[0].latlng);
}

var shortestLines = [];
function addShortestPathLine(markers) {
    var linePath = [];
    for (let i = 0; i < shortestLines.length; i++) {
        shortestLines[i].setMap(null);
    }
    for (let i = 0; i < markers.length; i++) {
        linePath.push(markers[i].getPosition());
    }

    var polyline = new kakao.maps.Polyline({
        path: linePath,
        strokeWeight: 2,
        strokeColor: 'orange',
        strokeOpacity: 0.7,
        strokeStlye: 'solid'
    });

    polyline.setMap(shortestMap);
    lines.push(polyline);
}


