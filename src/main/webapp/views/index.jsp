<%@page import="Model.Movie"%>
<%@page import="Service.Movie_Service"%>
<%@page import="java.util.List"%>
<%@page import="Service.Genre_Service"%>
<%@page import="Model.Users"%>
<%@page import="Model.Genre"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- bootstrap cdn link  -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <!-- font-awesome cdn link  -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
		<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css">
    <title>Advanced Level Movies Website</title>
</head>

<body>
<%
	Users user = (Users) session.getAttribute("user");
	Genre_Service genre_Service = new Genre_Service();
	List<Genre> listGenre = genre_Service.getallGenre(request);
    Movie_Service ms = new Movie_Service();	
    Movie topView = ms.getTopView(request);
%>
    <header style="background-image: url('<%= topView.getSrcImg() %>');">
        <nav>
            <a href="/" class="logo"><img src="${pageContext.request.contextPath}/img/logo.png" alt=""></a>
            <div class="end_bx">
                <ul>
                 	<li><a class="text-danger fw-bold" href="#"><%= user.getEmail() %></a></li>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Movies</a></li>
                    <li><a href="#">Series</a></li>
                    <li style="color: red;cursor: pointer;">Chủ đề<i class="fas fa-angle-down"></i>
                         <div class="list">
                            <a href="#">Xu hướng</a>
                            <a href="#">Phổ Biến</a>
                            <a href="#">Nhiều lượt thích</a>
                            <a href="#">Mới ra mắt</a>
                            <a href="#">Diễn viên nỗi tiếng</a>
                            <a href="#">Hollywood</a>
                            <a href="${pageContext.request.contextPath}/views/addMovie.jsp">Thêm Phim</a>
                        </div>
                    </li>
                </ul>
                <div class="search">
                    <input type="text" placeholder="Search movies..." id="search">
                    <i class="fas fa-search" id="search_icon"></i>
                    <div class="search_bx2">

                    </div>
                </div>
                <div class="bell">
                    <i class="fas fa-bell"></i>
                </div>
                <div class="user">
                    <img src="https://images.unsplash.com/photo-1536440136628-849c177e76a1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Nnx8bW92aWV8ZW58MHx8MHx8fDA%3D" alt="Jahid Khan" title="jahid khan">
                </div>
            </div>
        </nav>

        <div class="content">
	            <h6>Duration: <span id="header_dur"><%= topView.getDuration() %></span></h6>
            <h3 id="header_gen"><i class="fas fa-star"></i><%= topView.getRating() %>
                <span><%= topView.getGenre().getName() %></span>
            </h3>
            <h1 id="header_title"><%= topView.getTitle() %></h1>
            <p id="header_pra"><%= topView.getDes() %></p>
            <div class="btns">
                <a href="#video"> <button><i class="fas fa-play" id="play_btn"></i> WATCH</button></a>
                <button><i class="fas fa-plus"></i> ADD LIST</button>
            </div>
        </div>
        <div class="slider_btns">
            <h6 class="slider"></h6>
            <h6 class="slider"></h6>
            <h6 class="slider"></h6>
        </div>
    </header>
    
    <!-- trending box start  -->
    <div class="tranding_bx">
        <li><a href="#" class="active"><i class="fas fa-angle-double-up"></i> Trends Now <span></span></a></li>
        <li><a href="#"><i class="fas fa-fire"></i> Popular <span></span></a></li>
        <li><a href="#"><i class="fas fa-star"></i> Prefrenes <span></span></a></li>
        <li><a href="#"><i class="fas fa-plus"></i> Recently Added <span></span></a></li>
    </div>

    <div class="cato_bx" id="cato_bx">
        <% for(Genre genre : listGenre) { %>
        <button><%=genre.getName()%></button>
        <% } %>
         <!-- Thể loại -->
        <!-- all button copyed  -->
        <div class="cato_left_right">
            <i class="fas fa-angle-down" id="left_scroll"></i>
        </div>
        <div class="cato_left_right">
            <i class="fas fa-angle-down" id="right_scroll"></i>
        </div>
    </div>
    <!-- video box start  -->
<iframe width="100%" height="530vh" src="<%= topView.getSourceTrailer() %>" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
</iframe>
    <!-- video box end  -->

    <!-- trending box2 start  -->
    <div class="tranding_bx" style="margin-top: 20px;">
        <li><a href="#" class="active"><i class="fas fa-photo-video"></i> Movies <span></span></a></li>
        <li><a href="#"><i class="fas fa-film"></i> Series <span></span></a></li>
        <li><a href="#"><i class="fas fa-check"></i> Original Series <span></span></a></li>
        <li><a href="#"> Tralier <span></span></a></li>
    </div>
    <div class="cato_bx cato_bx2">
    
        <div class="left_cato">
         	<Span class="me-2">Sắp xếp theo</Span>
         	
         	<!-- Đánh Giá -->
			<div class="btn-group vote">
			  <button type="button" class="btn btn-outline-success bg-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			    Đánh Giá
			  </button>
			  <ul class="dropdown-menu">
			    <li class="bg-danger"><a class="dropdown-item" href="#">Thấp Nhất</a></li>
			    <li><hr class="dropdown-divider"></li>
			    
			    <li><a class="dropdown-item" href="#">1 - 2 Sao</a></li>
			    <li><a class="dropdown-item" href="#">2 - 4 Sao</a></li>
			    <li><a class="dropdown-item" href="#">4 - 6 Sao</a></li>
			    <li><a class="dropdown-item" href="#">8 - 10 Sao</a></li>
			    
			    <li><hr class="dropdown-divider"></li>
			    <li class="bg-success"><a class="dropdown-item" href="#">Cao Nhất</a></li>
			  </ul>
			</div>
			
			<!-- Thời gian bộ phim -->
			<div class="btn-group duration">
			  <button type="button" class="btn btn-outline-success bg-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			    Thời Lượng
			  </button>
			  <ul class="dropdown-menu">
			    <li class="bg-danger"><a class="dropdown-item" href="#">Thấp Nhất</a></li>
			    <li><hr class="dropdown-divider"></li>
			    
			    <li><a class="dropdown-item" href="#">50 - 70 phút</a></li>
			    <li><a class="dropdown-item" href="#">70 - 90 phút</a></li>
			    <li><a class="dropdown-item" href="#">90  - 120 phút</a></li>
			    <li><a class="dropdown-item" href="#">120 - 180 phút</a></li>
			    
			    <li><hr class="dropdown-divider"></li>
			    <li class="bg-success"><a class="dropdown-item" href="#">Cao Nhất</a></li>
			  </ul>
			</div>
			
			<!-- Lượt xem -->
			<div class="btn-group view">
			  <button type="button" class="btn btn-outline-success bg-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			    Thời Lượng
			  </button>
			  <ul class="dropdown-menu">
			    <li class="bg-danger"><a class="dropdown-item" href="#">Thấp Nhất</a></li>
			    <li><hr class="dropdown-divider"></li>
			    
			    <li><a class="dropdown-item" href="">1 - 10 lượt xem</a></li>
			    <li><a class="dropdown-item" href="#">10 - 100 lượt xem</a></li>
			    <li><a class="dropdown-item" href="#">100 - 300 lượt xem</a></li>
			    <li><a class="dropdown-item" href="#">300 - 500 lượt xem</a></li>
			    <li><a class="dropdown-item" href="#">500 lượt xem trở lên</a></li>
			    
			    <li><hr class="dropdown-divider"></li>
			    <li class="bg-success"><a class="dropdown-item" href="#">Cao Nhất</a></li>
			  </ul>
			</div>
			
			<!-- Ngày Ra Mắt -->
			<div class="btn-group release">
			  <button type="button" class="btn btn-outline-success bg-danger dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false">
			    Thời gian ra mắt
			  </button>
			  <ul class="dropdown-menu">
			    <li class="bg-danger"><a class="dropdown-item" href="#">Thấp Nhất</a></li>
			    <li><hr class="dropdown-divider"></li>
			    
			    <li><a class="dropdown-item" href="#">Trước Năm 2010</a></li>
			    <li><a class="dropdown-item" href="#">Trước Năm 2014</a></li>
			    <li><a class="dropdown-item" href="#">Trước Năm 2018</a></li>
			    <li><a class="dropdown-item" href="#">Trước Năm 2022</a></li>
			    <li><a class="dropdown-item" href="#">Sau Năm 2022</a></li>
			    
			    <li><hr class="dropdown-divider"></li>
			    <li class="bg-success"><a class="dropdown-item" href="#">Cao Nhất</a></li>
			  </ul>
			</div>
         	
         	
        </div>
        <div class="right_cato">
            <i class="fas fa-star"></i>
            <input type="range" name="" id="change_input" min="4.2" max="9.9">
            <span>7.0</span>
        </div>
    </div>

    <div class="movie_bx_1 movie_bx_2">
        <div class="all box2_actives" id="all"></div>
        <div class="latest box2_actives" id="latest">
        	 <%@ include file="/views/listFlim.jsp" %>
        </div>
        <div class="year" id="year_2022"></div>
        <div class="year" id="year_2021"></div>
        <div class="year" id="year_2020"></div>
        <div class="letter" id="letter_a"></div>
        <div class="letter" id="letter_b"></div>
        <div class="letter" id="letter_t"></div>
        <div class="rate_change" id="rate4"></div>
        <div class="rate_change" id="rate8"></div>
    </div>
    
  <!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
  
</body>

</html>