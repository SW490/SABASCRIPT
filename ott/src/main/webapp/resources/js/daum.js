function go_daum_address(){
	
	new daum.Postcode({//팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분
		oncomplete: function(data) {
	var addr = '';//주소변수
	var extraAddr ='';//참고항목 변수
	
	//사용자가 선택한 주소 타입에 따라 해당 주소값을 가져온다
	if(data.userSelectedType === 'R'){//사용자가 도로명 주소를 선택했을 경우
	addr = data.roadAddress;
	}else{//사용자가 지번 주소를 선택했을 경우(J)
	addr = data.jibunAddress;	
	}
	//사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다
	if(data.userSelectedType === 'R'){
	//법정동명이 있을 경우 추가한다(법정리는 제외)
	//법정동의 경우 마지막 문자가 "동/로/가"로 끝난다
	if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
		extraAddr += data.bname;
	}
	// 건물명이 있고 , 공동 주택일 경우 추가한다
	if(data.buildingName !== '' && data.apartment === 'Y'){
		extraAddr += (extraAddr !== '' ? ', '+data.buildingName : data.buildingName);
	}	
	//표시할 참고항목이 있을 경우 괄호까지 추가한 최종 문자열을 만든다
	if(extraAddr !== ''){
		extraAddr = '('+ extraAddr +')';
	}
	addr += extraAddr;
	}else{
		addr += ' ';
	}	
	//우편번호와 주소정보를 해당 필드에 넣는다
	$(".address_input_1").val(data.zonecode);
	$(".address_input_2").val(addr);
	//주소가 선택되고 주소에 나머지 내용을 적기위해 인풋3번에 속성에 읽기전용을 거짓을 만든다
	$(".address_input_3").attr("readonly",false);	
	$(".address_input_3").focus();			
		}
	}).open();
}