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
        countPlusNumber()
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
    
    // 참여중인 인원
    const joinMember = document.querySelector('#joinMember').value;
    
    // 제한 인원
    const totalMember = document.querySelector('#totalMember').value;
    function countPlusNumber(){
        
        if(joinMember < totalMember ) {
            axios
            .put('/post/countMember' + postId)
            .then(response =>{
               console.log(response + '증가') 
            })
            .catch(err => {console.log(err)})
        }
        
        
        
        
        
    }

/*
    const btnNoJoin = document.querySelector('#btnNoJoin');
    btnNoJoin.addEventListener('change' ,showDeleteBtn);
    
        const joinmember = document.querySelector('#joinNickname').value;
    function showDeleteBtn(joinmember){
        axios.get('/api/checkid?joinmember=' + joinmember )
        .then(response => {
            if( joinmember == 'join') {
                btnNoJoin.classList.remove('disabled');
            }
        })
        .catch(err => {console.log(err)})
            }

    function showModal(data) {
        const divApply = document.querySelector('#showModal');
        
        let str = ''; 
            if(data.joinNickname == loginUser) {
            str += '<div>'
                + '<button type="button" class="btnJoinButton btn-outline-primary">신청하기</button>'
                +'</div>'
            }
        divApply.innerHTML = str;
    }
    
    */
    
});