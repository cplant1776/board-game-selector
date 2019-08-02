$(".commentBtn").click(function() {
    $("#comment-box").append( $(".new-comment"));
    $(".commentBtn").attr("hidden", "true");
});

// $(".submitComment").click(function() {
//     var content = $("textarea").val();
//     var pathname = window.location.pathname;
//     window.location.href = pathname + "?content=" + content;
// })