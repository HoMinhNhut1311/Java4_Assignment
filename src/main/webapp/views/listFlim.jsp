<%@page import="Filter.DataCache"%>
<%@page import="Model.Movie"%>
<%@page import="java.util.List"%>
<%@page import="Service.Movie_Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Card Effect</title>
</head>
<script src="https://kit.fontawesome.com/95a02bd20d.js"></script>
<style>
body {
	margin: 0;
	font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", "Roboto",
		"Oxygen", "Ubuntu", "Cantarell", "Fira Sans", "Droid Sans",
		"Helvetica Neue", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	background-color: rgb(22, 20, 24);
	color: #eee;
	user-select: none;
}

.nft {
	user-select: none;
	width: 400px;
	height: 450px;
	margin: 2rem auto;
	border: 1px solid #ffffff22;
	background-color: #282c34;
	background: linear-gradient(0deg, rgba(40, 44, 52, 1) 0%,
		rgba(17, 0, 32, .5) 100%);
	box-shadow: 0 7px 20px 5px #00000088;
	border-radius: .7rem;
	backdrop-filter: blur(7px);
	-webkit-backdrop-filter: blur(7px);
	overflow: hidden;
	transition: .5s all;
}

.nft hr {
	width: 100%;
	border: none;
	border-bottom: 1px solid #88888855;
	margin-top: 0;
}

.nft ins {
	text-decoration: none;
}

.nft .main {
	display: flex;
	flex-direction: column;
	width: 90%;
	padding: 1rem;
}

.nft .tokenImage {
	border-radius: .5rem;
	max-width: 100%;
	height: 150px;
	object-fit: cover;
}

.nft .description {
	margin: .5rem 0;
	color: #a89ec9;
	font-size: 12px;
	overflow: auto; /* Thêm thanh trượt khi mô tả vượt quá kích thước */
}

.nft .tokenInfo {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.nft .price {
	display: flex;
	align-items: center;
	color: #ee83e5;
	font-weight: 700;
}

.nft .price ins {
	margin-left: -.3rem;
	margin-right: .5rem;
}

.nft .duration {
	display: flex;
	align-items: center;
	color: #a89ec9;
	margin-right: .2rem;
}

.nft .duration ins {
	margin: .5rem;
	margin-bottom: .4rem;
}

.nft .creator {
	display: flex;
	align-items: center;
	margin-top: .2rem;
	margin-bottom: -.3rem;
}

.nft .creator ins {
	color: #a89ec9;
	text-decoration: none;
}

.nft .creator .wrapper {
	display: flex;
	align-items: center;
	border: 1px solid #ffffff22;
	padding: .3rem;
	margin: 0;
	margin-right: .5rem;
	border-radius: 100%;
	box-shadow: inset 0 0 0 4px #000000aa;
}

.nft .creator .wrapper img {
	border-radius: 100%;
	border: 1px solid #ffffff22;
	width: 2rem;
	height: 2rem;
	object-fit: cover;
	margin: 0;
}

.nft:hover {
	border: 1px solid #ffffff44;
	box-shadow: 0 7px 50px 10px #000000aa;
	transform: scale(1.015);
	filter: brightness(1.3);
}

.nft:hover::before {
	filter: brightness(.5);
	top: -100%;
	left: 200%;
}

.nft::before {
	position: fixed;
	content: "";
	box-shadow: 0 0 100px 40px #ffffff08;
	top: -10%;
	left: -100%;
	transform: rotate(-45deg);
	height: 60rem;
	transition: .7s all;
}
</style>
<body>
	<%
	List<Movie> listM = DataCache.getListM();
	for (Movie m : listM) {
	%>
	<a
		href="${pageContext.request.contextPath}/movie/detail?id=<%= m.getId() %>"
		class="nft" style="text-decoration: none">
		<div class='main'>
			<img class='tokenImage' src="<%=m.getSrcImg()%>" alt="NFT" />
			<h2 class="fs-5" style="color: red"><%=m.getTitle()%></h2>
			<div style="height: 160px; overflow: hidden;">
				<p class='description' style="font-size: 10px"><%=m.getDes()%>
				</p>
			</div>
			<div class='tokenInfo'>
				<div class="price">
					<span style="color: yellow;">&#9733; <%=m.getRating()%></span>
				</div>
				<div class="duration">
					<span class="text-primary">◷<%=m.getDuration()%> phút
					</span>
				</div>
				<div class="view">
					<span class="text-danger"> <i class="fas fa-eye"></i> <%=m.getVisit()%>
						Lượt xem
					</span>
				</div>
			</div>
			<hr />
			<div class='creator'
				style="display: flex; justify-content: space-between;">
				<div class='release fw-bold text-succsess'>
					<span>Ra mắt: <%=m.getReleaseYear()%><ins></span>
				</div>
				<div class="director" style="font-style: italic;">
					<%=m.getDirector()%></ins>
				</div>
			</div>

		</div>
	</a>
	<div>
		<a
			href="${pageContext.request.contextPath}/addMovie?id=<%= m.getId() %>">Xóa</a>
	</div>
	<%
	}
	%>
</body>
</html>

