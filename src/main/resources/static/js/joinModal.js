/**
 * 
 */
 
window.addEventListener('DOMContentLoaded', () => {
   
   // 신청하기 버튼
   const btnApplyJoin = document.querySelector('#btnApplyJoin');
   
   btnApplyJoin.addEventListener('click', joinNewApply);
   
   const divModal = document.querySelector('#staticBackdrop');
   const applyModal = new bootstrap.Modal(divModal);
   
   // 신청 함수
   function joinNewApply(){
    
    // 포스트 글번호 
    const postId = document.querySelector('#id').value;
    // 신청자 아이디
    const joinNickname = document.querySelector('#joinNickname').value;
    
    const data = { postId: postId,
        joinNickname: joinNickname };
    if (joinNickname != loginUser) {
        
    }
    axios.post('/api/apply', data)
    .then(response => {
        console.log(response, data);
        alert('신청완료! 신청 내용은 마이페이지에서 확인 가능합니다.');
    })
    .catch(error => {
        console.log(error)
    })
    .then(function(){applyModal.hide()});
}


    // 신청 취소 버튼
    const btnNoJoin = document.querySelector('#btnNoJoin');
    btnNoJoin.addEventListener('click', noJoinMeeting);
    
    function noJoinMeeting(){
        //삭제할 닉네임 아이디
        const joinNickname2 = document.querySelector('#joinNickname').value;
        const recruitPostId = document.querySelector('#id').value;
        
        const result = confirm('신청취소 하시겠습니까?');
        if(result) {
            axios
            .delete(`/api/apply?joinNickname=${joinNickname2}&recruitPostId=${recruitPostId}`)
            .then(response => {
                alert('신청 취소 완료')
            })
            .catch(err => {console.log(err)})
        }
        
        
    }
    const btnOk = document.querySelector('#ok');
    const btnNok = document.querySelector('#nok');
    const joinNicknameInput = document.querySelector('#joinNickname'); 
    
    joinNicknameInput.addEventListener('load', function(){
    const joinNickname = joinNicknameInput.value; 
    console.log(joinNickname);
        axios.get('/api/checkid?joinNickname=' + joinNickname)
        .then(response => displayCheckResult(response.data))
        .catch(err => {console.log(err)})
    });
    
    function displayCheckResult(data){
        if(data.joinNickname == 'ok') { // 신청이력 없음
            btnOk.classList.remove('disabled');
            btnNok.classList.add('disabled');
        } else { // 신청이력이 있음.
            btnOk.classList.add('disabled');
            btnNok.classList.remove('disabled');
        }
    }
    
});