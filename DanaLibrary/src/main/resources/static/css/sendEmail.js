/* 이메일 인증 */
	$('#certifiedEmail').on('click', function(){
		var data = {
			email : $('#email').val()
		};
		console.log(data);
		$.ajax({
			url: '/account/certifiedEmail',
			type: 'post',
			data: data,
			dataType: "json",
			success: [function(resp){
				console.log(resp);
			}],
			error: function(resp){
				console.log(resp);
			}
		})
	});