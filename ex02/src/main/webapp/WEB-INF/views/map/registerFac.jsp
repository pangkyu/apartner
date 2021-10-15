<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp" %>

<div id="map" style="width:100%;height:350px;"></div>

<div id="clickLatlng"></div>

            <div id="myModal" class="modal" tabindex="-1" role="dialog">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title">아파트 정보를 저장하시겠습니끼?</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        	<form action="/map/registerFacility" method="post">
				        	    <div class="form-group">
									<label>시설물 이름을 입력하세요</label>
                                	<input class="form-control" name = "fac_name" id="fac_name">
                                </div>
                           		<div class="form-group">
									<label>아파트 이름</label>
                                	<input class="form-control" name = "fac_aptname" id="fac_aptname" value="${apt_name }" readonly>
                                </div>
								<div>
									<label>최대 인원 수</label> 
									<input type="number" name="fac_numperson" id="fac_numperson" value=1/>
								</div>
                                <div class="form-group">
                                	<input class="form-control" name = "fac_lat" id="fac_lat"  type="hidden">
                                	<input class="form-control" name = "fac_lng" id="fac_lng"  type="hidden">
	                               	<input class="form-control" name = "fac_admin" type="hidden" value = "user00">
                                </div>
                                <button type="submit" class="btn btn-default">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>
                            </form>
				      </div>
				    </div>
				  </div>
				</div>
	<input id="hidden_lat" type="hidden" value="${getApart.apt_lat }">
	<input id="hidden_lng" type="hidden" value="${getApart.apt_lng }">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=985f52f2cde50dbe19ca2aa591157924&libraries=services"></script>
<script>
$(document).ready(function(){
	$('#fac_numperson').spinner();
});


// 마커를 담을 배열입니다
var markers = [];

var initLat = document.getElementById('hidden_lat').value;
var initLng = document.getElementById('hidden_lng').value;

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(initLat, initLng), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

//지도를 클릭한 위치에 표출할 마커입니다
var marker = new kakao.maps.Marker({ 
    // 지도 중심좌표에 마커를 생성합니다 
    position: map.getCenter() 
}); 
// 지도에 마커를 표시합니다
marker.setMap(map);

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
kakao.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng; 
    
    // 마커 위치를 클릭한 위치로 옮깁니다
    marker.setPosition(latlng);
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('clickLatlng'); 
    resultDiv.innerHTML = message;

    $("#fac_lat").val(latlng.getLat());
	$("#fac_lng").val(latlng.getLng());
	$("#myModal").modal("show");
    
});
</script>
<%@include file="../includes/footer.jsp" %>