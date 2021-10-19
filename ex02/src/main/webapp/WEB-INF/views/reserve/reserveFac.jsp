<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp" %>
<input value="${info.fac_aptname }"></input>
<input value="${info.fac_name }"></input>
<input value="${info.fac_info }"></input>
<input value="${info.fac_opentime }"></input>
<input value="${info.fac_closetime }"></input>

                                <div class="form-group">
                                	<label>시작 시간</label>
									<input type="hidden" id="rcvopenhour" value="${openhour}"/>
									<input type="hidden" id="rcvopenmin" value="${openmin}"/>
									<input type="hidden" id="rcvclosehour" value="${closehour}"/>
									<input type="hidden" id="rcvclosemin" value="${closemin}"/>
                                    <select name="fac_opentime" id="openhour" onchange="addOpt('open')">
                                    	<option>---</option>
										<c:forEach var="i" begin="${openhour }" end="${closehour }">
										  <option value="${i}">${i}</option>
										</c:forEach>
								    </select>
								    <select id="openmin">
                                	</select>
                                </div>
                                <div class="form-group">
                                	<label>끝나는 시간</label>
                                    <select name="fac_closetime" id="closehour" onchange="addOpt('close')">
                                    	<option>---</option>
								        <c:forEach var="i" begin="00" end="23">
										  <option value="${i}">${i}</option>
										</c:forEach>
								    </select>
								    <select id="closemin">
								    </select>
								</div>
</body>
<script>

function addOpt(type){

	var selectedhour = $('#openhour').val();
	var selectedhour_close = $('#closehour').val();
	if(type == 'open'){
		$('#openmin').empty();
		if(selectedhour	== $('#rcvopenhour').val() && $('#rcvopenmin').val() == '30'){	
	        $('#openmin').append($("<option>30</option>"));
		}
		else{
	        $('#openmin').append($("<option>00</option>"));	
			$('#openmin').append($("<option>30</option>"));
		}
	} else{
		$('#closemin').empty();	
		if(selectedhour_close	== $('#rcvclosehour').val() && $('#rcvclosemin').val() == '0'){	
	        $('#closemin').append($("<option>00</option>"));
		}
		else{
	        $('#closemin').append($("<option>00</option>"));	
	        $('#closemin').append($("<option>30</option>"));
		}
	}
}
</script>
</html>