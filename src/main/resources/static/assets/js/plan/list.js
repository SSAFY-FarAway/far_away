
window.onload = function() {

    initList();
}
const urlParams = new URLSearchParams(location.search);
const currentPage = urlParams.get("page") == null?1:urlParams.get("page");
const key = urlParams.get("key") == null?"":urlParams.get("key");
const word = urlParams.get("word") == null?"":urlParams.get("word");

function initList() {
    fetch(root+"/plan?page="+currentPage+"&key="+key+"&word="+word + "#share-plan-list")
        .then((response) => {
            response.json().then((data) => {
                makeList(data)
                makeNavigation(data.pagination);
            });
        })
}

function makeList(data) {
    var planTable = document.getElementById("plan-table");
    console.log(data.list);
    data.list.forEach(plan => {
        let tr = document.createElement("tr");
        tr.className = "text-center";

        let thId = document.createElement("th");
        thId.scope = "row";
        thId.innerText = plan['id'];
        tr.appendChild(thId);

        let thTitle = document.createElement("td");
        thTitle.className="text-start";
        let aTag = document.createElement("a");
        aTag.href = root+"/plan-view?id="+plan['id'] + "#share-plan-view";
        aTag.style="text-decoration: none";
        aTag.innerText = plan['title'];
        thTitle.appendChild(aTag);
        tr.appendChild(thTitle);

        let thLoginId = document.createElement("td");
        thLoginId.innerText = plan['loginId'];
        tr.appendChild(thLoginId);

        let thHit = document.createElement("td");
        thHit.innerText = plan['hit'];
        tr.appendChild(thHit);

        let thCreated = document.createElement("td");
        thCreated.innerText = plan['createdDate'];
        tr.appendChild(thCreated);


        planTable.appendChild(tr);
    })


}

function makeNavigation(pagination) {
    let navigation = document.getElementById("navigation");
    let content = '<ul class="pagination justify-content-center">';

    if(pagination.startPage == 1) {
        content += '<li class ="page-item disabled"><a class="page-link" href="#" tabindex="-1" aria-disabled="true"> Previous </a></li>';
    } else {
        content += '<li class ="page-item"><a class="page-link" href="'+ root+'/plan-list?page=' + pagination.startPage+'&key='+key+'&word='+word+ '#share-plan-list" tabindex="-1" aria-disabled="true"> Previous </a></li>';
    }

    for(let i = pagination.startPage;i<=pagination.endPage;i++) {
        if(i == currentPage) {
            content += '<li class="page-item active"><a class="page-link" href="' + root + '/plan-list?page=' + i +'&key='+key+'&word='+word+'#share-plan-list">'+i+'</a></li>';
        } else {
            content += '<li class="page-item"><a class="page-link" href="' + root + '/plan_list?page=' + i + '">'+i+'</a></li>';
        }
    }

    if(pagination.endPage == currentPage) {
        content += '<li class ="page-item disabled"><a class="page-link" href="#"> Next </a></li>';
    } else {
        content += '<li class ="page-item"><a class="page-link" href="'+ root+'/plan-list?page=' + pagination.endPage +'&key='+key+'&word='+word +'#share-plan-list"> Next </a></li>';
    }
    content += "</ul>";
    navigation.innerHTML = content;

}

document.getElementById("btn-search").addEventListener("click", () => {
    // 검색 버튼클릭시
    // key와 word와 currentPage를 가지고 이동
    let searchKey = document.getElementById("key");
    let searchKeyValue = searchKey.options[searchKey.selectedIndex].value;

    let searchWord = document.getElementById("word");

    if(searchKeyValue == "검색조건") {
        alert("검색 키워드를 선택해주세요.");
        searchWord.value = "";
        searchWord.focus();
    } else {
        location.href = root + "/plan-list?page="+currentPage + "&key=" + searchKeyValue + "&word=" + searchWord.value +"#share-plan-list";
    }


})

document.getElementById("btn-mv-register").addEventListener("click",() => {
    location.href = root + "/plan-write#share-plan-write";
})