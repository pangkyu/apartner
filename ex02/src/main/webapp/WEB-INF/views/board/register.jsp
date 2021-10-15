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
                            <label>Board Register</label>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form action="/board/register" method="post">
                           		<div class="form-group">
									<label>Title</label>
                                	<input class="form-control" name = "title">
                                </div>
                                <div class="form-group">
									<label>Writer</label>
                                	<input class="form-control" name = "writer">
                                </div>
                                <div class="form-group" name = "">
                                	<label>Content</label>
                                	<textarea class="form-control" rows="5" cols="50" name="content"></textarea>
                                </div>
                                <button type="submit" class="btn btn-default">Submit Button</button>
                                <button type="reset" class="btn btn-default">Reset Button</button>
                            </form>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
<%@include file="../includes/footer.jsp" %>