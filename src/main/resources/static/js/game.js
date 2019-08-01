$(".commentBtn").click(function() {
    $("#comment-box").append( $(".new-comment"));
    $(".commentBtn").attr("hidden", "true");
})