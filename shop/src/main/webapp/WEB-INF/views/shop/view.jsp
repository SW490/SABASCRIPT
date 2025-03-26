<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<jsp:include page="../include/header.jsp" flush="false"/>

         <div class="container-fluid">
            <div class="row">
               <div class="col-md-3 col-lg-2 mt-5">
                   <jsp:include page="../include/aside.jsp" />    
               </div> 
               <div class="col-md-9 col-lg-10">
                  <form role="form">
                     <input type="hidden" name="gdsNum" value="${view.gdsNum}" />
                     <!-- 익스프레션 자바 표현식 el 익스프레션 랭귀지 -->
                  </form>

                  <div class="menubox">
                     <div class="menubar">
                        <ul>
                           <li class="active">
                           <button type="button">에피소드</button>
                           </li>
                           <li class="">
                           <button type="button">리뷰(0)</button>
                           </li><li class="">
                           <button type="button">프로그램 소개</button>
                           </li><li class="">
                           <button type="button">공식이미지</button>
                           </li>
                        </ul>
                     </div>
                        
                  <div class="my-3 content-item">
                     <a href="https://www.youtube.com/watch?v=HyU3XL2F9GE&t=1s">
                  <div class="">
                     <img src="https://img.youtube.com/vi/HyU3XL2F9GE/0.jpg" alt="이미지" loading="lazy">
                  </div>
                  <div class="info text-white my-3">
                     <p class="content-title subject">Python超入門コース 合併版｜Pythonの超基本的な部分をたった1時間で学べます【プログラミング初心者向け入門講座】</p>
                     <p class="subject">예고편</p>
                     <span class="date">2020.3.20</span>
                  </div>
                  </a>
                  </div>
                  
                  <!-- 장바구니에 담기 -->
                  <div class="my-3">
                        <button type="button" class="addCart_btn btn btn-outline-danger">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart-fill" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M8 1.314C12.438-3.248 23.534 4.735 8 15-7.534 4.736 3.562-3.248 8 1.314"></path>
</svg>
                찜하기
              </button>
                     <script src="/resources/js/cart.js"></script>
                  </div>
                  <c:if test="${view.gdsStock == 0 }">
                     <p>상품 수량이 부족합니다</p>
                  </c:if>
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

                              <input type="hidden" name="gdsNum" id="gdsNum" value="${view.gdsNum}">
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
                        <script>
                           replyList();//헤더에서 만들 함수 호출
                        </script>
                        <!-- 댓글 수정관련 스크립트 -->

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