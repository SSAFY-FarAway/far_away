window.onload = function () {
        makeSidoList();
}

function makeSidoList() {
        fetch(root+"/attraction/sido")
            .then((response) => {
                    if(response.status != 200) {
                            alert("에러 발생");
                            location.href=root+"/";
                    }
                    response.json().then((datas) => makeSidoSelect(datas));
            });
}

function makeSidoSelect(datas) {
        var searchArea = document.getElementById("search-area");
        datas.forEach(data => {
                let child = document.createElement("option");
                child.value = data['sidoCode'];
                child.innerText = data['sidoName'];
                searchArea.appendChild(child);
        })
}

// 지역 이 선택된 경우
let sel = document.getElementById("search-sigun");
document.getElementById("search-area").addEventListener("change", function () {
// 지역이 변경된 경우
        let areaCode = document.getElementById("search-area").value;

        if (areaCode != 0) {
                let sigunAreaUrl = root + "/attraction/gugun/"+areaCode;
                fetch(sigunAreaUrl, { method: 'GET' })
                    .then((response) => response.json())
                    .then((data) => {
                            makeOptionForSigun(data);
                    });
        } else {
                sel.innerHTML = '<option value="0" selected>검색 할 구군</option>';
        }
})

function makeOptionForSigun(data) {
        let option = "";
        data.forEach((area) => {
                option += "<option value=" + area['gugunCode'] + ">" + area['gugunName'] + "</option>";
        });
        sel.innerHTML = option;
}
document.getElementById("btn-search").addEventListener("click", () => search() );

function search() {
        let searchUrl = root + "/attraction/";

        let sidoCode = document.getElementById("search-area").value;
        let gugunCode = document.getElementById("search-sigun").value;
        let contentTypeId = document.getElementById("search-content-id").value;

        if (parseInt(sidoCode)) {
                searchUrl += `?sidoCode=${sidoCode}`;
        } else {
                alert("지역을 선택해주세요.");
        }
        if (parseInt(gugunCode)) {
                searchUrl += `&gugunCode=${gugunCode}`;
        } else {
                alert("시군을 선택해주세요.");
        }
        if (parseInt(contentTypeId)) {
                searchUrl += `&contentTypeId=${contentTypeId}`;
        } else {
                alert('컨텐츠를 선택해주세요.');
        }
        fetch(searchUrl)
            .then((response) => response.json())
            .then((data) => {
                        makeList(data)
                }
            );
}

document.getElementById("btn-reload").addEventListener("click", () => {
        deleteClickLine();
        deleteCircleDot();
        deleteDistnce();
        drawingFlag = false;
        chooseContentIdList = [];
});

var positions; // marker 배열.
function makeList(data) {
        //  응답받은 json data = > postion
        let trips = data; // trips => 여행지 정보들 출력
        positions = [];
        trips.forEach((area) => {
                // title, addr1, zipcode, firstImage, latitude, longitude,
                let markerInfo = {
                        contentId: area.contentId,
                        title: area.title,
                        addr1: area.addr1,
                        zipcode: area.zipcode,
                        firstImage: area.firstImage,
                        latlng: new kakao.maps.LatLng(area.latitude, area.longitude),
                };
                positions.push(markerInfo);
        });
        displayMarker();
}

var mapContainer = document.getElementById("map"), // 지도를 표시할 div
    mapOption = {
        center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
        level: 5, // 지도의 확대 레벨
};

var map = new kakao.maps.Map(mapContainer, mapOption);

var ovList= [];
var markerList = [];

var chooseContentIdList = [];
function displayMarker() {
        // 마커 이미지의 이미지 주소입니다

        for (var i = 0; i < ovList.length; i++) {
                ovList[i].setMap(null);
        }
        for (var i = 0; i < positions.length; i++) {

                // 마커를 생성합니다
                let marker = new kakao.maps.Marker({
                        map: map, // 마커를 표시할 지도
                        position: positions[i].latlng, // 마커를 표시할 위치
                        title: positions[i].contentId,
                });
                markerList[i] = marker;

                let content= '<div class="wrap">' +
                    '    <div class="info  shadow ">' +
                    '        <div class="bg-primary ">' +
                    '        		<div class="text-light font-weight-bold p-1 d-flex justify-content-between">' +
                    positions[i].title +
                    '        		</div>'+
                    '		   </div>' +
                    '        <div class="body">' +
                    '            <div class="img">' ;
                if(positions[i].firstImage == '') {
                        content += '<img src="resources/static/assets/img/default.jpg" width="73" height="70">';
                } else {
                        content += '<img src="'+positions[i].firstImage+'" width="73" height="70">';
                }
                content +=
                    '           </div>' +
                    '            <div class="desc">' +
                    '                <div class="ellipsis">'+positions[i].addr1+'</div>' +
                    '                <div class="jibun ellipsis">(우)'+positions[i].zipcode+'</div>' +
                    '                <div class="d-flex justify-content-end me-2">' +
                     '                </div>' +
                    '            </div>' +
                    '        </div>' +
                    '    </div>' +
                    '</div>';



                // 마커 위에 커스텀오버레이를 표시합니다
                // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
                let overlay = new kakao.maps.CustomOverlay({
                        content: content,
                        position: marker.getPosition()
                });

                kakao.maps.event.addListener(marker, 'mouseover', function () {
                        overlay.setMap(map);
                });
                kakao.maps.event.addListener(marker, 'mouseout', function () {
                        overlay.setMap(null);
                });

                kakao.maps.event.addListener(marker, 'click', function() {
                        doDraw(marker);
                });

                ovList[i] = overlay;


        }
        // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
        map.setCenter(positions[0].latlng);
}

document.getElementById("btn-write").addEventListener("click",() => {
   console.log(chooseContentIdList);
   /*{
  "content": "string",
  "memberId": 0,
  "plan": "string",
  "title": "string"
        }*/

        let content = document.getElementById("content");
        let title = document.getElementById("title");
        if(content.value == "") {
                alert("내용을 입력해주세요.");
                content.focus();
        } else if(title.value == '') {
                alert("제목을 입력해주세요");
                title.focus();
        } else if (chooseContentIdList.length == 0) {
                alert("경로를 선택해주세요.");
        } else {
                let url = root + "/plan";
                fetch(url, {
                        method: "POST",
                        headers: {
                                "Content-Type": "application/json",
                        },
                        body: JSON.stringify({
                                content: content.value,
                                title: title.value,
                                memberId: document.getElementById("memberId").innerText,
                                plan: chooseContentIdList.toString()
                        }),
                }).then((response) => {
                        if(response.status == 200) {
                                location.href = root + "/plan_list";
                        }
                });
        }




});



var drawingFlag = false; // 선이 그려지고 있는 상태를 가지고 있을 변수입니다
var moveLine; // 선이 그려지고 있을때 마우스 움직임에 따라 그려질 선 객체 입니다
var clickLine // 마우스로 클릭한 좌표로 그려질 선 객체입니다
var distanceOverlay; // 선의 거리정보를 표시할 커스텀오버레이 입니다
var dots = {}; // 선이 그려지고 있을때 클릭할 때마다 클릭 지점과 거리를 표시하는 커스텀 오버레이 배열입니다.

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 선 그리기가 시작됩니다 그려진 선이 있으면 지우고 다시 그립니다
function doDraw(marker) {
        chooseContentIdList.push(marker.getTitle());
        // 마우스로 클릭한 위치입니다
        var clickPosition = marker.getPosition();

        // 지도 클릭이벤트가 발생했는데 선을 그리고있는 상태가 아니면
        if (!drawingFlag) {

                // 상태를 true로, 선이 그리고있는 상태로 변경합니다
                drawingFlag = true;

                // 지도 위에 선이 표시되고 있다면 지도에서 제거합니다
                deleteClickLine();

                // 지도 위에 커스텀오버레이가 표시되고 있다면 지도에서 제거합니다
                deleteDistnce();

                // 지도 위에 선을 그리기 위해 클릭한 지점과 해당 지점의 거리정보가 표시되고 있다면 지도에서 제거합니다
                deleteCircleDot();

                // 클릭한 위치를 기준으로 선을 생성하고 지도위에 표시합니다
                clickLine = new kakao.maps.Polyline({
                        map: map, // 선을 표시할 지도입니다
                        path: [clickPosition], // 선을 구성하는 좌표 배열입니다 클릭한 위치를 넣어줍니다
                        strokeWeight: 3, // 선의 두께입니다
                        strokeColor: '#db4040', // 선의 색깔입니다
                        strokeOpacity: 1, // 선의 불투명도입니다 0에서 1 사이값이며 0에 가까울수록 투명합니다
                        strokeStyle: 'solid' // 선의 스타일입니다
                });

                // 선이 그려지고 있을 때 마우스 움직임에 따라 선이 그려질 위치를 표시할 선을 생성합니다

                // 클릭한 지점에 대한 정보를 지도에 표시합니다
                displayCircleDot(clickPosition, 0);


        } else { // 선이 그려지고 있는 상태이면

                // 그려지고 있는 선의 좌표 배열을 얻어옵니다
                var path = clickLine.getPath();

                // 좌표 배열에 클릭한 위치를 추가합니다
                path.push(clickPosition);

                // 다시 선에 좌표 배열을 설정하여 클릭 위치까지 선을 그리도록 설정합니다
                clickLine.setPath(path);

                var distance = Math.round(clickLine.getLength());
                displayCircleDot(clickPosition, distance);
        }
}





// 클릭으로 그려진 선을 지도에서 제거하는 함수입니다
function deleteClickLine() {
        if (clickLine) {
                clickLine.setMap(null);
                clickLine = null;
        }
}

// 마우스 드래그로 그려지고 있는 선의 총거리 정보를 표시하거
// 마우스 오른쪽 클릭으로 선 그리가 종료됐을 때 선의 정보를 표시하는 커스텀 오버레이를 생성하고 지도에 표시하는 함수입니다
function showDistance(content, position) {

        if (distanceOverlay) { // 커스텀오버레이가 생성된 상태이면

                // 커스텀 오버레이의 위치와 표시할 내용을 설정합니다
                distanceOverlay.setPosition(position);
                distanceOverlay.setContent(content);

        } else { // 커스텀 오버레이가 생성되지 않은 상태이면

                // 커스텀 오버레이를 생성하고 지도에 표시합니다
                distanceOverlay = new kakao.maps.CustomOverlay({
                        map: map, // 커스텀오버레이를 표시할 지도입니다
                        content: content,  // 커스텀오버레이에 표시할 내용입니다
                        position: position, // 커스텀오버레이를 표시할 위치입니다.
                        xAnchor: 0,
                        yAnchor: 0,
                        zIndex: 3
                });
        }
}

// 그려지고 있는 선의 총거리 정보와
// 선 그리가 종료됐을 때 선의 정보를 표시하는 커스텀 오버레이를 삭제하는 함수입니다
function deleteDistnce () {
        if (distanceOverlay) {
                distanceOverlay.setMap(null);
                distanceOverlay = null;
        }
}

// 선이 그려지고 있는 상태일 때 지도를 클릭하면 호출하여
// 클릭 지점에 대한 정보 (동그라미와 클릭 지점까지의 총거리)를 표출하는 함수입니다
function displayCircleDot(position, distance) {

        // 클릭 지점을 표시할 빨간 동그라미 커스텀오버레이를 생성합니다
        var circleOverlay = new kakao.maps.CustomOverlay({
                content: '<span class="dot"></span>',
                position: position,
                zIndex: 1
        });

        // 지도에 표시합니다
        circleOverlay.setMap(map);

        if (distance > 0) {
                // 클릭한 지점까지의 그려진 선의 총 거리를 표시할 커스텀 오버레이를 생성합니다
                var distanceOverlay = new kakao.maps.CustomOverlay({
                        content: '<div class="dotOverlay">거리 <span class="number">' + distance + '</span>m</div>',
                        position: position,
                        yAnchor: 1,
                        zIndex: 2
                });

                // 지도에 표시합니다
                distanceOverlay.setMap(map);
        }

        // 배열에 추가합니다
        dots.push({circle:circleOverlay, distance: distanceOverlay});
}

// 클릭 지점에 대한 정보 (동그라미와 클릭 지점까지의 총거리)를 지도에서 모두 제거하는 함수입니다
function deleteCircleDot() {
        var i;

        for ( i = 0; i < dots.length; i++ ){
                if (dots[i].circle) {
                        dots[i].circle.setMap(null);
                }

                if (dots[i].distance) {
                        dots[i].distance.setMap(null);
                }
        }

        dots = [];
}


