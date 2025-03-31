<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../../include/header.jsp"/>

<div class="container-fluid bg-gradient-primary">
<div class="row">
<div class="col-md-12">
<div class="d-flex">
	<div class="w-25">
		<div class="mt-1"></div>
		<jsp:include page="../include/lnb.jsp"/>
	</div>
	<div class="w-75">
		<form role="form" method="post" enctype="multipart/form-data">
			<input type="hidden" name="contents_Id" value="${contents.contents_Id}"/>
			
			<div class="d-flex my-3">
				<div class="text-white">기등록 카테고리</div>
				<div class="text-white mx-3">${contents.cateName}</div>
				<div class="text-white mx-3">${contents.contents_category_code}</div>
			</div>
			
			<!-- category -->
			<div class="d-flex">
				<label class="form-label fw-bold text-white">1st categorization
					<select name="cateName" id="" class="form-select category1">
						<option value="${contents.cateName}" selected>${contents.cateName}</option>
					</select>
				</label>
				<label class="form-label fw-bold mx-3 text-white">2nd categorization
					<select name="contents_category_code" id="" class="form-select category2">
						<option value="${contents.contents_category_code}" selected>${contents.contents_category_code}</option>
					</select>
				</label>
			</div>
			<!-- 수정과 쓰기의 다른 점 
			 	: 기존에 썼던 내용을 불러와야 함. 따라서 el로 밸류 지정.
			-->
			<div class="input-group my-3">
				<label class="form-label fw-bold w-25 text-white">콘텐츠제목</label>
				<input type="text" name="contents_title" id="contents_title" value="${contents.contents_title}" class="form-control">
			</div>
			<div class="input-group mb-3">
				<label class="form-label fw-bold w-25 text-white">콘텐츠소개</label>
				<textarea name="contents_description" id="contents_description" rows="5">${contents.contents_description}</textarea>
				<script src="${contextPath}/resources/js/ckeditorConfig.js">
				</script>
			</div>
			<!--이미지 추가 업로드-->
			<div class="input-group mt-3">
				<label class="form-label fw-bold w-25 text-white">콘텐츠이미지</label>
				<input type="file" name="file" id="contents_poster_img" class="form-control">
				<div class="my-3">
					<div class="select_img d-flex justify-content-end">
						<img src="${contents.contents_poster_img}" alt="이미지를 불러올 수 없음." class="thumb img-thumbnail">
						<input type="hidden" name="contents_poster_img" value="${contents.contents_poster_img}"/>
						<input type="hidden" name="contents_thumb_img" value="${contents.contents_thumb_img}"/>
					</div>
				<script src="${contextPath}/resources/js/changeImgFunction.js"></script>
				<div class="text-white"><%=request.getRealPath("/")%></div>
			</div>
			<!--btn set-->
			<div class="d-flex justify-content-end my-5">
				<div class="btn-group">
					<button type="submit" id="update_Btn" class="btn btn-primary">완료</button>
					<button type="button" id="back_Btn" class="btn btn-secondary">취소</button>
				</div>
			</div>
			<script src="${contextPath}/resources/js/backBtn.js"></script>
			<script>
				let jsonData = JSON.parse('${category}');
			</script>
			<script src="${contextPath}/resources/js/jsonDrop2.js"></script>
		</form>
	</div>
</div>
</div>
</div>
</div>


<jsp:include page="../../include/footer.jsp"/>