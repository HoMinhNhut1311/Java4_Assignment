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
	<link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.2/dist/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <title>Advanced Level Movies Website</title>
</head>

<body>
<%
	Users user = (Users) session.getAttribute("user");
	Genre_Service genre_Service = new Genre_Service();
	List<Genre> listGenre = genre_Service.getallMovie(request);
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
            <button>Sort by:</button>
            <button id="all_btn">All</button>
            <button id="latest_btn">Latest</button>
            <button id="year">Year <i class="fas fa-angle-down" ></i>
            <div class="year_bx">
                <li id="year2022__btn">2022</li>
                <li id="year2021__btn">2021</li>
                <li id="year2020__btn">2020</li>
                <li>2019</li>
                <li>2018</li>
                <li>2017</li>
                <li>2016</li>
                <li>2015</li>
                <li>2014</li>
            </div>
            </button>
            <button id="a_z">A-Z <i class="fas fa-angle-down" ></i>
                <div class="year_bx letter_bx">
                    <li id="letter_a_btn">A</li>
                    <li id="letter_b_btn">B</li>
                    <li>C</li>
                    <li>E</li>
                    <li>F</li>
                    <li>G</li>
                    <li>H</li>
                    <li id="letter_t_btn">T</li>
                    <li>Z</li>
                </div></button>
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
    
  
</body>

</html>