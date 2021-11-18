<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                 
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Register or Remove 선택 후 submit 버튼을 누르세요
                            <button id = "submitBtn" type = "button" class = "btn btn-xs pull-right submitBtn">Submit</button>
                        	<button id = "removeBtn" type = "button" class = "btn btn-xs pull-right">Remove</button>
                            <button id = "regBtn" type="button" class="btn btn-xs pull-right">Register</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>bno</th>
                                        <th>아파트 이름</th>
                                        <th>시설물 이름</th>
                                        <th>사용인원</th>
                                        <th>등록일자</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${faclist }" var="board">
                                    <tr class="odd gradeX">
                                        <td>${board.fac_bno }</td>
                                        <td><c:out value="${board.fac_aptname}"/></td>
                                        <td>${board.fac_name }</td>
                                        <td>${board.fac_usingperson }/${board.fac_numperson}</td>
                                        <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate}" /></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <!-- /.table-responsive -->
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
            <div id="myModal" class="modal" tabindex="-1" role="dialog">
				  <div class="modal-dialog" role="document">
				    <div class="modal-content">
				      <div class="modal-header">
				        <h5 class="modal-title">Modal title</h5>
				        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
				          <span aria-hidden="true">&times;</span>
				        </button>
				      </div>
				      <div class="modal-body">
				        <p>Modal body text goes here.</p>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-primary">Save changes</button>
				        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				      </div>
				    </div>
				  </div>
				</div>
           

<%@include file="../includes/footer.jsp" %>