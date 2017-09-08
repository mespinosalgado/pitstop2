$(document).ready(function(){
  $('li').click(function(){
    $('li').removeClass("menu");
    $(this).addClass("active");
});
});
