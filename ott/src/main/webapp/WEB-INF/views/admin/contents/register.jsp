<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../../include/header.jsp"/>

<div class="container-fluid bg-gradient-primary">
<div class="row">
<div class="col-md-12">
<div class="d-flex">
<div class="w-10 mt-1">
	<jsp:include page="../include/lnb.jsp"/>
</div>
<div class="w-90">
	<h2 class="my-3 text-white">コンテンツ登録</h2>
	<form method="post" enctype="multipart/form-data">
		<div class="input-group">
			<label class="form-label text-white">1st Level</label>
			<div class="w-5"></div>
			<select class="form-select category1">
				<option value="">--</option>
			</select>
			<div class="w-5"></div>
			<label class="form-label text-white">2nd Level</label>
			<select class="form-select category2" name="cateCode">
				<option value="">--</option>
			</select>
		</div>
		<div class="input-group mt-5">
			<label class="form-label text-white w-10">タイトル</label>
			<input type="text" id="contents_title" name="contents_title" class="form-control w-90" required/>
		</div>
		<div class="input-group mt-5">
			<label class="form-label text-white w-10">動画URL</label>
			<input type="url" id="contents_video_url" name="contents_video_url" class="form-control w-90" placeholder="https://..." required/>
		</div>
		<div class="input-group mt-5">
			<label class="form-label text-white w-10">紹介文</label>
			<textarea rows="5" id="contents_description" name="contents_description" class="form-control w-90" required></textarea>
			<script src="${contextPath}/resources/js/ckeditorConfig.js">
			</script>
		</div>
		<div class="input-group mt-5">
			<label class="form-label text-white w-10">サムネイル</label>
			<input type="file" id="contents_poster_img" name="file" class="form-control w-90"/>
		</div>
		<div class="select_img my-3">
			<img src="" style="width:100px;"/>
		</div>
		<div class="d-flex">
			<div class="text-white">元画像</div>
			<img src="${contents.contents_poster_img}" style="width:100px;"/>
			<div class="text-white">サムネイル</div>
			<img src="${contents.contents_thumb_img}" style="width:50px;"/>
		</div>
		<script src="${contextPath}/resources/js/changeImgFunction.js"></script>
		<div class="text-white"><%=request.getRealPath("/") %></div>
		<button type="submit" id="register_Btn" class="btn btn-outline-warning btn-block mt-4">
		 登録する
		</button>
	</form>
	<script>
		let jsonData = JSON.parse('${category}');
	</script>
	<script src="${contextPath}/resources/js/jsonDrop.js"></script>
</div>
</div>
</div>
</div>
</div>


<jsp:include page="../../include/footer.jsp"/>