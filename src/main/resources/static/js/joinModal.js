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
    
    axios.post('/api/apply', data)
    .then(response => {
        console.log(response);
        alert('신청완료! 신청 내용은 마이페이지에서 확인 가능합니다.');
    })
    .catch(error => {
        console.log(error)
    })
    .then(function(){applyModal.hide()});
}

    function showModal(data) {
        const divApply = document.querySelector('#showModal');
        
        let str = ''; 
        for(let r of data) {
            if(r.joinNickname == loginUser) {
            str += '<div>'
                + '<button type="button" class="btnJoinButton btn-outline-primary">신청하기</button>'
                +'</div>'
            }
        }
        divApply.innerHTML = str;
    }
    
});