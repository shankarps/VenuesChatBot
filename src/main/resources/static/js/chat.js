$(function () {
	
    var Message;
    Message = function (arg) {
        this.text = arg.text, this.source = arg.source;
        this.draw = function (_this) {
            return function () {
                var $message;
                $message = $($('.message_template').clone().html());
                $message.addClass(_this.source).find('.text').html(_this.text);
                $('.messages').append($message);
                $message.addClass('appeared');
                /*return setTimeout(function () {
                    return $message.addClass('appeared');
                }, 0);*/
            };
        }(this);
        return this;
    };
    
    var sendMessage = function (text, source) {
        var $messages, message;
        if (text.trim() === '') {
            return;
        }
        $('.message_input').val('');
        $messages = $('.messages');
        message = new Message({
            text: text,
            source: source
        });
        console.log('showing message '+text);
        message.draw();
        return $messages.animate({ scrollTop: $messages.prop('scrollHeight') }, 300);
    };

    //sendMessage('Hello Philip! :)', 'left');
    //sendMessage('Hello Robin! ', 'right');
    
	$("#removeClass").click(function() {
		$('.chat_window').hide();
	});
	
	$("#addClass")
	.click(
			function() {
				$('.chat_window').show();
				$('.messages').empty();
				$.ajax({
					url : "/chat",
					type : "GET",
					datatype : "application/json",
					contentType : "application/json",
					success : function(data) {
						$.each(data,
							function(i, item) {
								//console.log(item.message+" "+item.source);
								var source = '';
								if(item.source == 'ADMIN')
									source ='left';
								else if(item.source == 'GUEST')
									source ='right';
								sendMessage(item.message, source);
						})
					}
				})
			});
	
	$("#send_message")
	.click(
			function() {
				var message = $('#message_input').val();
				//$('.chat_window').show();
				$('.messages').empty();
				$.ajax({
					url : "/chat",
					type : "POST",
					datatype : "application/json",
					contentType : "application/json",
					data : '{ "message":' + '"'+message + '"'+' }',
					success : function(data) {
						$.each(data,
							function(i, item) {
								console.log('POSTED return '+item.message+" "+item.source);
								var source = '';
								
								if(item.source == 'ADMIN')
									source ='left';
								else if(item.source == 'GUEST')
									source ='right';
								
								sendMessage(item.message, source);
						})
					}
				})
			});
	
	
})