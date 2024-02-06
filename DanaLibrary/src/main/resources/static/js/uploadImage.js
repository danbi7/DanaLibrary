function uploadImage() {
    // 선택한 파일 가져오기
    var fileInput = document.getElementById('fileInput');
    var file = fileInput.files[0];

    // FormData 객체 생성
    var formData = new FormData();
    formData.append('file', file);

    // AJAX를 이용하여 이미지 업로드
    $.ajax({
        type: "POST",
        url: "/", // 실제 서버 업로드 처리 주소로 변경
        data: formData,
        processData: false,
        contentType: false,
        success: function(response) {
            console.log(response);
            alert("이미지 업로드 성공!");
            // 업로드 성공 시 추가로 수행할 작업을 여기에 추가
        },
        error: function(error) {
            alert("이미지 업로드 실패: " + error.responseText);
        }
    });
}
