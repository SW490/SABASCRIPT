<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../../include/header.jsp" flush="false"/>

<div class="container-fluid bg-gradient-primary">
<div class="row">
<div class="col-md-12">
	<div class="d-flex">
		<div class="w-25">
		<div class="mt-1"></div>
			<jsp:include page="../include/lnb.jsp"/>
		</div>
		<div class="w-75 p-2">
			<!-- 내용 -->
			<h2 class="my-5 text-white">상품목록</h2>
			<table class="table table-hover">
				<colgroup>
					<col width="5%"/>
					<col width="10%"/>
					<col width="30%"/>
					<col width="30%"/>
					<col width="20%"/>
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>콘텐츠이미지</th>
						<th>콘텐츠제목</th>
						<th>단백질 함량</th>
						<th>등록날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="list">
						<tr>
							<td class="text-center">${list.contents_Id}</td>
							<td><img src="${list.contents_thumb_img}" class="thumb img-thumbnail"/></td>
							<td>
								<a href="/admin/contents/view?n=${list.contents_Id}" class="">
									<!-- 제목을 클릭할때 맞는 순번 상품순서로 view page-->
									${list.contents_title}<!-- 제목 -->
								</a>
							</td>
							<td class="text-center">${list.contents_description}</td>
							<td class="text-center">
								<fmt:formatDate pattern="yyyy-MM-dd" value="${list.contents_created_at}"/>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
</div>
</div>

<jsp:include page="../../include/footer.jsp"/>