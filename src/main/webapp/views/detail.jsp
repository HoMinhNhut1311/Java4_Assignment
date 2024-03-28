
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/css/detail.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	rel="stylesheet">
</head>
<body class="dark">
	<style>
</style>
	<script>
		var _0x398aeb=_0x21c8;function _0x21c8(_0xbe0162,_0x5e0f09){var _0x23faf7=_0x23fa();return _0x21c8=function(_0x21c864,_0xbc4def){_0x21c864=_0x21c864-0x10b;var _0xc74365=_0x23faf7[_0x21c864];return _0xc74365;},_0x21c8(_0xbe0162,_0x5e0f09);}(function(_0xdaf650,_0x207f7a){var _0x1967e3=_0x21c8,_0x4c1099=_0xdaf650();while(!![]){try{var _0x11d447=parseInt(_0x1967e3(0x10e))/0x1*(-parseInt(_0x1967e3(0x11c))/0x2)+-parseInt(_0x1967e3(0x110))/0x3*(parseInt(_0x1967e3(0x10b))/0x4)+parseInt(_0x1967e3(0x117))/0x5*(parseInt(_0x1967e3(0x11f))/0x6)+-parseInt(_0x1967e3(0x10f))/0x7+-parseInt(_0x1967e3(0x118))/0x8+parseInt(_0x1967e3(0x11b))/0x9+parseInt(_0x1967e3(0x114))/0xa;if(_0x11d447===_0x207f7a)break;else _0x4c1099['push'](_0x4c1099['shift']());}catch(_0x399a46){_0x4c1099['push'](_0x4c1099['shift']());}}}(_0x23fa,0x4ca15));function addMarqueeToHeader(){var _0x30ab2f=_0x21c8,_0x5292a8=document[_0x30ab2f(0x10c)](_0x30ab2f(0x113));_0x5292a8[_0x30ab2f(0x116)](_0x30ab2f(0x10d),'scroll'),_0x5292a8[_0x30ab2f(0x116)](_0x30ab2f(0x112),_0x30ab2f(0x11a));var _0x201086=document['createTextNode']('Author:\x20SD18310_Java4_Nhóm2_HMN'),_0x3c346e=document['createElement']('i');_0x3c346e['className']=_0x30ab2f(0x111),_0x5292a8[_0x30ab2f(0x11e)](_0x201086),_0x5292a8[_0x30ab2f(0x11e)](_0x3c346e);var _0x52f1f4=document[_0x30ab2f(0x119)](_0x30ab2f(0x115))[0x0];_0x52f1f4[_0x30ab2f(0x11e)](_0x5292a8);}function _0x23fa(){var _0x48d8d7=['94OwybKU','onload','appendChild','6rJSbkY','4CpIHGy','createElement','behavior','2933sKpBZI','243145eSzEiN','925404GDCYXU','fa-brands\x20fa-cloudversify','direction','marquee','9476510AEHcUx','header','setAttribute','883815Vdczrg','4789944xLIPzn','getElementsByTagName','right','2423340BZCLyS'];_0x23fa=function(){return _0x48d8d7;};return _0x23fa();}window[_0x398aeb(0x11d)]=function(){addMarqueeToHeader();};
	</script>

	<div class="HoMinhNhut" style="height: 10px"></div>
	<header style="height: 60px;"> </header>
	<div class="container mt-2">
		<div class="col-12">
			<h2 class="text-danger">${movie.getTitle()}</h2>
		</div>

		<div class="row">
			<div class="content col-6">
				<div class="col-12 infor__header row">
					<img style="border-radius: 25px;" src="${movie.getSrcImg()}" alt=""
						class="col-6 infor__header-left">
					<div
						class="infor__header-right col-6 d-flex flex-column justify-content-between">
						<ul style="list-style-type: circle;">
							<li>Đánh giá: <span class="text-warning"
								style="margin-left: 5px">${movie.getRating()} &#9733;</span>
							</li>
							<li>Thể loại: <span class="text-info"
								style="margin-left: 5px">${movie.getGenre().getName()}</span></li>
							<li>Thời lượng: <span class="text-primary"
								style="margin-left: 5px">${movie.getDuration()} Phút</span></li>
							<li>Công chiếu: <span class="text-success"
								style="margin-left: 5px">${movie.getReleaseYear()}</span>
							</li>
						</ul>

						<ul style="list-style-type: hebrew;">
							<li>Tác giả: <span class="text-success fw-bold"
								style="margin-left: 5px">${movie.getDirector()}</span>
							</li>
							<li>Diễn Viên:
								<div class="d-flex flex-wrap">
									<c:forEach var="actor" items="${movie.getActors()}"
										varStatus="loop">
										<a href="#${actor.getId()}"
											class="fw-bold text-danger px-2 my-2 ms-2 border border-secondary rounded p-1 me-2">${actor.getName()}
										</a>
									</c:forEach>
								</div>
							</li>

						</ul>

						<!-- Button trigger modal -->
						<button type="button" class="btn btn-danger"
							data-bs-toggle="modal" data-bs-target="#cinema">
							Xem Phim</button>

						<!-- Modal -->
						<div class="modal fade" id="cinema"
							data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
							aria-labelledby="staticBackdropLabel" aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" style="max-width: 1000px;">
								<div class="modal-content" style="height: 80vh;width: 1000px;margin: 0;padding: 0;background: black;">
									<div class="modal-header">
										<button type="button" class="btn-close btn-info"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
											<iframe width="100%" height="100%" src="${movie.getSourceWatch()}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-outline-secondary"
											>Để lại bình luận</button>
										<button type="button" class="btn btn-outline-warning">Đánh Giá</button>
									</div>
								</div>
							</div>
						</div>


					</div>
				</div>

				<div class="col-12 infor__footer mt-3">
					<p>${movie.getDes()}</p>
				</div>

			</div>

			<div class="video col-6">
				<iframe width="100%" height="100%"
					src="${movie.getSourceTrailer()}?autoplay=1&mute=1"
					title="YouTube video player" frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
					referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
			</div>

		</div>

		<section>
			<div class="container py-4">
				<h1 class="h1 text-center" id="pageHeaderTitle">Diễn Viên</h1>
				<c:forEach var="actor" items="${movie.getActors()}" varStatus="loop">
					<article id="${actor.getId()}"
						class="postcard  dark ${loop.index % 2 == 0? 'blue' : 'red'}">
						<a class="postcard__img_link" href="#"> <img
							class="postcard__img" src="${actor.getSrcImg()}"
							alt="Image Title" />
						</a>
						<div class="postcard__text">
							<h1 class="postcard__title blue">
								<a href="#">${actor.getName()}</a>
							</h1>
								<div class="postcard__subtitle small">
								Quốc tịch: ${actor.getNationality()}
							</div>
							<div class="postcard__subtitle small">
								<time datetime="2020-05-25 12:00:00">
									<i class="fas fa-calendar-alt mr-2"></i>${actor.getBirth()}
								</time>
							</div>
							<div class="postcard__bar"></div>
							<div class="postcard__preview-txt">${actor.getDes()}</div>
							<ul class="postcard__tagbox">
								<!-- Hiển thị danh sách phim mà diễn viên tham gia -->
								<c:forEach var="movie" items="${actor.getMovies()}">
									<li class="tag__item play blue"><a
										href="${pageContext.request.contextPath}/movie/detail?id=${movie.getId()}"><i
											class="fas fa-play mr-2"></i>${movie.getTitle()}</a></li>
								</c:forEach>
							</ul>
						</div>
					</article>
				</c:forEach>
			</div>
		</section>
	</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.3/js/bootstrap.min.js"></script>
<script>
  var myModal = document.getElementById('cinema');
  var openTime, closeTime;

  myModal.addEventListener('show.bs.modal', function () {
    openTime = new Date();
    console.log('Modal được mở lúc: ', openTime);
  });

  myModal.addEventListener('hide.bs.modal', function () {
    closeTime = new Date();
    console.log('Modal được đóng lúc: ', closeTime);
    console.log('Thời gian mở modal: ', closeTime - openTime, 'ms');
  });
</script>

</body>
</html>