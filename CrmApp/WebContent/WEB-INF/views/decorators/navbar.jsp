<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <nav class="navbar navbar-default navbar-static-top m-b-0">
     	<div class="navbar-header"> 
          	<a class="navbar-toggle hidden-sm hidden-md hidden-lg"
             	href="javascript:void(0)" data-toggle="collapse" data-target=".navbar-collapse">
              	<i class="fa fa-bars"></i>
     		</a>
           	<div class="top-left-part">
               	<a class="logo" href="<c:url value="/home" />">
                	<b><img src='<c:url value="/assets/plugins/images/pixeladmin-logo.png" />' alt="home" /></b>
                	<span class="hidden-xs">
                		<img src='<c:url value="/assets/plugins/images/pixeladmin-text.png"/>' alt="home" />
                	</span>
                </a>
                </div>
                <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                    <li>
                        <form role="search" class="app-search hidden-xs">
                            <input type="text" placeholder="Search..." class="form-control"> 
                          	<a href="">
                          		<i class="fa fa-search"></i>
             				</a>
                        </form>
                    </li>
                </ul>
                <ul class="nav navbar-top-links navbar-right pull-right">
                    <li>
                        <div class="dropdown">
                            <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#"> 
                                <img src='<c:url value="${ LOGIN.avatar }"></c:url>'" alt="user-img" width="36" class="img-circle" />
                                <b class="hidden-xs">${ LOGIN.fullname }</b> 
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Thông tin cá nhân</a></li>
                                <li><a href='<c:url value="/user/password" />'>Đổi mật khẩu</a></li>
                                <li><a href="#">Thống kê công việc</a></li>
                                <li class="divider"></li>
                                <li><a href='<c:url value="/logout" />'>Đăng xuất</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>