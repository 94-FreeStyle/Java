$(function() {
	$('#login2').click(function() {
		$('.login-body1').hide().fadeIn();
		$('.login-body2').show().fadeOut();
		$('#login2').css({
			'color' : 'black',
			'font-size' : '22',
		});
		$('#login1').css({
			'color' : '#666',
			'font-size' : '20',
		});
	});
	$('#login1').click(function() {
		$('.login-body2').hide().fadeIn();
		$('.login-body1').show().fadeOut();
		$('#login1').css({
			'color' : 'black',
			'font-size' : '22',
		});
		$('#login2').css({
			'color' : '#666',
			'font-size' : '20',
		});
	});
	$('form').validate();
	$("#tijiao").button();
});