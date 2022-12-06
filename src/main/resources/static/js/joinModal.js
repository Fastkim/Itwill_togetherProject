/**
 * 
 */
 
 window.addEventListener('DOMContentLoaded', () => {
   
   // 현재 인원 id 0명으로 시작 
   const joinMember = document.getElementById("joinMember");
   
   // 신청하기 버튼
   const btnApplyJoin = document.querySelector('#btnApplyJoin');
   btnApplyJoin.addEventListener('click', joinNewApply);
   
   function joinNewApply(){
    
    // 포스트 글번호 
    const postId = document.querySelector('#id').value;
    // 신청자 아이디
    const joinNickname = document.querySelector('#joinNickname').value;
    
    const data = { postId: postId , joinNickname: joinNickname };
    
    axios.post('/api/apply', data)
    .then(response => {
        console.log(response);
        alert('신청완료! 신청 내용은 마이페이지에서 확인 가능합니다.');
    })
    .catch(error => {
        console.log(error)
    });
}

    function countJoinMember(){
        
    }
    
    
});