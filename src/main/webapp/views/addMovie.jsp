<%@page import="Model.Actor"%>
<%@page import="Model.Genre"%>
<%@page import="Filter.DataCache"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<body>
	<div class="container">
		<h2>Thêm Phim</h2>
		<form action="${pageContext.request.contextPath}/addMovie" method="post">
		<div class="row">
		<div class="col">
		<div class="form-group">
			<label class="form-label">Tên phim</label> <input type="text" class="form-control"
				name="title">
		</div>

		<div class="form-group">
			<label class="form-label">Tên phim</label> <select name="genre" class="form-control">
				<%
				for (Genre g : DataCache.getListGenre()) {
				%>
				<option value="<%=g.getGenre_id()%>"><%=g.getName()%></option>
				<%
				}
				%>
			</select>

			<div class="form-group">
				<label class="form-label">Đạo diễn</label> <input type="text" class="form-control"
					name="director">
			</div>

			<div class="form-group">
				<label class="form-label">Mô tả</label> <input type="text" class="form-control"
					name="des">
			</div>

			<div class="form-group">
				<label class="form-label">Đường dẫn ảnh</label> <input type="text" class="form-control"
					name="srcImg">
			</div>
			</div>

			<div class="form-group">
				<label class="form-label">Danh sách diễn viên</label> <select class="form-control"
					name="actors" multiple="multiple">
					<%
					for (Actor a : DataCache.getListActors()) {
					%>
					<option value="<%=a.getId()%>"><%=a.getName()%></option>
					<%
					}
					%>
				</select>
			</div>
		</div>

		<div class="col">
		<div class="form-group">
			<label class="form-label">Đánh giá</label> <input type="number" class="form-control" name="rating" max="10" min="0"> 
		</div>
		
		<div class="form-group">
			<label class="form-label">Ngày ra mắt</label> <input class="form-control" type="date" name="release"> 
		</div>

		<div class="form-group">
			<label class="form-label">Đường dẫn Video Trailer</label> <input class="form-control" type="text" name="sourceTrailer">
		</div>
		
		<div class="form-group">
			<label class="form-label">Đường dẫn Video Full</label> <input class="form-control" type="text" name="sourceWatch">
		</div>
</div>
</div>
	<button class="btn btn-outline-primary mt-4" type="submit">Thêm Phim</button>
</form>

	</div>

</body>
</html>