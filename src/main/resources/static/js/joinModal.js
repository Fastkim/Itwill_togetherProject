/**
 * 
 */
 
window.addEventListener('DOMContentLoaded', () => {
    
    const totalMember = document.querySelector('#totalMember').value;
    const joinMember =document.querySelector('#joinMember').value;
   
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

    if(totalMember != joinMember) {
        axios.post('/api/apply', data)
        .then(response => {
            console.log(response, data);
            alert('신청완료! 신청 내용은 마이페이지에서 확인 가능합니다.');
            // 부모 페이지 로딩 코드
            location.reload();
            countMember();
        })
        .catch(error => {
            console.log(error)
        })
        .then(function(){applyModal.hide()});
    } else {
        alert('모집인원이 완료되어 신청이 불가능합니다.')
    }
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
                location.reload();
            })
            .catch(err => {console.log(err)})
        }
        
    }
    

});