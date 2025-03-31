<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="../include/header.jsp" flush="false"/>

         <div class="container-fluid">
            <div class="row">
               <div class="col-md-3 col-lg-2 mt-5">
                   <jsp:include page="../include/aside.jsp" />    
               </div> 
               <div class="col-md-9 col-lg-10">
                  <form role="form">
                     <input type="hidden" name="contents_Id" value="${view.contents_Id}" />
                     <!-- 익스프레션 자바 표현식 el 익스프레션 랭귀지 -->
                  </form>

                  <div class="menubox">
                     <div class="menubar">
                        <ul>
                           <li class="active">
                           <button type="button">エピソード</button>
                           </li>
                           <li class="">
                           <button type="button">コメント(0)</button>
                           </li><li class="">
                           <button type="button">あらすじ</button>
                           </li><li class="">
                           <button type="button">公式イメージ</button>
                           </li>
                        </ul>
                     </div>
                        
                  <div class="my-3 content-item">
                  		<div class="ratio ratio-16x9 mb-4">
                  			<iframe src="${view.contents_video_url}" title="${view.contents_title}" allowfullscreen></iframe>
                  		</div>
                  		<div class="info text-white my-3">
                  			<p class="content-title subject">Python超入門コース 合併版｜Pythonの超基本的な部分をたった1時間で学べます【プログラミング初心者向け入門講座】</p>
	                     	<p class="subject">予告編</p>
	                     	<span class="date">2025.03.31</span>
	                  	</div>
                  </div>
                  
                  <div class="my-3">
                  	<button type="button" class="btn btn-sm toggle-like ${liked ? 'btn-outline-danger' : ''}" data-contents_Id="${view.contents_Id}" data-liked="${liked}">
                  		${liked ? '❤️' : '🤍'}
              		</button>
                  </div>
                  
                  <script>
	                  document.querySelector(".toggle-like").addEventListener("click", function () {
	                      const btn = this;
	                      const contents_Id = btn.dataset.contents_Id;
	
	                      fetch("/ott/toggleLike", {
	                          method: "POST",
	                          headers: { "Content-Type": "application/x-www-form-urlencoded" },
	                          body: "contents_Id=" + contents_Id
	                      })
	                      .then(res => res.json())
	                      .then(data => {
	                          if (data.status === "unauthenticated") {
	                              alert("ログインしてください！");
	                              return;
	                          }
	                          const liked = data.liked;
	                          btn.innerText = liked ? "❤️" : "🤍";
	                          	if(liked) {
	                        	  	btn.classList.add("btn-outline-danger");
	                        	} else {
	                        		btn.classList.remove("btn-outline-danger");
	                        	}
	                          }
	                      });
                  </script>
                  
                  <div class="text-white">
                     <label class="form-label">카테고리</label>
                     <span class="mx-3">일본어, IT</span>
                  </div>
                  <div class="text-white my-3">
                     <label class="form-label">영상내용</label>
                     <span class="mx-3">파이썬 기초강의(이엘 테그 넣기)</span>
                  </div>

                  <div id="reply" class="text-white my-3">
                     <c:if test="${member == null}">
                        <p>리뷰를 남기시려면 <a href="/member/signin">로그인</a>해주세요</p>
                     </c:if>

                     <c:if test="${member != null}"><!-- 로그인을 하면 댓글을 사용 -->
                        <section class="replyForm">
                           <!-- 히든으로 제품번호가 들어가야됨 -->
                           <form role="form" method="post" autocomplete="off">

                              <input type="hidden" name="contents_Id" id="contents_Id" value="${view.contents_Id}">
                              <!-- 댓글쓰기 -->
                              <div class="my-3 text-white">
                                 <textarea name="repCon" id="repCon"
                                    class="form-control">리뷰를 남겨주세요</textarea>
                              </div>

                              <div class="d-flex justify-content-end text-white">
                                 <button type="button" id="reply_btn" class="btn btn-outline-primary">
                                    리뷰쓰기
                                 </button>
                                 <script src="/resources/js/reply.js"></script>
                              </div>

                           </form>
                        </section>
                     </c:if>

                     <section class="replyList my-3">
                        <ul class="list-group list-group-flush">

                        </ul>

                     </section>
                  </div>
                  
               </div>

         </div>
         </div>
         </div>


         <!-- 리플리에 수정창 탑재 -->
         <div class="replyModal">

            <div class="modalContent">

               <div class="">
                  <textarea class="modal_repCon form-control" name="modal_repCon"></textarea>
               </div>

               <div class="d-flex justify-content-end my-2">
                  <button type="button" class="modal_modify_btn btn btn-success mx-2">
                     수정
                  </button>
                  <button type="button" class="modal_cancel btn btn-secondary">
                     취소
                  </button>
               </div>

            </div>
            <script src="/resources/js/replyDelete.js"></script>
            <script src="/resources/js/replyEdit.js"></script>

            <div class="modalBackground"></div><!-- 검정색 바탕에 투명도 80 -->
         </div>

         <jsp:include page="../include/footer.jsp" />