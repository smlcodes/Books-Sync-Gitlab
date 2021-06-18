$('#menu-toggle').click(function(e) {
    e.preventDefault();
    $('#wrapper').toggleClass('toggled');
});

$('#menu-toggle').click(function() {
    if ($('#open-close').hasClass("fa-long-arrow-left")) {
        $('#open-close').removeClass('fa-long-arrow-left');
        $('#open-close').addClass('fa-long-arrow-right');
    } else {
        $('#open-close').removeClass('fa-long-arrow-right');
        $('#open-close').addClass('fa-long-arrow-left');
    }
});

function getDimensions() {
    let width = $(window).width();
    if(width <= 768) {
        $('#open-close').addClass("fa-long-arrow-right");
        $('#open-close').removeClass("fa-long-arrow-left");
    }else{
        $('#open-close').removeClass("fa-long-arrow-right");
        $('#open-close').addClass("fa-long-arrow-left");
    }
}

window.onresize = function() {
    getDimensions()
}

$('#btn-login').on('click', function () {
    window.location.href = 'index.html'
});

